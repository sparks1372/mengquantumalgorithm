package Utils;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TemplateJPPFTaskTest</code> contains tests for the class <code>{@link TemplateJPPFTask}</code>.
 *
 * @generatedBy CodePro at 29/03/11 15:29
 * @author sam
 * @version $Revision: 1.0 $
 */
public class TemplateJPPFTaskTest {
	/**
	 * Run the TemplateJPPFTask() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 15:29
	 */
	@Test
	public void testTemplateJPPFTask_1()
		throws Exception {

		TemplateJPPFTask result = new TemplateJPPFTask();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getResult());
		assertEquals(null, result.getDataProvider());
		assertEquals(null, result.getTimeoutDate());
		assertEquals(null, result.getTimeoutDateFormat());
		assertEquals(null, result.getTimeoutFormat());
		assertEquals(null, result.getTaskObject());
		assertEquals(null, result.getTimeoutSchedule());
		assertEquals(null, result.getException());
		assertEquals(null, result.getId());
		assertEquals(0, result.getPosition());
		assertEquals(0L, result.getTimeout());
	}

	/**
	 * Run the void run() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 29/03/11 15:29
	 */
	@Test
	public void testRun_1()
		throws Exception {
		TemplateJPPFTask fixture = new TemplateJPPFTask();

		fixture.run();

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 29/03/11 15:29
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
	 * @generatedBy CodePro at 29/03/11 15:29
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
	 * @generatedBy CodePro at 29/03/11 15:29
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TemplateJPPFTaskTest.class);
	}
}