package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Core.Problem.testcase;
import Jama.Matrix;
import Utils.Complex;
import Utils.MatrixUtils;

public class Custom_Gate implements quantumgate {
	private static final String	labelStr	= "C";
	private final int			targ;
	private Matrix				unitary;
	private final int			cgate_index;

	/**
		 */
	public Custom_Gate(int target, int cindex) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		this.cgate_index = cindex;
	}

	@Override
	public Matrix apply(Matrix start_state, testcase tc) {
		String[] customGateDefs = tc.getCustomGates();
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
		if (cgate_index < customGateDefs.length) {
			unitary = getUnitary_operation(tc);
		} else {
			unitary = Matrix.identity(2, 2);
		}
		double unitaryqubits = Math.log(unitary.getRowDimension())
				/ Math.log(2);
		for (int index = 1; index <= qubits;) {
			if (index == targ) {
				operation = MatrixUtils.tensor_prod(unitary, operation);
				index += unitaryqubits;
			} else {
				operation = MatrixUtils.tensor_prod(iden, operation);
				index++;
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
		return labelStr.concat(Integer.toString(cgate_index));
	}

	@Override
	public int getTarget() {
		return targ;
	}

	@Override
	public Matrix getUnitary_operation(testcase tc) {
		String[] customGateDefs = tc.getCustomGates();
		if ((customGateDefs != null) && (cgate_index < customGateDefs.length)) {
			return MatrixUtils.fromFile(customGateDefs[cgate_index]);
		} else {
			return Matrix.identity(2, 2);
		}
	}

	@Override
	public String toLatex() {
		return "\\gate{C" + cgate_index + "}&";
	}

}
