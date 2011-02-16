/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import Core.qcevolutionbackend;

/**
 * @author Sam Ratcliff
 * 
 */
public class ProblemSelectionPanel extends JPanel implements ActionListener,
		Observer {
	private final JComboBox				selection;
	private ComboBoxModel				selection_model;
	private final JTextPane				description;
	private final JScrollPane			description_scroller;
	private final qcevolutionbackend	backend;

	/**
	 * 
	 */
	public ProblemSelectionPanel(qcevolutionbackend be, ActionListener ac) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		backend = be;
		selection_model = new DefaultComboBoxModel(backend.getProbmanager()
				.getAvailableProblems().toArray());

		description = new JTextPane();
		description.setEditable(false);
		description_scroller = new JScrollPane(description);
		description_scroller
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		description_scroller.setPreferredSize(new Dimension(250, 155));
		description_scroller.setMinimumSize(new Dimension(10, 10));

		if (backend.getCurrentse() != null) {
			String key = backend.getQproblem().getName();
			selection_model.setSelectedItem(key);
			description.setText(backend.getProbmanager().getSearchEngineDesc(
					key));
		}
		selection = new JComboBox(selection_model);
		selection.addActionListener(this);
		selection.addActionListener(ac);

		be.getProbmanager().addObserver(this);

		this.add(selection);
		this.add(description_scroller);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String prob_key = (String) cb.getSelectedItem();
		description.setText(backend.getProbmanager().getSearchEngineDesc(
				prob_key));
		backend.setQproblem(backend.getProbmanager().getProblem(prob_key));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		selection_model = new DefaultComboBoxModel(backend.getProbmanager()
				.getAvailableProblems().toArray());
		if (backend.getQproblem() != null) {
			String key = backend.getQproblem().getName();
			selection_model.setSelectedItem(key);
			description.setText(backend.getProbmanager().getSearchEngineDesc(
					key));
		}
		selection.setModel(selection_model);
	}

}
