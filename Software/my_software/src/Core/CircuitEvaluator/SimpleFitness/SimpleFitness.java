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
		double fit = 0.0;
		int count = 0;
		for (int i = 0; i < final_state.getRowDimension(); i++) {
			double s = start_state.get(i, 0)
					.times(start_state.get(i, 0).conj()).mod();
			double f = final_state.get(i, 0)
					.times(final_state.get(i, 0).conj()).mod();
			double e = expected_state.get(i, 0)
					.times(expected_state.get(i, 0).conj()).mod();
			if (f != e) {
				// System.out.println("f = " + f + " e = " + e + " fit + "
				// + Math.abs(f - e));
				fit += Math.abs(f - e);
			} else if (s != f) {
				// System.out.println(" f==e f = " + f + " e = " + e);
				count++;
			}
		}

		// System.out.println("fit  = " + fit + "\ncircuit \n"
		// + circuit.toLatex(3) + "algo " + algo.print() + "\nAlgoSum "
		// + algo.getValSum());
		return new Fitness(fit * fit + algo.getValSum(), count);
	}

	@Override
	public String getName() {
		return name;
	}

}
