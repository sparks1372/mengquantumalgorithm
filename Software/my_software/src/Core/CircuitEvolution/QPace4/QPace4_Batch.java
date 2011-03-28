/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Core.Algorithms.QuantumAlgorithm;
import Core.Algorithms.QuantumInstructionEnum;
import Core.CircuitBuilder.circuitBuilder;
import Core.CircuitEvaluator.circuitevaluator;
import Core.CircuitEvolution.SearchEngineState;
import Core.CircuitEvolution.SearchResult;
import Core.CircuitEvolution.circuitsearchengine;
import Utils.WindowUtils;
import Utils.WrapLayout;
import ec.EvolutionState;
import ec.Evolve;

/**
 * @author Sam Ratcliff
 * 
 */
public class QPace4_Batch extends Evolve implements circuitsearchengine {

	class tickBoxListener implements ItemListener {
		int	index;

		/**
		 * 
		 */
		public tickBoxListener(int i) {
			index = i;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent
		 * )
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				enabledGate[index] = false;
			} else {
				enabledGate[index] = true;
			}

		}

	}

	public static void main(String[] args) {
		boolean[] temp = new boolean[QuantumInstructionEnum.values().length];
		for (int i = 0; i < temp.length; i++) {
			if (i % 2 != 0) {
				temp[i] = true;
			}
		}

		// new QPace4_Imp(null, null, temp);
	}

	private circuitBuilder			cb;
	private circuitevaluator		ce;
	private static final String		NAME			= "QPace 4 Implementation";

	private QuantumAlgorithm		al;
	private static final String		filename		= "config/ecparams.params";
	private Params_Writer			pw				= null;
	private SearchEngineState		state			= SearchEngineState.Start;
	private final Vector<Observer>	observers		= new Vector<Observer>();

	private EvolutionState			evoState;
	private final JPanel			progressPanel;
	private JDialog					evolveDialog;
	private JTextArea				genTA;
	private JLabel					genL;
	private final static String		genStr			= "Generations";
	private final static int		genDef			= 128;
	private JTextArea				popTA;
	private JLabel					popL;
	private final static String		popStr			= "Population Size";
	private final static int		popDef			= 128;
	private JTextArea				bthTA;
	private JLabel					bthL;
	private final static String		bthStr			= "# of Breeder Threads";
	private final static int		bthDef			= 8;
	private JTextArea				ethTA;
	private JLabel					ethL;
	private final static String		ethStr			= "# of Evaluation Threads";
	private final static int		ethDef			= 8;
	private JTextArea				mintreedepthTA;
	private JLabel					mintreedepthL;
	private final static String		mintreedepthStr	= "Minimum Initial Tree Depth";
	private final static int		mintreedepthDef	= 10;
	private JTextArea				maxtreedepthTA;
	private JLabel					maxtreedepthL;
	private final static String		maxtreedepthStr	= "Minimum Initial Tree Depth";
	private final static int		maxtreedepthDef	= 20;
	private JCheckBox				timeCB;
	private boolean					time			= true;
	private final static String		timeStr			= "Use Time as Seeds?";
	private JTextArea				elTA;
	private JLabel					elL;
	private final static String		elStr			= "# of Elites";
	private final static int		elDef			= 1;
	private JTextArea				xoverTA;
	private JLabel					xoverL;
	private final static String		xoverStr		= "CrossOver Rate";
	private final static double		xoverDef		= 0.9;
	private JTextArea				mutTA;
	private JLabel					mutL;
	private final static String		mutStr			= "Mutation Rate";
	private final static double		mutDef			= 0.1;
	private boolean[]				enabledGate;

	private StatsPanel				statsPanel;

	/**
	 * 
	 */
	public QPace4_Batch() {
		progressPanel = new JPanel();
		enabledGate = new boolean[QuantumInstructionEnum.values().length];
		for (int i = 0; i < enabledGate.length; i++) {
			enabledGate[i] = true;
		}
		setupEvolveDialog();
		setupSearchStatisticsPanel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Core.CircuitEvolution.circuitsearchengine#addObserver(java.util.Observer)
	 */
	@Override
	public void addObserver(Observer ob) {
		observers.add(ob);
	}

	private void centre() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		evolveDialog.setLocation(screenSize.width / 2 - evolveDialog.getWidth()
				/ 2, screenSize.height / 2 - evolveDialog.getHeight() / 2);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getAvailableinstructions()
	 */
	@Override
	public boolean[] getAvailableinstructions() {
		return enabledGate;
	}

	private JPanel getButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton evButton = new JButton("Evolve Now");
		JButton cancelButton = new JButton("Cancel");

		evButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Thread ev = new Thread(new Runnable() {

					@Override
					public void run() {
						search();
					}
				});

				try {
					int gen = Integer.parseInt(genTA.getText());
					int pop = Integer.parseInt(popTA.getText());
					int bth = Integer.parseInt(bthTA.getText());
					int eth = Integer.parseInt(ethTA.getText());
					int mintreedepth = Integer.parseInt(mintreedepthTA
							.getText());
					int maxtreedepth = Integer.parseInt(maxtreedepthTA
							.getText());
					int el = Integer.parseInt(elTA.getText());

					double xover = Double.parseDouble(xoverTA.getText());
					double mut = Double.parseDouble(mutTA.getText());
					System.out.println("gen " + gen + " pop " + pop + " bth "
							+ bth + " eth " + eth + " minimum tree depth "
							+ mintreedepth + " maximum tree depth "
							+ maxtreedepth + " xover rate " + xover
							+ " mutation rate " + mut);

					pw.updateParams(enabledGate, gen, pop, bth, eth,
							mintreedepth, maxtreedepth, el, xover, mut, time);
					ev.start();
					evolveDialog.setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane
							.showMessageDialog(
									evolveDialog,
									"Please check the Generation, Population, Breed Thread and Evalutaion Thread fields. These must be numeric",
									"Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				evolveDialog.setVisible(false);
			}
		});

		buttonPanel.add(evButton);
		buttonPanel.add(cancelButton);
		return buttonPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getCbuilder()
	 */
	@Override
	public circuitBuilder getCbuilder() {
		return cb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getCevaluator()
	 */
	@Override
	public circuitevaluator getCevaluator() {
		return ce;
	}

	private JPanel getGatePanel() {

		JPanel allowedGatePanel = new JPanel();
		allowedGatePanel.setLayout(new WrapLayout());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		allowedGatePanel.setSize(new Dimension(screenSize.width / 2,
				screenSize.height));

		QuantumInstructionEnum[] gates = QuantumInstructionEnum.values();
		JLabel l;
		JCheckBox cb;
		JPanel p;
		for (int i = 0; i < gates.length; i++) {
			l = new JLabel(gates[i].name());
			cb = new JCheckBox("", enabledGate[i]);
			cb.addItemListener(new tickBoxListener(i));
			p = new JPanel();
			p.setLayout(new FlowLayout());
			p.add(l);
			p.add(cb);
			allowedGatePanel.add(p);
		}

		return allowedGatePanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	private JPanel getParamsPanel() {

		JPanel paramsPanel = new JPanel();
		paramsPanel.setLayout(new BoxLayout(paramsPanel, BoxLayout.PAGE_AXIS));
		paramsPanel.setBorder(BorderFactory.createEtchedBorder());

		genTA = new JTextArea(Integer.toString(genDef));
		genL = new JLabel(genStr);

		JPanel genPanel = new JPanel();
		genPanel.setLayout(new FlowLayout());

		genPanel.add(genL);
		genPanel.add(genTA);

		popTA = new JTextArea(Integer.toString(popDef));
		popL = new JLabel(popStr);

		JPanel popPanel = new JPanel();
		popPanel.setLayout(new FlowLayout());

		popPanel.add(popL);
		popPanel.add(popTA);

		bthTA = new JTextArea(Integer.toString(bthDef));
		bthL = new JLabel(bthStr);

		JPanel bthPanel = new JPanel();
		bthPanel.setLayout(new FlowLayout());

		bthPanel.add(bthL);
		bthPanel.add(bthTA);

		ethTA = new JTextArea(Integer.toString(ethDef));
		ethL = new JLabel(ethStr);

		JPanel ethPanel = new JPanel();
		ethPanel.setLayout(new FlowLayout());

		ethPanel.add(ethL);
		ethPanel.add(ethTA);

		mintreedepthTA = new JTextArea(Integer.toString(mintreedepthDef));
		mintreedepthL = new JLabel(mintreedepthStr);

		JPanel mintreedepthPanel = new JPanel();
		mintreedepthPanel.setLayout(new FlowLayout());

		mintreedepthPanel.add(mintreedepthL);
		mintreedepthPanel.add(mintreedepthTA);

		maxtreedepthTA = new JTextArea(Integer.toString(maxtreedepthDef));
		maxtreedepthL = new JLabel(maxtreedepthStr);

		JPanel maxtreedepthPanel = new JPanel();
		maxtreedepthPanel.setLayout(new FlowLayout());

		maxtreedepthPanel.add(maxtreedepthL);
		maxtreedepthPanel.add(maxtreedepthTA);

		timeCB = new JCheckBox(timeStr, time);
		timeCB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time = !time;

			}
		});

		elTA = new JTextArea(Integer.toString(elDef));
		elL = new JLabel(elStr);

		JPanel elPanel = new JPanel();
		elPanel.setLayout(new FlowLayout());

		elPanel.add(elL);
		elPanel.add(elTA);

		xoverTA = new JTextArea(Double.toString(xoverDef));
		xoverL = new JLabel(xoverStr);

		JPanel xoverPanel = new JPanel();
		xoverPanel.setLayout(new FlowLayout());

		xoverPanel.add(xoverL);
		xoverPanel.add(xoverTA);

		mutTA = new JTextArea(Double.toString(mutDef));
		mutL = new JLabel(mutStr);

		JPanel mutPanel = new JPanel();
		mutPanel.setLayout(new FlowLayout());

		mutPanel.add(mutL);
		mutPanel.add(mutTA);

		JPanel upperPanel = new JPanel(new WrapLayout());
		JPanel midPanel = new JPanel(new WrapLayout());
		JPanel lowerPanel = new JPanel(new WrapLayout());

		upperPanel.add(popPanel);
		upperPanel.add(genPanel);
		upperPanel.add(bthPanel);
		upperPanel.add(ethPanel);
		midPanel.add(elPanel);
		midPanel.add(mintreedepthPanel);
		midPanel.add(maxtreedepthPanel);
		midPanel.add(timeCB);
		lowerPanel.add(xoverPanel);
		lowerPanel.add(mutPanel);

		paramsPanel.add(upperPanel);
		paramsPanel.add(midPanel);
		paramsPanel.add(lowerPanel);

		return paramsPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getProgressBar()
	 */
	@Override
	public JPanel getProgressBar() {
		return progressPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getResults()
	 */
	@Override
	public SearchResult[] getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#getSearchStatisticsPanel()
	 */
	@Override
	public JPanel getSearchStatisticsPanel() {
		return statsPanel;
	}

	/**
	 * @return the state
	 */
	@Override
	public SearchEngineState getState() {
		return state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#statsDialog()
	 */
	@Override
	public JDialog getStatsDialog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(circuitBuilder cb, circuitevaluator ce, boolean[] ai) {
		this.cb = cb;
		this.ce = ce;

		try {
			pw = new Params_Writer(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void notifyObservers() {
		Iterator<Observer> iter = observers.iterator();
		while (iter.hasNext()) {
			iter.next().update(null, this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Core.CircuitEvolution.circuitsearchengine#removeAllObservers()
	 */
	@Override
	public void removeAllObservers() {
		observers.removeAllElements();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Core.CircuitEvolution.circuitsearchengine#removeObserver(java.util.Observer
	 * )
	 */
	@Override
	public void removeObserver(Observer ob) {
		observers.remove(ob);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.Evolve#Evolve()
	 */
	// @Override
	@Override
	public void search() {
		WindowUtils.centre(evolveDialog);
		evolveDialog.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Core.CircuitEvolution.circuitsearchengine#setAvailableinstructions(boolean
	 * [])
	 */
	@Override
	public void search(boolean[] availableinstructions, Object[] p) {
		enabledGate = availableinstructions;
		String[] params = (String[]) p;
		try {
			int gen = Integer.parseInt(genTA.getText());
			int pop = Integer.parseInt(popTA.getText());
			int bth = Integer.parseInt(bthTA.getText());
			int eth = Integer.parseInt(ethTA.getText());
			int mintreedepthth = Integer.parseInt(mintreedepthTA.getText());
			int maxtreedepthth = Integer.parseInt(maxtreedepthTA.getText());
			int el = Integer.parseInt(elTA.getText());
			double xover = Double.parseDouble(xoverTA.getText());
			double mut = Double.parseDouble(mutTA.getText());

			pw.updateParams(enabledGate, gen, pop, bth, eth, mintreedepthth,
					maxtreedepthth, el, xover, mut, time);
		} catch (NumberFormatException ex) {
			JOptionPane
					.showMessageDialog(
							evolveDialog,
							"Please check the Generation, Population, Breed Thread and Evalutaion Thread fields. These must be numeric",
							"Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	private void setupEvolveDialog() {

		JPanel allowedGatePanel;
		JPanel paramsPanel;
		JPanel buttonPanel;

		evolveDialog = new JDialog();

		evolveDialog.getContentPane().setLayout(
				new BoxLayout(evolveDialog.getContentPane(),
						BoxLayout.PAGE_AXIS));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		evolveDialog.setBounds(screenSize.width / 4, screenSize.height / 4,
				screenSize.width / 2, screenSize.height / 2);
		evolveDialog.setMaximumSize(new Dimension(screenSize.width / 2,
				screenSize.height));
		evolveDialog.getContentPane().setBounds(screenSize.width / 4,
				screenSize.height / 4, screenSize.width / 2,
				screenSize.height / 2);
		evolveDialog.getContentPane().setMaximumSize(
				new Dimension(screenSize.width / 2, screenSize.height));
		evolveDialog.setUndecorated(true);
		evolveDialog.setModalityType(ModalityType.APPLICATION_MODAL);

		allowedGatePanel = getGatePanel();

		paramsPanel = getParamsPanel();

		buttonPanel = getButtonPanel();

		evolveDialog.getContentPane().add(allowedGatePanel);
		evolveDialog.getContentPane().add(paramsPanel);
		evolveDialog.getContentPane().add(buttonPanel);
		evolveDialog.pack();
		centre();
	}

	/**
	 * 
	 */
	private void setupSearchStatisticsPanel() {
		statsPanel = new StatsPanel();
		statsPanel.setVisible(false);
	}

	private synchronized void updateState(SearchEngineState s) {
		this.state = s;
		notifyObservers();
	}
}