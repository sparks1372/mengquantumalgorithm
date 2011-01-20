/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
 */

package QPACEIV.nonterminals;

import Jama.Matrix;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import Utils.Complex;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.util.Parameter;

public class Hadamard extends NonTerminalSuper {

	public Hadamard() {
		Complex[][] hadamard = new Complex[2][2];
		hadamard[0][0] = new Complex(1 / Math.sqrt(2), 0);
		hadamard[0][1] = new Complex(1 / Math.sqrt(2), 0);
		hadamard[1][0] = new Complex(1 / Math.sqrt(2), 0);
		hadamard[1][1] = new Complex(-1 / Math.sqrt(2), 0);

		operation = new Matrix(hadamard);
	}

	public String toString() {
		return "\\gate{h}&";
	}

	public void checkConstraints(final EvolutionState state, final int tree,
			final GPIndividual typicalIndividual, final Parameter individualBase) {
		super.checkConstraints(state, tree, typicalIndividual, individualBase);
		if (children.length != 1)
			state.output.error("Incorrect number of children for node "
					+ toStringForError() + " at " + individualBase);
	}

	public void eval(final EvolutionState state, final int thread,
			final GPData input, final ADFStack stack,
			final GPIndividual individual, final Problem problem) {
		double result;
		QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		children[0].eval(state, thread, input, stack, individual, problem);
		apply_operation(rd);
	}

	public QPaceIVQuantumState apply_operation(QPaceIVQuantumState state_0) {
		state_0.x = operation.times(state_0.x);
		return state_0;
	}
}