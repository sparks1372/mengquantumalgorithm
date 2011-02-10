package Core.CircuitEvolution;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

import Core.CircuitEvolution.Util.SE_XML_Parser;

public class searchenginemanager {

	/**
	 * @uml.property name="availablesearchengines" readOnly="true"
	 */
	// Search Engine Name - Search Engine Class Name
	private final HashMap<String, String>	availablesearchengines;

	/**
			 */
	public searchenginemanager(String se_xml_file_name) {
		SE_XML_Parser xmlp = new SE_XML_Parser(se_xml_file_name);
		availablesearchengines = xmlp.parseDocument();
	}

	public Set<String> getAvailableSearchEngines() {
		return availablesearchengines.keySet();
	}

	public circuitsearchengine getSearchEngine(String key) {
		Object retobj = null;
		try {
			Class<?> cls = Class.forName(availablesearchengines.get(key));
			Class<?> partypes[] = new Class[0];
			Constructor<?> ct = cls.getConstructor(partypes);
			Object arglist[] = new Object[0];
			retobj = ct.newInstance(arglist);
		} catch (Throwable e) {
			System.err.println(e);
		}
		return (circuitsearchengine) retobj;
	}

}
