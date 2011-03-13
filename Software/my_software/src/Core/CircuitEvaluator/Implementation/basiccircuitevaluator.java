package Core.CircuitEvaluator.Implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import Core.Algorithms.QuantumAlgorithm;
import Core.Circuit.Circuit;
import Core.Circuit.quantumgate;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.Fitness;
import Core.CircuitEvaluator.FitnessFunction;
import Core.CircuitEvaluator.circuitevaluator;
import Core.Problem.SuperPositionalTestSet;
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
			if (tempts instanceof SuperPositionalTestSet) {
				numofqubits = Math.abs(numofqubits);
			}
			cir = cb.Build(alg, numofqubits);
			Iterator<testcase> tciter = tempts.getTestcases();
			quantumgate qg;
			while (tciter.hasNext()) {
				tc = tciter.next();
				qgate_iter = cir.getCircuitlayout();
				cir.getSize();
				Matrix state = tc.getStartingStateCopy().copy();
				while (qgate_iter.hasNext()) {
					qg = qgate_iter.next();
					state = qg.apply(state);
				}

				temp = ff.evaluate(tc.getStartingStateCopy(), state,
						tc.getFinalStateCopy(), cir, alg);
				fitness_to_return += temp.getFitness();
				count += temp.getPerfectcount();
				possiblecount += state.getRowDimension();
			}
		}

		if (fitness_to_return > Float.MAX_VALUE) {
			return new Fitness(Float.MAX_VALUE, 0);
		}
		fitness_to_return = count != 0 ? fitness_to_return
				/ ((double) count / possiblecount) : fitness_to_return
				* possiblecount;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvaluator.circuitevaluator#getResults(Core.Algorithms.
	 * QuantumAlgorithm)
	 */
	@Override
	public testsuite getResults(QuantumAlgorithm alg) {
		Circuit cir;
		Iterator<quantumgate> qgate_iter;
		testsuite ts = quantprob.getTestSuite();
		testsuite to_return = new testsuite();
		testcase tc;
		testcase tc_toadd;
		testset ts_toadd;
		Set<Integer> keys = ts.getKeys();

		Iterator<Integer> kiter = keys.iterator();

		while (kiter.hasNext()) {
			int numofqubits = kiter.next();
			testset tempts = ts.getTestcases(numofqubits);

			if (tempts instanceof SuperPositionalTestSet) {
				numofqubits = Math.abs(numofqubits);
				ts_toadd = new SuperPositionalTestSet(numofqubits);
			} else {
				ts_toadd = new testset(numofqubits);
			}
			cir = cb.Build(alg, numofqubits);
			Iterator<testcase> tciter = tempts.getTestcases();
			quantumgate qg;
			while (tciter.hasNext()) {
				tc = tciter.next();
				tc_toadd = new testcase(tc.getId(), tc.getLabel());
				qgate_iter = cir.getCircuitlayout();
				cir.getSize();
				Matrix state = tc.getStartingStateCopy();
				while (qgate_iter.hasNext()) {
					qg = qgate_iter.next();
					state = qg.apply(state);
				}
				tc_toadd.setStartingstate(tc.getStartingStateCopy());
				tc_toadd.setFinalstate(state);
				ts_toadd.addTestcases(tc_toadd);

			}
			to_return.addTestcases(ts_toadd);
		}
		return to_return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvaluator.circuitevaluator#getTrace(Core.Algorithms.
	 * QuantumAlgorithm)
	 */
	@Override
	public LinkedList<testset> getTrace(QuantumAlgorithm alg, int numofqubits) {
		LinkedList<testset> toReturn = new LinkedList<testset>();
		Circuit cir;
		Iterator<quantumgate> qgate_iter;
		int id = 0;

		testsuite ts = quantprob.getTestSuite();
		cir = cb.Build(alg, numofqubits);
		testcase tc[] = new testcase[cir.getSize() + 1];
		for (testcase element : tc) {
			toReturn.add(new testset(numofqubits));
		}
		Set<Integer> keys = ts.getKeys();

		Iterator<Integer> kiter = keys.iterator();
		while (kiter.hasNext()) {
			int tsnumofqubits = kiter.next();
			testset tempts = ts.getTestcases(tsnumofqubits);
			if (Math.abs(tsnumofqubits) == numofqubits) {
				Iterator<testcase> tciter = tempts.getTestcases();
				quantumgate qg;
				while (tciter.hasNext()) {
					testcase next = tciter.next();
					testcase temp = new testcase(id++, next.getLabel());
					temp.setStartingstate(next.getStartingStateCopy());
					temp.setFinalstate(next.getFinalStateCopy());
					// System.out.println("basic circuit eval ID : "
					// + next.getId() + " Label : " + next.getLabel());
					qgate_iter = cir.getCircuitlayout();
					cir.getSize();
					Matrix state = next.getStartingStateCopy();
					int x = 0;
					tc[x] = temp.copy();
					tc[x].setFinalstate(state.copy());
					x++;
					while (qgate_iter.hasNext()) {
						qg = qgate_iter.next();
						state = qg.apply(state);
						tc[x] = temp.copy();
						tc[x].setFinalstate(state.copy());
						x++;
					}
					for (int i = 0; i < tc.length; i++) {
						toReturn.get(i).addTestcases(tc[i]);
					}
				}
			}
		}

		return toReturn;
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
