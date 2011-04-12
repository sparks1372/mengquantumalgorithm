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
		Matrix oracle;
		Matrix test_state;
		Matrix result;
		ControlledU_Gate test;

		test = new ControlledU_Gate(new Pauli_X(1), 1, 2);
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
		oracle.set(3, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_2", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_3();

		oracle = new Matrix(4, 1);
		oracle.set(2, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_3", Matrix.equal(result, oracle));

		test = new ControlledU_Gate(new Pauli_X(1), 2, 1);
		test_state = predefined_states.get_2q_0();

		oracle = new Matrix(4, 1);
		oracle.set(0, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_0", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_1();

		oracle = new Matrix(4, 1);
		oracle.set(3, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_1", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_2();

		oracle = new Matrix(4, 1);
		oracle.set(2, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_2", Matrix.equal(result, oracle));

		test_state = predefined_states.get_2q_3();

		oracle = new Matrix(4, 1);
		oracle.set(1, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_2q_3", Matrix.equal(result, oracle));

		test = new ControlledU_Gate(new Pauli_X(1), 1, 3);
		test_state = predefined_states.get_3q_0();

		oracle = new Matrix(8, 1);
		oracle.set(0, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_0", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_1();

		oracle = new Matrix(8, 1);
		oracle.set(1, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_1", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_2();

		oracle = new Matrix(8, 1);
		oracle.set(2, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_2", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_3();

		oracle = new Matrix(8, 1);
		oracle.set(3, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_3", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_4();

		oracle = new Matrix(8, 1);
		oracle.set(5, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_4", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_5();

		oracle = new Matrix(8, 1);
		oracle.set(4, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_5", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_6();

		oracle = new Matrix(8, 1);
		oracle.set(7, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_6", Matrix.equal(result, oracle));

		test_state = predefined_states.get_3q_7();

		oracle = new Matrix(8, 1);
		oracle.set(6, 0, new Complex(1, 0));

		result = test.apply(test_state, null);
		assertTrue("Fail on get_3q_7", Matrix.equal(result, oracle));
	}

}
