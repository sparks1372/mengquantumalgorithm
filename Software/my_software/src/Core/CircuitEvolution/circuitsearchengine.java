package Core.CircuitEvolution;

import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JPanel;

import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;

/**
 * @uml.dependency supplier="Core.CircuitBuilder.circuitBuilder"
 */
public abstract interface circuitsearchengine {

	public void addObserver(Observer ob);

	/**
	 * @return Returns the availableinstructions.
	 * @uml.property name="availableinstructions" multiplicity="(0 -1)"
	 *               dimension="1"
	 */
	public boolean[] getAvailableinstructions();

	/**
	 * @return Returns the cbuilder.
	 * @uml.property name="cbuilder" readOnly="true"
	 */
	public circuitBuilder getCbuilder();

	/**
	 * @return Returns the cevaluator.
	 * @uml.property name="cevaluator" readOnly="true"
	 */
	public circuitevaluator getCevaluator();

	/**
	 * @return Returns the name.
	 * @uml.property name="Name" readOnly="true"
	 */
	public String getName();

	public JPanel getProgressBar();

	/**
	 * @return Returns the Search Results.
	 * @uml.property name="SearchResult" readOnly="true"
	 */
	public SearchResult[] getResults();

	public JPanel getSearchStatisticsPanel();

	public SearchEngineState getState();

	public void init(circuitBuilder cb, circuitevaluator ce, boolean[] ai);

	/**
	 * 
	 */
	public void removeAllObservers();

	public void removeObserver(Observer ob);

	/**
	 * Initiate search For use with a GUI
	 */
	public void search();

	/**
	 * Initiate search For use without a GUI
	 */
	public void search(boolean[] availableinstructions, String[] params);

	/**
	 * @return
	 */
	public JDialog getStatsDialog();

}
