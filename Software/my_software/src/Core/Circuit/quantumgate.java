package Core.Circuit;

import Jama.Matrix;

public interface quantumgate {

	/**
			 */
	public abstract String toLatex();

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
	public Matrix getUnitary_operation();

		
		/**
		 */
		public abstract Matrix apply(Matrix start_state);
		

}
