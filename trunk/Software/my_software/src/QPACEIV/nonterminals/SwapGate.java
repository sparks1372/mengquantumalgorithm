/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
 */

package QPACEIV.nonterminals;

import Jama.Matrix;
import QPACEIV.QuantumProblem;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import Utils.Complex;
import Utils.Tensor_Matrix;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.util.Parameter;

public class SwapGate extends NonTerminalSuper {
	int targ1, targ2;
	Matrix A = Matrix.identity(2, 2);
	Matrix B = Matrix.identity(2, 2);
	Matrix C = Matrix.identity(2, 2);
	Matrix D = Matrix.identity(2, 2);

	public SwapGate(int t, int c, QuantumProblem rd) {
		targ1 = t;
		targ2 = c;
		A.set(1, 1, new Complex(0, 0));
		B.set(0, 0, new Complex(0, 0));
		B.set(0, 1, new Complex(0, 0));
		B.set(1, 0, new Complex(1, 0));
		B.set(1, 1, new Complex(0, 0));
		C.set(0, 0, new Complex(0, 0));
		C.set(0, 1, new Complex(1, 0));
		C.set(1, 0, new Complex(0, 0));
		C.set(1, 1, new Complex(0, 0));
		D.set(0, 0, new Complex(0, 0));

		Matrix temp = Matrix.identity(1, 1);
		for (int i = 0; i < Math.abs(targ1 - targ2) - 1; i++) {
			temp = Tensor_Matrix.tensor_prod(temp, Matrix.identity(2, 2));
		}

		A = Tensor_Matrix.tensor_prod(temp, A);
		B = Tensor_Matrix.tensor_prod(temp, B);
		C = Tensor_Matrix.tensor_prod(temp, C);
		D = Tensor_Matrix.tensor_prod(temp, D);
		int dim = A.getColumnDimension() * 2;
		operation = new Matrix(dim, dim);
		operation.setMatrix(0, A.getColumnDimension() - 1, 0,
				A.getColumnDimension() - 1, A);
		operation.setMatrix(0, A.getColumnDimension() - 1,
				A.getColumnDimension(), dim - 1, B);
		operation.setMatrix(A.getColumnDimension(), dim - 1, 0,
				A.getColumnDimension() - 1, C);
		operation.setMatrix(A.getColumnDimension(), dim - 1,
				A.getColumnDimension(), dim - 1, D);

		if (Math.min(targ1, targ2) != 0) {
			operation = Tensor_Matrix.tensor_prod(Matrix.identity(
					(int) Math.pow(2, targ2 < targ1 ? targ2 : targ1),
					(int) Math.pow(2, targ2 < targ1 ? targ2 : targ1)),
					operation);
		}

		if (Math.max(targ1, targ2) != rd.NUM_OF_QUBITS - 1) {
			operation = Tensor_Matrix.tensor_prod(operation, Matrix.identity(
					(int) Math.pow(2, targ2 > targ1 ? (rd.NUM_OF_QUBITS - 1)
							- targ2 : (rd.NUM_OF_QUBITS - 1) - targ1),
					(int) Math.pow(2, targ2 > targ1 ? (rd.NUM_OF_QUBITS - 1)
							- targ2 : (rd.NUM_OF_QUBITS - 1) - targ1)));
		}
	}

	public String toString() {
		return "\\gate{U}&";
	}

	public void checkConstraints(final EvolutionState state, final int tree,
			final GPIndividual typicalIndividual, final Parameter individualBase) {
		super.checkConstraints(state, tree, typicalIndividual, individualBase);
		if (children.length != 3)
			state.output.error("Incorrect number of children for node "
					+ toStringForError() + " at " + individualBase);
	}

	public void eval(final EvolutionState state, final int thread,
			final GPData input, final ADFStack stack,
			final GPIndividual individual, final Problem problem) {
		/*
		 * QPaceIVQuantumState rd = ((QPaceIVQuantumState) (input));
		 * children[0].eval(state, thread, input, stack, individual, problem);
		 * int ctrl = rd.in; children[1].eval(state, thread, input, stack,
		 * individual, problem); int targ = rd.in; Matrix temp =
		 * Matrix.identity(1, 1); for (int i = 0; i < Math.abs(targ - ctrl) - 1;
		 * i++) { temp = Tensor_Matrix.tensor_prod(temp, Matrix.identity(2, 2));
		 * }
		 * 
		 * D = ((NonTerminalSuper) children[2]).getOperation();
		 * 
		 * A = Tensor_Matrix.tensor_prod(temp, A); B =
		 * Tensor_Matrix.tensor_prod(temp, B); C =
		 * Tensor_Matrix.tensor_prod(temp, C); D =
		 * Tensor_Matrix.tensor_prod(temp, D); int dim = A.getColumnDimension()
		 * * 2; operation = new Matrix(dim, dim); operation.setMatrix(0,
		 * A.getColumnDimension() - 1, 0, A.getColumnDimension() - 1, A);
		 * operation.setMatrix(0, A.getColumnDimension() - 1,
		 * A.getColumnDimension(), dim - 1, B);
		 * operation.setMatrix(A.getColumnDimension(), dim - 1, 0,
		 * A.getColumnDimension() - 1, C);
		 * operation.setMatrix(A.getColumnDimension(), dim - 1,
		 * A.getColumnDimension(), dim - 1, D);
		 * 
		 * if (Math.min(targ, ctrl) != 0) { operation =
		 * Tensor_Matrix.tensor_prod(Matrix.identity( (int) Math.pow(2, ctrl <
		 * targ ? ctrl : targ), (int) Math.pow(2, ctrl < targ ? ctrl : targ)),
		 * operation); }
		 * 
		 * if (Math.max(targ, ctrl) != rd.NUM_OF_QUBITS - 1) { operation =
		 * Tensor_Matrix.tensor_prod(operation, Matrix.identity( (int)
		 * Math.pow(2, ctrl > targ ? (rd.NUM_OF_QUBITS - 1) - ctrl :
		 * (rd.NUM_OF_QUBITS - 1) - targ), (int) Math.pow(2, ctrl > targ ?
		 * (rd.NUM_OF_QUBITS - 1) - ctrl : (rd.NUM_OF_QUBITS - 1) - targ))); }
		 * // operation.print(0, 0); apply_operation(rd);
		 */
	}

	public QPaceIVQuantumState apply_operation(QPaceIVQuantumState state_0) {
		state_0.x = operation.times(state_0.x);
		return state_0;
	}

}
