package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;
import Utils.Tensor_Matrix;

public class Phase_Gate implements quantumgate {
	private static final String	labelStr	= "P";

	public static void main(String[] args) {

		Phase_Gate test = new Phase_Gate(1, Math.PI / 4);

		System.out.println("2 qubits state 00, Phase Gate PI/4 Qubit 1");
		Matrix test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		Matrix result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Phase Gate PI/4 Qubit 1");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		test = new Phase_Gate(2, Math.PI / 2);

		System.out.println("2 qubits state 00, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_2q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 01, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_2q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("2 qubits state 10, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_2q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 000, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_0();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 001, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_1();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 010, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_3();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
		result.print_state(0, 0);

		System.out.println("3 qubits state 100, Phase Gate PI/4 Qubit 2");
		test_state = predefined_states.get_3q_5();
		test_state.print_state(0, 0);
		result = test.apply(test_state);
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
		zero[1][1] = new Complex(0, Math.exp(2 * theta));

		unitary = new Matrix(zero);
		// unitary.print(0, 0);
	}

	@Override
	public Matrix apply(Matrix start_state) {
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
				operation = Tensor_Matrix.tensor_prod(operation, unitary);
			} else {
				operation = Tensor_Matrix.tensor_prod(operation, iden);
			}
		}
		// operation.print(0, 0);
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
	public Matrix getUnitary_operation() {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{P(" + Math.PI / theta + ")}&";
	}
}
