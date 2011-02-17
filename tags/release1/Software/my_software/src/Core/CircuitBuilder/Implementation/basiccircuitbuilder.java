package Core.CircuitBuilder.Implementation;

import java.util.ListIterator;
import java.util.Random;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstruction;
import Core.Circuit.Circuit;
import Core.Circuit.Implementation.basiccircuit;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvolution.GateImplementations.ControlledU_Gate;
import Core.CircuitEvolution.GateImplementations.Hadamard_Gate;
import Core.CircuitEvolution.GateImplementations.Pauli_X;
import Core.CircuitEvolution.GateImplementations.Pauli_Y;
import Core.CircuitEvolution.GateImplementations.Pauli_Z;
import Core.CircuitEvolution.GateImplementations.Phase_Gate;
import Core.CircuitEvolution.GateImplementations.RX_Gate;
import Core.CircuitEvolution.GateImplementations.RY_Gate;
import Core.CircuitEvolution.GateImplementations.RZ_Gate;
import Core.CircuitEvolution.GateImplementations.Swap_Gate;
import Core.CircuitEvolution.GateImplementations.V_Gate;
import Core.CircuitEvolution.GateImplementations.W_Gate;
import Core.CircuitEvolution.GateImplementations.Zero_Gate;
import Core.CircuitEvolution.QPace4.terminal.Variables.LoopVar;
import Core.CircuitEvolution.QPace4.terminal.Variables.SystemSize;

public class basiccircuitbuilder implements circuitBuilder {
	private final int	Builder_ID;

	public basiccircuitbuilder() {
		Random rand = new Random();
		Builder_ID = rand.nextInt();
	}

	@Override
	public Circuit Build(QuantumAlgorithm quantumAlgorithm, int num_qubits) {
		return Build(quantumAlgorithm, num_qubits, SystemSize.SYSTEM_SIZE_FLAG);
	}

	@Override
	public Circuit Build(QuantumAlgorithm quantumAlgorithm, int num_qubits,
			int loopvar) {
		QuantumAlgorithm[] qcarray;
		Circuit to_return = new basiccircuit(Builder_ID);
		Circuit temp = null;
		basiccircuitbuilder internal_builder = new basiccircuitbuilder();
		int Int1;
		int Int2;
		double Double1;

		ListIterator<QuantumInstruction> iter = quantumAlgorithm
				.getInstructions();
		QuantumInstruction next_instruction;
		while (iter.hasNext()) {
			next_instruction = iter.next();
			Int1 = next_instruction.getInteger1();
			Int2 = next_instruction.getInteger2();
			Double1 = next_instruction.getDouble1();

			Int1 = (Int1 == LoopVar.LOOP_VARIABLE) ? loopvar : Int1;
			Int2 = (Int2 == LoopVar.LOOP_VARIABLE) ? loopvar : Int2;

			Int1 = (Int1 == SystemSize.SYSTEM_SIZE_FLAG) ? num_qubits : Int1;
			Int2 = (Int2 == SystemSize.SYSTEM_SIZE_FLAG) ? num_qubits : Int2;

			// If the requested Qubit number is greater than the number of
			// Qubits available then set it to the System Size, final Qubit
			Int1 = (Int1 > num_qubits) ? num_qubits : Int1;
			Int2 = (Int2 > num_qubits) ? num_qubits : Int2;

			Int1 = (Int1 < 1) ? 1 : Int1;
			Int2 = (Int2 < 1) ? 1 : Int2;

			// System.out.println("Int1 = " + Int1);
			// System.out.println("Int2 = " + Int2);

			switch (next_instruction.getInstruction()) {
				case Create_H:
					to_return.addGate(Builder_ID, new Hadamard_Gate(Int1));
					break;
				case Create_X:
					to_return.addGate(Builder_ID, new Pauli_X(Int1));
					break;
				case Create_Y:
					to_return.addGate(Builder_ID, new Pauli_Y(Int1));
					break;
				case Create_Z:
					to_return.addGate(Builder_ID, new Pauli_Z(Int1));
					break;
				case Create_P:
					to_return
							.addGate(Builder_ID, new Phase_Gate(Int1, Double1));
					break;
				case Create_RX:
					to_return.addGate(Builder_ID, new RX_Gate(Int1, Double1));
					break;
				case Create_RY:
					to_return.addGate(Builder_ID, new RY_Gate(Int1, Double1));
					break;
				case Create_RZ:
					to_return.addGate(Builder_ID, new RZ_Gate(Int1, Double1));
					break;
				case Create_SWAP:
					if (Int1 != Int2) {
						to_return
								.addGate(Builder_ID, new Swap_Gate(Int1, Int2));
					}
					break;
				case Create_V:
					to_return.addGate(Builder_ID, new V_Gate(Int1));
					break;
				case Create_W:
					to_return.addGate(Builder_ID, new W_Gate(Int1));
					break;
				case Create_Zero:
					to_return.addGate(Builder_ID, new Zero_Gate(Int1));
					break;
				case Create_CH:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new Hadamard_Gate(1)), Int1, Int2));
					}
					break;
				case Create_CX:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new Pauli_X(1)), Int1, Int2));
					}
					break;
				case Create_CY:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new Pauli_Y(1)), Int1, Int2));
					}
					break;
				case Create_CZ:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new Pauli_Z(1)), Int1, Int2));
					}
					break;
				case Create_CP:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new Phase_Gate(1, Double1)), Int1, Int2));
					}
					break;
				case Create_CRX:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new RX_Gate(1, Double1)), Int1, Int2));
					}
					break;
				case Create_CRY:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new RY_Gate(1, Double1)), Int1, Int2));
					}
					break;
				case Create_CRZ:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new RZ_Gate(1, Double1)), Int1, Int2));
					}
					break;
				case Create_CV:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new V_Gate(1)), Int1, Int2));
					}
					break;
				case Create_CW:
					if (Int1 != Int2) {
						to_return.addGate(Builder_ID, new ControlledU_Gate(
								(new W_Gate(1)), Int1, Int2));
					}
					break;
				// case Root:
				case Body:
					qcarray = next_instruction.getSubalg();

					for (QuantumAlgorithm element : qcarray) {
						temp = internal_builder.Build(element, num_qubits);
						to_return.addCircuit(Builder_ID, temp);
					}
					break;
				case Iterate:
					qcarray = next_instruction.getSubalg();

					for (int i = 1; (qcarray.length > 0) && (i <= Int1); i++) {
						try {
							temp = internal_builder.Build(qcarray[0],
									num_qubits, i);
						} catch (NullPointerException e) {
							e.printStackTrace();
						}
						to_return.addCircuit(Builder_ID, temp);
					}
					break;

				default:
					break;
			}
		}

		return to_return;
	}
}
