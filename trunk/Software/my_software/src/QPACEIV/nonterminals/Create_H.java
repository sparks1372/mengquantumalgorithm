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

public class Create_H extends GPNode {

	public Create_H() {
		children = new GPNode[3];
	}

	@Override
	public String toString() {
		return "Create_H()";
	}

	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) {

		QuantumProblem Qprob = (QuantumProblem) problem;

		QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		children[0].eval(state, thread, input, stack, individual, problem);

		for (int index = 0; index < Qprob.NUM_OF_QUBITS; index++) {
			if (index == rd.in) {
				Qprob.circuit[index].add(new Hadamard());
			} else {
				Qprob.circuit[index].add(new Pauli_I());
			}
		}

	}

	public static void main(String[] args) {
		Create_H test_create_h = new Create_H();
		QuantumProblem qprob = new QuantumProblem(2);

		test_create_h.children[0] = new Qubit(1);

		test_create_h.eval(null, 0, new QPaceIVQuantumState(), null, null,
				qprob);

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
