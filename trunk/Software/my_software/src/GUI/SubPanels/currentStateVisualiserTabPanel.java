/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.Component;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Core.Problem.testsuite;

/**
 * @author Sam Ratcliff
 * 
 */
public class currentStateVisualiserTabPanel extends JPanel {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2646703096590848391L;
	private static String		qubits_string		= " Qubit(s)";
	private final JTabbedPane	tabPane;

	/**
	 * 
	 */
	public currentStateVisualiserTabPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		tabPane = new JTabbedPane();
		tabPane.setVisible(false);

		this.add(tabPane);
	}

	public void setTestSuite(testsuite ts) {

		this.remove(tabPane);
		this.validate();
		tabPane.removeAll();
		testsuite results = ts.copy();

		Set<Integer> keys = results.getKeys();

		Iterator<Integer> iter = keys.iterator();

		Component tab;
		while (iter.hasNext()) {
			int numofqubits = iter.next();
			tab = new currectStateVisualiserTab(
					results.getTestcases(numofqubits), "");
			tabPane.add(Integer.toString(numofqubits).concat(qubits_string),
					tab);
		}
		if (tabPane.getTabCount() > 0) {
			tabPane.setVisible(true);
		} else {
			tabPane.setVisible(false);
		}
		this.add(tabPane);
		this.validate();
	}
}
