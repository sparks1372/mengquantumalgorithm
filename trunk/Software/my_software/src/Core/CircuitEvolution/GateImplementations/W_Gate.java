package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;
import Utils.MatrixUtils;

public class W_Gate implements quantumgate {
	private static final String	labelStr	= "W";

	public static void main(String[] args) {

		W_Gate test = new W_Gate(1);

		System.out.println("2 qubits state 00, Pauli X Qubit 1");
		Matrix test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		Matrix result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Pauli X Qubit 1");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Pauli X Qubit 1");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);
	}

	private final int		targ;

	private final Matrix	unitary;

	/**
		 */
	public W_Gate(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		Complex[][] w = new Complex[2][2];
		w[0][0] = new Complex(1, 0);
		w[0][1] = new Complex(0, 0);
		w[1][0] = new Complex(0, 0);
		w[1][1] = new Complex(0, -1);

		unitary = new Matrix(w);
	}

	@Override
	public Matrix apply(Matrix start_state, String[] customGateDefs) {
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
	public Matrix getUnitary_operation(String[] customGateDefs) {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{W}&";
	}

}
