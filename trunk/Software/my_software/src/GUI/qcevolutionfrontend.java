package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Core.qcevolutionbackend;
import Core.CircuitEvaluator.fitnessfunctionmanager;
import Core.CircuitEvolution.searchenginemanager;
import Core.Problem.Problem_Manager;
import GUI.CircuitVisualiser.circuitvisualiser;
import GUI.ProblemEditor.problemeditor;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;

class ClockLabel extends JLabel implements ActionListener {

	public ClockLabel() {
		super("" + new Date());
		Timer t = new Timer(1000, this);
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		setText((new Date()).toString());
	}
}

/**
 * @uml.dependency supplier="Core.qcevolutionbackend"
 */
public class qcevolutionfrontend extends JFrame {

	public static void main(String[] args) {
		qcevolutionfrontend frame = new qcevolutionfrontend("Test", args[0],
				args[1], args[2]);
		frame.setVisible(true);
	}

	/**
	 * @uml.property name="backend"
	 */
	private qcevolutionbackend	backend	= new Core.qcevolutionbackend();

	/**
	 * @uml.property name="cvisualiser" readOnly="true"
	 */
	private circuitvisualiser	cvisualiser;

	/**
	 * @uml.property name="peditor" readOnly="true"
	 */
	private problemeditor		peditor;

	private final String		se_file;
	private final String		ff_file;
	private final String		prob_file;

	public qcevolutionfrontend(String title, String sef, String fff,
			String probf) {
		super(title);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
		} catch (UnsupportedLookAndFeelException ex) {
		}

		se_file = sef;
		ff_file = fff;
		prob_file = probf;

		backend.setFfmanager(new fitnessfunctionmanager(ff_file));
		backend.setSemanager(new searchenginemanager(se_file));
		backend.setProbmanager(new Problem_Manager(prob_file));

		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Close button Pressed");
				qcevolutionfrontend.this.setVisible(false);
				System.exit(0);
			}
		});
		JLabel userLabel = new JLabel();
		userLabel.setText("Currently running as "
				+ System.getProperty("user.name"));
		ClockLabel clock = new ClockLabel();
		JPanel lowerPanel = new JPanel();
		JPanel closePanel = new JPanel();
		closePanel.add(closeButton);
		lowerPanel.setLayout(new BorderLayout());
		lowerPanel.add(userLabel, BorderLayout.LINE_START);
		lowerPanel.add(closePanel, BorderLayout.CENTER);
		lowerPanel.add(clock, BorderLayout.LINE_END);
		getContentPane().add(new MainPanel(screenSize, backend),
				BorderLayout.CENTER);
		getContentPane().add(lowerPanel, BorderLayout.PAGE_END);
	}

	/**
	 * Getter of the property <tt>backend</tt>
	 * 
	 * @return Returns the backend.
	 * @uml.property name="backend"
	 */
	public qcevolutionbackend getBackend() {
		return backend;
	}

	/**
	 * Getter of the property <tt>cvisualiser</tt>
	 * 
	 * @return Returns the cvisualiser.
	 * @uml.property name="cvisualiser"
	 */
	public circuitvisualiser getCvisualiser() {
		return cvisualiser;
	}

	/**
	 * Getter of the property <tt>peditor</tt>
	 * 
	 * @return Returns the peditor.
	 * @uml.property name="peditor"
	 */
	public problemeditor getPeditor() {
		return peditor;
	}

	/**
	 * Setter of the property <tt>backend</tt>
	 * 
	 * @param backend
	 *            The backend to set.
	 * @uml.property name="backend"
	 */
	public void setBackend(qcevolutionbackend backend) {
		this.backend = backend;
	}

}