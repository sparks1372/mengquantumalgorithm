/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.Component;
import java.awt.Font;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Core.qcevolutionbackend;
import Core.CircuitEvolution.SearchEngineState;
import Core.CircuitEvolution.circuitsearchengine;
import Core.Problem.testsuite;
import GUI.MainPanel;

/**
 * @author Sam Ratcliff
 * 
 */
public class finalStateVisualiserTabPanel extends JPanel implements Observer {
	private final qcevolutionbackend	backend;
	private static String				qubits_string	= " Qubit(s)";
	private static String				psLabelStr		= "Actual Final State Visualisation";
	private JLabel						psLabel;
	private JPanel						labelPanel;
	private final JTabbedPane			tabPane;

	/**
	 * 
	 */
	public finalStateVisualiserTabPanel(qcevolutionbackend be) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		backend = be;
		update(null, null);
		backend.addObserver(this);

		if (null != backend.getCurrentse()) {
			backend.getCurrentse().addObserver(this);
		}

		tabPane = new JTabbedPane();
		setupLabels();

		this.add(labelPanel);
		this.add(tabPane);
	}

	private void setupLabels() {

		psLabel = new JLabel(psLabelStr);
		Font fancyFont = new Font(psLabel.getFont().getFontName(), psLabel
				.getFont().getStyle(), MainPanel.titleFontSize);
		psLabel.setFont(fancyFont);

		labelPanel = new JPanel();
		labelPanel.add(psLabel);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof qcevolutionbackend) {
			if (null != backend.getCurrentse()) {
				backend.getCurrentse().removeObserver(this);
				backend.getCurrentse().addObserver(this);
			}
		} else if (arg instanceof circuitsearchengine) {
			tabPane.removeAll();

			if ((backend.getCurrentse().getState() == SearchEngineState.SearchCompleteResultAvailable)
					&& (backend.getCurrentse().getBestAlgorithm() != null)) {
				testsuite results = backend.getCireval().getResults(
						backend.getCurrentse().getBestAlgorithm());

				Set<Integer> keys = results.getKeys();

				Iterator<Integer> iter = keys.iterator();

				Component tab;
				while (iter.hasNext()) {
					int numofqubits = iter.next();
					tab = new stateVisualiserTab(
							results.getTestcases(numofqubits));
					tabPane.add(
							Integer.toString(numofqubits).concat(qubits_string),
							tab);
				}
			}
		}
	}
}