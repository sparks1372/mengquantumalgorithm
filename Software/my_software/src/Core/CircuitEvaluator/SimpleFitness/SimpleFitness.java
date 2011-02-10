package Core.CircuitEvaluator.SimpleFitness;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.CircuitEvaluator.Fitness;
import Core.CircuitEvaluator.FitnessFunction;
import Jama.Matrix;
import Testing.predefined_states;

public class SimpleFitness implements FitnessFunction {
	public static void main(String[] args) {
		SimpleFitness test = new SimpleFitness();

		System.out.println("2 qubits state 00, Pauli X Qubit 1");
		Matrix final_state = predefined_states.get_2q_0();
		Matrix expected_state = predefined_states.get_2q_1();
		final_state.print_state(0, 0);
		expected_state.print_state(0, 0);
		Fitness fitness = test.evaluate(predefined_states.get_2q_0(),
				final_state, expected_state, null, null);
		System.out.println("Fitness : " + fitness.getFitness());

	}

	private final String	name	= "Simple Fitness";

	@Override
	public Fitness evaluate(Matrix start_state, Matrix final_state,
			Matrix expected_state, Circuit circuit, QuantumAlgorithm algo) {
		if (Matrix.euclid(start_state, expected_state).getFitness() == 0) {
			return new Fitness(0, 0);
		}
		if (Matrix.euclid(start_state, final_state).getFitness() == 0) {
			return new Fitness((Float.MAX_VALUE / 128), 0);
		}
		if (Matrix.euclid(final_state, expected_state).getFitness() == 0) {
			return new Fitness(0, Matrix.euclid(final_state, expected_state)
					.getPerfectcount());
		}
		return Matrix.euclid(expected_state, final_state);
	}

	@Override
	public String getName() {
		return name;
	}

}
