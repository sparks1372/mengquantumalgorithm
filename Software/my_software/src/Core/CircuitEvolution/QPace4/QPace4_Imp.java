/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4;

import java.io.File;
import java.io.IOException;

import Core.Algorithms.QuantumInstructionEnum;
import Core.Circuit.Circuit;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;
import Core.CircuitEvolution.EvolutionType;
import Core.CircuitEvolution.circuitsearchengine;
import Core.CircuitEvolution.QPace4.State.QPaceEvoState;
import ec.EvolutionState;
import ec.Evolve;
import ec.Individual;
import ec.util.ParameterDatabase;

/**
 * @author Sam Ratcliff
 * 
 */
public class QPace4_Imp extends Evolve implements circuitsearchengine {

	public static void main(String[] args) {
		boolean[] temp = new boolean[QuantumInstructionEnum.values().length];
		for (int i = 0; i < temp.length; i++) {
			if (i % 2 != 0) {
				temp[i] = true;
			}
		}

		// new QPace4_Imp(null, null, temp);
	}

	private circuitBuilder				cb;
	private circuitevaluator			ce;
	private static final String			NAME		= "QPace 4 Implementation";
	private static final EvolutionType	ET			= EvolutionType.Evolutionary;
	private Circuit						bc;
	private boolean[]					ai			= new boolean[QuantumInstructionEnum
															.values().length];
	private static final String			filename	= "config/ecparams.params";

	private Params_Writer				pw			= null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#Evolve()
	 */
	@Override
	public float Evolve() {

		EvolutionState state;
		ParameterDatabase parameters;
		float to_return = Float.MAX_VALUE;

		// Now we're going to load the parameter database to see if there are
		// any more jobs.
		// We could have done this using the previous parameter database, but
		// it's no big deal.
		try {
			parameters = new ParameterDatabase(new File(filename),
					new String[0]);

			// Initialize the EvolutionState, then set its job variables
			state = initialize(parameters, 0); // pass in job# as the seed
												// increment
			state.output.systemMessage("Job: " + 0);
			state.job = new Object[1]; // make the job argument storage
			state.job[0] = new Integer(0); // stick the current job in our
											// job storage
			((QPaceEvoState) state).cir_evaluator = ce;
			((QPaceEvoState) state).cir_builder = cb;

			// Here you can set up the EvolutionState's parameters further
			// before it's setup(...).
			// This includes replacing the random number generators,
			// changing values in state.parameters,
			// changing instance variables (except for job and
			// runtimeArguments, please), etc.

			// now we let it go
			state.run(EvolutionState.C_STARTED_FRESH);

			for (Individual individual : state.population.subpops[0].individuals) {
				if (individual.fitness.fitness() < to_return) {
					to_return = individual.fitness.fitness();
				}
			}
			cleanup(state); // flush and close various streams, print out
							// parameters if necessary
			parameters = null; // so we load a fresh database next time
								// around
		} catch (Throwable e) // such as an out of memory error caused by
								// this job
		{
			e.printStackTrace();
			state = null;
			System.gc(); // take a shot!
		}

		return to_return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getAvailableinstructions()
	 */
	@Override
	public boolean[] getAvailableinstructions() {
		return ai;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getBestCircuit()
	 */
	@Override
	public Circuit getBestCircuit() {
		return bc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getCbuilder()
	 */
	@Override
	public circuitBuilder getCbuilder() {
		return cb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getCevaluator()
	 */
	@Override
	public circuitevaluator getCevaluator() {
		return ce;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getEvotype()
	 */
	@Override
	public EvolutionType getEvotype() {
		return ET;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void init(circuitBuilder cb, circuitevaluator ce, boolean[] ai) {
		this.cb = cb;
		this.ce = ce;
		for (int i = 0; i < this.ai.length; i++) {
			this.ai[i] = ai[i];
		}
		try {
			pw = new Params_Writer(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.updateParams(ai);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Core.CircuitEvolution.circuitsearchengine#setAvailableinstructions(boolean
	 * [])
	 */
	@Override
	public void setAvailableinstructions(boolean[] availableinstructions) {
		ai = availableinstructions;
		pw.updateParams(ai);
	}
}
