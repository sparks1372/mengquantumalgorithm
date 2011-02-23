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
public class VGateTest {

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
		V_Gate test;

		test = new V_Gate(1);
		test_state = predefined_states.get_1q_0();

		state_array = new Complex[2][1];
		state_array[0][0] = new Complex(1, 0);
		state_array[1][0] = new Complex(0, 0);

		result = test.apply(test_state);

		assertTrue("Fail on get_1q_0",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_1q_1();
		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 1);

		result = test.apply(test_state);
		assertTrue("Fail on get_1q_1",
				Matrix.equal(result, new Matrix(state_array)));

		test = new V_Gate(2);
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
		state_array[2][0] = new Complex(0, 1);
		state_array[3][0] = new Complex(0, 0);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_2",
				Matrix.equal(result, new Matrix(state_array)));

		test_state = predefined_states.get_2q_3();

		state_array[0][0] = new Complex(0, 0);
		state_array[1][0] = new Complex(0, 0);
		state_array[2][0] = new Complex(0, 0);
		state_array[3][0] = new Complex(0, 1);

		result = test.apply(test_state);
		assertTrue("Fail on get_2q_3",
				Matrix.equal(result, new Matrix(state_array)));
	}
}
