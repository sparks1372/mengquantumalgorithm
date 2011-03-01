package Core.CircuitBuilder;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;

public interface circuitBuilder {

	/**
		 */
	public abstract Circuit Build(QuantumAlgorithm quantumAlgorithm,
			int num_qubits);

	/**
	 */
	public abstract Circuit Build(QuantumAlgorithm quantumAlgorithm,
			int num_qubits, int[] loopvars);

}
