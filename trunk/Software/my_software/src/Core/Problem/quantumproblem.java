package Core.Problem;

import java.io.Serializable;

public interface quantumproblem extends Serializable {

	/**
	 * @return Returns the name.
	 * @uml.property name="name" readOnly="true"
	 */
	public String getName();

	/**
	 * @return Returns the testset.
	 * @uml.property name="testset"
	 */

	public testsuite getTestSuite();

	/**
	 * @arg the testset.
	 * @uml.property name="testset"
	 */
	public void setTestSuite(testsuite tsin);

}
