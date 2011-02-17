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
public class EditProblemSetButton extends JButton implements Observer {
	private final qcevolutionbackend	backend;
	private static final String			text	= "Edit Selected Problem";

	/**
	 * 
	 */
	public EditProblemSetButton(qcevolutionbackend be) {
		super(text);
		backend = be;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				(new EditProblemPanel(backend, backend.getQproblem()))
						.setVisible(true);
			}
		});
		backend.addObserver(this);
		if ((backend.getQproblem() == null)
				|| (backend.getQproblem().getTestSuite() == null)) {
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
	public void update(Observable arg0, Object arg1) {
		if ((backend.getQproblem() == null)
				|| (backend.getQproblem().getTestSuite() == null)) {
			this.setEnabled(false);
		} else {
			this.setEnabled(true);
		}
	}

}
