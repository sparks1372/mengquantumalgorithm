package Core.Algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Core.Algorithms.Implementation.ExpArith.add;
import Core.Algorithms.Implementation.ExpArith.div;
import Core.Algorithms.Implementation.ExpArith.loopvar;
import Core.Algorithms.Implementation.ExpArith.mul;
import Core.Algorithms.Implementation.ExpArith.pidiv;
import Core.Algorithms.Implementation.ExpArith.pow;
import Core.Algorithms.Implementation.ExpArith.sub;
import Core.Algorithms.ImplementationExpTerm.syssize;
import Core.Algorithms.ImplementationExpTerm.val;

/**
 * The class <code>exp_nodeTest</code> contains tests for the class
 * <code>{@link exp_node}</code>.
 * 
 * @generatedBy CodePro at 06/05/11 19:52
 * @author sam
 * @version $Revision: 1.0 $
 */
public class exp_nodeTest {

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 06/05/11 19:52
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(exp_nodeTest.class);
	}

	private final double	accuracy	= 0.001;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 06/05/11 19:52
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
	 * @generatedBy CodePro at 06/05/11 19:52
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Perform test
	 * 
	 * 2+SystemSize SystemSize=0
	 */
	@Test
	public void test_add1() {
		exp_node e = new add(new val(2), new syssize());

		assertEquals(2, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+SystemSize SystemSize=1
	 */
	@Test
	public void test_add2() {
		exp_node e = new add(new val(2), new syssize());

		assertEquals(3, e.evaluate(1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+SystemSize SystemSize=15
	 */
	@Test
	public void test_add3() {
		exp_node e = new add(new val(2), new syssize());

		assertEquals(17, e.evaluate(15, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={} SystemSize=0
	 */
	@Test
	public void test_combo11() {
		int[] lv = new int[0];
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo12() {
		int[] lv = { 1 };
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(3, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo13() {
		int[] lv = { 1, 2 };
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(3, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={} SystemSize=1
	 */
	@Test
	public void test_combo14() {
		int[] lv = new int[0];
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo15() {
		int[] lv = { 1 };
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(3, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo16() {
		int[] lv = { 1, 2 };
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(4, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={} SystemSize=2
	 */
	@Test
	public void test_combo17() {
		int[] lv = new int[0];
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo18() {
		int[] lv = { 1 };
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(3, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2+LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo19() {
		int[] lv = { 1, 2 };
		exp_node e = new add(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(3, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={} SystemSize=0
	 */
	@Test
	public void test_combo21() {
		int[] lv = new int[0];
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo22() {
		int[] lv = { 1 };
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo23() {
		int[] lv = { 1, 2 };
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={} SystemSize=1
	 */
	@Test
	public void test_combo24() {
		int[] lv = new int[0];
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo25() {
		int[] lv = { 1 };
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(1, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo26() {
		int[] lv = { 1, 2 };
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={} SystemSize=2
	 */
	@Test
	public void test_combo27() {
		int[] lv = new int[0];
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo28() {
		int[] lv = { 1 };
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(1, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo29() {
		int[] lv = { 1, 2 };
		exp_node e = new sub(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(1, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={} SystemSize=0
	 */
	@Test
	public void test_combo31() {
		int[] lv = new int[0];
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo32() {
		int[] lv = { 1 };
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo33() {
		int[] lv = { 1, 2 };
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={} SystemSize=1
	 */
	@Test
	public void test_combo34() {
		int[] lv = new int[0];
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo35() {
		int[] lv = { 1 };
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo36() {
		int[] lv = { 1, 2 };
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(4, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={} SystemSize=2
	 */
	@Test
	public void test_combo37() {
		int[] lv = new int[0];
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo38() {
		int[] lv = { 1 };
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo39() {
		int[] lv = { 1, 2 };
		exp_node e = new mul(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={} SystemSize=0
	 */
	@Test
	public void test_combo41() {
		int[] lv = new int[0];
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo42() {
		int[] lv = { 1 };
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={1} SystemSize=0
	 */
	@Test
	public void test_combo43() {
		int[] lv = { 1, 2 };
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={} SystemSize=1
	 */
	@Test
	public void test_combo44() {
		int[] lv = new int[0];
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo45() {
		int[] lv = { 1 };
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={1} SystemSize=1
	 */
	@Test
	public void test_combo46() {
		int[] lv = { 1, 2 };
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(1, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={} SystemSize=2
	 */
	@Test
	public void test_combo47() {
		int[] lv = new int[0];
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(0, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo48() {
		int[] lv = { 1 };
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/LoopVars[SystemSize] LoopVars={1} SystemSize=2
	 */
	@Test
	public void test_combo49() {
		int[] lv = { 1, 2 };
		exp_node e = new div(new val(2), new loopvar(new add(new val(2),
				new syssize())));

		assertEquals(2, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 0
	 */
	@Test
	public void test_const1() {
		exp_node e = new val(0);

		assertEquals(0, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2
	 */
	@Test
	public void test_const2() {
		exp_node e = new val(2);

		assertEquals(2, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * -2
	 */
	@Test
	public void test_const3() {
		exp_node e = new val(-2);

		assertEquals(-2, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/SystemSize SystemSize=0
	 */
	@Test
	public void test_div1() {
		exp_node e = new div(new val(2), new syssize());

		assertEquals(0, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/SystemSize SystemSize=1
	 */
	@Test
	public void test_div2() {
		exp_node e = new div(new val(2), new syssize());

		assertEquals(2, e.evaluate(1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2/SystemSize SystemSize=1
	 */
	@Test
	public void test_div3() {
		exp_node e = new div(new val(2), new syssize());

		assertEquals(1, e.evaluate(2, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[0] LoopVars={}
	 */
	@Test
	public void test_loop11() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new val(0));

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[0] LoopVars={1}
	 */
	@Test
	public void test_loop12() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new val(0));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[0] LoopVars={1}
	 */
	@Test
	public void test_loop13() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new val(0));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[1] LoopVars={}
	 */
	@Test
	public void test_loop21() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new val(1));

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[1] LoopVars={1}
	 */
	@Test
	public void test_loop22() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new val(1));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[1] LoopVars={1}
	 */
	@Test
	public void test_loop23() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new val(1));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[-1] LoopVars={}
	 */
	@Test
	public void test_loop31() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new val(-1));

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[-1] LoopVars={1}
	 */
	@Test
	public void test_loop32() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new val(-1));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[-1] LoopVars={1}
	 */
	@Test
	public void test_loop33() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new val(-1));

		assertEquals(2, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={}
	 */
	@Test
	public void test_loop41() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new syssize());

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop42() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new syssize());

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop43() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new syssize());

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={}
	 */
	@Test
	public void test_loop44() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new syssize());

		assertEquals(0, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop45() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new syssize());

		assertEquals(1, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop46() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new syssize());

		assertEquals(2, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={}
	 */
	@Test
	public void test_loop47() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new syssize());

		assertEquals(0, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop48() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new syssize());

		assertEquals(1, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop49() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new syssize());

		assertEquals(1, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={}
	 */
	@Test
	public void test_loop51() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(0, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop52() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop53() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(1, e.evaluate(0, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={}
	 */
	@Test
	public void test_loop54() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(0, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop55() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(1, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop56() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(2, e.evaluate(1, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={}
	 */
	@Test
	public void test_loop57() {
		int[] lv = new int[0];
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(0, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop58() {
		int[] lv = { 1 };
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(1, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * LoopVars[SystemSize] LoopVars={1}
	 */
	@Test
	public void test_loop59() {
		int[] lv = { 1, 2 };
		exp_node e = new loopvar(new add(new val(2), new syssize()));

		assertEquals(1, e.evaluate(2, lv), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*SystemSize SystemSize=0
	 */
	@Test
	public void test_mul1() {
		exp_node e = new mul(new val(2), new syssize());

		assertEquals(0, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*SystemSize SystemSize=1
	 */
	@Test
	public void test_mul2() {
		exp_node e = new mul(new val(2), new syssize());

		assertEquals(2, e.evaluate(1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*SystemSize SystemSize=-1
	 */
	@Test
	public void test_mul3() {
		exp_node e = new mul(new val(2), new syssize());

		assertEquals(-2, e.evaluate(-1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2*SystemSize SystemSize=1
	 */
	@Test
	public void test_mul4() {
		exp_node e = new mul(new val(2), new syssize());

		assertEquals(4, e.evaluate(2, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * \pi/(2^SystemSize) SystemSize=1
	 */
	@Test
	public void test_pidiv1() {
		exp_node e = new pidiv(new syssize());

		assertEquals(Math.PI / 2, e.evaluate(1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * \pi/(2^SystemSize) SystemSize=2
	 */
	@Test
	public void test_pidiv2() {
		exp_node e = new pidiv(new syssize());

		assertEquals(Math.PI / 4, e.evaluate(2, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * \pi/(2^SystemSize) SystemSize=0
	 */
	@Test
	public void test_pidiv3() {
		exp_node e = new pidiv(new syssize());

		assertEquals(Math.PI, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2^SystemSize SystemSize=1
	 */
	@Test
	public void test_pow1() {
		exp_node e = new pow(new val(2), new syssize());

		assertEquals(2, e.evaluate(1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2^SystemSize SystemSize=2
	 */
	@Test
	public void test_pow2() {
		exp_node e = new pow(new val(2), new syssize());

		assertEquals(4, e.evaluate(2, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2^SystemSize SystemSize=0
	 */
	@Test
	public void test_pow3() {
		exp_node e = new pow(new val(2), new syssize());

		assertEquals(1, e.evaluate(0, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-SystemSize SystemSize=1
	 */
	@Test
	public void test_sub1() {
		exp_node e = new sub(new val(2), new syssize());

		assertEquals(1, e.evaluate(1, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-SystemSize SystemSize=2
	 */
	@Test
	public void test_sub2() {
		exp_node e = new sub(new val(2), new syssize());

		assertEquals(0, e.evaluate(2, null), accuracy);
	}

	/**
	 * Perform test
	 * 
	 * 2-SystemSize SystemSize=0
	 */
	@Test
	public void test_sub3() {
		exp_node e = new sub(new val(2), new syssize());

		assertEquals(2, e.evaluate(0, null), accuracy);
	}
}