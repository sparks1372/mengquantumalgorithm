package Testing;

import Jama.Matrix;
import Utils.Complex;

public class predefined_states {

	public static Matrix get_1q_0() {
		Complex[][] state_array = new Complex[2][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_1q_1() {
		Complex[][] state_array = new Complex[2][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(1, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_2q_0() {
		Complex[][] state_array = new Complex[4][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_2q_1() {
		Complex[][] state_array = new Complex[4][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(1, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_2q_2() {
		Complex[][] state_array = new Complex[4][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(1, 0);
		state_array[3][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_2q_3() {
		Complex[][] state_array = new Complex[4][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(1, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_0() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_1() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(1, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_2() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(1, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_3() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(1, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_4() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(1, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_5() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(1, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_6() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(1, 0);
		state_array[7][0] = new Complex(0, 0);
		return new Matrix(state_array);
	}

	public static Matrix get_3q_7() {
		Complex[][] state_array = new Complex[8][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(1, 0);
		return new Matrix(state_array);
	}
}
