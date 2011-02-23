/*
 * Create by Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4.EvolutionOperators.Mutation;

import ec.EvolutionState;
import ec.Individual;
import ec.gp.GPInitializer;
import ec.gp.koza.MutationPipeline;

public class ReplacementPipeline extends MutationPipeline {

	@Override
	public int produce(final int min, final int max, final int start,
			final int subpopulation, final Individual[] inds,
			final EvolutionState state, final int thread) {

		// grab individuals from our source and stick 'em right into inds.
		// we'll modify them from there
		int n = sources[0].produce(min, max, start, subpopulation, inds, state,
				thread);
		GPInitializer initializer = ((GPInitializer) state.initializer);

		// now let's mutate 'em
		for (int q = start; q < n + start; q++) {
			inds[q] = state.population.subpops[subpopulation].species
					.newIndividual(state, thread);
		}
		return n;

	}
}
