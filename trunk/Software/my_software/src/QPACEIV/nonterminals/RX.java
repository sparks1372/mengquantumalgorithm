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
import ec.gp.GPNode;
import ec.util.Parameter;

public class RX extends NonTerminalSuper {
	private double theta;

	public RX(GPNode p) {
		children = new GPNode[3];
		children[0] = p;
		QPaceIVQuantumState rd = new QPaceIVQuantumState();
		children[0].eval(null, 0, rd, null, null, null);
		theta = rd.in;
		// [row][column]
		Complex[][] rx_theta = new Complex[2][2];
		rx_theta[0][0] = new Complex(Math.cos(theta / 2), 0);
		rx_theta[0][1] = new Complex(0, -Math.sin(theta / 2));
		rx_theta[1][0] = new Complex(0, -Math.sin(theta / 2));
		rx_theta[1][1] = new Complex(Math.cos(theta / 2), 0);

		operation = new Matrix(rx_theta);
	}

	public String toString() {
		return "\\gate{RX(" + children[0].toString() + "}&";
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
		 * current_operation = operation; if (qubit != 0) { current_operation =
		 * Tensor_Matrix.tensor_prod( Matrix.identity((int) Math.pow(2, qubit),
		 * (int) Math.pow(2, qubit)), current_operation); }
		 * 
		 * if (qubit != rd.NUM_OF_QUBITS - 1) { current_operation =
		 * Tensor_Matrix.tensor_prod(current_operation, Matrix.identity( (int)
		 * Math.pow(2, (rd.NUM_OF_QUBITS - 1) - qubit), (int) Math.pow(2,
		 * (rd.NUM_OF_QUBITS - 1) - qubit))); }
		 * 
		 * apply_operation(rd);
		 */
	}

	public QPaceIVQuantumState apply_operation(QPaceIVQuantumState state_0) {
		state_0.x = operation.times(state_0.x);
		return state_0;
	}

}
