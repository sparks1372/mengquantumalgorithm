package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Utils.Complex;
import Utils.MatrixUtils;

public class Zero_Gate implements quantumgate {
	private static final String	labelStr	= "Zero";
	private final int			targ;
	private final Matrix		unitary;

	/**
		 */
	public Zero_Gate(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		Complex[][] zero = new Complex[2][2];
		zero[0][0] = new Complex(1, 0);
		zero[0][1] = new Complex(1, 0);
		zero[1][0] = new Complex(0, 0);
		zero[1][1] = new Complex(0, 0);

		unitary = new Matrix(zero);
	}

	@Override
	public Matrix apply(Matrix start_state) {
		double qubits = Math.log(start_state.getRowDimension()) / Math.log(2);
		Complex[][] init = new Complex[1][1];
		init[0][0] = new Complex(1, 0);
		Matrix operation = new Matrix(init);
		Complex[][] I = new Complex[2][2];
		I[0][0] = new Complex(1, 0);
		I[1][1] = new Complex(1, 0);
		I[0][1] = new Complex(0, 0);
		I[1][0] = new Complex(0, 0);
		Matrix iden = new Matrix(I);
		for (int index = 1; index <= qubits; index++) {
			if (index == targ) {
				operation = MatrixUtils.tensor_prod(unitary, operation);
			} else {
				operation = MatrixUtils.tensor_prod(iden, operation);
			}
		}
		return operation.times(start_state);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Circuit.quantumgate#getlabel()
	 */
	@Override
	public String getlabel() {
		return labelStr;
	}

	@Override
	public int getTarget() {
		return targ;
	}

	@Override
	public Matrix getUnitary_operation() {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{zero}&";
	}

}
