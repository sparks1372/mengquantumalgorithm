package Core.CircuitEvolution.GateImplementations;

import Core.Circuit.quantumgate;
import Jama.Matrix;
import Utils.Complex;

public class Zero_Gate implements quantumgate {
	private static final String	labelStr	= "Zero";
	private final int			targ;
	private final Matrix		unitary;

	/**
		 */
	public Zero_Gate(int target) {
		// System.out.println(this.getClass().getName());
		this.targ = Math.abs(target);
		Complex[][] zero = new Complex[2][2];
		zero[0][0] = new Complex(1, 0);
		zero[0][1] = new Complex(1, 0);
		zero[1][0] = new Complex(0, 0);
		zero[1][1] = new Complex(0, 0);

		unitary = new Matrix(zero);
	}

	@Override
	public Matrix apply(Matrix start_state) {
		start_state = start_state.times(new Complex(0, 0));
		start_state.set(0, 0, new Complex(1, 0));
		return start_state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.Circuit.quantumgate#getlabel()
	 */
	@Override
	public String getlabel() {
		return labelStr;
	}

	@Override
	public int getTarget() {
		return targ;
	}

	@Override
	public Matrix getUnitary_operation() {
		return unitary;
	}

	@Override
	public String toLatex() {
		return "\\gate{zero}&";
	}

}
