package GUI.ProblemEditor.Implementation;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class InnerEditorPanel extends JPanel implements ListSelectionListener {

	private final JList				test_case_list;
	private final testset			tset;
	private JPanel					test_case_editor;
	private final DefaultListModel	model;
	private final JLabel			tc_label	= new JLabel("Starting State");
	private final TestCaseEditor	tce;

	public InnerEditorPanel(testset tset) {
		super();
		this.tset = tset;
		this.tce = new TestCaseEditor();
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

		JScrollPane listScroller = new JScrollPane(test_case_list);
		listScroller.setPreferredSize(new Dimension(250, 80));

		JPanel left_panel = new JPanel();
		left_panel.setLayout(new BoxLayout(left_panel, BoxLayout.PAGE_AXIS));
		left_panel.add(tc_label);
		left_panel.add(listScroller);

		this.add(left_panel, BorderLayout.LINE_START);

		this.add(tce, BorderLayout.CENTER);

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
		tce.setTestCase(tc);
	}
}
