package Core.Problem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Core.qcevolutionbackend;
import Jama.Matrix;

public class testset {

	private final Matrix[]			customgates	= new Matrix[qcevolutionbackend.CUSTOMGATELIMIT];

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
	 * @return
	 */
	public testset copy() {
		testset to_ret = new testset(num_of_qubits);
		Iterator<testcase> iter = getTestcases();
		testcase tc;
		while (iter.hasNext()) {
			tc = iter.next();
			tc = tc.copy();
			to_ret.addTestcases(tc);
		}
		return to_ret;
	}

	public Matrix getCustomGate(int cgate) throws IllegalArgumentException {
		if ((cgate >= customgates.length) || (cgate < 0)) {
			throw new IllegalArgumentException();
		}
		return customgates[cgate];
	}

	public int getCustomGateSize(int cgate) throws IllegalArgumentException {
		if ((cgate >= customgates.length) || (cgate < 0)) {
			throw new IllegalArgumentException();
		}
		double qubits = Math.log(getCustomGate(cgate).getRowDimension())
				/ Math.log(2);
		return (int) Math.round(qubits);
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
	 * Getter of the property <tt>testcases.size()</tt>
	 * 
	 * @return Returns the number of testcases.
	 * @uml.property name="testcases"
	 */
	public int getNumberOfTestcases() {
		return testcases.size();
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

	public void setCustomGate(int cgate, Matrix m)
			throws IllegalArgumentException {
		if ((cgate >= customgates.length) || (cgate < 0)) {
			throw new IllegalArgumentException();
		}
		customgates[cgate] = m;
	}

}
