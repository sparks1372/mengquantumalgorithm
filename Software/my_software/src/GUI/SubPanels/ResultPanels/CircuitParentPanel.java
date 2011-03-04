/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels.ResultPanels;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import Core.Circuit.Circuit;
import GUI.SubPanels.ResultPanels.Util.CircuitPanel;

/**
 * @author Sam Ratcliff
 * 
 */
public class CircuitParentPanel extends JScrollPane {
	private static final String	nameStr	= "Circuit";
	private CircuitPanel		cPanel;

	/**
	 * 
	 */
	public CircuitParentPanel() {

		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setPreferredSize(new Dimension(250, 155));
		setMinimumSize(new Dimension(10, 10));

	}

	public int circuitNextPosition() {
		return cPanel.nextPosition();
	}

	public int circuitPreviousPosition() {
		return cPanel.prevPosition();
	}

	@Override
	public String getName() {
		return nameStr;
	}

	/**
	 * @param circuit
	 * @param num
	 */
	public void update(Circuit circuit, int num) {
		cPanel = new CircuitPanel(circuit, num);
		setViewportView(cPanel);
	}

}
