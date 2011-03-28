package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Core.Problem.testcase;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

public class Pauli_X implements quantumgate {
	private static final String	labelStr	= "X";

	public static void main(String[] args) {

		Pauli_X test = new Pauli_X(1);

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

		System.out.println("3 qubits state 000, Pauli X Qubit 1");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Pauli X Qubit 1");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Pauli X Qubit 1");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Pauli X Qubit 1");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		test = new Pauli_X(2);

		System.out.println("2 qubits state 00, Pauli X Qubit 2");
		test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Pauli X Qubit 2");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Pauli X Qubit 2");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Pauli X Qubit 2");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Pauli X Qubit 2");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Pauli X Qubit 2");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Pauli X Qubit 2");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);
	}

	private final int		targ;

	private final Matrix	unitary;

	/**
		 */
	public Pauli_X(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		Complex[][] pauli_x = new Complex[2][2];
		pauli_x[0][0] = new Complex(0, 0);
		pauli_x[0][1] = new Complex(1, 0);
		pauli_x[1][0] = new Complex(1, 0);
		pauli_x[1][1] = new Complex(0, 0);

		unitary = new Matrix(pauli_x);
	}

	@Override
	public Matrix apply(Matrix start_state, testcase tc) {
		Complex temp;

		for (int k = 0; k < start_state.getRowDimension(); k += Math.pow(2,
				targ)) {
			for (int l = 0; l < Math.pow(2, targ - 1); l++) {
				int i0 = k + l;
				int i1 = (int) (k + l + Math.pow(2, targ - 1));

				temp = start_state.get(i0, 0);

				start_state.set(i0, 0, start_state.get(i1, 0));
				start_state.set(i1, 0, temp);
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
	public Matrix getUnitary_operation(testcase tc) {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{X}&";
	}
}
