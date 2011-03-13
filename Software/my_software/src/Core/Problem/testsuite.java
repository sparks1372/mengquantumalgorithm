package Core.Problem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class testsuite implements Serializable {

	/**
	 * @uml.property name="testsets" multiplicity="(0 -1)" dimension="1"
	 */
	private final HashMap<Integer, testset>	testsets;

	/**
	 * 
	 */
	public testsuite() {
		testsets = new HashMap<Integer, testset>();
	}

	/**
	 * Setter of the property <tt>testsets</tt>
	 * 
	 * @param testcases
	 *            The testsets to set.
	 * @uml.property name="testsets"
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

	/**
	 * @return
	 */
	public testsuite copy() {
		testsuite to_ret = new testsuite();
		Iterator<Integer> iter = testsets.keySet().iterator();
		testset ts;
		while (iter.hasNext()) {
			int key = iter.next();
			ts = testsets.get(key).copy();
			to_ret.addTestcases(ts);
		}
		return to_ret;
	}

	public Set<Integer> getKeys() {
		return testsets.keySet();
	}

	/**
	 * Getter of the property <tt>testsets</tt>
	 * 
	 * @return Returns the testsets.
	 * @uml.property name="testsets"
	 */
	public testset getTestcases(int qubit) {
		return testsets.get(qubit);
	}

	public void removeTestSet(testset ts) {
		testsets.remove(ts.getNum_of_qubits());
	}

}
