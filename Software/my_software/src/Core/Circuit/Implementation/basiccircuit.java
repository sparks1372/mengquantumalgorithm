package Core.Circuit.Implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import Core.Circuit.Circuit;
import Core.Circuit.quantumgate;
import Core.CircuitEvolution.GateImplementations.ControlledU_Gate;
import Core.CircuitEvolution.GateImplementations.Swap_Gate;

public class basiccircuit implements Circuit {
	private final int						builder_id;
	private final LinkedList<quantumgate>	circuit;

	public basiccircuit(int builderid) {
		builder_id = builderid;
		circuit = new LinkedList<quantumgate>();
	}

	@Override
	public void addCircuit(int b_id, Circuit circuit)
			throws IllegalArgumentException {
		if (b_id != builder_id) {
			throw new IllegalArgumentException(
					"Builder ID does not match the ID provided at construction");
		}
		if (circuit instanceof basiccircuit) {
			this.circuit.addAll(((basiccircuit) circuit).getCircuit());
		} else {
			Iterator<quantumgate> iter = circuit.getCircuitlayout();
			while (iter.hasNext()) {
				this.circuit.add(iter.next());
			}
		}
	}

	@Override
	public void addGate(int b_id, quantumgate quantumgate)
			throws IllegalArgumentException {
		if (b_id != builder_id) {
			throw new IllegalArgumentException(
					"Builder ID does not match the ID provided at construction");
		}
		circuit.add(quantumgate);
	}

	protected LinkedList<quantumgate> getCircuit() {
		return circuit;
	}

	@Override
	public ListIterator<quantumgate> getCircuitlayout() {
		return circuit.listIterator();
	}

	@Override
	public int getSize() {
		return circuit.size();
	}

	@Override
	public String toLatex(int qubits) {
		String[] cir_diag = new String[qubits];

		for (int i = 0; i < cir_diag.length; i++) {
			cir_diag[i] = new String();
		}

		Iterator<quantumgate> cir_iter = getCircuitlayout();
		quantumgate next_gate;

		while (cir_iter.hasNext()) {
			next_gate = cir_iter.next();

			if (next_gate instanceof Swap_Gate) {
				for (int i = 0; i < qubits; i++) {
					if (i == (((Swap_Gate) next_gate).getTarget() - 1)) {
						cir_diag[i] = cir_diag[i]
								.concat(((Swap_Gate) next_gate).toLatex(false));
					} else if (i == (((Swap_Gate) next_gate).getTarget2() - 1)) {
						cir_diag[i] = cir_diag[i]
								.concat(((Swap_Gate) next_gate).toLatex(true));
					} else if ((i > (((Swap_Gate) next_gate).getTarget() - 1))
							&& (i < (((Swap_Gate) next_gate).getTarget2() - 1))) {
						cir_diag[i] = cir_diag[i].concat("\\qw \\qwx&");
					} else {
						cir_diag[i] = cir_diag[i].concat("\\qw&");
					}
				}
			} else if (next_gate instanceof ControlledU_Gate) {
				for (int i = 0; i < qubits; i++) {
					if (i == (((ControlledU_Gate) next_gate).getTarget() - 1)) {
						cir_diag[i] = cir_diag[i]
								.concat(((ControlledU_Gate) next_gate)
										.toLatex());
					} else if ((i == (((ControlledU_Gate) next_gate)
							.getControl() - 1))
							&& (((ControlledU_Gate) next_gate).getTarget() > ((ControlledU_Gate) next_gate)
									.getControl())) {
						cir_diag[i] = cir_diag[i].concat("\\ctrl \\qwx&");
					} else if (i == (((ControlledU_Gate) next_gate)
							.getControl() - 1)) {
						cir_diag[i] = cir_diag[i].concat("\\ctrl &");
					} else if ((i > (((ControlledU_Gate) next_gate).getTarget() - 1))
							&& (i < (((ControlledU_Gate) next_gate)
									.getControl() - 1))) {
						cir_diag[i] = cir_diag[i].concat("\\qw \\qwx&");
					} else if ((i < (((ControlledU_Gate) next_gate).getTarget() - 1))
							&& (i > (((ControlledU_Gate) next_gate)
									.getControl() - 1))) {
						cir_diag[i] = cir_diag[i].concat("\\qw \\qwx&");
					} else {
						cir_diag[i] = cir_diag[i].concat("\\qw&");
					}
				}
			} else {
				for (int i = 0; i < qubits; i++) {
					if (i == (next_gate.getTarget() - 1)) {
						cir_diag[i] = cir_diag[i].concat(next_gate.toLatex());
					} else {
						cir_diag[i] = cir_diag[i].concat("\\qw&");
					}
				}
			}
		}

		String to_return = new String();
		String new_line = "\\\\\n";
		to_return = to_return
				.concat("\\begin{figure}\n\\[\n\\Qcircuit @C=1.0em @R=.7em {\n");

		for (String element : cir_diag) {
			to_return = to_return.concat(element);
			to_return = to_return.concat(new_line);
		}

		to_return = to_return.concat("}\n\\]\n\\end{figure}\n");

		return to_return;

	}
}
