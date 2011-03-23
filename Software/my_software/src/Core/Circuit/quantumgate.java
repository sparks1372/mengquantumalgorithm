package Core.Circuit;

import Jama.Matrix;

public interface quantumgate {

	/**
	 */
	public abstract Matrix apply(Matrix start_state, String[] customGateDefs);

	/**
	 */
	public abstract String getlabel();

	/**
	 * @return Returns the target.
	 * @uml.property name="target" readOnly="true"
	 */
	public int getTarget();

	/**
	 * @return Returns the unitary_operation.
	 * @uml.property name="unitary_operation" readOnly="true"
	 *               default="new Jama.Matrix()"
	 */
	public Matrix getUnitary_operation(String[] customGateDefs);

	/**
				 */
	public abstract String toLatex();

}
