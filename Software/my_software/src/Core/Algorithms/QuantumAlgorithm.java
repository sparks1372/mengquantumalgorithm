package Core.Algorithms;

import java.util.ListIterator;

public interface QuantumAlgorithm {

	public abstract void addInstruction(QuantumInstructionEnum inst,
			exp_node gate1, exp_node gate2, exp_node phase,
			QuantumAlgorithm[] subalg);

	/**
		 */
	public abstract ListIterator<QuantumInstruction> getInstructions();

	public abstract int getSize();

	public abstract int getValSum();

	public abstract String print();
}
