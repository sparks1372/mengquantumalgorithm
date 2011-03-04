/**
 * @Author = Sam Ratcliff
 */
package Core.Problem;

import java.util.Iterator;

/**
 * @author Sam Ratcliff
 * 
 */
public class SuperPositionalTestSet extends testset {

	public SuperPositionalTestSet(int numofqubits) {
		super(numofqubits);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Problem.testset#copy()
	 */
	@Override
	public SuperPositionalTestSet copy() {
		SuperPositionalTestSet to_ret = new SuperPositionalTestSet(
				super.getNum_of_qubits());
		Iterator<testcase> iter = getTestcases();
		testcase tc;
		while (iter.hasNext()) {
			tc = iter.next();
			tc = tc.copy();
			to_ret.addTestcases(tc);
		}
		return to_ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Problem.testset#getNum_of_qubits()
	 */
	@Override
	public int getNum_of_qubits() {
		return -super.getNum_of_qubits();
	}

}
