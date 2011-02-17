package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

public class Pauli_Y implements quantumgate {
	private static final String	labelStr	= "Y";

	public static void main(String[] args) {

		Pauli_Y test = new Pauli_Y(1);

		System.out.println("2 qubits state 00, Pauli Y Qubit 1");
		Matrix test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		Matrix result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Pauli Y Qubit 1");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Pauli Y Qubit 1");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Pauli Y Qubit 1");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Pauli Y Qubit 1");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Pauli Y Qubit 1");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Pauli Y Qubit 1");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		test = new Pauli_Y(2);

		System.out.println("2 qubits state 00, Pauli Y Qubit 2");
		test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Pauli Y Qubit 2");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Pauli Y Qubit 2");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Pauli Y Qubit 2");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Pauli Y Qubit 2");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Pauli Y Qubit 2");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Pauli Y Qubit 2");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);
	}

	private final int		targ;

	private final Matrix	unitary;

	/**
		 */
	public Pauli_Y(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		Complex[][] pauli_y = new Complex[2][2];
		pauli_y[0][0] = new Complex(0, 0);
		pauli_y[0][1] = new Complex(0, -1);
		pauli_y[1][0] = new Complex(0, 1);
		pauli_y[1][1] = new Complex(0, 0);

		unitary = new Matrix(pauli_y);
	}

	@Override
	public Matrix apply(Matrix start_state) {

		Complex temp;

		for (int k = 0; k < start_state.getRowDimension(); k += Math.pow(2,
				targ)) {
			for (int l = 0; l < Math.pow(2, targ - 1); l++) {
				int i0 = k + l;
				int i1 = (int) (k + l + Math.pow(2, targ - 1));

				temp = start_state.get(i0, 0);

				start_state.set(i0, 0, new Complex(start_state.get(i1, 0)
						.imag(), -start_state.get(i1, 0).real()));
				start_state.set(i1, 0, new Complex(-temp.imag(), temp.real()));
			}
		}
		return start_state;
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
		return "\\gate{Y}&";
	}
}
