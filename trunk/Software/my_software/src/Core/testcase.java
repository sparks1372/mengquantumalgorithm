package Core;

import Jama.Matrix;

public class testcase {

	public testcase(int id, String label) {
		this.id = id;
		this.label = label;
	}

	/**
	 * @uml.property name="startingstate"
	 */
	private Matrix startingstate;

	/**
	 * Getter of the property <tt>label</tt>
	 * 
	 * @return Returns the label.
	 * @uml.property name="label"
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @uml.property name="label"
	 */
	private String label;

	/**
	 * @uml.property name="id"
	 */
	private int id;

	/**
	 * Getter of the property <tt>id</tt>
	 * 
	 * @return Returns the id.
	 * @uml.property name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter of the property <tt>startingstate</tt>
	 * 
	 * @return Returns the startingstate.
	 * @uml.property name="startingstate"
	 */
	public Matrix getStartingstate() {
		return startingstate;
	}

	/**
	 * Setter of the property <tt>startingstate</tt>
	 * 
	 * @param startingstate
	 *            The startingstate to set.
	 * @uml.property name="startingstate"
	 */
	public void setStartingstate(Matrix startingstate) {
		this.startingstate = startingstate;
	}

	/**
	 * @uml.property name="finalstate"
	 */
	private Matrix finalstate;

	/**
	 * Getter of the property <tt>finalstate</tt>
	 * 
	 * @return Returns the finalstate.
	 * @uml.property name="finalstate"
	 */
	public Matrix getFinalstate() {
		return finalstate;
	}

	/**
	 * Setter of the property <tt>finalstate</tt>
	 * 
	 * @param finalstate
	 *            The finalstate to set.
	 * @uml.property name="finalstate"
	 */
	public void setFinalstate(Matrix finalstate) {
		this.finalstate = finalstate;
	}

}
