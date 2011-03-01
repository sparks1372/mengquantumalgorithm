/**
 * @Author = Sam Ratcliff
 */
package GUI.StateVisualiser;

import Jama.Matrix;

/**
 * @author Sam Ratcliff
 * 
 */
public interface stateVisualiser {

	public abstract void updateState(Matrix initialState, int labelLength);

}