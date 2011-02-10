package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

public class Hadamard_Gate implements quantumgate {
	public static void main(String[] args) {

		Hadamard_Gate test = new Hadamard_Gate(1);

		System.out.println("2 qubits state 00, Hadamard Gate Qubit 1");
		Matrix test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		Matrix result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Hadamard Gate Qubit 1");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Hadamard Gate Qubit 1");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Hadamard Gate Qubit 1");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Hadamard Gate Qubit 1");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Hadamard Gate Qubit 1");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Hadamard Gate Qubit 1");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		test = new Hadamard_Gate(2);

		System.out.println("2 qubits state 00, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Hadamard Gate Qubit 2");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);
	}

	private final int		targ;

	private final Matrix	unitary;

	/**
		 */
	public Hadamard_Gate(int target) {
		if (target == 0) {
			System.out.println("Something is really really wrong");
		}
		this.targ = target;
		Complex[][] hadamard = new Complex[2][2];
		hadamard[0][0] = new Complex(1 / Math.sqrt(2), 0);
		hadamard[0][1] = new Complex(1 / Math.sqrt(2), 0);
		hadamard[1][0] = new Complex(1 / Math.sqrt(2), 0);
		hadamard[1][1] = new Complex(-1 / Math.sqrt(2), 0);

		unitary = new Matrix(hadamard);
	}

	@Override
	public Matrix apply(Matrix start_state) {
		Complex temp0;
		Complex temp1;

		for (int k = 0; k < start_state.getRowDimension(); k += Math.pow(2,
				targ)) {
			for (int l = 0; l < Math.pow(2, targ - 1); l++) {
				int i0 = k + l;
				int i1 = (int) (k + l + Math.pow(2, targ - 1));

				temp0 = start_state.get(i0, 0);
				temp1 = start_state.get(i1, 0);

				start_state.set(
						i0,
						0,
						new Complex((temp0.real() + temp1.real())
								/ Math.sqrt(2), (temp0.imag() + temp1.imag())
								/ Math.sqrt(2)));
				start_state.set(
						i1,
						0,
						new Complex((temp0.real() - temp1.real())
								/ Math.sqrt(2), (temp0.imag() - temp1.imag())
								/ Math.sqrt(2)));
			}
		}
		return start_state;

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
		return "\\gate{H}&";
	}
}
