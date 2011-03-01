/**
 * @Author = Sam Ratcliff
 */
package GUI.SubPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Core.qcevolutionbackend;

/**
 * @author Sam Ratcliff
 * 
 */
public class LoadProblemSetButton extends JButton {
	private final qcevolutionbackend	backend;
	private static final String			text	= "Load";

	/**
	 * 
	 */
	public LoadProblemSetButton(qcevolutionbackend be) {
		super(text);
		backend = be;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				(new LoadProblemPanel(backend)).setVisible(true);
			}
		});
		this.setVisible(true);
	}

}
