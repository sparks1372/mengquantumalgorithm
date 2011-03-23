package GUI.ProblemEditor.Implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import Core.Problem.testcase;
import Core.Problem.testset;
import Core.Problem.testsuite;
import Jama.Matrix;

public class TestSuiteToXML {

	private static String	zero_string	= "0";

	public static void TestSuiteToXML(testsuite testsuite, File f) {
		String filename = f.getAbsolutePath();
		if (!filename.endsWith(".xml")) {
			filename = filename.concat(".xml");
		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			out.write("<testsuite");
			out.write(" NumCustomGates=");
			out.write(Integer.toString(testsuite.getNumOfCustomGates()));
			out.write(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"testset_xml_spec.xsd\">\n");
			Iterator<Integer> qubit_num_iterator = testsuite.getKeys()
					.iterator();
			testset ts;
			testcase tc;
			Matrix ss;
			Matrix fs;
			int index;
			while (qubit_num_iterator.hasNext()) {
				int num_of_qubits = qubit_num_iterator.next();
				out.write("<testset NumQubits=\"" + num_of_qubits + "\">\n");
				ts = testsuite.getTestcases(num_of_qubits);
				if (num_of_qubits < 0) {
					num_of_qubits = Math.abs(num_of_qubits);
				}
				Iterator<testcase> testcase_iter = ts.getTestcases();
				while (testcase_iter.hasNext()) {
					tc = testcase_iter.next();
					out.write("<testcase><!--" + tc.getLabel() + "-->\n");
					out.write("<starting_state>\n");
					ss = tc.getStartingStateCopy();
					for (index = 0; index < ss.getRowDimension(); index++) {
						String b_str = Integer.toBinaryString(index);
						while (b_str.length() < num_of_qubits) {
							b_str = zero_string.concat(b_str);
						}
						out.write("<matrix_element><!-- " + b_str + "-->\n");

						out.write("<Real>" + ss.get(index, 0).real()
								+ "</Real>\n");
						out.write("<Imag>" + ss.get(index, 0).imag()
								+ "</Imag>\n");

						out.write("</matrix_element>\n");
					}
					out.write("</starting_state>\n");

					out.write("<final_state>\n");
					fs = tc.getFinalStateCopy();
					for (index = 0; index < fs.getRowDimension(); index++) {
						String b_str = Integer.toBinaryString(index);
						while (b_str.length() < num_of_qubits) {
							b_str = zero_string.concat(b_str);
						}
						out.write("<matrix_element><!-- " + b_str + "-->\n");

						out.write("<Real>" + fs.get(index, 0).real()
								+ "</Real>\n");
						out.write("<Imag>" + fs.get(index, 0).imag()
								+ "</Imag>\n");

						out.write("</matrix_element>\n");
					}
					out.write("</final_state>\n");

					out.write("</testcase>\n");
				}
				out.write("</testset>\n");
			}
			out.write("</testsuite>");

			out.close();
		} catch (IOException e) {
		}
	}
}
