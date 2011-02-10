package Core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class testset {

	/**
	 * @uml.property name="testcases"
	 */
	private final List<testcase>	testcases;

	/**
	 * @uml.property name="num_of_qubits" readOnly="true"
	 */
	private final int				num_of_qubits;

	public testset(int numofqubits) {
		num_of_qubits = numofqubits;
		testcases = new LinkedList<testcase>();
	}

	/**
	 * Setter of the property <tt>testcases</tt>
	 * 
	 * @param testcases
	 *            The testcases to set.
	 * @uml.property name="testcases"
	 */
	public void addTestcases(testcase tc) {
		testcases.add(tc);
	}

	/**
	 * Getter of the property <tt>num_of_qubits</tt>
	 * 
	 * @return Returns the num_of_qubits.
	 * @uml.property name="num_of_qubits"
	 */
	public int getNum_of_qubits() {
		return num_of_qubits;
	}

	/**
	 * Getter of the property <tt>testcases</tt>
	 * 
	 * @return Returns the testcases.
	 * @uml.property name="testcases"
	 */
	public Iterator<testcase> getTestcases() {
		return testcases.listIterator();
	}

}
