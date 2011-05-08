package Core.Algorithms.Implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstruction;
import Core.Algorithms.QuantumInstructionEnum;
import Core.Algorithms.exp_node;
import Core.Algorithms.Implementation.ExpArith.add;
import Core.Algorithms.Implementation.ExpArith.loopvar;
import Core.Algorithms.Implementation.ExpArith.sub;
import Core.Algorithms.ImplementationExpTerm.syssize;
import Core.Algorithms.ImplementationExpTerm.val;

/**
 * The class <code>basicquantumalgorithmTest</code> contains tests for the class
 * <code>{@link basicquantumalgorithm}</code>.
 * 
 * @generatedBy CodePro at 06/05/11 21:54
 * @author sam
 * @version $Revision: 1.0 $
 */
public class basicquantumalgorithmTest {
	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(basicquantumalgorithmTest.class);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
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
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the void
	 * addInstruction(QuantumInstructionEnum,exp_node,exp_node,exp_node
	 * ,QuantumAlgorithm[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testAddInstruction_1() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();
		QuantumInstructionEnum inst = QuantumInstructionEnum.Body;
		exp_node gate1 = null;
		exp_node gate2 = new syssize();
		exp_node phase = new syssize();
		QuantumAlgorithm[] subalg = new QuantumAlgorithm[] {};

		try {
			fixture.addInstruction(inst, gate1, gate2, phase, subalg);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);

		}

	}

	/**
	 * Run the void
	 * addInstruction(QuantumInstructionEnum,exp_node,exp_node,exp_node
	 * ,QuantumAlgorithm[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testAddInstruction_2() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		try {
			fixture.addInstruction(QuantumInstructionEnum.Body, new loopvar(
					new val(0)), new val(2), new syssize(),
					new QuantumAlgorithm[] {});
			fixture.addInstruction(QuantumInstructionEnum.Create_CH,
					new loopvar(new val(0)), new add(new val(3), new val(2)),
					new syssize(), new QuantumAlgorithm[] {});
			fixture.addInstruction(QuantumInstructionEnum.Create_CRZ,
					new val(2), new loopvar(new val(0)), new syssize(),
					new QuantumAlgorithm[] {});
			fixture.addInstruction(QuantumInstructionEnum.Create_H,
					new loopvar(new val(0)), new val(2), new sub(new val(3),
							new val(2)), new QuantumAlgorithm[] {});
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	/**
	 * Run the void
	 * addInstruction(QuantumInstructionEnum,exp_node,exp_node,exp_node
	 * ,QuantumAlgorithm[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testAddInstruction_3() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();
		QuantumInstructionEnum inst = QuantumInstructionEnum.Body;
		exp_node gate1 = null;
		exp_node gate2 = new syssize();
		exp_node phase = new syssize();
		QuantumAlgorithm[] subalg = new QuantumAlgorithm[] {};

		fixture.addInstruction(inst, gate1, gate2, phase, subalg);
		int size = fixture.getSize();
		assertEquals(1, size);

	}

	/**
	 * Run the void
	 * addInstruction(QuantumInstructionEnum,exp_node,exp_node,exp_node
	 * ,QuantumAlgorithm[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testAddInstruction_4() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		fixture.addInstruction(QuantumInstructionEnum.Body, new loopvar(
				new val(0)), new val(2), new syssize(),
				new QuantumAlgorithm[] {});
		fixture.addInstruction(QuantumInstructionEnum.Create_CH, new loopvar(
				new val(0)), new add(new val(3), new val(2)), new syssize(),
				new QuantumAlgorithm[] {});
		fixture.addInstruction(QuantumInstructionEnum.Create_CRZ, new val(2),
				new loopvar(new val(0)), new syssize(),
				new QuantumAlgorithm[] {});
		fixture.addInstruction(QuantumInstructionEnum.Create_H, new loopvar(
				new val(0)), new val(2), new sub(new val(3), new val(2)),
				new QuantumAlgorithm[] {});
		int size = fixture.getSize();
		assertEquals(4, size);

	}

	/**
	 * Run the void
	 * addInstruction(QuantumInstructionEnum,exp_node,exp_node,exp_node
	 * ,QuantumAlgorithm[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testAddInstruction_5() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();
		QuantumInstructionEnum inst = QuantumInstructionEnum.Body;
		exp_node gate1 = null;
		exp_node gate2 = new syssize();
		exp_node phase = new syssize();
		QuantumAlgorithm[] subalg = new QuantumAlgorithm[] {};

		fixture.addInstruction(inst, gate1, gate2, phase, subalg);
		ListIterator<QuantumInstruction> iter = fixture.getInstructions();
		QuantumInstruction instruc = iter.next();
		assertTrue(instruc.getInstruction() == inst);
		assertTrue(instruc.getInteger1() == gate1);
		assertTrue(instruc.getInteger2() == gate2);
		assertTrue(instruc.getDouble1() == phase);
		assertTrue(instruc.getSubalg() == subalg);

	}

	/**
	 * Run the void
	 * addInstruction(QuantumInstructionEnum,exp_node,exp_node,exp_node
	 * ,QuantumAlgorithm[]) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testAddInstruction_6() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();
		QuantumInstructionEnum inst[] = { QuantumInstructionEnum.Body,
				QuantumInstructionEnum.Create_CH,
				QuantumInstructionEnum.Create_CRZ,
				QuantumInstructionEnum.Create_H };
		exp_node gate1[] = { new loopvar(new val(0)), new loopvar(new val(0)),
				new val(2), new loopvar(new val(0)) };
		exp_node gate2[] = { new val(2), new add(new val(3), new val(2)),
				new loopvar(new val(0)), new val(2) };
		exp_node phase[] = { new syssize(), new syssize(), new syssize(),
				new sub(new val(3), new val(2)) };
		QuantumAlgorithm[][] subalg = { new QuantumAlgorithm[] {},
				new QuantumAlgorithm[] {}, new QuantumAlgorithm[] {},
				new QuantumAlgorithm[] {} };

		fixture.addInstruction(inst[0], gate1[0], gate2[0], phase[0], subalg[0]);
		fixture.addInstruction(inst[1], gate1[1], gate2[1], phase[1], subalg[1]);
		fixture.addInstruction(inst[2], gate1[2], gate2[2], phase[2], subalg[2]);
		fixture.addInstruction(inst[3], gate1[3], gate2[3], phase[3], subalg[3]);
		ListIterator<QuantumInstruction> iter = fixture.getInstructions();
		for (int i = 0; i < 4; i++) {
			QuantumInstruction instruc = iter.next();
			assertTrue("" + i + " " + instruc.getInstruction() + " " + inst[i],
					instruc.getInstruction() == inst[i]);
			assertTrue("" + i + " " + instruc.getInteger1() + " " + gate1[i],
					instruc.getInteger1() == gate1[i]);
			assertTrue("" + i + " " + instruc.getInteger2() + " " + gate2[i],
					instruc.getInteger2() == gate2[i]);
			assertTrue("" + i + " " + instruc.getDouble1() + " " + phase[i],
					instruc.getDouble1() == phase[i]);
			assertTrue("" + i + " " + instruc.getSubalg() + " " + subalg[i],
					instruc.getSubalg() == subalg[i]);
		}
	}

	/**
	 * Run the basicquantumalgorithm() constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testBasicquantumalgorithm_1() throws Exception {

		basicquantumalgorithm result = new basicquantumalgorithm();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getValSum());
		assertEquals("", result.print());
		assertEquals(0, result.getSize());
	}

	/**
	 * Run the ListIterator<QuantumInstruction> getInstructions() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testGetInstructions_1() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		ListIterator<QuantumInstruction> result = fixture.getInstructions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.hasNext());
		assertEquals(false, result.hasPrevious());
		assertEquals(0, result.nextIndex());
		assertEquals(-1, result.previousIndex());
	}

	/**
	 * Run the int getSize() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testGetSize_1() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		int result = fixture.getSize();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int getValSum() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testGetValSum_1() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		int result = fixture.getValSum();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_1() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_10() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_2() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_3() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_4() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_5() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_6() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_7() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_8() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String print() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 06/05/11 21:54
	 */
	@Test
	public void testPrint_9() throws Exception {
		basicquantumalgorithm fixture = new basicquantumalgorithm();

		String result = fixture.print();

		// add additional test code here
		assertEquals("", result);
	}
}