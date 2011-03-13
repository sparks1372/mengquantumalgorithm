/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution;

import org.jppf.server.protocol.JPPFTask;

/**
 * @author Sam Ratcliff
 */
public abstract class SearchEngineCore extends JPPFTask {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		search();
	}

	public abstract void search();
}
