package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

public class Pauli_Z implements quantumgate {
	private static final String	labelStr	= "Z";

	public static void main(String[] args) {

		Pauli_Z test = new Pauli_Z(1);

		System.out.println("2 qubits state 00, Pauli Z Qubit 1");
		Matrix test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		Matrix result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Pauli Z Qubit 1");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Pauli Z Qubit 1");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Pauli Z Qubit 1");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Pauli Z Qubit 1");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Pauli Z Qubit 1");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Pauli Z Qubit 1");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		test = new Pauli_Z(2);

		System.out.println("2 qubits state 00, Pauli Z Qubit 2");
		test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Pauli Z Qubit 2");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Pauli Z Qubit 2");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Pauli Z Qubit 2");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Pauli Z Qubit 2");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Pauli Z Qubit 2");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Pauli Z Qubit 2");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);
	}

	private final int		targ;

	private final Matrix	unitary;

	/**
		 */
	public Pauli_Z(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = target;
		Complex[][] pauli_z = new Complex[2][2];
		pauli_z[0][0] = new Complex(1, 0);
		pauli_z[0][1] = new Complex(0, 0);
		pauli_z[1][0] = new Complex(0, 0);
		pauli_z[1][1] = new Complex(-1, 0);

		unitary = new Matrix(pauli_z);
	}

	@Override
	public Matrix apply(Matrix start_state, String[] customGateDefs) {

		Complex temp;

		for (int k = 0; k < start_state.getRowDimension(); k += Math.pow(2,
				targ)) {
			for (int l = 0; l < Math.pow(2, targ - 1); l++) {
				int i1 = (int) (k + l + Math.pow(2, targ - 1));

				start_state.set(i1, 0,
						start_state.get(i1, 0).times(new Complex(-1, 0)));
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
	public Matrix getUnitary_operation(String[] customGateDefs) {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{Z} &";
	}
}
