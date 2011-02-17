/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Core.Problem.testcase;
import Core.Problem.testset;
import GUI.StateVisualiser.columnchartvisualiser;

/**
 * @author Sam Ratcliff
 * 
 */
public class stateVisualiserTab extends JPanel implements ListSelectionListener {
	private final JList				startStateSelector;
	private columnchartvisualiser	stateVisualiser;
	private final DefaultListModel	model;
	private final testset			tset;
	public static int				selectorWidth;
	private final JLabel			tc_label	= new JLabel("Starting State");

	/**
	 * @param ts
	 */
	public stateVisualiserTab(testset ts) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		selectorWidth = (int) (screenSize.width * 0.1);

		model = new DefaultListModel();
		tset = ts;

		Iterator<testcase> iter = tset.getTestcases();
		testcase tc;
		while (iter.hasNext()) {
			tc = iter.next();
			model.add(tc.getId(), tc.getLabel());
		}
		startStateSelector = new JList(model);

		startStateSelector.setVisibleRowCount(-1);
		startStateSelector
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		startStateSelector.setSelectedIndex(0);
		iter = tset.getTestcases();
		if (iter.hasNext()) {
			tc = iter.next();
			stateVisualiser = new columnchartvisualiser(tc.getFinalstate(), tc
					.getLabel().length());
			valueChanged(null);
			startStateSelector.addListSelectionListener(this);
		} else {
			throw new IllegalArgumentException(
					"Test set for tab does not contain any test cases");
		}

		JScrollPane listScroller = new JScrollPane(startStateSelector);
		listScroller.setPreferredSize(new Dimension(selectorWidth,
				columnchartvisualiser.chartHeight));

		JPanel left_panel = new JPanel();
		left_panel.setLayout(new BoxLayout(left_panel, BoxLayout.PAGE_AXIS));
		left_panel.add(tc_label);
		left_panel.add(listScroller);

		this.add(left_panel, BorderLayout.LINE_START);

		this.add(stateVisualiser, BorderLayout.CENTER);

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int index;
		index = startStateSelector.getSelectedIndex();
		Iterator<testcase> iter = tset.getTestcases();
		testcase tc = null;
		while ((tc == null) && iter.hasNext()) {
			testcase temp = iter.next();
			if (temp.getId() == index) {
				tc = temp;
			}

		}
		stateVisualiser.updateState(tc.getFinalstate(), tc.getLabel().length());
	}
}
