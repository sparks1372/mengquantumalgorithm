package Core.CircuitEvaluator.Implementation;

import java.util.Iterator;
import java.util.Set;

import Core.quantumproblem;
import Core.testcase;
import Core.testset;
import Core.testsuite;
import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.Circuit.quantumgate;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.Fitness;
import Core.CircuitEvaluator.FitnessFunction;
import Core.CircuitEvaluator.circuitevaluator;
import Jama.Matrix;

public class basiccircuitevaluator implements circuitevaluator {
	private quantumproblem quantprob;
	private FitnessFunction ff;
	private final circuitBuilder cb;

	public basiccircuitevaluator(circuitBuilder cirbui) {
		cb = cirbui;
	}

	@Override
	public Fitness Evaluate(QuantumAlgorithm alg) {
		double fitness_to_return = 0;
		int count = 0;

		if (alg.getSize() == 0) {

			return new Fitness(Float.MAX_VALUE, 0);
		}
		Circuit cir;
		Iterator<quantumgate> qgate_iter;
		testsuite ts = quantprob.getTestSuite();
		testcase tc;
		Set<Integer> keys = ts.getKeys();

		Iterator<Integer> kiter = keys.iterator();
		Fitness temp;

		while (kiter.hasNext()) {
			int numofqubits = kiter.next();
			testset tempts = ts.getTestcases(numofqubits);
			cir = cb.Build(alg, numofqubits);
			Iterator<testcase> tciter = tempts.getTestcases();
			quantumgate qg;
			while (tciter.hasNext()) {
				tc = tciter.next();
				qgate_iter = cir.getCircuitlayout();
				Matrix state = tc.getStartingstate();
				while (qgate_iter.hasNext()) {
					qg = qgate_iter.next();
					state = qg.apply(state);
				}
				boolean same = true;
				for (int i = 0; same && (i < state.getRowDimension()); i++) {
					if ((state.get(i, 0).real() != tc.getStartingstate()
							.get(i, 0).real())
							&& (state.get(i, 0).imag() != tc.getStartingstate()
									.get(i, 0).imag())) {
						same = false;
					}
				}
				if (same) {
					return new Fitness(Float.MAX_VALUE, 0);
				}
				temp = ff.evaluate(tc.getStartingstate(), state,
						tc.getFinalstate(), cir, alg);
				fitness_to_return += temp.getFitness();
				count += temp.getPerfectcount();
			}

		}
		if (fitness_to_return > Float.MAX_VALUE) {
			return new Fitness(Float.MAX_VALUE, 0);
		}

		return new Fitness(fitness_to_return, count);
	}

	@Override
	public FitnessFunction getQfitnessfunction() {
		return ff;
	}

	@Override
	public quantumproblem getQproblem() {
		return quantprob;
	}

	@Override
	public void setQfitnessfunction(FitnessFunction qfitnessfunction) {
		ff = qfitnessfunction;
	}

	@Override
	public void setQproblem(quantumproblem qproblem) {
		quantprob = qproblem;
	}

}
