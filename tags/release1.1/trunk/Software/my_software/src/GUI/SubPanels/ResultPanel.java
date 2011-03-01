/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import Core.qcevolutionbackend;
import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.CircuitEvolution.SearchEngineState;
import GUI.SubPanels.ResultPanels.AlgorithmPanel;
import GUI.SubPanels.ResultPanels.CircuitParentPanel;
import GUI.SubPanels.ResultPanels.QCircuitPanel;

/**
 * @author Sam Ratcliff
 * 
 */
public class ResultPanel extends JPanel implements Observer, ActionListener {
	private final qcevolutionbackend	backend;
	private final JTabbedPane			tabPanel;
	private final AlgorithmPanel		algoPanel;
	private final QCircuitPanel			qcircuitPanel;
	private final CircuitParentPanel	circuitPanel;
	private final String				numQubitsLabelStr		= "Number of Qubits";
	private final String				buildCircuitButtonStr	= "Rebuild Circuit";
	private final JLabel				numQubitsLabel;
	private final JButton				buildCircuitButton;
	private final JTextArea				numQubits;
	private int							numOfQubits				= 1;
	private final JPanel				qubitPanel;

	/**
	 * 
	 */
	public ResultPanel(qcevolutionbackend be) {
		backend = be;

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		tabPanel = new JTabbedPane();

		algoPanel = new AlgorithmPanel();
		qcircuitPanel = new QCircuitPanel();
		circuitPanel = new CircuitParentPanel();

		backend.addObserver(this);

		if (null != backend.getCurrentse()) {
			backend.getCurrentse().addObserver(this);
		}

		tabPanel.add(algoPanel);
		tabPanel.add(circuitPanel);
		tabPanel.add(qcircuitPanel);

		numQubitsLabel = new JLabel(numQubitsLabelStr);
		numQubits = new JTextArea();
		numQubits.setSize(20, 10);
		numQubits.setText(Integer.toString(numOfQubits));

		buildCircuitButton = new JButton();
		buildCircuitButton.setText(buildCircuitButtonStr);
		buildCircuitButton.addActionListener(this);

		qubitPanel = new JPanel();
		qubitPanel.setLayout(new FlowLayout());
		qubitPanel.add(numQubitsLabel);
		qubitPanel.add(numQubits);
		qubitPanel.add(buildCircuitButton);

		circuitPanel.setPreferredSize(algoPanel.getSize());

		this.add(qubitPanel);
		this.add(tabPanel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			numOfQubits = Integer.parseInt(this.numQubits.getText());
			update(null, null);
		} catch (NumberFormatException e) {
			JOptionPane
					.showMessageDialog(
							this,
							"The number of qubits cannot be correctly parsed. Please try again.",
							"Message", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof qcevolutionbackend) {
			if (null != backend.getCurrentse()) {
				backend.getCurrentse().removeObserver(this);
				backend.getCurrentse().addObserver(this);
			}
		}

		if ((backend.getCurrentse() != null)
				&& (backend.getCurrentse().getState() == SearchEngineState.SearchCompleteResultAvailable)
				&& (backend.getCurrentse().getBestAlgorithm() != null)) {
			QuantumAlgorithm qa = backend.getCurrentse().getBestAlgorithm();
			algoPanel.update(qa);

			Circuit cir = backend.getCirbui().Build(qa, numOfQubits);

			qcircuitPanel.update(cir.toLatex(numOfQubits));

			circuitPanel.update(cir, numOfQubits);
		}
	}
}
