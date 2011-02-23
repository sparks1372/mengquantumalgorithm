/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4.nonterminal;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstructionEnum;
import Core.Algorithms.exp_node;
import Core.Algorithms.Implementation.basicquantumalgorithm;
import Core.Algorithms.Implementation.ExpArith.pidiv;
import Core.CircuitEvolution.QPace4.Data.QPaceData;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

/**
 * @author Sam Ratcliff
 * 
 */
public class Gate extends GPNode {

	/**
	 * 
	 */
	public Gate() {
		System.out.println("Gate Constructed");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gp.GPNode#eval(ec.EvolutionState, int, ec.gp.GPData,
	 * ec.gp.ADFStack, ec.gp.GPIndividual, ec.Problem)
	 */
	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) {
		QuantumInstructionEnum qins;
		exp_node int1;
		exp_node int2;
		exp_node double1;
		QPaceData rd = ((QPaceData) (input));

		QPaceData secinput;
		secinput = new QPaceData();
		// Produce the Quantum Instruction
		children[0].eval(state, thread, secinput, stack, individual, problem);
		qins = QuantumInstructionEnum.values()[Math.abs(secinput.i
				% QuantumInstructionEnum.values().length)];

		/*
		 * Order of child 1 and 2 are reversed to that the returned value in
		 * rd.i is the Qubit ID of the "Target" Qubit
		 */

		secinput = new QPaceData();
		QuantumAlgorithm[] subalg = null;
		if (QuantumInstructionEnum.hasSecondQubit(qins)) {
			// Produce the "Control" Qubit ID
			children[2].eval(state, thread, input, stack, individual, problem);
			int2 = rd.ex;
		} else if (qins == QuantumInstructionEnum.Iterate) {

			int2 = null;
			// Produce the subalgorithm
			children[2].eval(state, thread, secinput, stack, individual,
					problem);
			subalg = new basicquantumalgorithm[1];
			subalg[0] = secinput.qa;
		} else {
			int2 = null;
		}
		if (qins == QuantumInstructionEnum.Iterate) {
			secinput = new QPaceData();
			// Produce the "Target Qubit ID
			children[1].eval(state, thread, secinput, stack, individual,
					problem);
			rd.ex = secinput.ex;
			int1 = rd.ex;
		} else {
			// Produce the "Target Qubit ID
			children[1].eval(state, thread, input, stack, individual, problem);
			int1 = rd.ex;
		}

		if (QuantumInstructionEnum.hasPhase(qins)) {
			// Produce the "Phase" value
			children[3].eval(state, thread, input, stack, individual, problem);
			double1 = new pidiv(rd.ex);
		} else {
			double1 = null;
		}

		rd.qa.addInstruction(qins, int1, int2, double1, subalg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gp.GPNode#toString()
	 */
	@Override
	public String toString() {
		return "Gate";
	}

}
