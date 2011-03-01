/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
 */

package QPACEIV;

import java.util.Iterator;
import java.util.LinkedList;

import Jama.Matrix;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import QPACEIV.nonterminals.NonTerminalSuper;
import Utils.Complex;
import Utils.Tensor_Matrix;
import ec.EvolutionState;
import ec.Individual;
import ec.gp.GPIndividual;
import ec.gp.GPProblem;
import ec.gp.koza.KozaFitness;
import ec.simple.SimpleProblemForm;
import ec.util.Parameter;

/**
 * @author  sam
 */
public class QuantumProblem extends GPProblem implements SimpleProblemForm {
	public double currentX;
	public double currentY;
	public final int NUM_OF_QUBITS;
	@SuppressWarnings("unchecked")
	public LinkedList<NonTerminalSuper>[] circuit;

	/**
	 * @uml.property  name="input"
	 * @uml.associationEnd  
	 */
	public QPaceIVQuantumState input;

	public QuantumProblem(int qbits) {
		super();
		NUM_OF_QUBITS = qbits;
		circuit = (LinkedList<NonTerminalSuper>[]) new LinkedList[NUM_OF_QUBITS];
		for (int index = 0; index < NUM_OF_QUBITS; index++) {
			circuit[index] = new LinkedList<NonTerminalSuper>();
		}
	}

	public Object clone() {
		QuantumProblem newobj = (QuantumProblem) (super.clone());
		newobj.input = (QPaceIVQuantumState) (input.clone());
		return newobj;
	}

	public void setup(final EvolutionState state, final Parameter base) {
		// very important, remember this
		super.setup(state, base);

		// set up our input -- don't want to use the default base, it's unsafe
		// here
		input = (QPaceIVQuantumState) state.parameters
				.getInstanceForParameterEq(base.push(P_DATA), null,
						QPaceIVQuantumState.class);
		input.setup(state, base.push(P_DATA));
	}

	public void evaluate(final EvolutionState state, final Individual ind,
			final int subpopulation, final int threadnum) {
		if (!ind.evaluated) // don't bother reevaluating
		{
			int hits = 0;
			double sum = 0.0;
			double expectedResult;
			double result;
			for (int y = 0; y < 10; y++) {
				currentX = state.random[threadnum].nextDouble();
				currentY = state.random[threadnum].nextDouble();
				expectedResult = currentX * currentX * currentY + currentX
						* currentY + currentY;
				((GPIndividual) ind).trees[0].child.eval(state, threadnum,
						input, stack, ((GPIndividual) ind), this);

				// result = Math.abs(expectedResult - input.x);
				// if (result <= 0.01)
				// hits++;
				// sum += result;
			}

			// the fitness better be KozaFitness!
			KozaFitness f = ((KozaFitness) ind.fitness);
			f.setStandardizedFitness(state, (float) sum);
			f.hits = hits;
			ind.evaluated = true;
		}
	}

	public void print_circuit() {
		System.out.println("\\begin{figure}");
		System.out.println("\\[");
		System.out.println("\\Qcircuit @C=1.0em @R=.7em {");

		for (int index = 0; index < NUM_OF_QUBITS; index++) {
			Iterator<NonTerminalSuper> iter = circuit[index]
					.descendingIterator();
			String circuit_layout = new String();
			while (iter.hasNext()) {
				circuit_layout = circuit_layout.concat(iter.next().toString());
			}
			circuit_layout = circuit_layout.concat("\\\\");
			System.out.println(circuit_layout);
		}

		System.out.println("}");
		System.out.println("\\]");
		System.out.println("\\end{figure}");
	}

	public Matrix evaluate(Matrix state) {
		if (state.getRowDimension() != Math.pow(2, NUM_OF_QUBITS)) {
			System.err
					.println("The number of Qubits in the state does not match the number of Qubits in the system");
		}

		Object[] iters = new Object[NUM_OF_QUBITS];
		for (int index = 0; index < NUM_OF_QUBITS; index++) {
			// iters[index] = circuit[index].descendingIterator();
			iters[index] = circuit[index].iterator();
		}
		// [row][column]
		Complex[][] pauli_x = new Complex[1][1];
		pauli_x[0][0] = new Complex(1, 0);
		Matrix init_op = new Matrix(pauli_x);

		while (((Iterator<NonTerminalSuper>) iters[0]).hasNext()) {
			Matrix operation = init_op;
			for (int index = 0; index < NUM_OF_QUBITS; index++) {
				operation = Tensor_Matrix.tensor_prod(operation,
						((Iterator<NonTerminalSuper>) iters[index]).next()
								.getOperation());
			}
			state = operation.times(state);
		}

		return state;

	}
}
