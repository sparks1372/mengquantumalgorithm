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
public class CreateProblemSetButton extends JButton {
	private final qcevolutionbackend	backend;
	private static final String			text	= "Create";

	/**
	 * 
	 */
	public CreateProblemSetButton(qcevolutionbackend be) {
		super(text);
		backend = be;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				(new CreateProblemPanel(backend)).setVisible(true);
			}
		});
		this.setVisible(true);
	}

}
