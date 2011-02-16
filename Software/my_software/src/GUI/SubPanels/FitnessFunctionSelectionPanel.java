/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FitnessFunctionSelectionPanel extends JPanel implements
		ActionListener {
	private final JComboBox				selection;
	private final ComboBoxModel			selection_model;
	private final JTextPane				description;
	private final JScrollPane			description_scroller;
	private final qcevolutionbackend	backend;

	/**
	 * 
	 */
	public FitnessFunctionSelectionPanel(qcevolutionbackend be) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		backend = be;
		selection_model = new DefaultComboBoxModel(backend.getFfmanager()
				.getAvailableFitnessFunctions().toArray());
		selection = new JComboBox(selection_model);
		selection.addActionListener(this);

		description = new JTextPane();
		description.setEditable(false);
		description_scroller = new JScrollPane(description);
		description_scroller
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		description_scroller.setPreferredSize(new Dimension(250, 155));
		description_scroller.setMinimumSize(new Dimension(10, 10));

		if (backend.getCurrentff() != null) {
			String key = backend.getCurrentff().getName();
			selection_model.setSelectedItem(key);
			description.setText(backend.getFfmanager().getFitnessFunctionDesc(
					key));
		}

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
		String ff_key = (String) cb.getSelectedItem();
		description.setText(backend.getFfmanager().getFitnessFunctionDesc(
				ff_key));
		backend.setCurrentff(backend.getFfmanager().getFitnessFuntion(ff_key));
	}
}
