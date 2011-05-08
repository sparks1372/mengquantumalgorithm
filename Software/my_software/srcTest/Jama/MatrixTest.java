package Jama;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	 * @generatedBy CodePro at 19/04/11 00:54
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
	 * @generatedBy CodePro at 19/04/11 00:54
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
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the int getColumnDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetColumnDimension_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		int result = fixture.getColumnDimension();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getColumnDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetColumnDimension_2() throws Exception {
		Matrix fixture = new Matrix(2, 1);

		int result = fixture.getColumnDimension();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getColumnDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetColumnDimension_3() throws Exception {
		Matrix fixture = new Matrix(1, 2);

		int result = fixture.getColumnDimension();

		// add additional test code here
		assertEquals(2, result);
	}

	/**
	 * Run the int getColumnDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetColumnDimension_4() throws Exception {
		Matrix fixture = new Matrix(2, 2);

		int result = fixture.getColumnDimension();

		// add additional test code here
		assertEquals(2, result);
	}

	/**
	 * Run the int getRowDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetRowDimension_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		int result = fixture.getRowDimension();

		assertEquals(1, result);
	}

	/**
	 * Run the int getRowDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetRowDimension_2() throws Exception {
		Matrix fixture = new Matrix(2, 1);

		int result = fixture.getRowDimension();

		assertEquals(2, result);
	}

	/**
	 * Run the int getRowDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetRowDimension_3() throws Exception {
		Matrix fixture = new Matrix(1, 2);

		int result = fixture.getRowDimension();

		assertEquals(1, result);
	}

	/**
	 * Run the int getRowDimension() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testGetRowDimension_4() throws Exception {
		Matrix fixture = new Matrix(2, 2);

		int result = fixture.getRowDimension();

		assertEquals(2, result);
	}

	/**
	 * Run the Matrix identity(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testIdentity_1() throws Exception {
		int m = 1;
		int n = 1;

		Matrix result = Matrix.identity(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), 1.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix identity(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testIdentity_2() throws Exception {
		int m = 2;
		int n = 2;

		Matrix result = Matrix.identity(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), 1.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 0).real(), 0.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(0, 1).real(), 0.0, accuracy);
		assertEquals(result.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 1).real(), 1.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix minus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testMinus_1() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(1, 3));
		A.set(1, 0, new Complex(1, 2.5));
		A.set(0, 1, new Complex(-6.3, 2));
		A.set(1, 1, new Complex(2, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.minus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), -1.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 3.0, accuracy);
		assertEquals(result.get(0, 1).real(), -9.3, accuracy);
		assertEquals(result.get(0, 1).imag(), 2.0, accuracy);
		assertEquals(result.get(1, 0).real(), -1.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 2.5, accuracy);
		assertEquals(result.get(1, 1).real(), -1.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix minus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testMinus_2() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(1, 0));
		A.set(1, 0, new Complex(1, 0));
		A.set(0, 1, new Complex(1, 0));
		A.set(1, 1, new Complex(1, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.minus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), -1.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(0, 1).real(), -2.0, accuracy);
		assertEquals(result.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 0).real(), -1.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 1).real(), -2.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix minus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testMinus_3() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(-4, 0));
		A.set(1, 0, new Complex(51, 0));
		A.set(0, 1, new Complex(1, 0));
		A.set(1, 1, new Complex(1, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.minus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), -6.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(0, 1).real(), -2.0, accuracy);
		assertEquals(result.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 0).real(), 49.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 1).real(), -2.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix minusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testMinusEquals_1() throws Exception {
		Matrix fixture = Matrix.identity(1, 1);
		Matrix B = Matrix.identity(1, 1);

		fixture.minusEquals(B);

		// add additional test code here
		assertNotNull(fixture);
		assertEquals(1, fixture.getColumnDimension());
		assertEquals(1, fixture.getRowDimension());

		assertEquals(fixture.get(0, 0).real(), 0.0, accuracy);
		assertEquals(fixture.get(0, 0).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix minusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testMinusEquals_2() throws Exception {
		Matrix fixture = Matrix.identity(2, 2);
		Matrix B = Matrix.identity(2, 2);

		B.set(0, 0, new Complex(0, 0));

		fixture.minusEquals(B);

		// add additional test code here
		assertNotNull(fixture);
		assertEquals(2, fixture.getColumnDimension());
		assertEquals(2, fixture.getRowDimension());

		assertEquals(fixture.get(0, 0).real(), 1.0, accuracy);
		assertEquals(fixture.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).real(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).real(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 1).real(), 0.0, accuracy);
		assertEquals(fixture.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix minusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testMinusEquals_3() throws Exception {
		Matrix fixture = Matrix.identity(2, 2);
		Matrix B = Matrix.identity(2, 2);

		B.set(1, 1, new Complex(0, 0));

		fixture.minusEquals(B);

		// add additional test code here
		assertNotNull(fixture);
		assertEquals(2, fixture.getColumnDimension());
		assertEquals(2, fixture.getRowDimension());

		assertEquals(fixture.get(0, 0).real(), 0.0, accuracy);
		assertEquals(fixture.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).real(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).real(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 1).real(), 1.0, accuracy);
		assertEquals(fixture.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix plus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testPlus_1() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(1, 3));
		A.set(0, 1, new Complex(-6.3, 2));
		A.set(1, 0, new Complex(1, 2.5));
		A.set(1, 1, new Complex(2, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.plus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), 3.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 3.0, accuracy);
		assertEquals(result.get(0, 1).real(), -3.3, accuracy);
		assertEquals(result.get(0, 1).imag(), 2.0, accuracy);
		assertEquals(result.get(1, 0).real(), 3.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 2.5, accuracy);
		assertEquals(result.get(1, 1).real(), 5.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix plus(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testPlus_2() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(6, 3));
		A.set(0, 1, new Complex(-6.3, 0.2643));
		A.set(1, 0, new Complex(1, 2.5));
		A.set(1, 1, new Complex(0.6721, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.plus(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), 8.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 3.0, accuracy);
		assertEquals(result.get(0, 1).real(), -3.3, accuracy);
		assertEquals(result.get(0, 1).imag(), 0.2643, accuracy);
		assertEquals(result.get(1, 0).real(), 3.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 2.5, accuracy);
		assertEquals(result.get(1, 1).real(), 3.6721, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix plusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testPlusEquals_1() throws Exception {
		Matrix fixture = Matrix.identity(1, 1);
		Matrix B = Matrix.identity(1, 1);

		fixture.plusEquals(B);

		// add additional test code here
		assertNotNull(fixture);
		assertEquals(1, fixture.getColumnDimension());
		assertEquals(1, fixture.getRowDimension());

		assertEquals(fixture.get(0, 0).real(), 2.0, accuracy);
		assertEquals(fixture.get(0, 0).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix plusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testPlusEquals_2() throws Exception {
		Matrix fixture = Matrix.identity(2, 2);
		Matrix B = Matrix.identity(2, 2);

		B.set(0, 0, new Complex(0, 0));

		fixture.plusEquals(B);

		// add additional test code here
		assertNotNull(fixture);
		assertEquals(2, fixture.getColumnDimension());
		assertEquals(2, fixture.getRowDimension());

		assertEquals(fixture.get(0, 0).real(), 1.0, accuracy);
		assertEquals(fixture.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).real(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).real(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 1).real(), 2.0, accuracy);
		assertEquals(fixture.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix plusEquals(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testPlusEquals_3() throws Exception {
		Matrix fixture = Matrix.identity(2, 2);
		Matrix B = Matrix.identity(2, 2);

		B.set(1, 1, new Complex(0, 0));

		fixture.plusEquals(B);

		// add additional test code here
		assertNotNull(fixture);
		assertEquals(2, fixture.getColumnDimension());
		assertEquals(2, fixture.getRowDimension());

		assertEquals(fixture.get(0, 0).real(), 2.0, accuracy);
		assertEquals(fixture.get(0, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).real(), 0.0, accuracy);
		assertEquals(fixture.get(0, 1).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).real(), 0.0, accuracy);
		assertEquals(fixture.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(fixture.get(1, 1).real(), 1.0, accuracy);
		assertEquals(fixture.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testRandom_1() throws Exception {
		int m = 1;
		int n = 1;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testRandom_2() throws Exception {
		int m = 1;
		int n = 0;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testRandom_3() throws Exception {
		int m = 0;
		int n = 1;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(0, result.getRowDimension());
	}

	/**
	 * Run the Matrix random(int,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testRandom_4() throws Exception {
		int m = 2;
		int n = 2;

		Matrix result = Matrix.random(m, n);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());
	}

	/**
	 * Run the void set(int,int,Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testSet_1() throws Exception {
		Matrix fixture = Matrix.identity(1, 1);
		int i = 0;
		int j = 0;
		Complex s = new Complex(1.0, 1.0);

		fixture.set(i, j, s);

		assertNotNull(fixture);
		assertEquals(1, fixture.getColumnDimension());
		assertEquals(1, fixture.getRowDimension());
		assertEquals(1, fixture.get(0, 0).real(), accuracy);
		assertEquals(1, fixture.get(0, 0).imag(), accuracy);
	}

	/**
	 * Run the void set(int,int,Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testSet_2() throws Exception {
		Matrix fixture = Matrix.identity(1, 1);
		int i = 0;
		int j = 0;
		Complex s = new Complex(1.0, 3.0);

		fixture.set(i, j, s);

		assertNotNull(fixture);
		assertEquals(1, fixture.getColumnDimension());
		assertEquals(1, fixture.getRowDimension());
		assertEquals(1, fixture.get(0, 0).real(), accuracy);
		assertEquals(3, fixture.get(0, 0).imag(), accuracy);
	}

	/**
	 * Run the void set(int,int,Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testSet_3() throws Exception {
		Matrix fixture = Matrix.identity(2, 2);
		int i = 1;
		int j = 0;
		Complex s = new Complex(1.0, 3.0);

		fixture.set(i, j, s);

		assertNotNull(fixture);
		assertEquals(2, fixture.getColumnDimension());
		assertEquals(2, fixture.getRowDimension());
		assertEquals(1, fixture.get(0, 0).real(), accuracy);
		assertEquals(0, fixture.get(0, 0).imag(), accuracy);
		assertEquals(0, fixture.get(0, 1).real(), accuracy);
		assertEquals(0, fixture.get(0, 1).imag(), accuracy);
		assertEquals(1, fixture.get(1, 0).real(), accuracy);
		assertEquals(3, fixture.get(1, 0).imag(), accuracy);
		assertEquals(1, fixture.get(1, 1).real(), accuracy);
		assertEquals(0, fixture.get(1, 1).imag(), accuracy);
	}

	/**
	 * Run the void set(int,int,Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testSet_4() throws Exception {
		Matrix fixture = Matrix.identity(2, 2);
		int i = 0;
		int j = 1;
		Complex s = new Complex(1.0, 3.0);

		fixture.set(i, j, s);

		assertNotNull(fixture);
		assertEquals(2, fixture.getColumnDimension());
		assertEquals(2, fixture.getRowDimension());
		assertEquals(1, fixture.get(0, 0).real(), accuracy);
		assertEquals(0, fixture.get(0, 0).imag(), accuracy);
		assertEquals(1, fixture.get(0, 1).real(), accuracy);
		assertEquals(3, fixture.get(0, 1).imag(), accuracy);
		assertEquals(0, fixture.get(1, 0).real(), accuracy);
		assertEquals(0, fixture.get(1, 0).imag(), accuracy);
		assertEquals(1, fixture.get(1, 1).real(), accuracy);
		assertEquals(0, fixture.get(1, 1).imag(), accuracy);
	}

	/**
	 * Run the Matrix times(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimes_1() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(1, 0));
		A.set(1, 0, new Complex(1, 0));
		A.set(0, 1, new Complex(2, 0));
		A.set(1, 1, new Complex(2, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.times(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), 6.0, accuracy);
		assertEquals(result.get(0, 1).real(), 9.0, accuracy);
		assertEquals(result.get(1, 0).real(), 6.0, accuracy);
		assertEquals(result.get(1, 1).real(), 9.0, accuracy);
	}

	/**
	 * Run the Matrix times(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimes_2() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(1, 0));
		A.set(1, 0, new Complex(1, 0));
		A.set(0, 1, new Complex(0, 2));
		A.set(1, 1, new Complex(2, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.times(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), 2.0, accuracy);
		assertEquals(result.get(0, 0).imag(), 4.0, accuracy);
		assertEquals(result.get(0, 1).real(), 3.0, accuracy);
		assertEquals(result.get(0, 1).imag(), 6.0, accuracy);
		assertEquals(result.get(1, 0).real(), 6.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 0.0, accuracy);
		assertEquals(result.get(1, 1).real(), 9.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 0.0, accuracy);
	}

	/**
	 * Run the Matrix times(Matrix) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimes_3() throws Exception {
		Matrix A = new Matrix(2, 2);
		A.set(0, 0, new Complex(1, 3));
		A.set(1, 0, new Complex(1, 2.5));
		A.set(0, 1, new Complex(-6.3, 2));
		A.set(1, 1, new Complex(2, 0));

		Matrix B = new Matrix(2, 2);
		B.set(0, 0, new Complex(2, 0));
		B.set(1, 0, new Complex(2, 0));
		B.set(0, 1, new Complex(3, 0));
		B.set(1, 1, new Complex(3, 0));

		Matrix result = A.times(B);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2, result.getColumnDimension());
		assertEquals(2, result.getRowDimension());

		assertEquals(result.get(0, 0).real(), -10.6, accuracy);
		assertEquals(result.get(0, 0).imag(), 10, accuracy);
		assertEquals(result.get(0, 1).real(), -15.9, accuracy);
		assertEquals(result.get(0, 1).imag(), 15.0, accuracy);
		assertEquals(result.get(1, 0).real(), 6.0, accuracy);
		assertEquals(result.get(1, 0).imag(), 5.0, accuracy);
		assertEquals(result.get(1, 1).real(), 9.0, accuracy);
		assertEquals(result.get(1, 1).imag(), 7.5, accuracy);
	}

	/**
	 * Run the Matrix times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimes_4() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.times(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimes_5() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.times(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimes_6() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.times(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(0, result.getRowDimension());
	}

	/**
	 * Run the Matrix timesEquals(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimesEquals_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.timesEquals(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix timesEquals(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimesEquals_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.timesEquals(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix timesEquals(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTimesEquals_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);
		Complex s = new Complex(1.0, 1.0);

		Matrix result = fixture.timesEquals(s);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(0, result.getRowDimension());
	}

	/**
	 * Run the Complex trace() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
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
	 * @generatedBy CodePro at 19/04/11 00:54
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
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTranspose_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Matrix result = fixture.transpose();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix transpose() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTranspose_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Matrix result = fixture.transpose();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(0, result.getRowDimension());
	}

	/**
	 * Run the Matrix transpose() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testTranspose_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Matrix result = fixture.transpose();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix uminus() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testUminus_1() throws Exception {
		Matrix fixture = new Matrix(1, 1);

		Matrix result = fixture.uminus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix uminus() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testUminus_2() throws Exception {
		Matrix fixture = new Matrix(1, 0);

		Matrix result = fixture.uminus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getColumnDimension());
		assertEquals(1, result.getRowDimension());
	}

	/**
	 * Run the Matrix uminus() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 19/04/11 00:54
	 */
	@Test
	public void testUminus_3() throws Exception {
		Matrix fixture = new Matrix(0, 1);

		Matrix result = fixture.uminus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getColumnDimension());
		assertEquals(0, result.getRowDimension());
	}
}