package Core.Algorithms.Implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstruction;
import Core.Algorithms.QuantumInstructionEnum;

public class basicquantumalgorithm implements QuantumAlgorithm {
	private final LinkedList<QuantumInstruction>	inst_list;
	private int										size	= 0;
	private int										val_sum	= 0;

	public basicquantumalgorithm() {
		inst_list = new LinkedList<QuantumInstruction>();
	}

	@Override
	public void addInstruction(QuantumInstructionEnum inst, int gate1,
			int gate2, double phase, QuantumAlgorithm[] subalg) {

		QuantumInstruction to_add = new basicquantuminstruction();
		switch (inst) {
			case Body:
			case Iterate:
				// case Root:
				size = size + 5;
				break;
			default:
				size = size + 1;
				break;
		}
		val_sum += Math.abs(gate1);
		val_sum += Math.abs(gate2);
		to_add.setInstruction(inst);
		to_add.setInteger1(gate1);
		to_add.setInteger2(gate2);
		to_add.setDouble1(phase);
		to_add.setSubalg(subalg);
		if (to_add.getSubalg() == null) {
			basicquantumalgorithm[] temp = new basicquantumalgorithm[0];
			to_add.setSubalg(temp);
		}
		for (int i = 0; i < to_add.getSubalg().length; i++) {
			size = size + to_add.getSubalg()[i].getSize();

			val_sum += to_add.getSubalg()[i].getValSum();
		}

		inst_list.add(to_add);
	}

	@Override
	public ListIterator<QuantumInstruction> getInstructions() {
		return inst_list.listIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Algorithms.QuantumAlgorithm#size()
	 */
	@Override
	public int getSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Algorithms.QuantumAlgorithm#getValSum()
	 */
	@Override
	public int getValSum() {
		// TODO Auto-generated method stub
		return val_sum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Algorithms.QuantumAlgorithm#print()
	 */
	@Override
	public String print() {
		String to_return = "";
		String ins;
		QuantumInstruction qi;
		Iterator<QuantumInstruction> iter = getInstructions();
		while (iter.hasNext()) {
			qi = iter.next();
			if (qi.getSubalg().length == 0) {
				ins = qi.getInstruction().name() + " on gate "
						+ qi.getInteger1() + " and gate " + qi.getInteger2()
						+ " with phase " + qi.getDouble1() + "\n";
			} else if ((qi.getInstruction() == QuantumInstructionEnum.Iterate)
					&& (qi.getSubalg().length != 0)) {
				ins = qi.getInstruction().name() + " for " + qi.getInteger1()
						+ " iterations {\n";
				for (int i = 0; i < qi.getSubalg().length; i++) {
					ins = ins.concat(qi.getSubalg()[i].print());
				}
				ins = ins.concat("}\n");
			} else if (qi.getSubalg().length != 0) {
				ins = "{\n";
				for (int i = 0; i < qi.getSubalg().length; i++) {
					ins = ins.concat(qi.getSubalg()[i].print());
				}
				ins = ins.concat("}\n");
			} else {
				ins = new String();
			}

			to_return = to_return.concat(ins);
		}

		return to_return;
	}
}
