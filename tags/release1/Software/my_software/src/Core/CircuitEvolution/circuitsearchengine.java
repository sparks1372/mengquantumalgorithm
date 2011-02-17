package Core.CircuitEvolution;

import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JPanel;

import Core.Algorithms.QuantumAlgorithm;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;

/**
 * @uml.dependency supplier="Core.CircuitBuilder.circuitBuilder"
 */
public interface circuitsearchengine {

	public void addObserver(Observer ob);

	public void Evolve();

	/**
	 * @return Returns the availableinstructions.
	 * @uml.property name="availableinstructions" multiplicity="(0 -1)"
	 *               dimension="1"
	 */
	public boolean[] getAvailableinstructions();

	/**
	 * @return Returns the best Algorithm.
	 * @uml.property name="BestAlgorithm" readOnly="true"
	 */
	public QuantumAlgorithm getBestAlgorithm();

	/**
	 * @return Returns the cbuilder.
	 * @uml.property name="cbuilder" readOnly="true"
	 */
	public circuitBuilder getCbuilder();

	/**
	 * @return Returns the cevaluator.
	 * @uml.property name="cevaluator" readOnly="true"
	 */
	public circuitevaluator getCevaluator();

	public JDialog getEvolveDialog();

	/**
	 * @return Returns the evotype.
	 * @uml.property name="evotype" readOnly="true"
	 */
	public EvolutionType getEvotype();

	/**
	 * @return Returns the name.
	 * @uml.property name="Name" readOnly="true"
	 */
	public String getName();

	public JPanel getProgressBar();

	public JPanel getSearchStatisticsPanel();

	public SearchEngineState getState();

	public void init(circuitBuilder cb, circuitevaluator ce, boolean[] ai);

	/**
	 * 
	 */
	public void removeAllObservers();

	public void removeObserver(Observer ob);

	/**
	 * Setter of the property <tt>availableinstructions</tt>
	 * 
	 * @param availableinstructions
	 *            The availableinstructions to set.
	 * @uml.property name="availableinstructions"
	 */
	public void setAvailableinstructions(boolean[] availableinstructions);

}
