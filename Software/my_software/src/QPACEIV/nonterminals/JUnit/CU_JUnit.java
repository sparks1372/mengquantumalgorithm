package QPACEIV.nonterminals.JUnit;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import Jama.Matrix;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import QPACEIV.nonterminals.CU;
import QPACEIV.nonterminals.Pauli_X;
import QPACEIV.terminals.Qubit;
import Utils.Complex;
import ec.gp.GPNode;

public class CU_JUnit {

	QPaceIVQuantumState state_0 = new QPaceIVQuantumState();
	QPaceIVQuantumState state_1 = new QPaceIVQuantumState();
	QPaceIVQuantumState result_state_0 = new QPaceIVQuantumState();
	QPaceIVQuantumState result_state_1 = new QPaceIVQuantumState();

	@Before
	public void setUp() throws Exception {
		Complex[][] state_0_array = new Complex[8][1];
		state_0_array[0][0] = new Complex(1, 0);
		state_0_array[1][0] = new Complex(0, 0);
		state_0_array[2][0] = new Complex(0, 0);
		state_0_array[3][0] = new Complex(0, 0);
		state_0_array[4][0] = new Complex(0, 0);
		state_0_array[5][0] = new Complex(0, 0);
		state_0_array[6][0] = new Complex(0, 0);
		state_0_array[7][0] = new Complex(0, 0);
		state_0.x = new Matrix(state_0_array);
		state_0.NUM_OF_QUBITS = 3;

		Complex[][] state_1_array = new Complex[8][1];
		state_1_array[0][0] = new Complex(0, 0);
		state_1_array[1][0] = new Complex(0, 0);
		state_1_array[2][0] = new Complex(0, 0);
		state_1_array[3][0] = new Complex(0, 0);
		state_1_array[4][0] = new Complex(1, 0);
		state_1_array[5][0] = new Complex(0, 0);
		state_1_array[6][0] = new Complex(0, 0);
		state_1_array[7][0] = new Complex(0, 0);
		state_1.x = new Matrix(state_1_array);
		state_1.NUM_OF_QUBITS = 3;

		Complex[][] result_state_0_array = new Complex[8][1];
		result_state_0_array[0][0] = new Complex(1, 0);
		result_state_0_array[1][0] = new Complex(0, 0);
		result_state_0_array[2][0] = new Complex(0, 0);
		result_state_0_array[3][0] = new Complex(0, 0);
		result_state_0_array[4][0] = new Complex(0, 0);
		result_state_0_array[5][0] = new Complex(0, 0);
		result_state_0_array[6][0] = new Complex(0, 0);
		result_state_0_array[7][0] = new Complex(0, 0);
		result_state_0.x = new Matrix(result_state_0_array);

		Complex[][] result_state_1_array = new Complex[8][1];
		result_state_1_array[0][0] = new Complex(0, 0);
		result_state_1_array[1][0] = new Complex(0, 0);
		result_state_1_array[2][0] = new Complex(0, 0);
		result_state_1_array[3][0] = new Complex(0, 0);
		result_state_1_array[4][0] = new Complex(0, 0);
		result_state_1_array[5][0] = new Complex(1, 0);
		result_state_1_array[6][0] = new Complex(0, 0);
		result_state_1_array[7][0] = new Complex(0, 0);
		result_state_1.x = new Matrix(result_state_1_array);
	}

	@Test
	public void testapply_operation() {
		CU to_test = new CU();
		to_test.children = new GPNode[3];
		to_test.children[0] = new Qubit(0);
		to_test.children[1] = new Qubit(1);
		to_test.children[2] = new Pauli_X();
		to_test.eval(null, 0, state_0, null, null, null);

		if (!(to_test.apply_operation(state_0)).equals(result_state_0)) {
			fail("Pauli CU gate fails on 0 input");
		}
		if (!(to_test.apply_operation(state_1)).equals(result_state_1)) {
			fail("Pauli CU gate fails on 1 input");
		}
	}

}
