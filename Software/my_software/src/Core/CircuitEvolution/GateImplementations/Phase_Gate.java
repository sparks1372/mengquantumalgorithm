package Core.CircuitEvolution.GateImplementations;

import java.text.DecimalFormat;

import Core.Circuit.quantumgate;
import Core.Problem.testcase;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;
import Utils.MatrixUtils;

public class Phase_Gate implements quantumgate {
	private static final String	labelStr	= "P";

	public static void main(String[] args) {

		Phase_Gate test = new Phase_Gate(1, Math.PI / 4);

		System.out.println("2 qubits state 00, Phase Gate PI/4 Qubit 1");
		Matrix test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		Matrix result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		test = new Phase_Gate(2, Math.PI / 2);

		System.out.println("2 qubits state 00, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state, null);
		result.print_state(0, 0);
	}

	private final int		targ;

	private final Matrix	unitary;
	private final double	theta;

	/**
		 */
	public Phase_Gate(int target, double th) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		this.theta = th;
		// [row][column]
		Complex[][] zero = new Complex[2][2];
		zero[0][0] = new Complex(1, 0);
		zero[0][1] = new Complex(0, 0);
		zero[1][0] = new Complex(0, 0);
		zero[1][1] = new Complex(Math.cos(2 * theta), Math.sin(2 * theta));

		unitary = Matrix.identity(2, 2);
		unitary.set(1, 1, new Complex(Math.cos(2 * theta), Math.sin(2 * theta)));
	}

	@Override
	public Matrix apply(Matrix start_state, testcase tc) {
		double qubits = Math.log(start_state.getRowDimension()) / Math.log(2);
		Matrix operation = Matrix.identity(1, 1);
		Matrix iden = Matrix.identity(2, 2);
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
	public Matrix getUnitary_operation(testcase tc) {
		return unitary;
	}

	@Override
	public String toLatex() {
		DecimalFormat twoPlaces = new DecimalFormat("0.0000");
		return "\\gate{P(" + twoPlaces.format(theta) + ")}&";
	}
}