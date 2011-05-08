package Core.Problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Jama.Matrix;

/**
 * The class <code>testsuiteTest</code> contains tests for the class
 * <code>{@link testsuite}</code>.
 * 
 * @generatedBy CodePro at 29/03/11 17:10
 * @author sam
 * @version $Revision: 1.0 $
 */
public class testsuiteTest {
	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(testsuiteTest.class);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_11() throws Exception {
		int cg = 0;
		int qubits = 1;
		testsuite fixture = new testsuite(cg);
		String lab = "label 1";
		testset ts = new testset(qubits);
		testcase tc = new testcase(0, lab, cg);
		ts.addTestcases(tc);

		fixture.addTestcases(ts);

		testset rts = fixture.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		Iterator<testcase> iter = rts.getTestcases();

		testcase rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab));
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_12() throws Exception {
		int cg = 0;
		int qubits = 2;
		testsuite fixture = new testsuite(cg);
		String lab = "label 1";
		testset ts = new testset(qubits);
		testcase tc = new testcase(0, lab, cg);
		ts.addTestcases(tc);

		fixture.addTestcases(ts);

		testset rts = fixture.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		Iterator<testcase> iter = rts.getTestcases();

		testcase rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab));
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_13() throws Exception {
		int cg = 0;
		int qubits = 3;
		testsuite fixture = new testsuite(cg);
		String lab = "label 1";
		testset ts = new testset(qubits);
		testcase tc = new testcase(0, lab, cg);
		ts.addTestcases(tc);

		fixture.addTestcases(ts);

		testset rts = fixture.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		Iterator<testcase> iter = rts.getTestcases();

		testcase rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab));
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_2() throws Exception {
		int cg = 0;
		int qubits1 = 1;
		int qubits2 = 2;
		testsuite fixture = new testsuite(cg);
		String lab1 = "label 1";
		String lab2 = "label 1";
		testset ts1 = new testset(qubits1);
		testcase tc1 = new testcase(0, lab1, cg);
		ts1.addTestcases(tc1);
		testset ts2 = new testset(qubits2);
		testcase tc2 = new testcase(0, lab2, cg);
		ts2.addTestcases(tc2);

		fixture.addTestcases(ts1);
		fixture.addTestcases(ts2);

		testset rts = fixture.getTestcases(qubits1);

		assertEquals(qubits1, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		Iterator<testcase> iter = rts.getTestcases();

		testcase rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab1));

		rts = fixture.getTestcases(qubits2);

		assertEquals(qubits2, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		iter = rts.getTestcases();

		rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab2));
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_3() throws Exception {
		int cg = 0;
		int qubits = 1;
		testsuite A = new testsuite(cg);
		testsuite B = new testsuite(cg);
		String lab1 = "label 1";
		String lab2 = "label 1";
		testset ts1 = new testset(qubits);
		testcase tc1 = new testcase(0, lab1, cg);
		tc1.setStartingstate(Matrix.identity(2, 2));
		tc1.setFinalstate(Matrix.identity(2, 2));
		ts1.addTestcases(tc1);

		testset ts2 = new testset(qubits);
		testcase tc2 = new testcase(0, lab2, cg);
		tc2.setStartingstate(Matrix.identity(2, 2));
		tc2.setFinalstate(Matrix.identity(2, 2));
		ts2.addTestcases(tc2);

		A.addTestcases(ts1);
		B.addTestcases(ts2);

		testset rts = A.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		Iterator<testcase> iter = rts.getTestcases();

		testcase rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab1));

		rts = B.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		iter = rts.getTestcases();

		rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab2));

		A.addTestcases(ts2);
		rts = A.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(2, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		iter = rts.getTestcases();

		rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab1));
		rtc = iter.next();

		assertEquals(1, rtc.getId());
		assertTrue(!rtc.getLabel().equalsIgnoreCase(lab1));

		rts = B.getTestcases(qubits);

		assertEquals(qubits, rts.getNum_of_qubits());
		assertEquals(1, rts.getNumberOfTestcases());
		assertEquals(cg, rts.getNumOfCustomGates());

		iter = rts.getTestcases();

		rtc = iter.next();

		assertEquals(0, rtc.getId());
		assertTrue(rtc.getLabel().equalsIgnoreCase(lab2));
	}

	/**
	 * Run the testsuite copy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testCopy_1() throws Exception {
		testsuite fixture = new testsuite(1);

		testsuite result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getNumOfCustomGates());
	}

	/**
	 * Run the testsuite copy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testCopy_2() throws Exception {
		testsuite fixture = new testsuite(1);

		testsuite result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getNumOfCustomGates());
	}

	/**
	 * Run the boolean equal(testsuite) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testEqual_1() throws Exception {
		testsuite fixture = new testsuite(1);
		testsuite ts = new testsuite(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testsuite) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testEqual_2() throws Exception {
		testsuite fixture = new testsuite(1);
		testsuite ts = new testsuite(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testsuite) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testEqual_3() throws Exception {
		testsuite fixture = new testsuite(1);
		testsuite ts = new testsuite(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testsuite) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testEqual_4() throws Exception {
		testsuite fixture = new testsuite(1);
		testsuite ts = new testsuite(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the Set<Integer> getKeys() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testGetKeys_1() throws Exception {
		testsuite fixture = new testsuite(1);

		Set<Integer> result = fixture.getKeys();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the int getNumOfCustomGates() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testGetNumOfCustomGates_1() throws Exception {
		testsuite fixture = new testsuite(1);

		int result = fixture.getNumOfCustomGates();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the testset getTestcases(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testGetTestcases_1() throws Exception {
		testsuite fixture = new testsuite(1);
		int qubit = 1;

		testset result = fixture.getTestcases(qubit);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void removeTestSet(testset) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testRemoveTestSet_1() throws Exception {
		testsuite fixture = new testsuite(1);
		testset ts = new testset(1);

		fixture.removeTestSet(ts);

		// add additional test code here
	}

	/**
	 * Run the void setNumOfCustomGates(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testSetNumOfCustomGates_1() throws Exception {
		testsuite fixture = new testsuite(1);
		int numOfCustomGates = 1;

		fixture.setNumOfCustomGates(numOfCustomGates);

		// add additional test code here
	}

	/**
	 * Run the void setNumOfCustomGates(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testSetNumOfCustomGates_2() throws Exception {
		testsuite fixture = new testsuite(1);
		int numOfCustomGates = 1;

		fixture.setNumOfCustomGates(numOfCustomGates);

		// add additional test code here
	}
}