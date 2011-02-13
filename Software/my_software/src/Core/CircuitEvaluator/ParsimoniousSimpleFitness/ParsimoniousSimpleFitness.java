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

	private final String name = "Parsimonious Simple Fitness";

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
			if (s != f && f != e) {
				fit += Math.abs(f - e);
				// System.out.println("f = " + f + " e = " + e + " fit = " +
				// fit);
			} else if (s != f && e == 1 && f > 0.55) {
				// System.out.println(" f==e f = " + f + " e = " + e);
				count++;
			} else if (s != e) {
				fit += 1;
			}
		}
		int size = circuit.getSize() + algo.getSize();
		fit = ((fit) / (final_state.getRowDimension() - 1)) * 100;
		fit = size + fit;
		// System.out.println("fit  = " + fit + "\ncircuit \n"
		// + circuit.toLatex(3) + "algo " + algo.print() + "\nAlgoSum "
		// + algo.getValSum());
		return new Fitness(fit + algo.getValSum(), count);
	}

	@Override
	public String getName() {
		return name;
	}

}
