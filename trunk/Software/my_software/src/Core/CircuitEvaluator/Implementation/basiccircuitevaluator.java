package Core.CircuitEvaluator.Implementation;

import java.util.Iterator;
import java.util.Set;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.Circuit.quantumgate;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.Fitness;
import Core.CircuitEvaluator.FitnessFunction;
import Core.CircuitEvaluator.circuitevaluator;
import Core.Problem.quantumproblem;
import Core.Problem.testcase;
import Core.Problem.testset;
import Core.Problem.testsuite;
import Jama.Matrix;

public class basiccircuitevaluator implements circuitevaluator {
	private quantumproblem			quantprob;
	private FitnessFunction			ff;
	private final circuitBuilder	cb;

	public basiccircuitevaluator(circuitBuilder cirbui) {
		cb = cirbui;
	}

	@Override
	public Fitness Evaluate(QuantumAlgorithm alg) {
		double fitness_to_return = 0;
		int count = 0;
		int possiblecount = 0;

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
				cir.getSize();
				Matrix state = tc.getStartingstate().copy();
				while (qgate_iter.hasNext()) {
					qg = qgate_iter.next();
					state = qg.apply(state);
				}
				// boolean same = true;
				// for (int i = 0; same && (i < state.getRowDimension()); i++) {
				// if (((state.get(i, 0).real() != tc.getStartingstate()
				// .get(i, 0).real()) && (tc.getStartingstate()
				// .get(i, 0).real() != tc.getFinalstate().get(i, 0)
				// .real()))
				// || ((state.get(i, 0).imag() != tc
				// .getStartingstate().get(i, 0).imag()) && (tc
				// .getStartingstate().get(i, 0).imag() != tc
				// .getFinalstate().get(i, 0).imag()))) {
				// same = false;
				// }
				// }

				temp = ff.evaluate(tc.getStartingstate(), state,
						tc.getFinalstate(), cir, alg);
				fitness_to_return += temp.getFitness();
				count += temp.getPerfectcount();
				possiblecount += state.getRowDimension();
				// if (same) {
				// fitness_to_return = fitness_to_return < 1 ? 1
				// : fitness_to_return;
				// fitness_to_return *= 2;
				// System.out.println("HERE!!!!!! count = " + count
				// + " possible count = " + possiblecount);
				// }
			}

		}
		if (fitness_to_return > Float.MAX_VALUE) {
			return new Fitness(Float.MAX_VALUE, 0);
		}
		fitness_to_return = count != 0 ? fitness_to_return
				/ ((double) count / possiblecount) : Float.MAX_VALUE;

		fitness_to_return = count == possiblecount ? 0 : fitness_to_return;

		// if (fitness_to_return < 15.701) {
		// keys = ts.getKeys();
		//
		// kiter = keys.iterator();
		//
		// while (kiter.hasNext()) {
		// int numofqubits = kiter.next();
		// testset tempts = ts.getTestcases(numofqubits);
		// cir = cb.Build(alg, numofqubits);
		// Iterator<testcase> tciter = tempts.getTestcases();
		// quantumgate qg;
		// while (tciter.hasNext()) {
		// tc = tciter.next();
		// qgate_iter = cir.getCircuitlayout();
		// Matrix state = tc.getStartingstate();
		// while (qgate_iter.hasNext()) {
		// qg = qgate_iter.next();
		// state = qg.apply(state);
		// }
		// }
		//
		// }
		// }
		// System.out.println("Percentage correct = "
		// + ((double) count / possiblecount) * 100);

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
