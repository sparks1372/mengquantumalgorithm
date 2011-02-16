/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.qcevolutionbackend;

/**
 * @author Sam Ratcliff
 * 
 */
public class RPanel extends JPanel {
	private static String				psLabelStr	= "Problem Selection";
	private final qcevolutionbackend	backend;
	private JLabel						psLabel;
	private final ProblemSelectionPanel	prob_select_panel;
	private JButton						cpbutton;
	private JButton						spbutton;
	private JButton						ldbutton;
	private EditProblemSetButton		edbutton;
	private JButton						evbutton;
	private JPanel						labelPanel;
	private JPanel						buttonPanel;

	/**
	 * 
	 */
	public RPanel(qcevolutionbackend be) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		backend = be;

		setupLabels();
		setupButtons();

		prob_select_panel = new ProblemSelectionPanel(backend, edbutton);

		this.add(labelPanel);
		this.add(prob_select_panel);
		this.add(buttonPanel);
	}

	private void setupButtons() {

		cpbutton = new CreateProblemSetButton(backend);
		cpbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cpbutton.setAlignmentY(Component.CENTER_ALIGNMENT);

		spbutton = new SaveProblemSetButton(backend);
		spbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		spbutton.setAlignmentY(Component.CENTER_ALIGNMENT);

		ldbutton = new LoadProblemSetButton(backend);
		ldbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ldbutton.setAlignmentY(Component.CENTER_ALIGNMENT);

		edbutton = new EditProblemSetButton(backend);
		edbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		edbutton.setAlignmentY(Component.CENTER_ALIGNMENT);

		evbutton = new JButton("Evolve");
		evbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		evbutton.setAlignmentY(Component.CENTER_ALIGNMENT);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

		buttonPanel.add(cpbutton);
		buttonPanel.add(ldbutton);
		buttonPanel.add(spbutton);
		buttonPanel.add(edbutton);
		buttonPanel.add(evbutton);
	}

	private void setupLabels() {

		psLabel = new JLabel(psLabelStr);
		Font fancyFont = new Font(psLabel.getFont().getFontName(), psLabel
				.getFont().getStyle(), 32);
		psLabel.setFont(fancyFont);

		labelPanel = new JPanel();
		labelPanel.add(psLabel);

	}
}
