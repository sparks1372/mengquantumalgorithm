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
import Core.CircuitEvolution.SearchEngineState;

/**
 * @author Sam Ratcliff
 * 
 */
public class EvolveButton extends JButton implements Observer {
	/**
	 * 
	 */
	private static final long			serialVersionUID	= 4111378675542756867L;
	private final qcevolutionbackend	backend;
	private static final String			text				= "Evolve";

	/**
	 * 
	 */
	public EvolveButton(qcevolutionbackend be) {
		super(text);
		backend = be;
		backend.addObserver(this);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backend.getCurrentse().search();
			}

		});
		if ((backend.getCirbui() != null) && (backend.getCireval() != null)
				&& (backend.getCurrentff() != null)
				&& (backend.getQproblem() != null)
				&& (backend.getCurrentse() != null)) {
			if (backend.getCurrentse().getState() == SearchEngineState.Searching) {
				setEnabled(false);
			} else {
				setEnabled(true);
			}
		} else {
			setEnabled(false);
		}
		this.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public synchronized void update(Observable arg0, Object arg1) {
		if (arg0 instanceof qcevolutionbackend) {
			if (null != backend.getCurrentse()) {
				backend.getCurrentse().removeObserver(this);
				backend.getCurrentse().addObserver(this);
			}

		}
		if ((backend.getCirbui() != null) && (backend.getCireval() != null)
				&& (backend.getCurrentff() != null)
				&& (backend.getQproblem() != null)
				&& (backend.getCurrentse() != null)) {
			if (backend.getCurrentse().getState() == SearchEngineState.Searching) {
				setEnabled(false);
			} else {
				setEnabled(true);
			}
		} else {
			setEnabled(false);
		}
	}
}
