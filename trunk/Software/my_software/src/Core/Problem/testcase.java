package Core.Problem;

import java.io.Serializable;

import Jama.Matrix;

public class testcase implements Serializable {

	/**
	 * @uml.property name="startingstate"
	 */
	private Matrix		startingstate;

	/**
	 * @uml.property name="label"
	 */
	private String		label;

	/**
	 * @uml.property name="id"
	 */
	private int			id;

	/**
	 * @uml.property name="finalstate"
	 */
	private Matrix		finalstate;

	private String[]	customGates;

	public testcase(int id, String label, int numCustomGates) {
		this.id = id;
		this.label = label;
		customGates = new String[numCustomGates];
	}

	public testcase(int id, String label, String[] customGates) {
		this.id = id;
		this.label = label;
		this.customGates = customGates;
	}

	/**
	 * @return
	 */
	public testcase copy() {
		testcase to_ret = new testcase(getId(), getLabel(), getCustomGates());
		to_ret.setStartingstate(getStartingStateCopy());
		to_ret.setFinalstate(getFinalStateCopy());
		return to_ret;
	}

	/**
	 * @return the customGates
	 */
	public String[] getCustomGates() {
		return customGates.clone();
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
	 * @param customGates
	 *            the customGates to set
	 */
	public void setCustomGates(int index, String customGates) {
		this.customGates[index] = customGates;
	}

	/**
	 * @param customGates
	 *            the customGates to set
	 */
	private void setCustomGates(String[] customGates) {
		this.customGates = customGates;
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
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
