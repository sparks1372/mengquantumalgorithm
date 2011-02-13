/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4.Data;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.Implementation.basicquantumalgorithm;
import ec.gp.GPData;

/**
 * @author Sam Ratcliff
 * 
 */
public class QPaceData extends GPData {

	public QuantumAlgorithm	qa	= new basicquantumalgorithm();
	public int				i;
	public double			d;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gp.GPData#copyTo(ec.gp.GPData)
	 */
	@Override
	public void copyTo(GPData gpd) {
		((QPaceData) gpd).qa = qa;
		((QPaceData) gpd).i = i;
		((QPaceData) gpd).d = d;
	}

}