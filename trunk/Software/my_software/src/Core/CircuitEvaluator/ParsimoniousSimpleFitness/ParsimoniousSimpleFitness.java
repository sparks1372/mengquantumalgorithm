package Core.CircuitEvaluator.ParsimoniousSimpleFitness;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.CircuitEvaluator.Fitness;
import Core.CircuitEvaluator.FitnessFunction;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

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

		double fit = 0.0;
		int count = 0;
		for (int i = 0; i < final_state.getRowDimension(); i++) {

			Complex resulting = final_state.get(i, 0).minus(
					expected_state.get(i, 0));
			Complex resulting_phase_flip = final_state.get(i, 0).minus(
					expected_state.get(i, 0).times(new Complex(-1, 0)));
			// System.out.println("final_state.get(i, 0) = "
			// + final_state.get(i, 0).toString()
			// + " expected_state.get(i, 0) = " + expected_state.get(i, 0)
			// + " resulting vector is " + resulting + " resulting.mod() "
			// + resulting.mod());
			resulting = resulting.mod() < resulting_phase_flip.mod() ? resulting
					: resulting_phase_flip;

			if (resulting.mod() > 0) {
				fit += resulting.mod();
				// System.out.println(" fit = " + fit);
			} else {
				// System.out.println(" f==e f = " + f + " e = " + e);
				count++;
			}
		}
		int size = circuit.getSize() + algo.getSize();
		fit = fit * 100;
		fit = size + fit;
		// System.out.println("fit  = " + fit + "\ncircuit \n"
		// + circuit.toLatex(3) + "algo " + algo.print() + "\nAlgoSum "
		// + algo.getValSum());
		return new Fitness(fit /* + algo.getValSum() */, count);
	}

	@Override
	public String getName() {
		return name;
	}

}
