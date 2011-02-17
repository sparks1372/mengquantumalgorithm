/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Core.qcevolutionbackend;

/**
 * @author Sam Ratcliff
 * 
 */
public class LPanel extends JPanel {
	private final qcevolutionbackend			backend;
	private final SearchEngineSelectionPanel	se_select_panel;
	private final FitnessFunctionSelectionPanel	ff_select_panel;

	/**
	 * 
	 */
	public LPanel(qcevolutionbackend be) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		backend = be;

		se_select_panel = new SearchEngineSelectionPanel(be);
		ff_select_panel = new FitnessFunctionSelectionPanel(be);

		this.add(se_select_panel);
		this.add(ff_select_panel);
	}
}
