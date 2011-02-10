package Core.Implementation;

import Core.quantumproblem;
import Core.testsuite;

public class simpleqcproblem implements quantumproblem {

	private final String	name;
	private testsuite		ts;

	public simpleqcproblem(String n) {
		name = n;
		ts = new testsuite();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public testsuite getTestSuite() {
		return ts;
	}

	@Override
	public void setTestSuite(testsuite ints) {
		ts = ints;
	}

}
