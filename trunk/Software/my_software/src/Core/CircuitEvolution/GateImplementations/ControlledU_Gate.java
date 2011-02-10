package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Core.CircuitEvolution.multiqubitquantumgate;
import Jama.Matrix;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class ControlledU_Gate implements multiqubitquantumgate {
	private int			targ;
	private int			ctrl;
	private String		latex;
	private quantumgate	innergate	= null;
	/**
	 * @uml.property name="u_node"
	 * @uml.associationEnd
	 */
	private Matrix		unitary;
	/**
	 * @uml.property name="a"
	 * @uml.associationEnd
	 */
	private Matrix		A			= Matrix.identity(2, 2);
	/**
	 * @uml.property name="b"
	 * @uml.associationEnd
	 */
	private Matrix		B			= Matrix.identity(2, 2);
	/**
	 * @uml.property name="c"
	 * @uml.associationEnd
	 */
	private Matrix		C			= Matrix.identity(2, 2);
	/**
	 * @uml.property name="d"
	 * @uml.associationEnd
	 */
	private Matrix		D			= Matrix.identity(2, 2);

	/**
		 */

	/**
		 */
	public ControlledU_Gate(quantumgate gate, int t, int c) {
		// System.out.println(this.getClass().getName());
		if (t != c) {
			targ = t;
			ctrl = c;
			latex = gate.toLatex();
			B.set(0, 0, new Complex(0, 0));
			B.set(0, 1, new Complex(0, 0));
			B.set(1, 0, new Complex(0, 0));
			B.set(1, 1, new Complex(0, 0));
			C.set(0, 0, new Complex(0, 0));
			C.set(0, 1, new Complex(0, 0));
			C.set(1, 0, new Complex(0, 0));
			C.set(1, 1, new Complex(0, 0));
			D = gate.getUnitary_operation();

			Matrix temp = Matrix.identity(1, 1);
			for (int i = 1; i < Math.abs(targ - ctrl); i++) {
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

			if (Math.min(targ, ctrl) != 1) {
				unitary = Tensor_Matrix.tensor_prod(Matrix.identity(
						(int) Math.pow(2, ctrl < targ ? ctrl - 1 : targ - 1),
						(int) Math.pow(2, ctrl < targ ? ctrl - 1 : targ - 1)),
						unitary);
			}
		} else {
			innergate = gate;
		}
	}

	@Override
	public Matrix apply(Matrix start_state) {
		if (innergate == null) {
			double qubits = Math.log(start_state.getRowDimension())
					/ Math.log(2);

			Matrix operation = unitary;
			if (Math.max(targ, ctrl) != qubits) {
				operation = Tensor_Matrix.tensor_prod(operation, Matrix
						.identity(
								(int) (ctrl > targ ? Math.pow(2, qubits - ctrl)
										: Math.pow(2, qubits - targ)),
								(int) (ctrl > targ ? Math.pow(2, qubits - ctrl)
										: Math.pow(2, qubits - targ))));
			}

			return operation.times(start_state);
		} else {
			return innergate.apply(start_state);
		}
	}

	public int getControl() {
		return ctrl;
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
		if (innergate != null) {
			return innergate.toLatex();
		} else {
			return toLatex(false);
		}
	}

	public String toLatex(boolean upward) {
		if (upward) {
			return latex.substring(0, latex.indexOf('&') - 1)
					.concat(" \\qwx &");
		} else {
			return latex;
		}

	}

}
