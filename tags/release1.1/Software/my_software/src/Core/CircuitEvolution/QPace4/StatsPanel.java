package Core.CircuitEvolution.QPace4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.CircuitEvolution.QPace4.State.QPaceEvoState;
import GUI.MainPanel;

public class StatsPanel extends JPanel {
	private final static String			genStr			= "Generations";
	private JLabel						timeL;
	private JLabel						timeTA;
	private static String				timeStr			= "Time Taken";
	private JLabel						numGenL;
	private JLabel						numGenTA;
	private JLabel						fitL;
	private JLabel						fitTA;
	private static String				fitStr			= "Best Fitness";
	
	public StatsPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMaximumSize(new Dimension(
				(int) (screenSize.width * MainPanel.right_perc),
				screenSize.height / 2));
		timeL = new JLabel(timeStr);
		timeTA = new JLabel();
		numGenL = new JLabel(genStr);
		numGenTA = new JLabel();
		fitL = new JLabel(fitStr);
		fitTA = new JLabel();

		JPanel tPanel = new JPanel();
		tPanel.setLayout(new FlowLayout());
		tPanel.add(timeL);
		tPanel.add(timeTA);

		JPanel ngPanel = new JPanel();
		ngPanel.setLayout(new FlowLayout());
		ngPanel.add(numGenTA);
		ngPanel.add(numGenL);

		JPanel fPanel = new JPanel();
		fPanel.setLayout(new FlowLayout());
		fPanel.add(fitL);
		fPanel.add(fitTA);

		this.add(tPanel);
		this.add(ngPanel);
		this.add(fPanel);
	}

	public void setFitness(float fit){
		fitTA.setText(Float.toString(fit));
	}

	public void setTime(long td){
		long dif = td;
		int days = (int) Math.floor(dif / (24 * 60 * 60 * 1000.0));
		dif = dif - days * (24 * 60 * 60 * 1000);
		int hours = (int) Math.floor(dif / (60 * 60 * 1000.0));
		dif = dif - hours * (60 * 60 * 1000);
		int mins = (int) Math.floor(dif / (60 * 1000.0));
		dif = dif - mins * (60 * 1000);
		int secs = (int) Math.floor(dif / (1000.0));
		dif = dif - secs * (1000);
		int millisecs = (int) dif;
		timeTA.setText(days + "::" + hours + "::" + mins + "::" + secs
				+ "." + millisecs);
	}
	
	public void setGens(int gens){
		numGenTA.setText(Integer.toString(gens + 1));
	}
}
