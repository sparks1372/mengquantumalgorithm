package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class V_Gate implements quantumgate {
	private final int		targ;
	private final Matrix	unitary;

	/**
		 */
	public V_Gate(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		Complex[][] v = new Complex[2][2];
		v[0][0] = new Complex(1, 0);
		v[0][1] = new Complex(0, 0);
		v[1][0] = new Complex(0, 0);
		v[1][1] = new Complex(0, 1);

		unitary = new Matrix(v);
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
				try {
					operation = Tensor_Matrix.tensor_prod(operation, unitary);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			} else {
				try {
					operation = Tensor_Matrix.tensor_prod(operation, iden);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
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
		return "\\gate{V}&";
	}

}
