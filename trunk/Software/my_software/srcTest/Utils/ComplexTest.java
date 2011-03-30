package Utils;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ComplexTest</code> contains tests for the class <code>{@link Complex}</code>.
 *
 * @generatedBy CodePro at 29/03/11 16:07
 * @author sam
 * @version $Revision: 1.0 $
 */
public class ComplexTest {
	/**
	 * Run the Complex(double,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testComplex_1()
		throws Exception {
		double u = 1.0;
		double v = 1.0;

		Complex result = new Complex(u, v);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), 1.0);
		assertEquals(1.0, result.imag(), 1.0);
		assertEquals("1.0 + 1.0i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), 1.0);
		assertEquals(1.4142135623730951, result.mod(), 1.0);
	}

	/**
	 * Run the double arg() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testArg_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.arg();

		// add additional test code here
		assertEquals(0.7853981633974483, result, 0.1);
	}

	/**
	 * Run the Complex chs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testChs_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.chs();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1.0, result.real(), 1.0);
		assertEquals(-1.0, result.imag(), 1.0);
		assertEquals("-1.0 - 1.0i", result.toString());
		assertEquals(-2.356194490192345, result.arg(), 1.0);
		assertEquals(1.4142135623730951, result.mod(), 1.0);
	}

	/**
	 * Run the Complex conj() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testConj_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.conj();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), 1.0);
		assertEquals(-1.0, result.imag(), 1.0);
		assertEquals("1.0 - 1.0i", result.toString());
		assertEquals(-0.7853981633974483, result.arg(), 1.0);
		assertEquals(1.4142135623730951, result.mod(), 1.0);
	}

	/**
	 * Run the Complex copy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testCopy_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.copy();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.real(), 1.0);
		assertEquals(1.0, result.imag(), 1.0);
		assertEquals("1.0 + 1.0i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), 1.0);
		assertEquals(1.4142135623730951, result.mod(), 1.0);
	}

	/**
	 * Run the Complex cos() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testCos_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.cos();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.8337300251311492, result.real(), 1.0);
		assertEquals(-0.9888977057628652, result.imag(), 1.0);
		assertEquals("0.8337300251311492 - 0.9888977057628652i", result.toString());
		assertEquals(-0.8703274249911193, result.arg(), 1.0);
		assertEquals(1.2934544550420959, result.mod(), 1.0);
	}

	/**
	 * Run the Complex cosh() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testCosh_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.cosh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.8337300251311492, result.real(), 1.0);
		assertEquals(0.9888977057628652, result.imag(), 1.0);
		assertEquals("0.8337300251311492 + 0.9888977057628652i", result.toString());
		assertEquals(0.8703274249911193, result.arg(), 1.0);
		assertEquals(1.2934544550420959, result.mod(), 1.0);
	}

	/**
	 * Run the Complex div(Complex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testDiv_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.div(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.9999999999999998, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0.9999999999999998", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.9999999999999998, result.mod(), 1.0);
	}

	/**
	 * Run the boolean equal(Complex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEqual_1()
		throws Exception {
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
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEqual_2()
		throws Exception {
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
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEqual_3()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		boolean result = fixture.equal(w);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the Complex euclid(Complex,Complex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testEuclid_1()
		throws Exception {
		Complex a = new Complex(1.0, 1.0);
		Complex b = new Complex(1.0, 1.0);

		Complex result = Complex.euclid(a, b);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.4142135623730951, result.real(), 1.0);
		assertEquals(1.4142135623730951, result.imag(), 1.0);
		assertEquals("1.4142135623730951 + 1.4142135623730951i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), 1.0);
		assertEquals(2.0, result.mod(), 1.0);
	}

	/**
	 * Run the Complex exp() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testExp_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.exp();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.4686939399158854, result.real(), 1.0);
		assertEquals(2.2873552871788427, result.imag(), 1.0);
		assertEquals("1.4686939399158854 + 2.2873552871788427i", result.toString());
		assertEquals(1.0, result.arg(), 1.0);
		assertEquals(2.7182818284590455, result.mod(), 1.0);
	}

	/**
	 * Run the double imag() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testImag_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.imag();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the Complex log() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testLog_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.log();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.3465735902799727, result.real(), 1.0);
		assertEquals(0.7853981633974483, result.imag(), 1.0);
		assertEquals("0.3465735902799727 + 0.7853981633974483i", result.toString());
		assertEquals(1.1552249377896453, result.arg(), 1.0);
		assertEquals(0.8584657992882624, result.mod(), 1.0);
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {};

		Complex.main(args);

		// add additional test code here
	}

	/**
	 * Run the Complex minus(Complex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMinus_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.minus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(0.0, result.imag(), 1.0);
		assertEquals("0.0", result.toString());
		assertEquals(0.0, result.arg(), 1.0);
		assertEquals(0.0, result.mod(), 1.0);
	}

	/**
	 * Run the double mod() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMod_1()
		throws Exception {
		Complex fixture = new Complex(0, 0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double mod() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMod_2()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(1.4142135623730951, result, 0.1);
	}

	/**
	 * Run the double mod() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testMod_3()
		throws Exception {
		Complex fixture = new Complex(0, 1.0);

		double result = fixture.mod();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_1()
		throws Exception {
		String p = "";

		Complex result = Complex.parseComplex(p);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		//       at java.lang.String.charAt(String.java:686)
		//       at Utils.Complex.parseComplex(Complex.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_2()
		throws Exception {
		String p = "";

		Complex result = Complex.parseComplex(p);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		//       at java.lang.String.charAt(String.java:686)
		//       at Utils.Complex.parseComplex(Complex.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_3()
		throws Exception {
		String p = "";

		Complex result = Complex.parseComplex(p);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		//       at java.lang.String.charAt(String.java:686)
		//       at Utils.Complex.parseComplex(Complex.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Complex parseComplex(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testParseComplex_4()
		throws Exception {
		String p = "";

		Complex result = Complex.parseComplex(p);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		//       at java.lang.String.charAt(String.java:686)
		//       at Utils.Complex.parseComplex(Complex.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Complex plus(Complex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testPlus_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.plus(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(2.0, result.real(), 1.0);
		assertEquals(2.0, result.imag(), 1.0);
		assertEquals("2.0 + 2.0i", result.toString());
		assertEquals(0.7853981633974483, result.arg(), 1.0);
		assertEquals(2.8284271247461903, result.mod(), 1.0);
	}

	/**
	 * Run the double real() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testReal_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		double result = fixture.real();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the Complex sin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testSin_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.sin();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.2984575814159773, result.real(), 1.0);
		assertEquals(0.6349639147847362, result.imag(), 1.0);
		assertEquals("1.2984575814159773 + 0.6349639147847362i", result.toString());
		assertEquals(0.45482023330995, result.arg(), 1.0);
		assertEquals(1.4453965766582495, result.mod(), 1.0);
	}

	/**
	 * Run the Complex sinh() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testSinh_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.sinh();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.6349639147847362, result.real(), 1.0);
		assertEquals(1.2984575814159773, result.imag(), 1.0);
		assertEquals("0.6349639147847362 + 1.2984575814159773i", result.toString());
		assertEquals(1.1159760934849465, result.arg(), 1.0);
		assertEquals(1.4453965766582495, result.mod(), 1.0);
	}

	/**
	 * Run the Complex sqrt() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testSqrt_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.sqrt();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0986841134678098, result.real(), 1.0);
		assertEquals(0.45508986056222733, result.imag(), 1.0);
		assertEquals("1.0986841134678098 + 0.45508986056222733i", result.toString());
		assertEquals(0.3926990816987242, result.arg(), 1.0);
		assertEquals(1.189207115002721, result.mod(), 1.0);
	}

	/**
	 * Run the Complex tan() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testTan_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		Complex result = fixture.tan();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.2717525853195117, result.real(), 1.0);
		assertEquals(1.0839233273386943, result.imag(), 1.0);
		assertEquals("0.2717525853195117 + 1.0839233273386943i", result.toString());
		assertEquals(1.325147658301069, result.arg(), 1.0);
		assertEquals(1.1174700207060702, result.mod(), 1.0);
	}

	/**
	 * Run the Complex times(Complex) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testTimes_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);
		Complex w = new Complex(1.0, 1.0);

		Complex result = fixture.times(w);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.real(), 1.0);
		assertEquals(2.0, result.imag(), 1.0);
		assertEquals("2.0i", result.toString());
		assertEquals(1.5707963267948966, result.arg(), 1.0);
		assertEquals(2.0, result.mod(), 1.0);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Complex fixture = new Complex(1.0, 1.0);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("1.0 + 1.0i", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testToString_2()
		throws Exception {
		Complex fixture = new Complex(1.0, -4.9E-324);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("1.0 - 4.9E-324i", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	@Test
	public void testToString_3()
		throws Exception {
		Complex fixture = new Complex(0, Double.POSITIVE_INFINITY);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Infinityi", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 29/03/11 16:07
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
	 * @generatedBy CodePro at 29/03/11 16:07
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
	 * @generatedBy CodePro at 29/03/11 16:07
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ComplexTest.class);
	}
}