package Core.CircuitEvolution;

import Core.Circuit.Circuit;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;

/**
 * @uml.dependency supplier="Core.CircuitBuilder.circuitBuilder"
 */
public interface circuitsearchengine {

	public abstract float Evolve();

	/**
	 * @return Returns the availableinstructions.
	 * @uml.property name="availableinstructions" multiplicity="(0 -1)"
	 *               dimension="1"
	 */
	public boolean[] getAvailableinstructions();

	/**
	 * @return Returns the bestCircuit.
	 * @uml.property name="BestCircuit" readOnly="true"
	 */
	public Circuit getBestCircuit();

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

	/**
	 * Setter of the property <tt>availableinstructions</tt>
	 * 
	 * @param availableinstructions
	 *            The availableinstructions to set.
	 * @uml.property name="availableinstructions"
	 */
	public void setAvailableinstructions(boolean[] availableinstructions);

}
