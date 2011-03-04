/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.BorderLayout;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import Core.Problem.testcase;
import Core.Problem.testset;
import GUI.StateVisualiser.columnchartvisualiser;

/**
 * @author Sam Ratcliff
 * 
 */
public class currectStateVisualiserTab extends stateVisualiserTab {

	/**
	 * @param ts
	 * @param title
	 */
	public currectStateVisualiserTab(testset ts, String title) {
		super(ts, title);
	}

	@Override
	protected void addCorrectPanel() {
		this.add(finalStateVisualiser, BorderLayout.CENTER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * GUI.SubPanels.stateVisualiserTab#setUpVisualising(Core.Problem.testcase,
	 * java.lang.String)
	 */
	@Override
	protected void setUpVisualising(testcase tc, String title) {
		int labelLength = (int) (Math.log(tc.getFinalStateCopy()
				.getRowDimension()) / Math.log(2));
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
		finalStateVisualiser.updateState(tc.getFinalStateCopy(), labelLength);
	}
}
