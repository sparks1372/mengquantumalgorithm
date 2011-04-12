package Jama;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.NumberFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Core.CircuitEvaluator.Fitness;
import Utils.Complex;

/**
 * The class <code>MatrixTest</code> contains tests for the class
 * <code>{@link Matrix}</code>.
 * 
 * @generatedBy CodePro at 31/03/11 18:27
 * @author sam
 * @version $Revision: 1.0 $
 */
public class MatrixTest {
	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MatrixTest.class);
	}

	private final double	accuracy	= 0.001;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
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
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the Matrix arrayLeftDivide(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayLeftDivide_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		A.set(0, 0, new Complex(2, 0));
		B.set(0, 0, new Complex(4, 0));

		Matrix result = A.arrayLeftDivide(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, A));
		assertEquals(2, A.get(0, 0).real(), accuracy);
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayLeftDivide(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayLeftDivide_2() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(4, 0));
		B.set(0, 0, new Complex(2, 0));
		C.set(0, 0, new Complex(0.5, 0));

		Matrix result = A.arrayLeftDivide(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertEquals(4, A.get(0, 0).real(), accuracy);
		assertEquals(2, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayLeftDivide(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayLeftDivide_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			fixture.arrayLeftDivide(B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Matrix arrayLeftDivideEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayLeftDivideEquals_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		A.set(0, 0, new Complex(2, 0));
		B.set(0, 0, new Complex(4, 0));

		Matrix result = A.arrayLeftDivideEquals(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, A));
		assertEquals(2, A.get(0, 0).real(), accuracy);
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayLeftDivideEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayLeftDivideEquals_2() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(4, 0));
		B.set(0, 0, new Complex(2, 0));
		C.set(0, 0, new Complex(0.5, 0));

		Matrix result = A.arrayLeftDivideEquals(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertTrue(Matrix.equal(A, C));
		assertEquals(2, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayLeftDivideEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayLeftDivideEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			fixture.arrayLeftDivideEquals(B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Matrix arrayRightDivide(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayRightDivide_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(4, 0));
		B.set(0, 0, new Complex(2, 0));
		C.set(0, 0, new Complex(0.5, 0));

		Matrix result = B.arrayRightDivide(A);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertEquals(4, A.get(0, 0).real(), accuracy);
		assertEquals(2, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayRightDivide(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayRightDivide_2() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		A.set(0, 0, new Complex(2, 0));
		B.set(0, 0, new Complex(4, 0));

		Matrix result = B.arrayRightDivide(A);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, A));
		assertEquals(2, A.get(0, 0).real(), accuracy);
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayRightDivide(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayRightDivide_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			fixture.arrayRightDivide(B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Matrix arrayRightDivideEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayRightDivideEquals_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(4, 0));
		B.set(0, 0, new Complex(2, 0));
		C.set(0, 0, new Complex(0.5, 0));

		Matrix result = B.arrayRightDivideEquals(A);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertTrue(Matrix.equal(B, C));
		assertEquals(4, A.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayRightDivideEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayRightDivideEquals_2() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(4, 0));
		B.set(0, 0, new Complex(2, 0));
		C.set(0, 0, new Complex(0.5, 0));

		Matrix result = B.arrayRightDivideEquals(A);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertTrue(Matrix.equal(B, C));
		assertEquals(4, A.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayRightDivideEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayRightDivideEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			fixture.arrayRightDivideEquals(B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Matrix arrayTimes(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayTimes_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(2, 0));
		B.set(0, 0, new Complex(4, 0));
		C.set(0, 0, new Complex(8, 0));

		Matrix result = A.arrayTimes(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertEquals(2, A.get(0, 0).real(), accuracy);
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayTimes(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayTimes_2() throws Exception {
		Matrix A = new Matrix(2, 1);
		Matrix B = new Matrix(2, 1);
		Matrix C = new Matrix(2, 1);
		A.set(0, 0, new Complex(2, 0));
		A.set(1, 0, new Complex(3, 0));
		B.set(0, 0, new Complex(4, 0));
		B.set(1, 0, new Complex(3, 0));
		C.set(0, 0, new Complex(8, 0));
		C.set(1, 0, new Complex(9, 0));

		Matrix result = A.arrayTimes(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertEquals(2, A.get(0, 0).real(), accuracy);
		assertEquals(3, A.get(1, 0).real(), accuracy);
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(3, B.get(1, 0).real(), accuracy);
		assertEquals(2, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayTimes(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayTimes_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			fixture.arrayTimes(B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Matrix arrayTimesEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayTimesEquals_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		Matrix C = new Matrix(1, 1);
		A.set(0, 0, new Complex(2, 0));
		B.set(0, 0, new Complex(4, 0));
		C.set(0, 0, new Complex(8, 0));

		Matrix result = A.arrayTimesEquals(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertTrue(Matrix.equal(A, C));
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayTimesEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayTimesEquals_2() throws Exception {
		Matrix A = new Matrix(2, 1);
		Matrix B = new Matrix(2, 1);
		Matrix C = new Matrix(2, 1);
		A.set(0, 0, new Complex(2, 0));
		A.set(1, 0, new Complex(3, 0));
		B.set(0, 0, new Complex(4, 0));
		B.set(1, 0, new Complex(3, 0));
		C.set(0, 0, new Complex(8, 0));
		C.set(1, 0, new Complex(9, 0));

		Matrix result = A.arrayTimesEquals(B);

		// add additional test code here
		assertNotNull(result);
		assertTrue(Matrix.equal(result, C));
		assertTrue(Matrix.equal(A, C));
		assertEquals(4, B.get(0, 0).real(), accuracy);
		assertEquals(3, B.get(1, 0).real(), accuracy);
		assertEquals(2, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix arrayTimesEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testArrayTimesEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			fixture.arrayTimesEquals(B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Object clone() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testClone_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Object result = fixture.clone();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Matrix copy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testCopy_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Matrix result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix copy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testCopy_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Matrix result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix copy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testCopy_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Matrix result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the boolean equal(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEqual_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		boolean result = Matrix.equal(A, B);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEqual_2() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);
		A.set(0, 0, new Complex(1, 1));

		boolean result = Matrix.equal(A, B);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equal(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEqual_3() throws Exception {
		Matrix A = new Matrix(1, 0);
		Matrix B = new Matrix(1, 1);

		boolean result = Matrix.equal(A, B);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equal(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEqual_4() throws Exception {
		Matrix A = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		boolean result = Matrix.equal(A, B);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the Fitness euclid(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEuclid_1() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Fitness result = Matrix.euclid(A, B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.getFitness(), 1.0);
		assertEquals(1, result.getPerfectcount());
	}

	/**
	 * Run the Fitness euclid(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEuclid_2() throws Exception {
		Matrix A = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Fitness result = Matrix.euclid(A, B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.getFitness(), 1.0);
		assertEquals(1, result.getPerfectcount());
	}

	/**
	 * Run the Fitness euclid(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testEuclid_3() throws Exception {
		Matrix A = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		try {
			Matrix.euclid(A, B);
			assertTrue(
					"The dimensions of A and B do not match so a euclidean distance cannot be calculated",
					false);
		} catch (java.lang.IllegalArgumentException iae) {
			assertTrue(true);
		}
	}

	/**
	 * Run the Fitness euclid(Matrix,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testEuclid_4() throws Exception {
		Matrix A = new Matrix(1, 2);
		Matrix B = new Matrix(1, 1);

		Fitness result = Matrix.euclid(A, B);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Complex get(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGet_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i = 1;
		int j = 1;

		Complex result = fixture.get(i, j);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: 1
		// at Jama.Matrix.get(Matrix.java:536)
		assertNotNull(result);
	}

	/**
	 * Run the Complex[][] getArray() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetArray_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex[][] result = fixture.getArray();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(1, result[0].length);
		assertNotNull(result[0][0]);
		assertEquals(0.0, result[0][0].real(), 1.0);
		assertEquals(0.0, result[0][0].imag(), 1.0);
		assertEquals("0", result[0][0].toString());
		assertEquals(0.0, result[0][0].arg(), 1.0);
		assertEquals(0.0, result[0][0].mod(), 1.0);
	}

	/**
	 * Run the Complex[][] getArrayCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetArrayCopy_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex[][] result = fixture.getArrayCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(1, result[0].length);
		assertNotNull(result[0][0]);
		assertEquals(0.0, result[0][0].real(), 1.0);
		assertEquals(0.0, result[0][0].imag(), 1.0);
		assertEquals("0", result[0][0].toString());
		assertEquals(0.0, result[0][0].arg(), 1.0);
		assertEquals(0.0, result[0][0].mod(), 1.0);
	}

	/**
	 * Run the Complex[][] getArrayCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetArrayCopy_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Complex[][] result = fixture.getArrayCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(0, result[0].length);
	}

	/**
	 * Run the Complex[][] getArrayCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetArrayCopy_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Complex[][] result = fixture.getArrayCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the int getColumnDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetColumnDimension_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		int result = fixture.getColumnDimension();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the Complex[] getColumnPackedCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetColumnPackedCopy_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex[] result = fixture.getColumnPackedCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(0.0, result[0].real(), 1.0);
		assertEquals(0.0, result[0].imag(), 1.0);
		assertEquals("0", result[0].toString());
		assertEquals(0.0, result[0].arg(), 1.0);
		assertEquals(0.0, result[0].mod(), 1.0);
	}

	/**
	 * Run the Complex[] getColumnPackedCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetColumnPackedCopy_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Complex[] result = fixture.getColumnPackedCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the Complex[] getColumnPackedCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetColumnPackedCopy_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Complex[] result = fixture.getColumnPackedCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the Matrix getMatrix(int[],int[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 1 };
		int[] c = new int[] { 1 };

		Matrix result = fixture.getMatrix(r, c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:712)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int,int,int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_10() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int j0 = 1;
		int j1 = 1;

		Matrix result = fixture.getMatrix(i0, i1, j0, j1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:617)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int,int,int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_11() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int j0 = 1;
		int j1 = 1;

		Matrix result = fixture.getMatrix(i0, i1, j0, j1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:617)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int,int,int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_12() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int j0 = 1;
		int j1 = 1;

		Matrix result = fixture.getMatrix(i0, i1, j0, j1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:617)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int[],int[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_2() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 0 };
		int[] c = new int[] {};

		Matrix result = fixture.getMatrix(r, c);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix getMatrix(int[],int[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_3() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] {};
		int[] c = new int[] {};

		Matrix result = fixture.getMatrix(r, c);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix getMatrix(int,int,int[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_4() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int[] c = new int[] { 1 };

		Matrix result = fixture.getMatrix(i0, i1, c);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:646)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int,int,int[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_5() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int[] c = new int[] {};

		Matrix result = fixture.getMatrix(i0, i1, c);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix getMatrix(int,int,int[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_6() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int[] c = new int[] {};

		Matrix result = fixture.getMatrix(i0, i1, c);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix getMatrix(int[],int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_7() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 1 };
		int j0 = 1;
		int j1 = 1;

		Matrix result = fixture.getMatrix(r, j0, j1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:685)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int[],int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_8() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 0 };
		int j0 = 1;
		int j1 = 1;

		Matrix result = fixture.getMatrix(r, j0, j1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.getMatrix(Matrix.java:685)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix getMatrix(int[],int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetMatrix_9() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] {};
		int j0 = 1;
		int j1 = 1;

		Matrix result = fixture.getMatrix(r, j0, j1);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the int getRowDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetRowDimension_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		int result = fixture.getRowDimension();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the Complex[] getRowPackedCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetRowPackedCopy_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex[] result = fixture.getRowPackedCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(0.0, result[0].real(), 1.0);
		assertEquals(0.0, result[0].imag(), 1.0);
		assertEquals("0", result[0].toString());
		assertEquals(0.0, result[0].arg(), 1.0);
		assertEquals(0.0, result[0].mod(), 1.0);
	}

	/**
	 * Run the Complex[] getRowPackedCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetRowPackedCopy_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Complex[] result = fixture.getRowPackedCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the Complex[] getRowPackedCopy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testGetRowPackedCopy_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Complex[] result = fixture.getRowPackedCopy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the Matrix identity(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testIdentity_1() throws Exception {
		int m = 1;
		int n = 1;

		Matrix result = Matrix.identity(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix identity(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testIdentity_2() throws Exception {
		int m = 1;
		int n = 1;

		Matrix result = Matrix.identity(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix identity(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testIdentity_3() throws Exception {
		int m = 1;
		int n = 0;

		Matrix result = Matrix.identity(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix identity(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testIdentity_4() throws Exception {
		int m = 0;
		int n = 1;

		Matrix result = Matrix.identity(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_1() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_10() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_11() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_12() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_13() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_14() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_15() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_16() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_2() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_3() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_4() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_5() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_6() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_7() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_8() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the void main(String[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMain_9() throws Exception {
		String[] args = new String[] {};

		Matrix.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.SecurityException: Cannot write to files while generating
		// test cases
		// at
		// com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:169)
		// at java.io.FileOutputStream.<init>(FileOutputStream.java:70)
		// at Jama.Matrix.main(Matrix.java:189)
	}

	/**
	 * Run the Matrix(int,int) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMatrix_1() throws Exception {
		int m = 1;
		int n = 1;

		Matrix result = new Matrix(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix(int,int) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMatrix_2() throws Exception {
		int m = 1;
		int n = 0;

		Matrix result = new Matrix(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix(int,int) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMatrix_3() throws Exception {
		int m = 0;
		int n = 1;

		Matrix result = new Matrix(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix(int,int,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMatrix_4() throws Exception {
		int m = 1;
		int n = 1;
		double s = 1.0;

		Matrix result = new Matrix(m, n, s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix(int,int,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMatrix_5() throws Exception {
		int m = 1;
		int n = 0;
		double s = 1.0;

		Matrix result = new Matrix(m, n, s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix(int,int,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMatrix_6() throws Exception {
		int m = 0;
		int n = 1;
		double s = 1.0;

		Matrix result = new Matrix(m, n, s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix minus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMinus_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.minus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix minus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMinus_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.minus(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.minus(Matrix.java:752)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix minus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMinus_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.minus(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.minus(Matrix.java:752)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix minusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMinusEquals_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.minusEquals(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix minusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMinusEquals_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.minusEquals(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.minusEquals(Matrix.java:772)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix minusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testMinusEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.minusEquals(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.minusEquals(Matrix.java:772)
		assertNotNull(result);
	}

	/**
	 * Run the Complex norm1() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testNorm1_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex result = fixture.norm1();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex norm1() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testNorm1_2() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Complex result = fixture.norm1();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex norm1() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testNorm1_3() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Complex result = fixture.norm1();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex normInf() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testNormInf_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex result = fixture.normInf();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex normInf() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testNormInf_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Complex result = fixture.normInf();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex normInf() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testNormInf_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Complex result = fixture.normInf();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Matrix plus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPlus_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.plus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix plus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPlus_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.plus(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.plus(Matrix.java:828)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix plus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPlus_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.plus(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.plus(Matrix.java:828)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix plusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPlusEquals_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.plusEquals(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix plusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPlusEquals_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.plusEquals(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.plusEquals(Matrix.java:848)
		assertNotNull(result);
	}

	/**
	 * Run the Matrix plusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPlusEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.plusEquals(B);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.IllegalArgumentException: Matrix dimensions must agree.
		// at Jama.Matrix.checkMatrixDimensions(Matrix.java:496)
		// at Jama.Matrix.plusEquals(Matrix.java:848)
		assertNotNull(result);
	}

	/**
	 * Run the void print(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int w = 1;
		int d = 1;

		fixture.print(w, d);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_10() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_11() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_12() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_13() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_14() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_15() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_2() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_3() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		int w = 1;
		int d = 1;

		fixture.print(output, w, d);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_4() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_5() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_6() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_7() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_8() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_9() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int w = 1;
		int d = 1;

		fixture.print_state(w, d);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_10() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_11() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_12() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_13() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_14() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_15() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_16() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_17() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_18() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_19() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_2() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_3() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		int w = 1;
		int d = 1;

		fixture.print_state(output, w, d);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_4() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_5() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_6() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_7() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_8() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the void print_state(PrintWriter,NumberFormat,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testPrint_state_9() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		PrintWriter output = new PrintWriter(new StringWriter());
		NumberFormat format = NumberFormat.getCurrencyInstance();
		int width = 1;

		fixture.print_state(output, format, width);

		// add additional test code here
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testRandom_1() throws Exception {
		int m = 1;
		int n = 1;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testRandom_2() throws Exception {
		int m = 1;
		int n = 0;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testRandom_3() throws Exception {
		int m = 0;
		int n = 1;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the void set(int,int,Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSet_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i = 1;
		int j = 1;
		Complex s = new Complex(1.0, 1.0);

		fixture.set(i, j, s);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: 1
		// at Jama.Matrix.set(Matrix.java:1146)
	}

	/**
	 * Run the void setMatrix(int[],int[],Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 1 };
		int[] c = new int[] { 1 };
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(r, c, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1253)
	}

	/**
	 * Run the void setMatrix(int,int,int,int,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_10() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int j0 = 1;
		int j1 = 1;
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(i0, i1, j0, j1, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1174)
	}

	/**
	 * Run the void setMatrix(int,int,int,int,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_11() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int j0 = 1;
		int j1 = 1;
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(i0, i1, j0, j1, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1174)
	}

	/**
	 * Run the void setMatrix(int,int,int,int,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_12() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int j0 = 1;
		int j1 = 1;
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(i0, i1, j0, j1, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1174)
	}

	/**
	 * Run the void setMatrix(int[],int[],Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_2() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 0 };
		int[] c = new int[] {};
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(r, c, X);

		// add additional test code here
	}

	/**
	 * Run the void setMatrix(int[],int[],Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_3() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] {};
		int[] c = new int[] {};
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(r, c, X);

		// add additional test code here
	}

	/**
	 * Run the void setMatrix(int,int,int[],Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_4() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int[] c = new int[] { 1 };
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(i0, i1, c, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1201)
	}

	/**
	 * Run the void setMatrix(int,int,int[],Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_5() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int[] c = new int[] {};
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(i0, i1, c, X);

		// add additional test code here
	}

	/**
	 * Run the void setMatrix(int,int,int[],Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_6() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int i0 = 1;
		int i1 = 1;
		int[] c = new int[] {};
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(i0, i1, c, X);

		// add additional test code here
	}

	/**
	 * Run the void setMatrix(int[],int,int,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_7() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 1 };
		int j0 = 1;
		int j1 = 1;
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(r, j0, j1, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1228)
	}

	/**
	 * Run the void setMatrix(int[],int,int,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_8() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] { 0 };
		int j0 = 1;
		int j1 = 1;
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(r, j0, j1, X);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.ArrayIndexOutOfBoundsException: Submatrix indices
		// at Jama.Matrix.setMatrix(Matrix.java:1228)
	}

	/**
	 * Run the void setMatrix(int[],int,int,Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testSetMatrix_9() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		int[] r = new int[] {};
		int j0 = 1;
		int j1 = 1;
		Matrix X = new Matrix(1, 1);

		fixture.setMatrix(r, j0, j1, X);

		// add additional test code here
	}

	/**
	 * Run the Matrix times(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimes_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.times(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix times(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimes_2() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Matrix B = new Matrix(1, 1);

		Matrix result = fixture.times(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix times(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimes_3() throws Exception {
		Matrix fixture = new Matrix(0, 0);
		Matrix B = new Matrix(0, 0);

		Matrix result = fixture.times(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimes_4() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.times(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimes_5() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.times(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimes_6() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.times(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix timesEquals(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimesEquals_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.timesEquals(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix timesEquals(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimesEquals_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.timesEquals(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix timesEquals(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTimesEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.timesEquals(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Complex trace() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTrace_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex result = fixture.trace();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex trace() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTrace_2() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Complex result = fixture.trace();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the Matrix transpose() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTranspose_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Matrix result = fixture.transpose();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix transpose() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTranspose_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Matrix result = fixture.transpose();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix transpose() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testTranspose_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Matrix result = fixture.transpose();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix uminus() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testUminus_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Matrix result = fixture.uminus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}

	/**
	 * Run the Matrix uminus() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testUminus_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Matrix result = fixture.uminus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getRowDimension());
		assertEquals(0, result.getColumnDimension());
	}

	/**
	 * Run the Matrix uminus() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 31/03/11 18:27
	 */
	@Test
	public void testUminus_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Matrix result = fixture.uminus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRowDimension());
		assertEquals(1, result.getColumnDimension());
	}
}