package QPACEIV.nonterminals;

import Jama.Matrix;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import ec.gp.GPNode;

public abstract class NonTerminalSuper extends GPNode {

	protected Matrix operation;

	public Matrix getOperation() {
		return operation;
	}

	public abstract QPaceIVQuantumState apply_operation(
			QPaceIVQuantumState state_0);
}
