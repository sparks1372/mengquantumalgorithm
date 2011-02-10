/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
 */

package Core.CircuitEvolution.QPace4.nonterminal.arithmetic_double;

import Core.CircuitEvolution.QPace4.Data.QPaceData;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ec.util.Parameter;

public class Add extends GPNode {
	@Override
	public void checkConstraints(final EvolutionState state, final int tree,
			final GPIndividual typicalIndividual, final Parameter individualBase) {
		super.checkConstraints(state, tree, typicalIndividual, individualBase);
		if (children.length != 2) {
			state.output.error("Incorrect number of children for node "
					+ toStringForError() + " at " + individualBase);
		}
	}

	@Override
	public void eval(final EvolutionState state, final int thread,
			final GPData input, final ADFStack stack,
			final GPIndividual individual, final Problem problem) {
		double result;
		QPaceData rd = ((QPaceData) (input));

		children[0].eval(state, thread, input, stack, individual, problem);
		result = rd.d;

		children[1].eval(state, thread, input, stack, individual, problem);
		rd.d = result + rd.d;
	}

	@Override
	public String toString() {
		return "+";
	}
}
