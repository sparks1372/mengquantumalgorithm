package Core.Algorithms;

import java.util.ListIterator;

public interface QuantumAlgorithm {

	public abstract void addInstruction(QuantumInstructionEnum inst, int gate1,
			int gate2, double phase, QuantumAlgorithm[] subalg);

	/**
		 */
	public abstract ListIterator<QuantumInstruction> getInstructions();

	public abstract int getSize();

	public abstract int getValSum();

	public abstract String print();
}
