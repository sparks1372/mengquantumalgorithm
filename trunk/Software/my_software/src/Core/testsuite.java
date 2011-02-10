package Core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class testsuite {

	/**
	 * @uml.property name="testcases" multiplicity="(0 -1)" dimension="1"
	 */
	private final HashMap<Integer, testset>	testsets;

	/**
	 * 
	 */
	public testsuite() {
		testsets = new HashMap<Integer, testset>();
	}

	/**
	 * Setter of the property <tt>testcases</tt>
	 * 
	 * @param testcases
	 *            The testcases to set.
	 * @uml.property name="testcases"
	 */
	public void addTestcases(testset ts) {
		if (testsets.containsKey(ts.getNum_of_qubits())) {
			testset current = testsets.get(ts.getNum_of_qubits());
			Iterator<testcase> iter = ts.getTestcases();
			while (iter.hasNext()) {
				current.addTestcases(iter.next());
			}
		} else {
			testsets.put(ts.getNum_of_qubits(), ts);
		}
	}

	public Set<Integer> getKeys() {
		return testsets.keySet();

	}

	/**
	 * Getter of the property <tt>testcases</tt>
	 * 
	 * @return Returns the testcases.
	 * @uml.property name="testcases"
	 */
	public testset getTestcases(int qubit) {
		return testsets.get(qubit);
	}

}
