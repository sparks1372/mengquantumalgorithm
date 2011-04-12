package Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>ComplexTest</code> contains tests for the class
 * <code>{@link Complex}</code>.
 * 
 * @generatedBy CodePro at 29/03/11 16:07
 * @author sam
 * @version $Revision: 1.0 $
 */
public class ComplexTest {
	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ComplexTest.class);
	}

	private final double	accuracy	= 0.001;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
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
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the double arg() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testArg_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.arg();

		// add additional test code here
		assertEquals(0.7853981633974483, result, accuracy);
	}

	/**
	 * Run the double arg() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testArg_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		double result = fixture.arg();

		// add additional test code here
		assertEquals(-0.7853981633974483, result, accuracy);
	}

	/**
	 * Run the double arg() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testArg_3() throws Exception {
		Complex fixture = new Complex(1.0, 0.0);

		double result = fixture.arg();

		// add additional test code here
		assertEquals(0.0, result, accuracy);
	}

	/**
	 * Run the double arg() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testArg_4() throws Exception {
		Complex fixture = new Complex(0.0, 1.0);

		double result = fixture.arg();

		// add additional test code here
		assertEquals(1.5708, result, accuracy);
	}

	/**
	 * Run the Complex chs() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testChs_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.chs();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals("-1 - 1i", result.toString());
		assertEquals(-2.356194490192345, result.arg(), accuracy);
		assertEquals(1.4142135623730951, result.mod(), accuracy);
	}

	/**
	 * Run the Complex chs() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChs_2() throws Exception {
		Complex fixture = new Complex(2.0, 1.0);

		Complex result = fixture.chs();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-2.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals("-2 - 1i", result.toString());
		assertEquals(-2.6779, result.arg(), accuracy);
		assertEquals(2.2361, result.mod(), accuracy);
	}

	/**
	 * Run the Complex chs() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChs_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.chs();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals("1 - 1i", result.toString());
		assertEquals(-0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex chs() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChs_4() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.chs();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("-1 + 1i", result.toString());
		assertEquals(2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex(double,double) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testComplex_1() throws Exception {
		double u = 1.0;
		double v = 1.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("1 + 1i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), accuracy);
		assertEquals(1.4142135623730951, result.mod(), accuracy);
	}

	/**
	 * Run the Complex(double,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testComplex_2() throws Exception {
		double u = 2.0;
		double v = 1.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("2 + 1i", result.toString());
		assertEquals(0.46365, result.arg(), accuracy);
		assertEquals(2.2361, result.mod(), accuracy);
	}

	/**
	 * Run the Complex(double,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testComplex_3() throws Exception {
		double u = -2.0;
		double v = 1.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-2.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("-2 + 1i", result.toString());
		assertEquals(2.6779, result.arg(), accuracy);
		assertEquals(2.2361, result.mod(), accuracy);
	}

	/**
	 * Run the Complex(double,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testComplex_4() throws Exception {
		double u = 2.0;
		double v = -2.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(-2.0, result.imag(), accuracy);
		assertEquals("2 - 2i", result.toString());
		assertEquals(-0.78540, result.arg(), accuracy);
		assertEquals(2.8284, result.mod(), accuracy);
	}

	/**
	 * Run the Complex(double,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testComplex_5() throws Exception {
		double u = 0.0;
		double v = 2.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(2.0, result.imag(), accuracy);
		assertEquals("2i", result.toString());
		assertEquals(1.5708, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex(double,double) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testComplex_6() throws Exception {
		double u = 0.0;
		double v = -2.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(-2.0, result.imag(), accuracy);
		assertEquals("-2i", result.toString());
		assertEquals(-1.5708, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex conj() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testConj_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.conj();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals("1 - 1i", result.toString());
		assertEquals(-0.7853981633974483, result.arg(), accuracy);
		assertEquals(1.4142135623730951, result.mod(), accuracy);
	}

	/**
	 * Run the Complex conj() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConj_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.conj();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("1 + 1i", result.toString());
		assertEquals(0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex conj() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConj_3() throws Exception {
		Complex fixture = new Complex(1.0, 0.0);

		Complex result = fixture.conj();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("1", result.toString());
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(1.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex copy() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testCopy_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("1 + 1i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), accuracy);
		assertEquals(1.4142135623730951, result.mod(), accuracy);
	}

	/**
	 * Run the Complex copy() method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testCopy_2() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals("-1 + 1i", result.toString());
		assertEquals(2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex copy() method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testCopy_3() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals("-1 - 1i", result.toString());
		assertEquals(-2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex copy() method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testCopy_4() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals("1 - 1i", result.toString());
		assertEquals(-0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cos() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testCos_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.cos();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.8337300251311492, result.real(), accuracy);
		assertEquals(-0.9888977057628652, result.imag(), accuracy);
		assertEquals("0.8337 - 0.9889i", result.toString());
		assertEquals(-0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cos() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCos_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.cos();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.8337300251311492, result.real(), accuracy);
		assertEquals(0.9888977057628652, result.imag(), accuracy);
		assertEquals("0.8337 + 0.9889i", result.toString());
		assertEquals(0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cos() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCos_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.cos();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.8337300251311492, result.real(), accuracy);
		assertEquals(0.9888977057628652, result.imag(), accuracy);
		assertEquals("0.8337 + 0.9889i", result.toString());
		assertEquals(0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cos() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCos_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.cos();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.8337300251311492, result.real(), accuracy);
		assertEquals(-0.9888977057628652, result.imag(), accuracy);
		assertEquals("0.8337 - 0.9889i", result.toString());
		assertEquals(-0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cosh() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testCosh_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.cosh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.83373, result.real(), accuracy);
		assertEquals(0.9889, result.imag(), accuracy);
		assertEquals("0.8337 + 0.9889i", result.toString());
		assertEquals(0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cosh() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCosh_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.cosh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.83373, result.real(), accuracy);
		assertEquals(-0.9889, result.imag(), accuracy);
		assertEquals("0.8337 - 0.9889i", result.toString());
		assertEquals(-0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cosh() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCosh_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.cosh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.83373, result.real(), accuracy);
		assertEquals(-0.9889, result.imag(), accuracy);
		assertEquals("0.8337 - 0.9889i", result.toString());
		assertEquals(-0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex cosh() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCosh_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.cosh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.83373, result.real(), accuracy);
		assertEquals(0.9889, result.imag(), accuracy);
		assertEquals("0.8337 + 0.9889i", result.toString());
		assertEquals(0.87033, result.arg(), accuracy);
		assertEquals(1.2935, result.mod(), accuracy);
	}

	/**
	 * Run the Complex div(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testDiv_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.div(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(1.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex div(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDiv_2() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, -1.0);

		Complex result = fixture.div(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals(1.5708, result.arg(), accuracy);
		assertEquals(1.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex div(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDiv_3() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, 1.0);

		Complex result = fixture.div(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals(-1.5708, result.arg(), accuracy);
		assertEquals(1.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex div(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDiv_4() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, -1.0);

		Complex result = fixture.div(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals(3.1416, result.arg(), accuracy);
		assertEquals(1.0, result.mod(), accuracy);
	}

	/**
	 * Run the boolean equal(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEqual_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, -1.0);

		boolean result = fixture.equal(w);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equal(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEqual_2() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, 1.0);

		boolean result = fixture.equal(w);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equal(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEqual_3() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		boolean result = fixture.equal(w);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equal(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEqual_4() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		boolean result = fixture.equal(w);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equal(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEqual_5() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);
		Complex w = new Complex(1.0, 1.0);

		boolean result = fixture.equal(w);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the Complex exp() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testExp_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.exp();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.46869, result.real(), accuracy);
		assertEquals(2.28735, result.imag(), accuracy);
		assertEquals("1.4687 + 2.2874i", result.toString());
		assertEquals(1.0, result.arg(), accuracy);
		assertEquals(2.7182818284590455, result.mod(), accuracy);
	}

	/**
	 * Run the Complex exp() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testExp_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.exp();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.46869, result.real(), accuracy);
		assertEquals(-2.28735, result.imag(), accuracy);
		assertEquals("1.4687 - 2.2874i", result.toString());
		assertEquals(-1.0, result.arg(), accuracy);
		assertEquals(2.7182818284590455, result.mod(), accuracy);
	}

	/**
	 * Run the Complex exp() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testExp_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.exp();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.19877, result.real(), accuracy);
		assertEquals(0.30956, result.imag(), accuracy);
		assertEquals("0.1988 + 0.3096i", result.toString());
		assertEquals(1.0, result.arg(), accuracy);
		assertEquals(0.36788, result.mod(), accuracy);
	}

	/**
	 * Run the Complex exp() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testExp_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.exp();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.19877, result.real(), accuracy);
		assertEquals(-0.30956, result.imag(), accuracy);
		assertEquals("0.1988 - 0.3096i", result.toString());
		assertEquals(-1.0, result.arg(), accuracy);
		assertEquals(0.36788, result.mod(), accuracy);
	}

	/**
	 * Run the double imag() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testImag_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.imag();

		// add additional test code here
		assertEquals(1.0, result, accuracy);
	}

	/**
	 * Run the double imag() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testImag_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		double result = fixture.imag();

		// add additional test code here
		assertEquals(-1.0, result, accuracy);
	}

	/**
	 * Run the double imag() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testImag_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		double result = fixture.imag();

		// add additional test code here
		assertEquals(1.0, result, accuracy);
	}

	/**
	 * Run the double imag() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testImag_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		double result = fixture.imag();

		// add additional test code here
		assertEquals(-1.0, result, accuracy);
	}

	/**
	 * Run the Complex log() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testLog_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.log();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.3466, result.real(), accuracy);
		assertEquals(0.7854, result.imag(), accuracy);
		assertEquals("0.3466 + 0.7854i", result.toString());
		assertEquals(1.1552, result.arg(), accuracy);
		assertEquals(0.85847, result.mod(), accuracy);
	}

	/**
	 * Run the Complex log() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLog_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.log();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.3466, result.real(), accuracy);
		assertEquals(-0.7854, result.imag(), accuracy);
		assertEquals("0.3466 - 0.7854i", result.toString());
		assertEquals(-1.1552, result.arg(), accuracy);
		assertEquals(0.85847, result.mod(), accuracy);
	}

	/**
	 * Run the Complex log() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLog_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.log();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.3466, result.real(), accuracy);
		assertEquals(2.3562, result.imag(), accuracy);
		assertEquals("0.3466 + 2.3562i", result.toString());
		assertEquals(1.4248, result.arg(), accuracy);
		assertEquals(2.3815, result.mod(), accuracy);
	}

	/**
	 * Run the Complex log() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLog_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.log();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.3466, result.real(), accuracy);
		assertEquals(-2.3562, result.imag(), accuracy);
		assertEquals("0.3466 - 2.3562i", result.toString());
		assertEquals(-1.4248, result.arg(), accuracy);
		assertEquals(2.3815, result.mod(), accuracy);
	}

	/**
	 * Run the Complex minus(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMinus_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.minus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(0.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex minus(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMinus_2() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, -1.0);

		Complex result = fixture.minus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(2.0, result.imag(), accuracy);
		assertEquals("2i", result.toString());
		assertEquals(1.5708, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex minus(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMinus_3() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, 1.0);

		Complex result = fixture.minus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("2", result.toString());
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex minus(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMinus_4() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, -1.0);

		Complex result = fixture.minus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(2.0, result.imag(), accuracy);
		assertEquals("2 + 2i", result.toString());
		assertEquals(0.78540, result.arg(), accuracy);
		assertEquals(2.8284, result.mod(), accuracy);
	}

	/**
	 * Run the double mod() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMod_1() throws Exception {
		Complex fixture = new Complex(0, 0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(0.0, result, accuracy);
	}

	/**
	 * Run the double mod() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMod_2() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(1.4142135623730951, result, accuracy);
	}

	/**
	 * Run the double mod() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMod_3() throws Exception {
		Complex fixture = new Complex(0, 1.0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(1.0, result, accuracy);
	}

	/**
	 * Run the double mod() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMod_4() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(1.4142, result, accuracy);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_1() throws Exception {
		String p = "1 + 1i";

		Complex result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals(p, result.toString());
		assertEquals(0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);

		p = "1+1i";

		result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals(0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_2() throws Exception {
		String p = "1 - 1i";

		Complex result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals(p, result.toString());
		assertEquals(-0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);

		p = "1-1i";

		result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals(-0.78540, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_3() throws Exception {
		String p = "-1 + 1i";

		Complex result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals(p, result.toString());
		assertEquals(2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);

		p = "-1+1i";

		result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(1.0, result.imag(), accuracy);
		assertEquals(2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_4() throws Exception {
		String p = "-1 - 1i";

		Complex result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals(p, result.toString());
		assertEquals(-2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);

		p = "-1-1i";

		result = Complex.parseComplex(p);

		assertNotNull(result);
		assertEquals(-1.0, result.real(), accuracy);
		assertEquals(-1.0, result.imag(), accuracy);
		assertEquals(-2.3562, result.arg(), accuracy);
		assertEquals(1.4142, result.mod(), accuracy);
	}

	/**
	 * Run the Complex plus(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testPlus_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.plus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(2.0, result.imag(), accuracy);
		assertEquals("2 + 2i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), accuracy);
		assertEquals(2.8284271247461903, result.mod(), accuracy);
	}

	/**
	 * Run the Complex plus(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlus_2() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, -1.0);

		Complex result = fixture.plus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("2", result.toString());
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex plus(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlus_3() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, 1.0);

		Complex result = fixture.plus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(2.0, result.imag(), accuracy);
		assertEquals("2i", result.toString());
		assertEquals(1.5708, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex plus(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlus_4() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(-1.0, -1.0);

		Complex result = fixture.plus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("0", result.toString());
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(0.0, result.mod(), accuracy);
	}

	/**
	 * Run the double real() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testReal_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.real();

		// add additional test code here
		assertEquals(1.0, result, accuracy);
	}

	/**
	 * Run the double real() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReal_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		double result = fixture.real();

		// add additional test code here
		assertEquals(1.0, result, accuracy);
	}

	/**
	 * Run the double real() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReal_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		double result = fixture.real();

		// add additional test code here
		assertEquals(-1.0, result, accuracy);
	}

	/**
	 * Run the double real() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReal_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		double result = fixture.real();

		// add additional test code here
		assertEquals(-1.0, result, accuracy);
	}

	/**
	 * Run the Complex sin() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testSin_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.sin();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.29846, result.real(), accuracy);
		assertEquals(0.63496, result.imag(), accuracy);
		assertEquals("1.2985 + 0.635i", result.toString());
		assertEquals(0.45482, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sin() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSin_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.sin();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.29846, result.real(), accuracy);
		assertEquals(-0.63496, result.imag(), accuracy);
		assertEquals("1.2985 - 0.635i", result.toString());
		assertEquals(-0.45482, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sin() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSin_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.sin();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.29846, result.real(), accuracy);
		assertEquals(0.63496, result.imag(), accuracy);
		assertEquals("-1.2985 + 0.635i", result.toString());
		assertEquals(2.6868, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sin() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSin_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.sin();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.29846, result.real(), accuracy);
		assertEquals(-0.63496, result.imag(), accuracy);
		assertEquals("-1.2985 - 0.635i", result.toString());
		assertEquals(-2.6868, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sinh() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testSinh_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.sinh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.63496, result.real(), accuracy);
		assertEquals(1.29846, result.imag(), accuracy);
		assertEquals("0.635 + 1.2985i", result.toString());
		assertEquals(1.1160, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sinh() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSinh_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.sinh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.63496, result.real(), accuracy);
		assertEquals(-1.29846, result.imag(), accuracy);
		assertEquals("0.635 - 1.2985i", result.toString());
		assertEquals(-1.1160, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sinh() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSinh_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.sinh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-0.63496, result.real(), accuracy);
		assertEquals(1.29846, result.imag(), accuracy);
		assertEquals("-0.635 + 1.2985i", result.toString());
		assertEquals(2.0256, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex sinh() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSinh_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.sinh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-0.63496, result.real(), accuracy);
		assertEquals(-1.29846, result.imag(), accuracy);
		assertEquals("-0.635 - 1.2985i", result.toString());
		assertEquals(-2.0256, result.arg(), accuracy);
		assertEquals(1.4454, result.mod(), accuracy);
	}

	/**
	 * Run the Complex tan() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testTan_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.tan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.2718, result.real(), accuracy);
		assertEquals(1.0839, result.imag(), accuracy);
		assertEquals("0.2718 + 1.0839i", result.toString());
		assertEquals(1.3251, result.arg(), accuracy);
		assertEquals(1.1175, result.mod(), accuracy);
	}

	/**
	 * Run the Complex tan() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTan_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);

		Complex result = fixture.tan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.2718, result.real(), accuracy);
		assertEquals(-1.0839, result.imag(), accuracy);
		assertEquals("0.2718 - 1.0839i", result.toString());
		assertEquals(-1.3251, result.arg(), accuracy);
		assertEquals(1.1175, result.mod(), accuracy);
	}

	/**
	 * Run the Complex tan() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTan_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);

		Complex result = fixture.tan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-0.2718, result.real(), accuracy);
		assertEquals(1.0839, result.imag(), accuracy);
		assertEquals("-0.2718 + 1.0839i", result.toString());
		assertEquals(1.8164, result.arg(), accuracy);
		assertEquals(1.1175, result.mod(), accuracy);
	}

	/**
	 * Run the Complex tan() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTan_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);

		Complex result = fixture.tan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-0.2718, result.real(), accuracy);
		assertEquals(-1.0839, result.imag(), accuracy);
		assertEquals("-0.2718 - 1.0839i", result.toString());
		assertEquals(-1.8164, result.arg(), accuracy);
		assertEquals(1.1175, result.mod(), accuracy);
	}

	/**
	 * Run the Complex times(Complex) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testTimes_1() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.times(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(2.0, result.imag(), accuracy);
		assertEquals("2i", result.toString());
		assertEquals(1.5707963267948966, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex times(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTimes_2() throws Exception {
		Complex fixture = new Complex(1.0, -1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.times(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("2", result.toString());
		assertEquals(0.0, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex times(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTimes_3() throws Exception {
		Complex fixture = new Complex(-1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.times(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-2.0, result.real(), accuracy);
		assertEquals(0.0, result.imag(), accuracy);
		assertEquals("-2", result.toString());
		assertEquals(3.1416, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the Complex times(Complex) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTimes_4() throws Exception {
		Complex fixture = new Complex(-1.0, -1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.times(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), accuracy);
		assertEquals(-2.0, result.imag(), accuracy);
		assertEquals("-2i", result.toString());
		assertEquals(-1.5708, result.arg(), accuracy);
		assertEquals(2.0, result.mod(), accuracy);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testToString() throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("1 + 1i", result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_2() throws Exception {
		Complex fixture = new Complex(0.1235, 0.5861);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("0.1235 + 0.5861i", result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_3() throws Exception {
		Complex fixture = new Complex(-0.1235, 0.5861);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("-0.1235 + 0.5861i", result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_4() throws Exception {
		Complex fixture = new Complex(0.1235, -0.5861);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("0.1235 - 0.5861i", result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_5() throws Exception {
		Complex fixture = new Complex(-0.1235, -0.5861);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("-0.1235 - 0.5861i", result);
	}
}