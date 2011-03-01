/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.GateImplementations;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

/**
 * @author Sam Ratcliff
 * 
 */
public class ControlledUGateTest {

	/**
	 * Test method for
	 * {@link Core.CircuitEvolution.GateImplementations.Hadamard_Gate#apply(Jama.Matrix)}
	 * .
	 */
	@Test
	public void testApply() {
		Complex[][] state_array;
		Matrix test_state;
		Matrix result;
		ControlledU_Gate test;

		test = new ControlledU_Gate(new Pauli_X(1), 1, 2);
		test_state = predefined_states.get_2q_0();

		state_array = new Complex[4][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_0",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_1();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(1, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_1",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_2();

		state_array = new Complex[4][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(1, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_2",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_3();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(1, 0);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_3",
				Matrix.equal(result, new Matrix(state_array)));

		test = new ControlledU_Gate(new Pauli_X(1), 2, 1);
		test_state = predefined_states.get_2q_0();

		state_array = new Complex[4][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_0",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_1();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(1, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_1",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_2();

		state_array = new Complex[4][1];
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(1, 0);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_2",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_3();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(1, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_3",
				Matrix.equal(result, new Matrix(state_array)));

		test = new ControlledU_Gate(new Pauli_X(1), 1, 3);
		test_state = predefined_states.get_3q_0();

		state_array = new Complex[8][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_0",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_1();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(1, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_1",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_2();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(1, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_2",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_3();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(1, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_3",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_4();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(1, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_4",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_5();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(1, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_5",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_6();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(0, 0);
		state_array[7][0] = new Complex(1, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_6",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_3q_7();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 0);
		state_array[4][0] = new Complex(0, 0);
		state_array[5][0] = new Complex(0, 0);
		state_array[6][0] = new Complex(1, 0);
		state_array[7][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_3q_7",
				Matrix.equal(result, new Matrix(state_array)));
	}

}
