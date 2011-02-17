package Core.CircuitEvaluator;

import Core.Algorithms.QuantumAlgorithm;
import Core.Problem.quantumproblem;
import Core.Problem.testsuite;

public interface circuitevaluator {

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
