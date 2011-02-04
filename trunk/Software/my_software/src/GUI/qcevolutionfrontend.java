package GUI;

import javax.swing.JFrame;

import Core.qcevolutionbackend;
import GUI.CircuitVisualiser.circuitvisualiser;
import GUI.ProblemEditor.problemeditor;

/**
 * @uml.dependency supplier="Core.qcevolutionbackend"
 */
public class qcevolutionfrontend extends JFrame {

	/**
	 * @uml.property name="backend"
	 */
	private qcevolutionbackend backend = new Core.qcevolutionbackend();

	/**
	 * Getter of the property <tt>backend</tt>
	 * 
	 * @return Returns the backend.
	 * @uml.property name="backend"
	 */
	public qcevolutionbackend getBackend() {
		return backend;
	}

	/**
	 * Setter of the property <tt>backend</tt>
	 * 
	 * @param backend
	 *            The backend to set.
	 * @uml.property name="backend"
	 */
	public void setBackend(qcevolutionbackend backend) {
		this.backend = backend;
	}

	/** 
	 * @uml.property name="cvisualiser" readOnly="true"
	 */
	private circuitvisualiser cvisualiser;

	/** 
	 * Getter of the property <tt>cvisualiser</tt>
	 * @return Returns the cvisualiser.
	 * @uml.property name="cvisualiser"
	 */
	public circuitvisualiser getCvisualiser() {
		return cvisualiser;
	}

	/** 
	 * @uml.property name="peditor" readOnly="true"
	 */
	private problemeditor peditor;

	/** 
	 * Getter of the property <tt>peditor</tt>
	 * @return  Returns the peditor.
	 * @uml.property  name="peditor"
	 */
	public problemeditor getPeditor() {
		return peditor;
	}

}
