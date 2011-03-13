package Core.CircuitEvaluator;

import java.io.Serializable;
import java.util.LinkedList;

import Core.Algorithms.QuantumAlgorithm;
import Core.Problem.quantumproblem;
import Core.Problem.testset;
import Core.Problem.testsuite;

public interface circuitevaluator extends Serializable {

	/**
		 */
	public abstract Fitness Evaluate(QuantumAlgorithm alg);

	/**
	 * @return Returns the qfitnessfunction.
	 * @uml.property name="qfitnessfunction"
	 */
	public FitnessFunction getQfitnessfunction();

	/**
	 * @return Returns the qproblem.
	 * @uml.property name="qproblem"
	 */
	public quantumproblem getQproblem();

	/**
		 */
	public abstract testsuite getResults(QuantumAlgorithm alg);

	/**
		 */
	public abstract LinkedList<testset> getTrace(QuantumAlgorithm alg,
			int numofqubits);

	/**
	 * Setter of the property <tt>qfitnessfunction</tt>
	 * 
	 * @param qfitnessfunction
	 *            The qfitnessfunction to set.
	 * @uml.property name="qfitnessfunction"
	 */
	public void setQfitnessfunction(FitnessFunction qfitnessfunction);

	/**
	 * Setter of the property <tt>qproblem</tt>
	 * 
	 * @param qproblem
	 *            The qproblem to set.
	 * @uml.property name="qproblem"
	 */
	public void setQproblem(quantumproblem qproblem);

}
