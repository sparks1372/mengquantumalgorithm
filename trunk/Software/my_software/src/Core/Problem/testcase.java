package Core.Problem;

import java.io.Serializable;

import Jama.Matrix;

public class testcase implements Serializable {

	/**
	 * @uml.property name="startingstate"
	 */
	private Matrix			startingstate;

	/**
	 * @uml.property name="label"
	 */
	private final String	label;

	/**
	 * @uml.property name="id"
	 */
	private final int		id;

	/**
	 * @uml.property name="finalstate"
	 */
	private Matrix			finalstate;

	public testcase(int id, String label) {
		this.id = id;
		this.label = label;
	}

	/**
	 * @return
	 */
	public testcase copy() {
		testcase to_ret = new testcase(getId(), getLabel());
		to_ret.setStartingstate(getStartingStateCopy());
		to_ret.setFinalstate(getFinalStateCopy());
		return to_ret;
	}

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
	 * Getter of the property <tt>finalstate</tt> BE CAREFULL WHEN USING, ONLY
	 * TO BE USED WHEN EDITTING THE TEST CASE. FOR READ-ONLY USE getFinalstate
	 * INSTEAD.
	 * 
	 * @return Returns the finalstate.
	 * @uml.property name="finalstate"
	 */
	public Matrix getFinalStateCopy() {
		return finalstate.copy();
	}

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
	 * Getter of the property <tt>label</tt>
	 * 
	 * @return Returns the label.
	 * @uml.property name="label"
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Getter of the property <tt>startingstate</tt> BE CAREFULL WHEN USING,
	 * ONLY TO BE USED WHEN EDITTING THE TEST CASE. FOR READ-ONLY USE
	 * getStartingStateCopy INSTEAD.
	 * 
	 * @return Returns the startingstate.
	 * @uml.property name="startingstate"
	 */
	public Matrix getStartingState() {
		return startingstate;
	}

	/**
	 * Getter of the property <tt>startingstate</tt>
	 * 
	 * @return Returns the startingstate.
	 * @uml.property name="startingstate"
	 */
	public Matrix getStartingStateCopy() {
		return startingstate.copy();
	}

	/**
	 * Setter of the property <tt>finalstate</tt>
	 * 
	 * @param finalstate
	 *            The finalstate to set.
	 * @uml.property name="finalstate"
	 */
	public void setFinalstate(Matrix finalstate) {
		this.finalstate = finalstate.copy();
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

}