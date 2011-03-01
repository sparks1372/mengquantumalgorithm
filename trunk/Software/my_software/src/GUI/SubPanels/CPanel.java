/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Core.qcevolutionbackend;
import Core.CircuitEvolution.SearchEngineState;
import Core.CircuitEvolution.circuitsearchengine;

/**
 * @author Sam Ratcliff
 * 
 */
public class CPanel extends JPanel implements Observer {
	private final qcevolutionbackend			backend;
	private final stateVisualiserTabPanel		stateExpectedTabPanel;
	private final finalStateVisualiserTabPanel	stateFinalTabPanel;
	private final ResultPanel					resPanel;

	/**
	 * 
	 */
	public CPanel(qcevolutionbackend be) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		backend = be;
		stateExpectedTabPanel = new stateVisualiserTabPanel(backend);
		stateFinalTabPanel = new finalStateVisualiserTabPanel(backend);
		resPanel = new ResultPanel(backend);
		resPanel.setVisible(false);
		backend.addObserver(this);
		if (null != backend.getCurrentse()) {
			backend.getCurrentse().addObserver(this);
		}
		add(stateExpectedTabPanel);
		add(stateFinalTabPanel);
		add(resPanel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof qcevolutionbackend) {
			if (null != backend.getCurrentse()) {
				backend.getCurrentse().removeObserver(this);
				backend.getCurrentse().addObserver(this);
			}
		} else if (arg1 instanceof circuitsearchengine) {
			if (backend.getCurrentse().getState() == SearchEngineState.SearchCompleteResultAvailable) {
				resPanel.setVisible(true);
			} else {
				resPanel.setVisible(false);
			}
		}
	}

}
