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
public class PauliXTest {

	/**
	 * Test method for
	 * {@link Core.CircuitEvolution.GateImplementations.Hadamard_Gate#apply(Jama.Matrix)}
	 * .
	 */
	@Test
	public void testApply() {
		Matrix oracle;
		Matrix test_state;
		Matrix result;
		Pauli_X test;

		test = new Pauli_X(1);
		test_state = predefined_states.get_1q_0();

		oracle = new Matrix(2, 1);
		oracle.set(1, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_1q_0", Matrix.equal(result, oracle));

		test_state = predefined_states.get_1q_1();

		oracle = new Matrix(2, 1);
		oracle.set(0, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_1q_1", Matrix.equal(result, oracle));

		test = new Pauli_X(2);
		test_state = predefined_states.get_2q_0();

		oracle = new Matrix(4, 1);
		oracle.set(2, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_0", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_1();

		oracle = new Matrix(4, 1);
		oracle.set(3, 0, new Complex(1, 0));

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
