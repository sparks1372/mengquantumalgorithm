package Core.Problem;

import org.junit.*;
import static org.junit.Assert.*;
import Jama.Matrix;

/**
 * The class <code>testcaseTest</code> contains tests for the class <code>{@link testcase}</code>.
 *
 * @generatedBy CodePro at 29/03/11 17:19
 * @author sam
 * @version $Revision: 1.0 $
 */
public class testcaseTest {
	/**
	 * Run the testcase(int,String,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testTestcase_1()
		throws Exception {
		int id = 1;
		String label = "";
		int numCustomGates = 1;

		testcase result = new testcase(id, label, numCustomGates);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getFinalstate());
		assertEquals(null, result.getStartingState());
		assertEquals(1, result.getId());
		assertEquals("", result.getLabel());
	}

	/**
	 * Run the testcase(int,String,String[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testTestcase_2()
		throws Exception {
		int id = 1;
		String label = "";
		String[] customGates = new String[] {};

		testcase result = new testcase(id, label, customGates);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getFinalstate());
		assertEquals(null, result.getStartingState());
		assertEquals(1, result.getId());
		assertEquals("", result.getLabel());
	}

	/**
	 * Run the testcase copy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testCopy_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		testcase result = fixture.copy();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Core.Problem.testcase.getFinalStateCopy(testcase.java:103)
		//       at Core.Problem.testcase.copy(testcase.java:49)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", 1);
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_2()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", 1);
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_3()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", 1);
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_4()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", 1);
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_5()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", new String[] {});
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_6()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", new String[] {});
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_7()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", new String[] {});
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the boolean equal(testcase) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testEqual_8()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		testcase tc = new testcase(1, "", new String[] {});
		tc.setStartingstate(new Matrix(1, 1));

		boolean result = fixture.equal(tc);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Jama.Matrix.equal(Matrix.java:109)
		//       at Core.Problem.testcase.equal(testcase.java:57)
		assertTrue(result);
	}

	/**
	 * Run the Matrix getFinalStateCopy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testGetFinalStateCopy_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		Matrix result = fixture.getFinalStateCopy();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Core.Problem.testcase.getFinalStateCopy(testcase.java:103)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getFinalstate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testGetFinalstate_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		Matrix result = fixture.getFinalstate();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the int getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		int result = fixture.getId();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the String getLabel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testGetLabel_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		String result = fixture.getLabel();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Matrix getStartingState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testGetStartingState_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		Matrix result = fixture.getStartingState();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix getStartingStateCopy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testGetStartingStateCopy_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));

		Matrix result = fixture.getStartingStateCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the void setCustomGates(int,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testSetCustomGates_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		int index = 1;
		String customGates = "";

		fixture.setCustomGates(index, customGates);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at Core.Problem.testcase.setCustomGates(testcase.java:153)
	}

	/**
	 * Run the void setFinalstate(Matrix) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testSetFinalstate_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		Matrix finalstate = new Matrix(1, 1);

		fixture.setFinalstate(finalstate);

		// add additional test code here
	}

	/**
	 * Run the void setId(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		int id = 1;

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setLabel(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testSetLabel_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		String label = "";

		fixture.setLabel(label);

		// add additional test code here
	}

	/**
	 * Run the void setStartingstate(Matrix) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	@Test
	public void testSetStartingstate_1()
		throws Exception {
		testcase fixture = new testcase(1, "", new String[] {});
		fixture.setStartingstate(new Matrix(1, 1));
		Matrix startingstate = new Matrix(1, 1);

		fixture.setStartingstate(startingstate);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 29/03/11 17:19
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
	 * @generatedBy CodePro at 29/03/11 17:19
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
	 * @generatedBy CodePro at 29/03/11 17:19
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(testcaseTest.class);
	}
}