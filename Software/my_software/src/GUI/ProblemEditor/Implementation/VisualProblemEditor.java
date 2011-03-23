package GUI.ProblemEditor.Implementation;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import Core.Problem.quantumproblem;
import Core.Problem.testsuite;
import GUI.ProblemEditor.problemeditor;
import Utils.WindowUtils;

public class VisualProblemEditor extends JPanel implements problemeditor,
		ActionListener {
	static private final String	newline	= "\n";

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("VisualProblemEditor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new VisualProblemEditor(frame));
		frame.setSize(1000, 550);

		// Display the window.
		// frame.pack();
		frame.setVisible(true);
		WindowUtils.centre(frame);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

	JButton			newButton, openButton, saveButton, saveAsButton;
	JButton			addTestSetButton;
	JFileChooser	fc;
	Window			parent;
	File			selected_file;
	JLabel			filename;
	JPanel			upperPanel;

	JPanel			midPanel;

	XMLEditor		xmled;

	public VisualProblemEditor(Window p) {
		super(new BorderLayout());

		parent = p;

		// Create a file chooser
		fc = new JFileChooser();
		fc.addChoosableFileFilter(new XMLFilter());
		fc.setAcceptAllFileFilterUsed(false);

		newButton = new JButton("New Test Suite");
		newButton.addActionListener(this);
		openButton = new JButton("Open File");
		openButton.addActionListener(this);
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveAsButton = new JButton("Save As");
		saveAsButton.addActionListener(this);

		upperPanel = new JPanel();
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.PAGE_AXIS));

		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel(); // use FlowLayout
		buttonPanel.add(newButton);
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(saveAsButton);

		filename = new JLabel();
		filename.setSize(parent.getWidth(), filename.getHeight());

		upperPanel.add(buttonPanel);
		upperPanel.add(filename);

		addTestSetButton = new JButton("Add TestSet");
		addTestSetButton.addActionListener(this);

		midPanel = new JPanel();
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.PAGE_AXIS));

		xmled = new XMLEditor();

		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.add(addTestSetButton);

		midPanel.add(buttonPanel1);
		midPanel.add(xmled);

		// Add the buttons and the log to this panel.
		add(upperPanel, BorderLayout.PAGE_START);
		add(midPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(parent);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				selected_file = fc.getSelectedFile();
				// upperPanel.remove(filename);
				filename.setText(selected_file.getAbsolutePath());
				// upperPanel.add(filename);
				loadFile(selected_file);
			}

			// Handle save button action.
		} else if (e.getSource() == newButton) {
			Object[] selectionValues = { "0", "1", "2", "3" };
			String initialSelection = "0";
			Object selection = JOptionPane.showInputDialog(null,
					"Please select the number of custom gates", "",
					JOptionPane.QUESTION_MESSAGE, null, selectionValues,
					initialSelection);
			try {
				int index = Integer.parseInt((String) selection);
				xmled.setTestSuite(new testsuite(index));
			} catch (NumberFormatException ex) {
			}
		} else if (e.getSource() == saveButton) {
			saveFile(selected_file);
		} else if (e.getSource() == saveAsButton) {
			int returnVal = fc.showSaveDialog(parent);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file);
				if (selected_file == null) {
					selected_file = file;
				}
			}
		} else if (e.getSource() == addTestSetButton) {
			try {
				int s = Integer.parseInt((String) JOptionPane.showInputDialog(
						parent, "Add Test Set for how many Qubits?",
						"Qubit Number", JOptionPane.PLAIN_MESSAGE, null, null,
						"1"));

				if (s > 10) {
					JOptionPane
							.showMessageDialog(
									parent,
									"Maximum number of Qubits is 10. Adding test set for 10 Qubits",
									"Message", JOptionPane.INFORMATION_MESSAGE);
					s = 10;
				}
				xmled.addTestSet(s);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(parent,
						"The number entered cannot be parsed. Try again.",
						"Message", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		this.validate();
		WindowUtils.centre(parent);
	}

	@Override
	public void edit(quantumproblem quantumproblem) {
		xmled.setTestSuite(quantumproblem.getTestSuite());
	}

	@Override
	public void loadFile(File file) {
		xmled.load(file);
	}

	@Override
	public void saveFile(File file) {
		TestSuiteToXML.TestSuiteToXML(xmled.getTsuite(), file);
	}
}
