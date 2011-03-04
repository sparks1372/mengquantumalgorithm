/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Core.Problem.SuperPositionalTestSet;
import Core.Problem.testcase;
import Core.Problem.testset;
import GUI.StateVisualiser.columnchartvisualiser;

/**
 * @author Sam Ratcliff
 * 
 */
public class stateVisualiserTab extends JPanel implements ListSelectionListener {
	protected final JList			startStateSelector;
	private columnchartvisualiser	startStateVisualiser;
	protected columnchartvisualiser	finalStateVisualiser;
	private JTabbedPane				startFinalTabSelector;
	private final DefaultListModel	model;
	protected final testset			tset;
	public static int				selectorWidth;
	private final JLabel			tc_label;

	/**
	 * @param ts
	 */
	public stateVisualiserTab(testset ts, String title) {
		selectorWidth = (50);

		model = new DefaultListModel();
		tset = ts;

		if (tset instanceof SuperPositionalTestSet) {
			startFinalTabSelector = new JTabbedPane();
			tc_label = new JLabel("Test Case");
		} else {

			tc_label = new JLabel("Starting State");
		}
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
			setUpVisualising(tc, title);
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
		addCorrectPanel();

	}

	protected void addCorrectPanel() {
		if (tset instanceof SuperPositionalTestSet) {
			startFinalTabSelector.add(startStateVisualiser, "Starting State");
			startFinalTabSelector.add(finalStateVisualiser, "Final State");
			this.add(startFinalTabSelector, BorderLayout.CENTER);
		} else {
			this.add(finalStateVisualiser, BorderLayout.CENTER);
		}
	}

	public int getSelectedIndex() {
		return startStateSelector.getSelectedIndex();
	}

	public void setSelectedIndex(int index) {
		startStateSelector.setSelectedIndex(index);
	}

	protected void setUpVisualising(testcase tc, String title) {
		int labelLength = (int) (Math.log(tc.getFinalStateCopy()
				.getRowDimension()) / Math.log(2));
		if (tset instanceof SuperPositionalTestSet) {
			startStateVisualiser = new columnchartvisualiser(
					tc.getStartingStateCopy(), labelLength, title);
		}
		finalStateVisualiser = new columnchartvisualiser(
				tc.getFinalStateCopy(), labelLength, title);
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

		int labelLength = (int) (Math.log(tc.getFinalStateCopy()
				.getRowDimension()) / Math.log(2));
		if (tset instanceof SuperPositionalTestSet) {
			startStateVisualiser.updateState(tc.getStartingStateCopy(),
					labelLength);
		}
		finalStateVisualiser.updateState(tc.getFinalStateCopy(), labelLength);
	}
}
