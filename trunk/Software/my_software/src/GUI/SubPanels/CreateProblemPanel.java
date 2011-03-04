/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Core.qcevolutionbackend;
import GUI.ProblemEditor.Implementation.InnerEditorPanel;
import GUI.ProblemEditor.Implementation.TestSuiteToXML;
import GUI.ProblemEditor.Implementation.XMLEditor;
import GUI.ProblemEditor.Implementation.XMLFilter;
import Utils.WindowUtils;

/**
 * @author Sam Ratcliff
 * 
 */
public class CreateProblemPanel extends JDialog implements ActionListener {
	private final qcevolutionbackend	backend;
	private static final String			nm			= "    Name   ";
	private static final String			dsc			= "Description";
	private static final String			nullStr		= "";
	private static final String			titleStr	= "Create Problem and Test Suite";

	private JButton						openButton;
	private JButton						okayButton;
	private JButton						cancelButton;
	private JButton						addTestSetButton,
			addSuperpositionTestSetButton;
	private JButton						deleteTestSetButton;
	private JLabel						nameLabel, descLabel, title;
	private JTextArea					name;
	private JTextArea					desc;
	private JFileChooser				fc;
	private File						selected_file;
	private JLabel						filename;
	private XMLEditor					tsXmlEditor;

	public CreateProblemPanel(qcevolutionbackend be) {

		backend = be;
		setUndecorated(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

		setupButtons();
		setupTextAreas();
		setupLabels();
		setupFileChooser();
		setupXmlEditor();

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(title);

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		namePanel.add(nameLabel);
		namePanel.add(name);

		JPanel filePanel = new JPanel();
		JPanel fileButtonPanel = new JPanel();
		fileButtonPanel.add(openButton);
		filePanel.setLayout(new BorderLayout());
		filePanel.add(fileButtonPanel, BorderLayout.LINE_START);
		filePanel.add(filename, BorderLayout.CENTER);

		JPanel editorButtonPanel = new JPanel();
		editorButtonPanel.setLayout(new BoxLayout(editorButtonPanel,
				BoxLayout.PAGE_AXIS));
		editorButtonPanel.add(addTestSetButton);
		editorButtonPanel.add(addSuperpositionTestSetButton);
		editorButtonPanel.add(deleteTestSetButton);

		JPanel editorTablePanel = new JPanel();
		editorTablePanel.setLayout(new FlowLayout());
		editorTablePanel.add(tsXmlEditor);

		JPanel editorPanel = new JPanel();
		editorPanel.setLayout(new FlowLayout());
		editorPanel.add(editorButtonPanel);
		editorPanel.add(editorTablePanel);

		JPanel descPanel = new JPanel();
		descPanel.setLayout(new FlowLayout());
		descPanel.add(descLabel);
		descPanel.add(desc);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(okayButton);
		buttonPanel.add(cancelButton);

		this.getContentPane().add(titlePanel);
		this.getContentPane().add(namePanel);
		this.getContentPane().add(filePanel);
		this.getContentPane().add(editorPanel);
		this.getContentPane().add(descPanel);
		this.getContentPane().add(buttonPanel);

		this.pack();
		WindowUtils.centre(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				selected_file = fc.getSelectedFile();
				String fn = selected_file.getAbsolutePath();
				if (!fn.endsWith(".xml")) {
					fn = fn.concat(".xml");
					selected_file = new File(fn);
				}
				filename.setText(fn);
			}

		} else if (e.getSource() == okayButton) {
			if (selected_file == null) {
				JOptionPane
						.showMessageDialog(
								this,
								"No file selected for the test suite to be saved to. Please select a file and try again.",
								"Message", JOptionPane.ERROR_MESSAGE);
			} else if (name.getText().length() == 0) {
				JOptionPane
						.showMessageDialog(
								this,
								"No Problem name specified. Please enter a Problem name and retry",
								"Message", JOptionPane.ERROR_MESSAGE);
			} else if (desc.getText().length() == 0) {
				JOptionPane
						.showMessageDialog(
								this,
								"No Problem description specified. Please enter a Problem description and retry",
								"Message", JOptionPane.ERROR_MESSAGE);
			} else {
				TestSuiteToXML.TestSuiteToXML(tsXmlEditor.getTsuite(),
						selected_file);
				backend.getProbmanager().addProblem(name.getText(),
						selected_file.getAbsolutePath(), desc.getText());
				this.setVisible(false);
			}
		} else if (e.getSource() == cancelButton) {
			this.setVisible(false);
		} else if (e.getSource() == addTestSetButton) {
			String qubit_number_string = (String) JOptionPane.showInputDialog(
					this, "Add Test Set for how many Qubits?", "Qubit Number",
					JOptionPane.PLAIN_MESSAGE, null, null, "1");
			if (qubit_number_string != null) {
				int q = Integer.parseInt(qubit_number_string);

				if (q > 10) {
					JOptionPane
							.showMessageDialog(
									this,
									"Maximum number of Qubits is 10. Adding test set for 10 Qubits",
									"Message", JOptionPane.INFORMATION_MESSAGE);
					q = 10;
				}
				tsXmlEditor.addTestSet(q);
				this.pack();
				WindowUtils.centre(this);
			}
		} else if (e.getSource() == deleteTestSetButton) {
			int q = ((InnerEditorPanel) (tsXmlEditor.getSelectedComponent()))
					.getQubit();
			int result = JOptionPane.showConfirmDialog(this,
					"Are you sure you want to delete the Test Set for " + q
							+ " Qubits");
			if (result == JOptionPane.YES_OPTION) {
				tsXmlEditor.removeCurrentTestSet();
				this.pack();
				WindowUtils.centre(this);
			}
		} else if (e.getSource() == addSuperpositionTestSetButton) {
			int s = Integer.parseInt((String) JOptionPane.showInputDialog(this,
					"Add Test Set for how many Qubits?", "Qubit Number",
					JOptionPane.PLAIN_MESSAGE, null, null, "1"));

			if (s > 10) {
				JOptionPane
						.showMessageDialog(
								this,
								"Maximum number of Qubits is 10. Adding test set for 10 Qubits",
								"Message", JOptionPane.INFORMATION_MESSAGE);
				s = 10;
			}
			tsXmlEditor.addSuperpositionalTestSet(s);
			this.pack();
			WindowUtils.centre(this);
		}
	}

	private void setupButtons() {

		openButton = new JButton("Select Definition Filename");
		openButton.addActionListener(this);
		openButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		openButton.setAlignmentY(Component.CENTER_ALIGNMENT);

		okayButton = new JButton("Okay");
		okayButton.addActionListener(this);
		okayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		okayButton.setAlignmentY(Component.CENTER_ALIGNMENT);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelButton.setAlignmentY(Component.CENTER_ALIGNMENT);

		addTestSetButton = new JButton("Add TestSet");
		addTestSetButton.addActionListener(this);
		addTestSetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addTestSetButton.setAlignmentY(Component.CENTER_ALIGNMENT);

		deleteTestSetButton = new JButton("Delete Current TestSet");
		deleteTestSetButton.addActionListener(this);
		deleteTestSetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteTestSetButton.setAlignmentY(Component.CENTER_ALIGNMENT);

		addSuperpositionTestSetButton = new JButton(
				"Add Superpositional TestSet");
		addSuperpositionTestSetButton.addActionListener(this);
		addSuperpositionTestSetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addSuperpositionTestSetButton.setAlignmentY(Component.CENTER_ALIGNMENT);

	}

	private void setupFileChooser() {

		fc = new JFileChooser();
		fc.addChoosableFileFilter(new XMLFilter());
		fc.setAcceptAllFileFilterUsed(false);
	}

	private void setupLabels() {
		title = new JLabel(titleStr);
		Font fancyFont = new Font(title.getFont().getFontName(), title
				.getFont().getStyle(), 18);
		title.setFont(fancyFont);
		descLabel = new JLabel(dsc);
		nameLabel = new JLabel(nm);
		filename = new JLabel(nullStr);
	}

	private void setupTextAreas() {
		name = new JTextArea();
		name.setSize(new Dimension(this.getWidth() - 50, 20));
		name.setPreferredSize(new Dimension(this.getWidth() - 50, 20));
		name.setBorder(BorderFactory.createRaisedBevelBorder());

		desc = new JTextArea();
		desc.setSize(new Dimension(this.getWidth() - 50, 100));
		desc.setPreferredSize(new Dimension(this.getWidth() - 50, 100));
		desc.setBorder(BorderFactory.createRaisedBevelBorder());
	}

	/**
	 * 
	 */
	private void setupXmlEditor() {
		tsXmlEditor = new XMLEditor();
	}

}
