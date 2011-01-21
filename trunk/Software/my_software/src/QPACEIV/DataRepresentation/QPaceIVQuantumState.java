/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
 */

package QPACEIV.DataRepresentation;

import Jama.Matrix;
import ec.gp.GPData;

public class QPaceIVQuantumState extends GPData {
	public Matrix x; // return value
	public double in;
	public int NUM_OF_QUBITS;

	public void copyTo(final GPData gpd) // copy my stuff to another DoubleData
	{
		((QPaceIVQuantumState) gpd).x = x;
	}

	public boolean equals(final QPaceIVQuantumState B) {
		if ((B.x).getColumnDimension() != x.getColumnDimension()) {
			System.out
					.println("(B.x).getColumnDimension() != x.getColumnDimension()");
			return false;
		}
		if ((B.x).getRowDimension() != x.getRowDimension()) {
			System.out
					.println("(B.x).getRowDimension() != x.getRowDimension()");
			return false;
		}

		for (int a_row = 0; a_row < x.getRowDimension(); a_row++) {
			for (int a_col = 0; a_col < x.getColumnDimension(); a_col++) {
				if (x.get(a_row, a_col).real() != (B.x).get(a_row, a_col)
						.real()
						&& x.get(a_row, a_col).imag() != (B.x)
								.get(a_row, a_col).imag()) {
					System.out.println("x.get(" + a_row + ", " + a_col
							+ ") != (B.x).get(" + a_row + ", " + a_col + ")");
					return false;
				}
			}
		}

		return true;
	}
}
