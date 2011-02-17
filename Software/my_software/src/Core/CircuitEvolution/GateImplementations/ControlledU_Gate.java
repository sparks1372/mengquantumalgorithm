package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Core.CircuitEvolution.multiqubitquantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class ControlledU_Gate implements multiqubitquantumgate {
	public static void main(String[] args) {
		ControlledU_Gate cu = new ControlledU_Gate(new Pauli_X(1), 2, 1);
		cu.apply(predefined_states.get_2q_3());
	}

	private final String	labelStr;

	private int				ctrl;
	private int				targ;
	private String			latex;
	private quantumgate		innergate		= null;
	/**
	 * @uml.property name="u_node"
	 * @uml.associationEnd
	 */
	private Matrix			unitary;
	/**
	 * @uml.property name="controlMat"
	 * @uml.associationEnd
	 */
	private final Matrix	controlMat		= Matrix.identity(2, 2);
	/**
	 * @uml.property name="nonControlMat"
	 * @uml.associationEnd
	 */
	private final Matrix	nonControlMat	= Matrix.identity(2, 2);

	/**
		 */
	public ControlledU_Gate(quantumgate gate, int t, int c) {
		labelStr = gate.getlabel();
		if (t != c) {
			targ = t;
			ctrl = c;
			latex = gate.toLatex();
			controlMat.set(0, 0, new Complex(0, 0));
			nonControlMat.set(1, 1, new Complex(0, 0));
			Matrix gateU = gate.getUnitary_operation();

			Matrix spacing = Matrix.identity(1, 1);
			for (int i = 1; i < Math.abs(targ - ctrl); i++) {
				spacing = Tensor_Matrix.tensor_prod(spacing,
						Matrix.identity(2, 2));
			}

			Matrix nonControlUnitary;
			Matrix controlUnitary;
			if (ctrl > targ) {
				nonControlUnitary = Tensor_Matrix.tensor_prod(
						nonControlMat,
						Tensor_Matrix.tensor_prod(spacing,
								Matrix.identity(2, 2)));
				controlUnitary = Tensor_Matrix.tensor_prod(controlMat,
						Tensor_Matrix.tensor_prod(spacing, gateU));
			} else {
				nonControlUnitary = Tensor_Matrix.tensor_prod(
						Matrix.identity(2, 2),
						Tensor_Matrix.tensor_prod(spacing, nonControlMat));
				controlUnitary = Tensor_Matrix.tensor_prod(gateU,
						Tensor_Matrix.tensor_prod(spacing, controlMat));
			}

			unitary = nonControlUnitary.plus(controlUnitary);

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

	/**
		 */

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

			// System.out.println("ContolledU " + getlabel() + " ctrlet "
			// + getTarget() + "r control " + getSecondQubit() + "Unitary");
			// operation.print(0, 0);
			return operation.times(start_state);
		} else {
			return innergate.apply(start_state);
		}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.multiqubitquantumgate#getSecondQubit()
	 */
	@Override
	public int getSecondQubit() {
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
