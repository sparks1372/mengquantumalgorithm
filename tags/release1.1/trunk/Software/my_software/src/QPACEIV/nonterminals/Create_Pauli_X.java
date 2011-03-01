package QPACEIV.nonterminals;

import Jama.Matrix;
import QPACEIV.QuantumProblem;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import QPACEIV.terminals.Qubit;
import Utils.Complex;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

public class Create_Pauli_X extends GPNode {

	public Create_Pauli_X() {
		children = new GPNode[3];
	}

	@Override
	public String toString() {
		return "Create_Pauli_X()";
	}

	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) {

		QuantumProblem Qprob = (QuantumProblem) problem;

		QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		children[0].eval(state, thread, input, stack, individual, problem);

		for (int index = 0; index < Qprob.NUM_OF_QUBITS; index++) {
			if (index == rd.in) {
				Qprob.circuit[index].add(new Pauli_X());
			} else {
				Qprob.circuit[index].add(new Pauli_I());
			}
		}

	}

	public static void main(String[] args) {
		Create_Pauli_X test_create_pauli_x = new Create_Pauli_X();
		QuantumProblem qprob = new QuantumProblem(2);

		test_create_pauli_x.children[0] = new Qubit(0);

		test_create_pauli_x.eval(null, 0, new QPaceIVQuantumState(), null,
				null, qprob);

		qprob.print_circuit();

		Complex[][] state_0_array = new Complex[4][1];
		state_0_array[0][0] = new Complex(1, 0);
		state_0_array[1][0] = new Complex(0, 0);
		state_0_array[2][0] = new Complex(0, 0);
		state_0_array[3][0] = new Complex(0, 0);

		Matrix test_state = new Matrix(state_0_array);
		test_state.print_state(0, 0);

		Matrix result = qprob.evaluate(test_state);
		result.print_state(0, 0);
	}
}
