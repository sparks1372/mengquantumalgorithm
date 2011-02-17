package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class RY_Gate implements quantumgate {
	private static final String	labelStr	= "RY";
	private final int			targ;
	private final double		theta;
	private final Matrix		unitary;

	/**
		 */
	public RY_Gate(int target, double th) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		this.theta = th;
		// [row][column]
		Complex[][] ry_theta = new Complex[2][2];
		ry_theta[0][0] = new Complex(Math.cos(theta / 2), 0);
		ry_theta[0][1] = new Complex(-Math.sin(theta / 2), 0);
		ry_theta[1][0] = new Complex(Math.sin(theta / 2), 0);
		ry_theta[1][1] = new Complex(Math.cos(theta / 2), 0);

		Complex[][] I = new Complex[2][2];
		I[0][0] = new Complex(1, 0);
		I[1][1] = new Complex(1, 0);
		I[0][1] = new Complex(0, 0);
		I[1][0] = new Complex(0, 0);
		Matrix iden = new Matrix(I);

		Matrix X = new Pauli_Y(1).getUnitary_operation();

		iden = iden.times(new Complex(Math.cos(th / 2), 0));
		X = X.times(new Complex(0, 1).times(new Complex(Math.sin(th / 2), 0)));

		unitary = iden.minus(X);
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

			if (index == (qubits)) {
				operation = Tensor_Matrix.tensor_prod(operation, unitary);
			} else {
				operation = Tensor_Matrix.tensor_prod(operation, iden);
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
		return "\\gate{RY(" + theta + ")}&";
	}

}
