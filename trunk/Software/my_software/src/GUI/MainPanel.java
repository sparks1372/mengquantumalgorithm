/**
 * @Author = Sam Ratcliff
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Core.qcevolutionbackend;
import GUI.SubPanels.LPanel;
import GUI.SubPanels.RPanel;

/**
 * @author Sam Ratcliff
 * 
 */
public class MainPanel extends JPanel {
	private final JPanel				left_panel;
	private final JPanel				centre_panel;
	private final JPanel				right_panel;
	private final Dimension				screen_size;
	private static final double			left_perc	= 0.2;
	private static final double			centre_perc	= 0.6;
	private static final double			right_perc	= 0.2;
	private static final double			height_perc	= 0.8;
	private final qcevolutionbackend	backend;

	/**
	 * 
	 */
	public MainPanel(Dimension dim, qcevolutionbackend be) {
		backend = be;
		screen_size = dim;
		left_panel = new LPanel(backend);
		centre_panel = new JPanel();
		right_panel = new RPanel(backend);

		left_panel.setSize((int) (screen_size.width * left_perc),
				(int) (screen_size.height * height_perc));
		centre_panel.setSize((int) (screen_size.width * centre_perc),
				(int) (screen_size.height * height_perc));
		right_panel.setSize((int) (screen_size.width * right_perc),
				(int) (screen_size.height * height_perc));

		this.add(left_panel, BorderLayout.LINE_START);
		this.add(centre_panel, BorderLayout.CENTER);
		this.add(right_panel, BorderLayout.LINE_END);
	}
}
