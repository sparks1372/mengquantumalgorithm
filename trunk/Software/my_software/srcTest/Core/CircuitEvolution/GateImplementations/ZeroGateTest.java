/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.GateImplementations;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Core.Circuit.GateImplementations.Zero_Gate;
import Jama.Matrix;
import Testing.predefined_states;
import Utils.Complex;

/**
 * @author Sam Ratcliff
 * 
 */
public class ZeroGateTest {

	/**
	 * Test method for
	 * {@link Core.Circuit.GateImplementations.Hadamard_Gate#apply(Jama.Matrix)}
	 * .
	 */
	@Test
	public void testApply() {
		Matrix oracle;
		Matrix test_state;
		Matrix result;
		Zero_Gate test;

		test = new Zero_Gate(1);
		test_state = predefined_states.get_1q_0();

		oracle = new Matrix(2, 1);
		oracle.set(0, 0, new Complex(1, 0));

		result = test.apply(test_state, null);

		assertTrue("Fail on get_1q_0", Matrix.equal(result, oracle));

		test_state = predefined_states.get_1q_1();

		result = test.apply(test_state, null);
		assertTrue("Fail on get_1q_1", Matrix.equal(result, oracle));

		test = new Zero_Gate(2);
		test_state = predefined_states.get_2q_0();

		oracle = new Matrix(4, 1);
		oracle.set(0, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_0", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_1();

		oracle = new Matrix(4, 1);
		oracle.set(1, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_1", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_2();

		oracle = new Matrix(4, 1);
		oracle.set(0, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_2", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_3();

		oracle = new Matrix(4, 1);
		oracle.set(1, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_3", Matrix.equal(result, oracle));
	}
}
