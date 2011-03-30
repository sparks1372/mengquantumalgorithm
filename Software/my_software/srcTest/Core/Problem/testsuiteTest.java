package Core.Problem;

import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>testsuiteTest</code> contains tests for the class <code>{@link testsuite}</code>.
 *
 * @generatedBy CodePro at 29/03/11 17:10
 * @author sam
 * @version $Revision: 1.0 $
 */
public class testsuiteTest {
	/**
	 * Run the testsuite(int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testTestsuite_1()
		throws Exception {
		int cg = 1;

		testsuite result = new testsuite(cg);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getNumOfCustomGates());
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_1()
		throws Exception {
		testsuite fixture = new testsuite(1);
		testset ts = new testset(1);

		fixture.addTestcases(ts);

		// add additional test code here
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_2()
		throws Exception {
		testsuite fixture = new testsuite(1);
		testset ts = new testset(1);

		fixture.addTestcases(ts);

		// add additional test code here
	}

	/**
	 * Run the void addTestcases(testset) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testAddTestcases_3()
		throws Exception {
		testsuite fixture = new testsuite(1);
		testset ts = new testset(1);

		fixture.addTestcases(ts);

		// add additional test code here
	}

	/**
	 * Run the testsuite copy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	@Test
	public void testCopy_1()
		throws Exception {
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
	public void testCopy_2()
		throws Exception {
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
	public void testEqual_1()
		throws Exception {
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
	public void testEqual_2()
		throws Exception {
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
	public void testEqual_3()
		throws Exception {
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
	public void testEqual_4()
		throws Exception {
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
	public void testGetKeys_1()
		throws Exception {
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
	public void testGetNumOfCustomGates_1()
		throws Exception {
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
	public void testGetTestcases_1()
		throws Exception {
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
	public void testRemoveTestSet_1()
		throws Exception {
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
	public void testSetNumOfCustomGates_1()
		throws Exception {
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
	public void testSetNumOfCustomGates_2()
		throws Exception {
		testsuite fixture = new testsuite(1);
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
	 * @generatedBy CodePro at 29/03/11 17:10
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
	 * @generatedBy CodePro at 29/03/11 17:10
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
	 * @generatedBy CodePro at 29/03/11 17:10
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(testsuiteTest.class);
	}
}