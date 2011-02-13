package Core;

import Core.Algorithms.QuantumInstructionEnum;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitBuilder.Implementation.basiccircuitbuilder;
import Core.CircuitEvaluator.circuitevaluator;
import Core.CircuitEvaluator.fitnessfunctionmanager;
import Core.CircuitEvaluator.Implementation.basiccircuitevaluator;
import Core.CircuitEvaluator.Implementation.test_UML_parser;
import Core.CircuitEvaluator.PhaseSensitiveParsimoniousSimpleFitness.PhaseSensitiveParsimoniousSimpleFitness;
import Core.CircuitEvolution.circuitsearchengine;
import Core.CircuitEvolution.searchenginemanager;
import Core.CircuitEvolution.QPace4.QPace4_Imp;
import Core.Implementation.simpleqcproblem;

/**
 * @uml.dependency supplier="Core.CircuitBuilder.circuitBuilder"
 */
public class qcevolutionbackend {

	/**
	 * @uml.property name="circuitBuilder"
	 * @uml.associationEnd multiplicity="(0 -1)" dimension="1" ordering="true"
	 *                     inverse=
	 *                     "qcevolutionbackend:Core.CircuitBuilder.circuitBuilder"
	 */

	public static void main(String[] args) {

		qcevolutionbackend be = new qcevolutionbackend();
		be.setQproblem(new simpleqcproblem("Hadamard"));
		test_UML_parser tup = new test_UML_parser(args[0]);
		be.getQproblem().setTestSuite(tup.parse());

		circuitBuilder cirbui = new basiccircuitbuilder();
		circuitevaluator cireval = new basiccircuitevaluator(cirbui);
		cireval.setQfitnessfunction(new PhaseSensitiveParsimoniousSimpleFitness());
		// cireval.setQfitnessfunction(new ParsimoniousSimpleFitness());
		// cireval.setQfitnessfunction(new SimpleFitness());
		cireval.setQproblem(be.getQproblem());
		boolean[] temp = new boolean[QuantumInstructionEnum.values().length];
		for (int i = 0; i < temp.length; i++) {
			if (// (i == QuantumInstructionEnum.Create_Zero.ordinal())
			// || (i == QuantumInstructionEnum.Create_CRX.ordinal())
			// || (i == QuantumInstructionEnum.Create_CRY.ordinal())
			// || (i == QuantumInstructionEnum.Create_CRZ.ordinal())
			// || (i == QuantumInstructionEnum.Create_RX.ordinal())
			// || (i == QuantumInstructionEnum.Create_RY.ordinal())
			// || (i == QuantumInstructionEnum.Create_RZ.ordinal())
			/* || */(i == QuantumInstructionEnum.Create_P.ordinal())) {
				temp[i] = false;
			} else {
				temp[i] = true;
			}
		}
		be.setCurrentse(new QPace4_Imp(cirbui, cireval, temp));
		be.getCurrentse().Evolve();
	}

	/**
	 * @uml.property name="semanager"
	 */
	private searchenginemanager		semanager;

	/**
	 * @uml.property name="currentse"
	 */
	private circuitsearchengine		currentse;

	/**
	 * @uml.property name="qproblem"
	 */
	private quantumproblem			qproblem;

	/**
	 * @uml.property name="ffmanager"
	 */
	private fitnessfunctionmanager	ffmanager;

	/**
	 * Getter of the property <tt>currentse</tt>
	 * 
	 * @return Returns the currentse.
	 * @uml.property name="currentse"
	 */
	public circuitsearchengine getCurrentse() {
		return currentse;
	}

	/**
	 * Getter of the property <tt>ffmanager</tt>
	 * 
	 * @return Returns the ffmanager.
	 * @uml.property name="ffmanager"
	 */
	public fitnessfunctionmanager getFfmanager() {
		return ffmanager;
	}

	/**
	 * Getter of the property <tt>qproblem</tt>
	 * 
	 * @return Returns the qproblem.
	 * @uml.property name="qproblem"
	 */
	public quantumproblem getQproblem() {
		return qproblem;
	}

	/**
	 * Getter of the property <tt>semanager</tt>
	 * 
	 * @return Returns the semanager.
	 * @uml.property name="semanager"
	 */
	public searchenginemanager getSemanager() {
		return semanager;
	}

	/**
	 * Setter of the property <tt>currentse</tt>
	 * 
	 * @param currentse
	 *            The currentse to set.
	 * @uml.property name="currentse"
	 */
	public void setCurrentse(circuitsearchengine currentse) {
		this.currentse = currentse;
	}

	/**
	 * Setter of the property <tt>ffmanager</tt>
	 * 
	 * @param ffmanager
	 *            The ffmanager to set.
	 * @uml.property name="ffmanager"
	 */
	public void setFfmanager(fitnessfunctionmanager ffmanager) {
		this.ffmanager = ffmanager;
	}

	/**
	 * Setter of the property <tt>qproblem</tt>
	 * 
	 * @param qproblem
	 *            The qproblem to set.
	 * @uml.property name="qproblem"
	 */
	public void setQproblem(quantumproblem qproblem) {
		this.qproblem = qproblem;
	}

	/**
	 * Setter of the property <tt>semanager</tt>
	 * 
	 * @param semanager
	 *            The semanager to set.
	 * @uml.property name="semanager"
	 */
	public void setSemanager(searchenginemanager semanager) {
		this.semanager = semanager;
	}
}
