package Core.Problem;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>testsetTest</code> contains tests for the class <code>{@link testset}</code>.
 *
 * @generatedBy CodePro at 29/03/11 17:14
 * @author sam
 * @version $Revision: 1.0 $
 */
public class testsetTest {
	/**
	 * Run the testset(int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testTestset_1()
		throws Exception {
		int numofqubits = 1;

		testset result = new testset(numofqubits);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getNum_of_qubits());
		assertEquals(0, result.getNumberOfTestcases());
		assertEquals(0, result.getNumOfCustomGates());
	}

	/**
	 * Run the void addTestcases(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testAddTestcases_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));
		testcase tc = new testcase(1, "", 1);

		fixture.addTestcases(tc);

		// add additional test code here
	}

	/**
	 * Run the testset copy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testCopy_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));

		testset result = fixture.copy();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Core.Problem.testcase.getStartingStateCopy(testcase.java:126)
		//       at Core.Problem.testcase.copy(testcase.java:48)
		//       at Core.Problem.testset.copy(testset.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the testset copy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testCopy_2()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));

		testset result = fixture.copy();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Core.Problem.testcase.getStartingStateCopy(testcase.java:126)
		//       at Core.Problem.testcase.copy(testcase.java:48)
		//       at Core.Problem.testset.copy(testset.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equal(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testEqual_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));
		testset ts = new testset(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testEqual_2()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		testset ts = new testset(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testEqual_3()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		testset ts = new testset(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testEqual_4()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		testset ts = new testset(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testEqual_5()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		testset ts = new testset(1);

		boolean result = fixture.equal(ts);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int getNumOfCustomGates() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testGetNumOfCustomGates_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));

		int result = fixture.getNumOfCustomGates();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getNum_of_qubits() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testGetNum_of_qubits_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));

		int result = fixture.getNum_of_qubits();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getNumberOfTestcases() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testGetNumberOfTestcases_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));

		int result = fixture.getNumberOfTestcases();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the Iterator<testcase> getTestcases() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testGetTestcases_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));

		Iterator<testcase> result = fixture.getTestcases();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.hasNext());
	}

	/**
	 * Run the void setNumOfCustomGates(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Test
	public void testSetNumOfCustomGates_1()
		throws Exception {
		testset fixture = new testset(1);
		fixture.setNumOfCustomGates(1);
		fixture.addTestcases(new testcase(1, "", 1));
		int numOfCustomGates = 1;

		fixture.setNumOfCustomGates(numOfCustomGates);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 29/03/11 17:14
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(testsetTest.class);
	}
}