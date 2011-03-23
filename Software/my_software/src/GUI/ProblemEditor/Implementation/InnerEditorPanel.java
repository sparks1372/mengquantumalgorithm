/**
 * @Author = Sam Ratcliff
 */
package GUI.ProblemEditor.Implementation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Core.Problem.testcase;
import Core.Problem.testset;
import Jama.Matrix;

/**
 * @author Sam Ratcliff
 * 
 */
public class InnerEditorPanel extends JPanel implements ListSelectionListener,
		ActionListener {

	private final JList				test_case_list;
	private final JButton			addTestCase;
	private final testset			tset;
	private final DefaultListModel	model;
	private final JLabel			tc_label	= new JLabel("TestCase ID");
	private final JLabel			start_label	= new JLabel("Starting State");
	private final JLabel			final_label	= new JLabel("Final State");
	private final TestCaseEditor	startingStateEditor;
	private final TestCaseEditor	finalStateEditor;
	private static final String		addtcStr	= "Add Test Case";

	public InnerEditorPanel(testset tset) {
		super();
		this.tset = tset;
		this.startingStateEditor = new TestCaseEditor();
		this.finalStateEditor = new TestCaseEditor();
		this.setLayout(new BorderLayout());

		model = new DefaultListModel();

		Iterator<testcase> iter = tset.getTestcases();
		testcase tc;
		while (iter.hasNext()) {
			tc = iter.next();
			model.add(tc.getId(), tc.getLabel());
		}
		test_case_list = new JList(model);

		test_case_list.setVisibleRowCount(-1);
		test_case_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		test_case_list.setSelectedIndex(0);
		valueChanged(null);
		test_case_list.addListSelectionListener(this);

		addTestCase = new JButton(addtcStr);
		addTestCase.addActionListener(this);

		JScrollPane listScroller = new JScrollPane(test_case_list);
		listScroller.setPreferredSize(new Dimension(250, 80));

		JPanel left_panel = new JPanel();
		left_panel.setLayout(new BoxLayout(left_panel, BoxLayout.PAGE_AXIS));
		left_panel.add(tc_label);
		left_panel.add(listScroller);
		left_panel.add(addTestCase);

		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.PAGE_AXIS));
		startPanel.add(start_label);
		startPanel.add(startingStateEditor);

		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
		finalPanel.add(final_label);
		finalPanel.add(finalStateEditor);

		JPanel centre_panel = new JPanel();
		centre_panel.setLayout(new FlowLayout());
		centre_panel.add(startPanel);
		centre_panel.add(finalPanel);

		this.add(left_panel, BorderLayout.LINE_START);

		this.add(centre_panel, BorderLayout.CENTER);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int num_of_qubits = tset.getNum_of_qubits();
		int num_of_currect_test_case = tset.getNumberOfTestcases();
		int vectorSize;
		switch (num_of_qubits) {
			case 1:
				vectorSize = 2;
				break;
			case 2:
				vectorSize = 4;
				break;
			case 3:
				vectorSize = 8;
				break;
			case 4:
				vectorSize = 16;
				break;
			case 5:
				vectorSize = 32;
				break;
			case 6:
				vectorSize = 64;
				break;
			case 7:
				vectorSize = 128;
				break;
			case 8:
				vectorSize = 256;
				break;
			case 9:
				vectorSize = 512;
				break;
			case 10:
				vectorSize = 1024;
				break;
			default:
				vectorSize = 2;
				break;
		}

		Matrix m;
		testcase tc;
		m = new Matrix(vectorSize, 1);
		String b_str = "Test Case ".concat(Integer
				.toString(num_of_currect_test_case + 1));

		tc = new testcase(num_of_currect_test_case, b_str,
				tset.getNumOfCustomGates());
		tc.setStartingstate(m);

		tc.setFinalstate(m.copy());

		tset.addTestcases(tc);

		model.add(tc.getId(), tc.getLabel());
	}

	public int getQubit() {
		return tset.getNum_of_qubits();
	}

	protected testset getTestSet() {
		return tset;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int index;
		index = test_case_list.getSelectedIndex();
		Iterator<testcase> iter = tset.getTestcases();
		testcase tc = null;
		while ((tc == null) && iter.hasNext()) {
			testcase temp = iter.next();
			if (temp.getId() == index) {
				tc = temp;
			}

		}
		startingStateEditor.setMatrix(tc.getStartingState());
		finalStateEditor.setMatrix(tc.getFinalstate());
	}
}
