/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4.nonterminal;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstructionEnum;
import Core.Algorithms.Implementation.basicquantumalgorithm;
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
public class Iterate extends GPNode {
	public Iterate() {
		System.out.println("Control Constructed");
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
		int int1;
		int int2;
		QPaceData rd = ((QPaceData) (input));

		// Produce the Quantum Instruction
		QuantumAlgorithm[] subalg;
		QPaceData secinput;
		// Produce the Number of Iteration
		children[1].eval(state, thread, input, stack, individual, problem);
		int1 = rd.i;

		subalg = new basicquantumalgorithm[1];
		secinput = new QPaceData();
		// Produce the subalgorithm
		children[4].eval(state, thread, secinput, stack, individual, problem);

		subalg[0] = secinput.qa != null ? secinput.qa
				: new basicquantumalgorithm();

		rd.qa.addInstruction(QuantumInstructionEnum.Iterate, int1, 0, 0, subalg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gp.GPNode#toString()
	 */
	@Override
	public String toString() {
		return "";
	}

}
