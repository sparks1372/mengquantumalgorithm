package Core.CircuitEvaluator.ParsimoniousSimpleFitness;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.CircuitEvaluator.Fitness;
import Core.CircuitEvaluator.FitnessFunction;
import Jama.Matrix;
import Testing.predefined_states;

public class ParsimoniousSimpleFitness implements FitnessFunction {
	public static void main(String[] args) {
		ParsimoniousSimpleFitness test = new ParsimoniousSimpleFitness();

		System.out.println("2 qubits state 00, Pauli X Qubit 1");
		Matrix final_state = predefined_states.get_2q_0();
		Matrix expected_state = predefined_states.get_2q_1();
		final_state.print_state(0, 0);
		expected_state.print_state(0, 0);
		Fitness fitness = test.evaluate(predefined_states.get_2q_0(),
				final_state, expected_state, null, null);
		System.out.println("Fitness : " + fitness.getFitness());

	}

	private final String	name	= "Parsimonious Simple Fitness";

	@Override
	public Fitness evaluate(Matrix start_state, Matrix final_state,
			Matrix expected_state, Circuit circuit, QuantumAlgorithm algo) {
		if (Matrix.euclid(start_state, expected_state).getFitness() == 0) {
			return new Fitness(0, 0);
		}
		if (Matrix.euclid(start_state, final_state).getFitness() == 0) {
			return new Fitness((Float.MAX_VALUE / 128), 0);
		}
		Double fitness = Matrix.euclid(expected_state, final_state)
				.getFitness();
		int count = Matrix.euclid(expected_state, final_state)
				.getPerfectcount();
		fitness *= 1024;
		if (circuit.getSize() != 0) {
			int size = circuit.getSize() + algo.getSize();
			fitness = size + fitness;
		} else {
			fitness = (double) (Float.MAX_VALUE / 128);
		}
		if (Matrix.euclid(final_state, expected_state).getFitness() == 0) {
			return new Fitness(fitness, count);
		}
		return new Fitness(fitness, count);
	}

	@Override
	public String getName() {
		return name;
	}

}
