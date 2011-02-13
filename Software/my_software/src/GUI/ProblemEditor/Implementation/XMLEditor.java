package GUI.ProblemEditor.Implementation;

import java.awt.Component;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JTabbedPane;

import Core.testcase;
import Core.testset;
import Core.testsuite;
import Core.CircuitEvaluator.Implementation.test_UML_parser;
import Jama.Matrix;
import Utils.Complex;

public class XMLEditor extends JTabbedPane {

	static String zero_string = "0";
	static String qubits_string = " Qubit(s)";
	private testsuite tsuite;

	public testsuite getTsuite() {
		return tsuite;
	}

	public XMLEditor() {
		super();
		tsuite = new testsuite();
	}

	public XMLEditor(File f) {
		super();
		test_UML_parser ts_parser = new test_UML_parser(f.getAbsolutePath());
		tsuite = ts_parser.parse();
		update_tabs();
	}

	public void load(File f) {
		test_UML_parser ts_parser = new test_UML_parser(f.getAbsolutePath());
		tsuite = ts_parser.parse();
		update_tabs();
	}

	protected void setTestSuite(testsuite ts) {
		tsuite = ts;
		update_tabs();
	}

	private void update_tabs() {

		this.removeAll();

		Set<Integer> keys = tsuite.getKeys();

		Iterator<Integer> iter = keys.iterator();

		Component tab;
		while (iter.hasNext()) {
			int numofqubits = iter.next();
			tab = new InnerEditorPanel(tsuite.getTestcases(numofqubits));
			this.add(Integer.toString(numofqubits).concat(qubits_string), tab);
		}
	}

	public void add_testset(int num_of_qubits) {
		int num_of_testcases;
		switch (num_of_qubits) {
		case 1:
			num_of_testcases = 2;
			break;
		case 2:
			num_of_testcases = 4;
			break;
		case 3:
			num_of_testcases = 8;
			break;
		case 4:
			num_of_testcases = 16;
			break;
		case 5:
			num_of_testcases = 32;
			break;
		case 6:
			num_of_testcases = 64;
			break;
		case 7:
			num_of_testcases = 128;
			break;
		case 8:
			num_of_testcases = 256;
			break;
		case 9:
			num_of_testcases = 512;
			break;
		case 10:
			num_of_testcases = 1024;
			break;
		default:
			num_of_testcases = 2;
			break;
		}

		Matrix m;
		testcase tc;
		Complex c1 = new Complex(1.0, 0.0);
		testset tset = new testset(num_of_qubits);

		for (int i = 0; i < num_of_testcases; i++) {
			String b_str = Integer.toBinaryString(i);
			while (b_str.length() != num_of_qubits) {
				b_str = zero_string.concat(b_str);
			}

			m = new Matrix(num_of_testcases, 1);
			m.set(i, 0, c1);

			tc = new testcase(i, b_str);
			tc.setStartingstate(m);
			tc.setFinalstate(m);

			tset.addTestcases(tc);

		}

		tsuite.addTestcases(tset);

		update_tabs();

	}
}
