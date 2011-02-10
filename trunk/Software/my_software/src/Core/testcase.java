package Core;

import Jama.Matrix;


public class testcase {

	/**
	 * @uml.property  name="startingstate"
	 */
	private Matrix startingstate;

	/**
	 * Getter of the property <tt>startingstate</tt>
	 * @return  Returns the startingstate.
	 * @uml.property  name="startingstate"
	 */
	public Matrix getStartingstate() {
		return startingstate;
	}

	/**
	 * Setter of the property <tt>startingstate</tt>
	 * @param startingstate  The startingstate to set.
	 * @uml.property  name="startingstate"
	 */
	public void setStartingstate(Matrix startingstate) {
		this.startingstate = startingstate;
	}

	/**
	 * @uml.property  name="finalstate"
	 */
	private Matrix finalstate;

	/**
	 * Getter of the property <tt>finalstate</tt>
	 * @return  Returns the finalstate.
	 * @uml.property  name="finalstate"
	 */
	public Matrix getFinalstate() {
		return finalstate;
	}

	/**
	 * Setter of the property <tt>finalstate</tt>
	 * @param finalstate  The finalstate to set.
	 * @uml.property  name="finalstate"
	 */
	public void setFinalstate(Matrix finalstate) {
		this.finalstate = finalstate;
	}

}
