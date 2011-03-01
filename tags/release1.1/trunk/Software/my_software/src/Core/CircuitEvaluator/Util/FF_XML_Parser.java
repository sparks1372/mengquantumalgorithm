/**
 * 
 */
package Core.CircuitEvaluator.Util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Sam
 * 
 */
public class FF_XML_Parser {
	public static void main(String[] args) {
		FF_XML_Parser p = new FF_XML_Parser("config/FitnessFunction.xml");
		HashMap<String, FitnessFunctionTag> fft = p.parseDocument();
		Iterator<String> iter = fft.keySet().iterator();
		while (iter.hasNext()) {
			String Name = iter.next();
			String Class = fft.get(Name).Class;
			System.out.println("Name : " + Name + " Class : " + Class);
		}

	}

	HashMap<String, FitnessFunctionTag>	ffs;

	Document							dom;

	public FF_XML_Parser(String filename) {
		ffs = new HashMap<String, FitnessFunctionTag>();
		parseXmlFile(filename);
	}

	/**
	 * I take an employee element and read the values in, create an Employee
	 * object and return it
	 * 
	 * @param empEl
	 * @return
	 */
	private FitnessFunctionTag getFitnessFunction(Element empEl) {

		// for each <employee> element get text or int values of
		// name ,id, age and name
		String Name = getTextValue(empEl, "Name");
		String Class = getTextValue(empEl, "Class");
		String Desc = getTextValue(empEl, "Desc");

		// Create a new Employee with the value read from the xml nodes
		FitnessFunctionTag e = new FitnessFunctionTag(Name, Class, Desc);

		return e;
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

	public HashMap<String, FitnessFunctionTag> parseDocument() {
		// get the root elememt
		Element docEle = dom.getDocumentElement();

		// get a nodelist of <employee> elements
		NodeList nl = docEle.getElementsByTagName("FitnessFunctionTag");
		if ((nl != null) && (nl.getLength() > 0)) {
			for (int i = 0; i < nl.getLength(); i++) {

				// get the employee element
				Element el = (Element) nl.item(i);

				// get the Employee object
				FitnessFunctionTag e = getFitnessFunction(el);

				// add it to list
				ffs.put(e.Name, e);
			}
		}
		return ffs;
	}

	private void parseXmlFile(String filename) {
		// get the factory
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
			schema = factory.newSchema(new File(
					"config/fitnessfunction_spec.xsd"));
		} catch (SAXException e) {
			e.printStackTrace();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

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
}
