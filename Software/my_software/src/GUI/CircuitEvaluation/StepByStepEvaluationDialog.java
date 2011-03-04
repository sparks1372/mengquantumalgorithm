/**
 * @Author = Sam Ratcliff
 */
package GUI.CircuitEvaluation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;
import Core.Problem.testcase;
import Core.Problem.testset;
import GUI.SubPanels.currectStateVisualiserTab;
import GUI.SubPanels.ResultPanels.CircuitParentPanel;
import Utils.WindowUtils;

/**
 * @author Sam Ratcliff
 * 
 */
public class StepByStepEvaluationDialog extends JDialog implements
		ActionListener {

	private final JPanel				stateHolderPanel;
	private currectStateVisualiserTab	statePanel;
	private final CircuitParentPanel	circuitPanel;
	private JPanel						buttonPanel;

	private JButton						nextButton;
	private final String				nextStr					= "Next";
	private JButton						prevButton;
	private final String				prevStr					= "Previous";
	private JButton						cancButton;
	private final String				cancStr					= "Cancel";
	private final String				numQubitsLabelStr		= "Number of Qubits";
	private final String				buildCircuitButtonStr	= "Rebuild Circuit";
	private JLabel						numQubitsLabel;
	private JButton						buildCircuitButton;
	private JTextArea					numQubits;
	private int							numOfQubits				= 1;
	private JPanel						qubitPanel;

	private final QuantumAlgorithm		quantAlg;
	private final circuitBuilder		cirBuilder;
	private final circuitevaluator		cirEval;
	private LinkedList<testset>			testSuiteList			= new LinkedList<testset>();
	private int							position				= 0;

	public StepByStepEvaluationDialog(QuantumAlgorithm quantAlg,
			circuitBuilder cirBuilder, circuitevaluator circuitEval) {
		super();
		this.quantAlg = quantAlg;
		this.cirBuilder = cirBuilder;
		this.cirEval = circuitEval;
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setUndecorated(true);
		stateHolderPanel = new JPanel();
		circuitPanel = new CircuitParentPanel();
		circuitPanel.setVisible(false);
		setupButtons();

		this.getContentPane().setLayout(
				new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

		this.getContentPane().add(stateHolderPanel);
		this.getContentPane().add(circuitPanel);
		this.getContentPane().add(qubitPanel);
		this.pack();
		WindowUtils.centre(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == buildCircuitButton) {
			try {
				numOfQubits = Integer.parseInt(this.numQubits.getText());
				updateNumOfQubits();
				nextButton.setVisible(true);
				prevButton.setVisible(true);
				stateHolderPanel.setVisible(true);
				circuitPanel.setVisible(true);
				validate();
				pack();
				WindowUtils.centre(this);
			} catch (NumberFormatException e) {
				JOptionPane
						.showMessageDialog(
								this,
								"The number of qubits cannot be correctly parsed. Please try again.",
								"Message", JOptionPane.ERROR_MESSAGE);
			}
		} else if (arg0.getSource() == nextButton) {
			position = circuitPanel.circuitNextPosition();
			stateHolderPanel.removeAll();
			int index = statePanel.getSelectedIndex();
			statePanel = new currectStateVisualiserTab(
					testSuiteList.get(position), "At Position " + position);
			statePanel.setSelectedIndex(index);
			stateHolderPanel.add(statePanel);
			validate();
			pack();
			WindowUtils.centre(this);
		} else if (arg0.getSource() == prevButton) {
			position = circuitPanel.circuitPreviousPosition();
			stateHolderPanel.removeAll();
			int index = statePanel.getSelectedIndex();
			statePanel = new currectStateVisualiserTab(
					testSuiteList.get(position), "At Position " + position);
			statePanel.setSelectedIndex(index);
			stateHolderPanel.add(statePanel);
			validate();
			pack();
			WindowUtils.centre(this);
		} else if (arg0.getSource() == cancButton) {
			this.setVisible(false);
		}

	}

	private void setupButtons() {
		nextButton = new JButton(nextStr);
		prevButton = new JButton(prevStr);

		nextButton.addActionListener(this);
		prevButton.addActionListener(this);

		nextButton.setVisible(false);
		prevButton.setVisible(false);

		numQubitsLabel = new JLabel(numQubitsLabelStr);
		numQubits = new JTextArea();
		numQubits.setSize(20, 10);
		numQubits.setText(Integer.toString(numOfQubits));

		buildCircuitButton = new JButton();
		buildCircuitButton.setText(buildCircuitButtonStr);
		buildCircuitButton.addActionListener(this);

		cancButton = new JButton();
		cancButton.setText(cancStr);
		cancButton.addActionListener(this);

		qubitPanel = new JPanel();
		qubitPanel.setLayout(new FlowLayout());

		qubitPanel.add(numQubitsLabel);
		qubitPanel.add(numQubits);
		qubitPanel.add(buildCircuitButton);
		qubitPanel.add(nextButton);
		qubitPanel.add(prevButton);
		qubitPanel.add(cancButton);
	}

	private void updateNumOfQubits() {
		Circuit cir = cirBuilder.Build(quantAlg, numOfQubits);
		circuitPanel.update(cir, numOfQubits);
		testSuiteList = cirEval.getTrace(quantAlg, numOfQubits);
		Iterator<testcase> tciter = testSuiteList.get(0).getTestcases();
		statePanel = new currectStateVisualiserTab(testSuiteList.get(0),
				"Starting State");
		stateHolderPanel.removeAll();
		stateHolderPanel.add(statePanel);
		validate();
		pack();
	}
}
