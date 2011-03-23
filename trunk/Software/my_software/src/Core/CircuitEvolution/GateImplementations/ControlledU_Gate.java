package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Core.CircuitEvolution.multiqubitquantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;
import Utils.MatrixUtils;

public class ControlledU_Gate implements multiqubitquantumgate {
	public static void main(String[] args) {
		ControlledU_Gate cu = new ControlledU_Gate(new Pauli_X(1), 2, 1);
		cu.apply(predefined_states.get_2q_3(), null);
	}

	private final String	labelStr;

	private final int		ctrl;
	private final int		targ;
	private final String	latex;
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
		targ = t;
		ctrl = c;
		latex = gate.toLatex();
		controlMat.set(0, 0, new Complex(0, 0));
		nonControlMat.set(1, 1, new Complex(0, 0));
		if (!(gate instanceof Custom_Gate)) {
			Matrix gateU = gate.getUnitary_operation(null);
			setUnitary(gateU);
		} else {
			innergate = gate;
		}
	}

	/**
		 */

	@Override
	public Matrix apply(Matrix start_state, String[] customGateDefs) {
		double qubits = Math.log(start_state.getRowDimension()) / Math.log(2);
		if (innergate == null) {

			Matrix operation = unitary;
			if (Math.max(targ, ctrl) != qubits) {
				operation = MatrixUtils.tensor_prod(Matrix.identity(
						(int) (ctrl > targ ? Math.pow(2, qubits - ctrl) : Math
								.pow(2, qubits - targ)),
						(int) (ctrl > targ ? Math.pow(2, qubits - ctrl) : Math
								.pow(2, qubits - targ))), operation);
			}

			// System.out.println("ContolledU " + getlabel() + " ctrlet "
			// + getTarget() + "r control " + getSecondQubit() + "Unitary");
			// operation.print(0, 0);
			return operation.times(start_state);
		} else {
			Matrix gateU = innergate.getUnitary_operation(customGateDefs);
			double gateSize = Math.log(gateU.getRowDimension()) / Math.log(2);
			if ((ctrl > targ) && (ctrl <= (targ + gateSize))) {
				return innergate.apply(start_state, customGateDefs);
			} else {
				setUnitary(gateU);

				Matrix operation = unitary;
				if (Math.max(targ, ctrl) != qubits) {
					operation = MatrixUtils.tensor_prod(Matrix.identity(
							(int) (ctrl > targ ? Math.pow(2, qubits - ctrl)
									: Math.pow(2, qubits - targ)),
							(int) (ctrl > targ ? Math.pow(2, qubits - ctrl)
									: Math.pow(2, qubits - targ))), operation);
				}
				return operation.times(start_state);
			}
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
	public Matrix getUnitary_operation(String[] customGateDefs) {
		return unitary;
	}

	private void setUnitary(Matrix gateU) {
		Matrix spacing = Matrix.identity(1, 1);
		double gateSize = Math.log(gateU.getRowDimension()) / Math.log(2);

		Matrix nonControlUnitary;
		Matrix controlUnitary;
		if (ctrl > targ) {

			for (int i = 0; i < ctrl - (targ + gateSize); i++) {
				spacing = MatrixUtils.tensor_prod(spacing,
						Matrix.identity(2, 2));
			}
			nonControlUnitary = MatrixUtils.tensor_prod(nonControlMat,
					MatrixUtils.tensor_prod(spacing, Matrix.identity(2, 2)));
			controlUnitary = MatrixUtils.tensor_prod(controlMat,
					MatrixUtils.tensor_prod(spacing, gateU));
		} else {
			for (int i = 1; i < targ - ctrl; i++) {
				spacing = MatrixUtils.tensor_prod(spacing,
						Matrix.identity(2, 2));
			}
			nonControlUnitary = MatrixUtils.tensor_prod(Matrix.identity(2, 2),
					MatrixUtils.tensor_prod(spacing, nonControlMat));
			controlUnitary = MatrixUtils.tensor_prod(gateU,
					MatrixUtils.tensor_prod(spacing, controlMat));
		}

		unitary = nonControlUnitary.plus(controlUnitary);

		if (Math.min(targ, ctrl) != 1) {
			unitary = MatrixUtils.tensor_prod(unitary, Matrix.identity(
					(int) Math.pow(2, ctrl < targ ? ctrl - 1 : targ - 1),
					(int) Math.pow(2, ctrl < targ ? ctrl - 1 : targ - 1)));
		}
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
			return latex.substring(0, latex.indexOf('&')).concat(" \\qwx &");
		} else {
			return latex;
		}

	}
}
