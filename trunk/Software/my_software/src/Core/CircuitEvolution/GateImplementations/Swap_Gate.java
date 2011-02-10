package Core.CircuitEvolution.GateImplementations;

import Core.CircuitEvolution.multiqubitquantumgate;
import Jama.Matrix;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class Swap_Gate implements multiqubitquantumgate {
	private final int	targ1;
	private final int	targ2;
	private Matrix		unitary;
	/**
	 * @uml.property name="a"
	 * @uml.associationEnd
	 */
	Matrix				A	= Matrix.identity(2, 2);
	/**
	 * @uml.property name="b"
	 * @uml.associationEnd
	 */
	Matrix				B	= Matrix.identity(2, 2);
	/**
	 * @uml.property name="c"
	 * @uml.associationEnd
	 */
	Matrix				C	= Matrix.identity(2, 2);
	/**
	 * @uml.property name="d"
	 * @uml.associationEnd
	 */
	Matrix				D	= Matrix.identity(2, 2);

	public Swap_Gate(int target, int target2) {
		// System.out.println(this.getClass().getName());
		this.targ1 = Math.abs(target);
		this.targ2 = Math.abs(target2);
		A.set(1, 1, new Complex(0, 0));
		B.set(0, 0, new Complex(0, 0));
		B.set(0, 1, new Complex(0, 0));
		B.set(1, 0, new Complex(1, 0));
		B.set(1, 1, new Complex(0, 0));
		C.set(0, 0, new Complex(0, 0));
		C.set(0, 1, new Complex(1, 0));
		C.set(1, 0, new Complex(0, 0));
		C.set(1, 1, new Complex(0, 0));
		D.set(0, 0, new Complex(0, 0));

		Matrix temp = Matrix.identity(1, 1);
		for (int i = 1; i < Math.abs(targ1 - targ2); i++) {
			temp = Tensor_Matrix.tensor_prod(temp, Matrix.identity(2, 2));
		}
		A = Tensor_Matrix.tensor_prod(temp, A);
		B = Tensor_Matrix.tensor_prod(temp, B);
		C = Tensor_Matrix.tensor_prod(temp, C);
		D = Tensor_Matrix.tensor_prod(temp, D);
		int dim = A.getColumnDimension() * 2;
		unitary = new Matrix(dim, dim);
		unitary.setMatrix(0, A.getColumnDimension() - 1, 0,
				A.getColumnDimension() - 1, A);
		unitary.setMatrix(0, A.getColumnDimension() - 1,
				A.getColumnDimension(), dim - 1, B);
		unitary.setMatrix(A.getColumnDimension(), dim - 1, 0,
				A.getColumnDimension() - 1, C);
		unitary.setMatrix(A.getColumnDimension(), dim - 1,
				A.getColumnDimension(), dim - 1, D);

		if (Math.min(targ1, targ2) != 1) {
			unitary = Tensor_Matrix.tensor_prod(Matrix.identity(
					(int) Math.pow(2, targ2 < targ1 ? targ2 - 1 : targ1 - 1),
					(int) Math.pow(2, targ2 < targ1 ? targ2 - 1 : targ1 - 1)),
					unitary);
		}
	}

	@Override
	public Matrix apply(Matrix start_state) {
		double qubits = Math.log(start_state.getRowDimension()) / Math.log(2);

		Matrix operation = unitary;
		if (Math.max(targ1, targ2) != qubits) {
			operation = Tensor_Matrix.tensor_prod(operation, Matrix.identity(
					(int) (targ2 > targ1 ? Math.pow(2, qubits - targ2) : Math
							.pow(2, qubits - targ1)),
					(int) (targ2 > targ1 ? Math.pow(2, qubits - targ2) : Math
							.pow(2, qubits - targ1))));
		}

		return operation.times(start_state);
	}

	@Override
	public int getTarget() {
		return targ1;
	}

	public int getTarget2() {
		return targ2;
	}

	@Override
	public Matrix getUnitary_operation() {
		return unitary;
	}

	@Override
	public String toLatex() {
		return toLatex(false);
	}

	public String toLatex(boolean upward) {
		if (upward) {
			return "\\qswap \\qwx &";
		} else {
			return "\\qswap &";
		}

	}

}
