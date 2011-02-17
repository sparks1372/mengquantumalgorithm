package QPACEIV.nonterminals;

import Jama.Matrix;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import ec.gp.GPNode;

/**
 * @author  sam
 */
public abstract class NonTerminalSuper extends GPNode {

	/**
	 * @uml.property  name="operation"
	 * @uml.associationEnd  
	 */
	protected Matrix operation;
	/**
	 * @uml.property  name="current_operation"
	 * @uml.associationEnd  
	 */
	protected Matrix current_operation;

	/**
	 * @return
	 * @uml.property  name="operation"
	 */
	public Matrix getOperation() {
		return operation;
	}

	public Matrix getCurrentOperation() {
		return current_operation;
	}

	public abstract QPaceIVQuantumState apply_operation(
			QPaceIVQuantumState state_0);
}
