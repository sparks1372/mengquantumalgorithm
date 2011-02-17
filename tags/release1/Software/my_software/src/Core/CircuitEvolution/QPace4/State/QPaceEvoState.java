/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4.State;

import javax.swing.JProgressBar;

import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;
import ec.simple.SimpleEvolutionState;

/**
 * @author Sam Ratcliff
 * 
 */
public class QPaceEvoState extends SimpleEvolutionState {
	public circuitBuilder		cir_builder;
	public circuitevaluator		cir_evaluator;
	private final JProgressBar	progressBar	= new JProgressBar();
	private int					gens;

	/**
	 * @return the gens
	 */
	public int getGens() {
		System.out.println("gens  = " + gens);
		return gens;
	}

	/**
	 * @return the progressBar
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * 
	 */
	private void resetProgressBar() {
		progressBar.setMaximum(numGenerations);
		System.out.println("numGenerations = " + numGenerations);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
	}

	/**
	 * @param gens
	 *            the gens to set
	 */
	public void setGens(int gens) {
		this.gens = gens;
	}

	@Override
	public void startFresh() {
		output.message("Setting up");
		setup(this, null); // a garbage Parameter
		resetProgressBar();

		// POPULATION INITIALIZATION
		output.message("Initializing Generation 0");
		statistics.preInitializationStatistics(this);
		population = initializer.initialPopulation(this, 0); // unthreaded
		statistics.postInitializationStatistics(this);

		// INITIALIZE CONTACTS -- done after initialization to allow
		// a hook for the user to do things in Initializer before
		// an attempt is made to connect to island models etc.
		exchanger.initializeContacts(this);
		evaluator.initializeContacts(this);
	}

}
