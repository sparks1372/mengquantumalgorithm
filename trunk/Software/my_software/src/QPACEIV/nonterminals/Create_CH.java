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

public class Create_CH extends GPNode {

	public Create_CH() {
		children = new GPNode[3];
	}

	@Override
	public String toString() {
		return "Create_CH()";
	}

	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) {

		QuantumProblem Qprob = (QuantumProblem) problem;

		QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		children[0].eval(state, thread, input, stack, individual, problem);
		int ctrl = (int) rd.in;
		children[1].eval(state, thread, input, stack, individual, problem);
		int targ = (int) rd.in;

		for (int index = 0; index < Qprob.NUM_OF_QUBITS; index++) {
			if (index == ctrl) {
				Qprob.circuit[index].add(new ControlGate(targ - ctrl));
			} else if (index == targ) {
				Qprob.circuit[index].add(new CU(targ, ctrl, new Hadamard(),
						(QuantumProblem) problem));
			} else {
				Qprob.circuit[index].add(new SkipGate());
			}
		}

	}

	public static void main(String[] args) {
		Create_CH test_create_ch = new Create_CH();
		QuantumProblem qprob = new QuantumProblem(2);

		test_create_ch.children[0] = new Qubit(0);
		test_create_ch.children[1] = new Qubit(1);

		test_create_ch.eval(null, 0, new QPaceIVQuantumState(), null, null,
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
