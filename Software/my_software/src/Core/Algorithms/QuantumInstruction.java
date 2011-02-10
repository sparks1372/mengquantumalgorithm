package Core.Algorithms;

public interface QuantumInstruction {

	/**
	 * @return Returns the instruction.
	 * @uml.property name="instruction"
	 */
	public QuantumInstructionEnum getInstruction();

	/**
	 * Setter of the property <tt>instruction</tt>
	 * 
	 * @param instruction
	 *            The instruction to set.
	 * @uml.property name="instruction"
	 */
	public void setInstruction(QuantumInstructionEnum instruction);

	/**
	 * @return Returns the subalgs.
	 * @uml.property name="subalg" multiplicity="(0 -1)" dimension="1"
	 */
	public QuantumAlgorithm[] getSubalg();

	/**
	 * Setter of the property <tt>subalg</tt>
	 * 
	 * @param subalg
	 *            The subalgs to set.
	 * @uml.property name="subalg"
	 */
	public void setSubalg(QuantumAlgorithm[] subalg);

	/** 
	 * @return Returns the controls.
	 * @uml.property  name="integer1"
	 */
	public int getInteger1();

	/** 
	 * Setter of the property <tt>Control</tt>
	 * @param Control The controls to set.
	 * @uml.property  name="integer1"
	 */
	public void setInteger1(int integer1);

	/** 
	 * @return Returns the gate2.
	 * @uml.property  name="integer2"
	 */
	public int getInteger2();

	/** 
	 * Setter of the property <tt>gate2</tt>
	 * @param gate2 The gate2 to set.
	 * @uml.property  name="integer2"
	 */
	public void setInteger2(int integer2);

	/** 
	 * @return  Returns the phase.
	 * @uml.property  name="double1"
	 */
	public double getDouble1();

	/** 
	 * Setter of the property <tt>phase</tt>
	 * @param phase  The phase to set.
	 * @uml.property  name="double1"
	 */
	public void setDouble1(double double1);

}
