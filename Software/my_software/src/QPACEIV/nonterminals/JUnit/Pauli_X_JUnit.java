package QPACEIV.nonterminals.JUnit;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import Jama.Matrix;
import QPACEIV.DataRepresentation.QPaceIVQuantumState;
import QPACEIV.nonterminals.Pauli_X;
import Utils.Complex;

/**
 * @author  sam
 */
public class Pauli_X_JUnit {

	/**
	 * @uml.property  name="state_0"
	 * @uml.associationEnd  
	 */
	QPaceIVQuantumState state_0 = new QPaceIVQuantumState();
	/**
	 * @uml.property  name="state_1"
	 * @uml.associationEnd  
	 */
	QPaceIVQuantumState state_1 = new QPaceIVQuantumState();
	/**
	 * @uml.property  name="result_state_0"
	 * @uml.associationEnd  
	 */
	QPaceIVQuantumState result_state_0 = new QPaceIVQuantumState();
	/**
	 * @uml.property  name="result_state_1"
	 * @uml.associationEnd  
	 */
	QPaceIVQuantumState result_state_1 = new QPaceIVQuantumState();

	@Before
	public void setUp() throws Exception {
		Complex[][] state_0_array = new Complex[2][1];
		state_0_array[0][0] = new Complex(1, 0);
		state_0_array[1][0] = new Complex(0, 0);
		state_0.x = new Matrix(state_0_array);

		Complex[][] state_1_array = new Complex[2][1];
		state_1_array[0][0] = new Complex(0, 0);
		state_1_array[1][0] = new Complex(1, 0);
		state_1.x = new Matrix(state_1_array);

		Complex[][] result_state_0_array = new Complex[2][1];
		result_state_0_array[0][0] = new Complex(0, 0);
		result_state_0_array[1][0] = new Complex(1, 0);
		result_state_0.x = new Matrix(result_state_0_array);

		Complex[][] result_state_1_array = new Complex[2][1];
		result_state_1_array[0][0] = new Complex(1, 0);
		result_state_1_array[1][0] = new Complex(0, 0);
		result_state_1.x = new Matrix(result_state_1_array);
	}

	@Test
	public void testapply_operation() {
		Pauli_X to_test = new Pauli_X();
		if (!(to_test.apply_operation(state_0)).equals(result_state_0)) {
			fail("Pauli X gate fails on 0 input");
		}
		if (!(to_test.apply_operation(state_1)).equals(result_state_1)) {
			fail("Pauli X gate fails on 1 input");
		}
	}

}
