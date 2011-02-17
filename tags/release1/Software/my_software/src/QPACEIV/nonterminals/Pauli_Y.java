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

public class Pauli_Y extends NonTerminalSuper {
	public Pauli_Y() {
		// [row][column]
		Complex[][] pauli_y = new Complex[2][2];
		pauli_y[0][0] = new Complex(0, 0);
		pauli_y[0][1] = new Complex(0, -1);
		pauli_y[1][0] = new Complex(0, 1);
		pauli_y[1][1] = new Complex(0, 0);

		operation = new Matrix(pauli_y);
		// operation.print(0, 0);
	}

	public String toString() {
		return "\\gate{Y}&";
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
		/*
		 * QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		 * children[0].eval(state, thread, input, stack, individual, problem);
		 * apply_operation(rd);
		 */
	}

	public QPaceIVQuantumState apply_operation(QPaceIVQuantumState state_0) {
		state_0.x = operation.times(state_0.x);
		return state_0;
	}

	public static void main(String[] args) {
		new Pauli_Y();
	}
}
