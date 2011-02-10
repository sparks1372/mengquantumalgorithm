/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4.terminal.Variables;

import Core.CircuitEvolution.QPace4.Data.QPaceData;
import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;

/**
 * @author Sam Ratcliff
 * 
 */
public class SystemSize extends GPNode {
	public static final int	SYSTEM_SIZE_FLAG	= -1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gp.GPNode#eval(ec.EvolutionState, int, ec.gp.GPData,
	 * ec.gp.ADFStack, ec.gp.GPIndividual, ec.Problem)
	 */
	@Override
	public void eval(EvolutionState state, int thread, GPData input,
			ADFStack stack, GPIndividual individual, Problem problem) {
		((QPaceData) input).i = SYSTEM_SIZE_FLAG;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gp.GPNode#toString()
	 */
	@Override
	public String toString() {
		return "";
	}

}
