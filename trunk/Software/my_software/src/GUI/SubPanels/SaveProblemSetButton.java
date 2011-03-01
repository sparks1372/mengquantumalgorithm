/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import Core.qcevolutionbackend;

/**
 * @author Sam Ratcliff
 * 
 */
public class SaveProblemSetButton extends JButton implements Observer {
	private final qcevolutionbackend	backend;
	private static final String			text	= "Save";

	/**
	 * 
	 */
	public SaveProblemSetButton(qcevolutionbackend be) {
		super(text);
		backend = be;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backend.getProbmanager().saveToFile();
			}
		});
		backend.getProbmanager().addObserver(this);
		if (backend.getProbmanager().isSaved()) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
		this.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (backend.getProbmanager().isSaved()) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}

}
