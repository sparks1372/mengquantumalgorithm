package Utils;

import Jama.Matrix;

public class Tensor_Matrix extends Matrix {

	public Tensor_Matrix(Complex[][] A) {
		super(A);
	}

	public Tensor_Matrix(Complex[][] A, int m, int n) {
		super(A, m, n);
	}

	public Tensor_Matrix(Complex[] vals, int m) {
		super(vals, m);
	}

	public Tensor_Matrix(int m, int n) {
		super(m, n);
	}

	public Tensor_Matrix(int m, int n, double s) {
		super(m, n, s);
	}

	public static Matrix tensor_prod(Matrix A, Matrix B) {
		Matrix to_return = new Matrix(
				(A.getRowDimension() * B.getRowDimension()),
				(A.getColumnDimension() * B.getColumnDimension()));

		Complex scalar_factor;
		Matrix resulting_matrix;

		int i0;
		int i1;
		int j0;
		int j1;

		for (int a_row = 0; a_row < A.getRowDimension(); a_row++) {
			i0 = a_row * B.getRowDimension();
			i1 = (a_row * B.getRowDimension()) + (B.getRowDimension() - 1);
			for (int a_col = 0; a_col < A.getColumnDimension(); a_col++) {
				scalar_factor = A.get(a_row, a_col);
				resulting_matrix = B.times(scalar_factor);
				j0 = a_col * B.getColumnDimension();
				j1 = (a_col * B.getColumnDimension())
						+ (B.getColumnDimension() - 1);

				to_return.setMatrix(i0, i1, j0, j1, resulting_matrix);
			}
		}

		return to_return;
	}
}
