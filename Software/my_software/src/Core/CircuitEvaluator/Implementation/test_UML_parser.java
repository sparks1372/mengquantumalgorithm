/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvaluator.Implementation;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Core.CircuitEvaluator.testparser;
import Core.Problem.SuperPositionalTestSet;
import Core.Problem.testcase;
import Core.Problem.testset;
import Core.Problem.testsuite;
import Jama.Matrix;
import Utils.Complex;

/**
 * @author Sam Ratcliff
 * 
 */
public class test_UML_parser implements testparser {
	static String	zero_string	= "0";

	public static void main(String[] args) {
		test_UML_parser tup = new test_UML_parser("config/testset.xml");
		tup.parse();
	}

	Document	dom;

	testsuite	ts;

	/**
 * 
 */
	public test_UML_parser(String filename) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		ts = new testsuite();

		// Validator validator = schema.newValidator();
		try {

			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parse using builder to get DOM representation of the XML file
			dom = db.parse(filename);

			// validator.validate(new DOMSource(dom));
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * @param tcel
	 * @return
	 */
	private Matrix getFinalState(Element tcel, int SystemSize) {
		int numofstates = (int) Math.pow(2, SystemSize);
		Matrix to_return = new Matrix(numofstates, 1);
		NodeList startmat = tcel.getElementsByTagName("final_state");
		Element smel = (Element) startmat.item(0);
		NodeList menl = smel.getElementsByTagName("matrix_element");
		if ((menl != null) && (menl.getLength() > 0)) {
			for (int i = 0; i < menl.getLength(); i++) {
				Element mel = (Element) menl.item(i);
				NodeList rnl = mel.getElementsByTagName("Real");
				NodeList inl = mel.getElementsByTagName("Imag");
				if ((rnl != null) && (rnl.getLength() > 0) && (inl != null)
						&& (inl.getLength() > 0)) {

					String textVal = null;
					Element el = (Element) rnl.item(0);
					textVal = el.getFirstChild().getNodeValue();
					double real = Double.parseDouble(textVal);

					el = (Element) inl.item(0);
					textVal = el.getFirstChild().getNodeValue();
					double complex = Double.parseDouble(textVal);

					to_return.set(i, 0, new Complex(real, complex));
				}

				Element matel = (Element) menl.item(i);
				NodeList temp = matel.getChildNodes();

			}
		}

		return to_return;
	}

	/**
	 * @param tcel
	 * @return
	 */
	private Matrix getStartState(Element tcel, int SystemSize) {
		int numofstates = (int) Math.pow(2, SystemSize);
		Matrix to_return = new Matrix(numofstates, 1);
		NodeList startmat = tcel.getElementsByTagName("starting_state");
		Element smel = (Element) startmat.item(0);
		NodeList menl = smel.getElementsByTagName("matrix_element");
		if ((menl != null) && (menl.getLength() > 0)) {
			for (int i = 0; i < menl.getLength(); i++) {
				Element mel = (Element) menl.item(i);
				NodeList rnl = mel.getElementsByTagName("Real");
				NodeList inl = mel.getElementsByTagName("Imag");
				if ((rnl != null) && (rnl.getLength() > 0) && (inl != null)
						&& (inl.getLength() > 0)) {

					String textVal = null;
					Element el = (Element) rnl.item(0);
					textVal = el.getFirstChild().getNodeValue();
					double real = Double.parseDouble(textVal);

					el = (Element) inl.item(0);
					textVal = el.getFirstChild().getNodeValue();
					double complex = Double.parseDouble(textVal);

					to_return.set(i, 0, new Complex(real, complex));
				}

				Element matel = (Element) menl.item(i);
				NodeList temp = matel.getChildNodes();

			}
		}

		return to_return;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if ((nl != null) && (nl.getLength() > 0)) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvaluator.testparser#parse(java.lang.String)
	 */
	@Override
	public testsuite parse() {
		testset tset;
		testcase tc;
		int syssize;

		// get the root elememt
		Element docEle = dom.getDocumentElement();

		// get a nodelist of <employee> elements
		NodeList tsnl = docEle.getElementsByTagName("testset");
		if ((tsnl != null) && (tsnl.getLength() > 0)) {
			for (int i = 0; i < tsnl.getLength(); i++) {

				// get the employee element
				Element tsel = (Element) tsnl.item(i);
				syssize = Integer.parseInt(tsel.getAttribute("NumQubits"));
				if (syssize > 0) {
					tset = new testset(syssize);
				} else {
					syssize = -syssize;
					tset = new SuperPositionalTestSet(syssize);
				}

				// get a nodelist of <employee> elements
				NodeList tcnl = tsel.getElementsByTagName("testcase");
				if ((tcnl != null) && (tcnl.getLength() > 0)) {
					for (int j = 0; j < tcnl.getLength(); j++) {
						String b_str;
						if (tset instanceof SuperPositionalTestSet) {
							b_str = "Test Case " + Integer.toString(j);
						} else {
							b_str = Integer.toBinaryString(j);
							while (b_str.length() < syssize) {
								b_str = zero_string.concat(b_str);
							}
						}
						// get the employee element
						Element tcel = (Element) tcnl.item(j);
						tc = new testcase(j, b_str);
						tc.setStartingstate(getStartState(tcel, syssize));
						tc.setFinalstate(getFinalState(tcel, syssize));

						tset.addTestcases(tc);
					}
				}

				ts.addTestcases(tset);
			}
		}
		return ts;
	}
}
