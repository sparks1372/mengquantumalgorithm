package Core.Circuit.Implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Core.Circuit.quantumgate;
import Core.Circuit.GateImplementations.Hadamard_Gate;
import Core.Circuit.GateImplementations.Pauli_X;
import Core.Circuit.GateImplementations.Pauli_Z;

/**
 * The class <code>basiccircuitTest</code> contains tests for the class
 * <code>{@link basiccircuit}</code>.
 * 
 * @generatedBy CodePro at 06/05/11 19:27
 * @author sam
 * @version $Revision: 1.0 $
 */
public class basiccircuitTest {
	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(basiccircuitTest.class);
	}

	private basiccircuit	circuit;
	private final int		builderid	= 1;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Before
	public void setUp() throws Exception {
		circuit = new basiccircuit(builderid);
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the void addCircuit(int,Circuit) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testAddCircuit_1() throws Exception {
		int b_id = 2;
		basiccircuit fixture = new basiccircuit(b_id);
		fixture.addGate(b_id, new Hadamard_Gate(1));
		circuit.addGate(builderid, new Hadamard_Gate(2));

		fixture.addCircuit(b_id, circuit);

		ListIterator<quantumgate> iter = fixture.getCircuitlayout();
		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(1, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(2, g.getTarget());
	}

	/**
	 * Run the void addCircuit(int,Circuit) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testAddCircuit_2() throws Exception {
		int b_id = 2;
		basiccircuit fixture = new basiccircuit(b_id);
		fixture.addGate(b_id, new Hadamard_Gate(1));
		circuit.addGate(builderid, new Pauli_X(2));

		fixture.addCircuit(b_id, circuit);

		ListIterator<quantumgate> iter = fixture.getCircuitlayout();
		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(1, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
	}

	/**
	 * Run the void addCircuit(int,Circuit) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testAddCircuit_3() throws Exception {
		int b_id = 2;
		basiccircuit fixture = new basiccircuit(b_id);
		fixture.addGate(b_id, new Hadamard_Gate(1));
		circuit.addGate(builderid, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));

		fixture.addCircuit(b_id, circuit);

		ListIterator<quantumgate> iter = fixture.getCircuitlayout();
		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(1, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
	}

	/**
	 * Run the void addCircuit(int,Circuit) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testAddCircuit_4() throws Exception {
		int b_id = 2;
		basiccircuit fixture = new basiccircuit(b_id);
		fixture.addGate(b_id, new Hadamard_Gate(1));
		fixture.addGate(b_id, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));

		fixture.addCircuit(b_id, circuit);

		ListIterator<quantumgate> iter = fixture.getCircuitlayout();
		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(1, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
	}

	/**
	 * Run the void addGate(int,quantumgate) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testAddGate_1() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(1));
		circuit.addGate(builderid, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));

		ListIterator<quantumgate> iter = circuit.getCircuitlayout();
		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(1, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
	}

	/**
	 * Run the void addGate(int,quantumgate) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testAddGate_2() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(3));
		circuit.addGate(builderid, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));

		ListIterator<quantumgate> iter = circuit.getCircuitlayout();
		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(3, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
	}

	/**
	 * Run the LinkedList<quantumgate> getCircuit() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testGetCircuit_1() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(3));
		circuit.addGate(builderid, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));

		LinkedList<quantumgate> cir = circuit.getCircuit();

		assertEquals(3, cir.size());
		quantumgate g = cir.get(0);
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(3, g.getTarget());
		g = cir.get(1);
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = cir.get(2);
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
	}

	/**
	 * Run the LinkedList<quantumgate> getCircuit() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testGetCircuit_2() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(3));
		circuit.addGate(builderid, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));
		int b_id = 2;
		basiccircuit fixture = new basiccircuit(b_id);
		fixture.addGate(b_id, new Hadamard_Gate(1));
		fixture.addGate(b_id, new Pauli_X(2));
		circuit.addCircuit(builderid, fixture);

		LinkedList<quantumgate> cir = circuit.getCircuit();

		assertEquals(5, cir.size());
		quantumgate g = cir.get(0);
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(3, g.getTarget());
		g = cir.get(1);
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = cir.get(2);
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
		g = cir.get(3);
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(1, g.getTarget());
		g = cir.get(4);
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
	}

	/**
	 * Run the ListIterator<quantumgate> getCircuitlayout() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testGetCircuitlayout_1() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(3));
		circuit.addGate(builderid, new Pauli_X(2));
		circuit.addGate(builderid, new Pauli_Z(3));

		ListIterator<quantumgate> iter = circuit.getCircuitlayout();

		quantumgate g = iter.next();
		assertTrue(g instanceof Hadamard_Gate);
		assertEquals(3, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_X);
		assertEquals(2, g.getTarget());
		g = iter.next();
		assertTrue(g instanceof Pauli_Z);
		assertEquals(3, g.getTarget());
	}

	/**
	 * Run the int getSize() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testGetSize_1() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(1));

		int result = circuit.getSize();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getSize() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testGetSize_2() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(1));
		basiccircuit fixture = new basiccircuit(1);
		fixture.addGate(1, new Hadamard_Gate(1));

		circuit.addCircuit(builderid, fixture);

		int result = circuit.getSize();

		// add additional test code here
		assertEquals(2, result);
	}

	/**
	 * Run the void removeLastGate() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testRemoveLastGate_1() throws Exception {
		circuit.addGate(1, new Hadamard_Gate(1));

		int result = circuit.getSize();
		assertEquals(1, result);

		circuit.removeLastGate();

		result = circuit.getSize();
		assertEquals(0, result);
	}

	/**
	 * Run the String toLatex(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testToLatex_1() throws Exception {
		circuit.addGate(builderid, new Hadamard_Gate(1));
		int qubits = 1;

		String result = circuit.toLatex(qubits);

		// add additional test code here
		assertEquals(
				"\\begin{figure}\n\\[\n\\Qcircuit @C=1.0em @R=.7em {\n&\\gate{H}&\\\\%1\n}\n\\]\n\\end{figure}\n",
				result);
	}

	/**
	 * Run the String toLatex(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 19:27
	 */
	@Test
	public void testToLatex_2() throws Exception {
		basiccircuit fixture = new basiccircuit(1);
		fixture.addGate(1, new Hadamard_Gate(1));
		int qubits = 1;

		circuit.addCircuit(builderid, fixture);

		String result = circuit.toLatex(qubits);

		// add additional test code here
		assertEquals(
				"\\begin{figure}\n\\[\n\\Qcircuit @C=1.0em @R=.7em {\n&\\gate{H}&\\\\%1\n}\n\\]\n\\end{figure}\n",
				result);
	}
}