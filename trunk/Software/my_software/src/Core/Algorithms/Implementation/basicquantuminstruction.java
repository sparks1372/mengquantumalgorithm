package Core.Algorithms.Implementation;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstruction;
import Core.Algorithms.QuantumInstructionEnum;

public class basicquantuminstruction implements QuantumInstruction {
	private QuantumInstructionEnum inst;
	private int gate1;
	private int gate2;
	private double phase;
	private QuantumAlgorithm[] subalg;

	@Override
	public QuantumInstructionEnum getInstruction() {
		return inst;
	}

	@Override
	public void setInstruction(QuantumInstructionEnum instruction) {
		inst = instruction;
	}

	@Override
	public int getInteger1() {
		return gate1;
	}

	@Override
	public void setInteger1(int gate1) {
		this.gate1 = gate1;
	}

	@Override
	public int getInteger2() {
		return gate2;
	}

	@Override
	public void setInteger2(int gate2) {
		this.gate2 = gate2;
	}

	@Override
	public double getDouble1() {
		return phase;
	}

	@Override
	public void setDouble1(double phase) {
		this.phase = phase;
	}

	@Override
	public QuantumAlgorithm[] getSubalg() {
		return subalg;
	}

	@Override
	public void setSubalg(QuantumAlgorithm[] subalg) {
		this.subalg = subalg;
	}

}
