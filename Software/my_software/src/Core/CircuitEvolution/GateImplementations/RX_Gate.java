package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class RX_Gate implements quantumgate {
	private final int		targ;
	private final double	theta;
	private final Matrix	unitary;

	/**
		 */
	public RX_Gate(int target, double th) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		this.theta = th;
		// [row][column]
		Complex[][] rx_theta = new Complex[2][2];
		rx_theta[0][0] = new Complex(Math.cos(theta / 2), 0);
		rx_theta[0][1] = new Complex(0, -Math.sin(theta / 2));
		rx_theta[1][0] = new Complex(0, -Math.sin(theta / 2));
		rx_theta[1][1] = new Complex(Math.cos(theta / 2), 0);

		unitary = new Matrix(rx_theta);
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
		return "\\gate{RX(" + Math.PI / theta + ")}&";
	}

}
