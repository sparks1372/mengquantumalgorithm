package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Core.Problem.testcase;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;
import Utils.MatrixUtils;

public class RZ_Gate implements quantumgate {
	private static final String	labelStr	= "RZ";

	public static void main(String[] args) {

		RZ_Gate test = new RZ_Gate(1, Math.PI / 2);

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

	private final double	theta;
	private final Matrix	unitary;

	/**
		 */
	public RZ_Gate(int target, double th) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		this.theta = th;
		// [row][column]

		Complex[][] I = new Complex[2][2];
		I[0][0] = new Complex(1, 0);
		I[1][1] = new Complex(1, 0);
		I[0][1] = new Complex(0, 0);
		I[1][0] = new Complex(0, 0);
		Matrix iden = new Matrix(I);

		Matrix X = new Pauli_Z(1).getUnitary_operation(null);

		iden = iden.times(new Complex(Math.cos(th / 2), 0));
		X = X.times(new Complex(0, 1).times(new Complex(Math.sin(th / 2), 0)));

		unitary = iden.minus(X);
	}

	@Override
	public Matrix apply(Matrix start_state, testcase tc) {
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
	public Matrix getUnitary_operation(testcase tc) {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{RZ(" + theta + ")}&";
	}

}
