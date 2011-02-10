package Core.CircuitEvaluator;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

import Core.CircuitEvolution.Util.SE_XML_Parser;

public class fitnessfunctionmanager {

	/**
	 * @uml.property name="availablefitnessfuntions" multiplicity="(0 -1)"
	 *               dimension="1"
	 */
	// Search Engine Name - Search Engine Class Name
	private final HashMap<String, String>	availablefitnessfuntions;

	/**
			 */
	public fitnessfunctionmanager(String se_xml_file_name) {
		SE_XML_Parser xmlp = new SE_XML_Parser(se_xml_file_name);
		availablefitnessfuntions = xmlp.parseDocument();
	}

	public Set<String> getAvailableSearchEngines() {
		return availablefitnessfuntions.keySet();
	}

	public FitnessFunction getSearchEngine(String key) {
		Object retobj = null;
		try {
			Class<?> cls = Class.forName(availablefitnessfuntions.get(key));
			Class<?> partypes[] = new Class[0];
			Constructor<?> ct = cls.getConstructor(partypes);
			Object arglist[] = new Object[0];
			retobj = ct.newInstance(arglist);
		} catch (Throwable e) {
			System.err.println(e);
		}
		return (FitnessFunction) retobj;
	}

}
