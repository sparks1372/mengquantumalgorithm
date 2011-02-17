package QPACEIV.nonterminals;

import Jama.Matrix;
import QPACEIV.QuantumProblem;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import QPACEIV.terminals.Qubit;
import QPACEIV.terminals.piovfourrad;
import Utils.Complex;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

public class Create_P extends GPNode {

	public Create_P() {
		children = new GPNode[3];
	}

	@Override
	public String toString() {
		return "Create_P(" + children[1].toString() + ")";
	}

	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) {

		QuantumProblem Qprob = (QuantumProblem) problem;

		QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		children[0].eval(state, thread, input, stack, individual, problem);

		for (int index = 0; index < Qprob.NUM_OF_QUBITS; index++) {
			if (index == rd.in) {
				Qprob.circuit[index].add(new Phase(children[1]));
			} else {
				Qprob.circuit[index].add(new Pauli_I());
			}
		}

	}

	public static void main(String[] args) {
		Create_P test_create_p = new Create_P();
		QuantumProblem qprob = new QuantumProblem(2);

		test_create_p.children[0] = new Qubit(0);
		test_create_p.children[1] = new piovfourrad();

		test_create_p.eval(null, 0, new QPaceIVQuantumState(), null, null,
				qprob);

		qprob.print_circuit();

		Complex[][] state_0_array = new Complex[4][1];
		state_0_array[0][0] = new Complex(0, 0);
		state_0_array[1][0] = new Complex(0, 0);
		state_0_array[2][0] = new Complex(1, 0);
		state_0_array[3][0] = new Complex(0, 0);

		Matrix test_state = new Matrix(state_0_array);
		test_state.print_state(0, 0);

		Matrix result = qprob.evaluate(test_state);
		result.print_state(0, 0);
	}
}
