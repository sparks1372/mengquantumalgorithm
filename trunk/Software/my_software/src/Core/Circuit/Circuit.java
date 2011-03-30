package Core.Circuit;

import java.util.Iterator;

public interface Circuit {

	/**
		 */
	public void addCircuit(int builder_id, Circuit circuit);

	/**
		 */
	public void addGate(int builder_id, quantumgate quantumgate);

	/**
	 * @return Returns the circuitlayout.
	 * @uml.property name="circuitlayout" readOnly="true" multiplicity="(0 -1)"
	 *               dimension="1"
	 */
	public Iterator<quantumgate> getCircuitlayout();

	/**
			 */
	public int getSize();

	public String toLatex(int qubits);

}
