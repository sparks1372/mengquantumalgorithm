/*
 * CircuitPanel.java - Class of the jQuantum computer simulator
 *
 * Copyright (C) 2004-2008 Andreas de Vries
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses
 * or write to the Free Software Foundation,Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA 02110-1301  USA
 */

package GUI.CircuitVisualiser;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import Core.Circuit.Circuit;
import Core.Circuit.quantumgate;
import Core.Circuit.GateImplementations.ControlledU_Gate;
import Core.Circuit.GateImplementations.Swap_Gate;
import Core.CircuitEvolution.multiqubitquantumgate;

/**
 * This class serves to show the panel on which the quantum circuits are
 * displayed.
 * 
 * @author Andreas de Vries
 * @version 1.6
 */
public class CircuitRendererPanel extends JPanel {
	private static final long			serialVersionUID	= 727054267;
	/** The circuit of of quantum gates which is displayed. */
	private final Core.Circuit.Circuit	circuit;
	private final int					numOfQubits;
	private final int					fontSize			= 10;
	private final int					xDelta				= 40;			// stepwidth
	// of
	// each
	// gate
	private int							yDelta;
	private int							x					= 0, y, y0 = 0;
	private int							y1					= 0;
	private final int					adjust				= 2;			// constant
	private int							position			= 0;
	private final int					circuitSize;						// constant
	private final int					initial_x			= 50;

	public CircuitRendererPanel(Circuit circuit, int num) {
		this(circuit, num, -1);
	}

	/**
	 * Creates new CircuitPanel.
	 * 
	 * @param circuit
	 *            the quantum circuit to be displayed
	 */
	public CircuitRendererPanel(Circuit circuit, int num, int position) {
		this.position = position;
		this.circuit = circuit;
		circuitSize = circuit.getSize();
		numOfQubits = num;
		initComponents();
	}

	private void drawGate(Graphics g, quantumgate gate, int i) {
		y0 = (2 * (numOfQubits - gate.getTarget()) + 1) * yDelta / 2 + adjust;
		drawGate(g, gate, i, x, y0);
	}

	private void drawGate(Graphics g, quantumgate gate, int i, int x, int y) {
		int gateHeight = 12;
		g.setColor(Color.white);
		g.fillRect(x - (3 * xDelta) / 4, y0 - gateHeight / 2, xDelta / 2,
				gateHeight);
		g.setColor(Color.black);
		g.drawRect(x - (3 * xDelta) / 4, y0 - gateHeight / 2, xDelta / 2,
				gateHeight);
		g.drawString(gate.getlabel(), x - (5 * xDelta) / 8, y0 + 4);
	}

	/**
	 * @return
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * This method is called from within the constructor to initialize this
	 * circuit panel. Note, however, that this class has no GUI components.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {// GEN-BEGIN:initComponents

	}// GEN-END:initComponents

	/**
	 * Paints and repaints the circuit panel.
	 * 
	 * @param g
	 *            the Graphic object
	 */

	public int nextPosition() {
		position++;
		position = position <= circuitSize ? position : circuitSize;
		repaint();
		return position;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		x = initial_x;
		y0 = 0;
		y1 = 0;
		if (numOfQubits > 0) {
			yDelta = (getHeight() - 3) / numOfQubits;
			yDelta = yDelta > 20 ? yDelta : 20;

			// adapt width of this panel because of scroll pane:
			setPreferredSize(new java.awt.Dimension(initial_x
					+ (circuitSize + 1) * xDelta, (yDelta * numOfQubits) + 3));
			revalidate(); // notify the scroll pane (if any)!

			g.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN,
					fontSize));
			// int currentGate = circuit.getNextGateNumber();
			int xRegisterSize = numOfQubits;

			// // mark current gate position during a quantum circuit execution:
			if ((position >= 0) && (position <= circuitSize)) {

				int tx = x + (xDelta * position) + (xDelta / 2);
				g.setColor(new java.awt.Color(0, 128, 0));
				g.drawLine(tx, 1, tx, getHeight() - 1);
				g.setColor(Color.black);
			}

			// The radius of dots and cycles:
			int radius;

			// draw tips of the wires:
			for (int i = 0; i < numOfQubits; i++) {
				y = (2 * i + 1) * yDelta / 2 + adjust;
				g.drawLine(x, y, x + xDelta / 2, y);
			}
			// ticks for the wires:
			g.setColor(new java.awt.Color(127, 127, 127));
			for (int i = 0; i < numOfQubits; i++) {
				g.drawString("" + (numOfQubits - i), x, (2 * i + 1) * yDelta
						/ 2 + adjust);
			}
			g.setColor(Color.black);

			x += xDelta / 2;
			quantumgate gate; // stores the next gate in each iteration
			Iterator<quantumgate> iter = circuit.getCircuitlayout();
			int i = 0;
			while (iter.hasNext()) {
				gate = iter.next();

				for (int il = 0; il < numOfQubits; il++) {
					y = (2 * (numOfQubits - il) - 1) * yDelta / 2 + adjust;
					g.drawLine(x, y, x + xDelta, y);
				}
				x += xDelta;

				if (gate instanceof ControlledU_Gate) {
					radius = numOfQubits <= 5 ? 3 : 2;
					y0 = (2 * (xRegisterSize - gate.getTarget()) + 1) * yDelta
							/ 2 + adjust;
					y1 = (2 * (xRegisterSize - ((multiqubitquantumgate) gate)
							.getSecondQubit()) + 1) * yDelta / 2 + adjust;
					g.fillOval(x - xDelta / 2 - radius, y1 - radius,
							2 * radius, 2 * radius);
					radius = numOfQubits <= 5 ? 6 : 4;
					if (y0 > y1) {
						g.drawLine(x - xDelta / 2, y0, x - xDelta / 2, y1
								+ radius);
					} else {
						g.drawLine(x - xDelta / 2, y0, x - xDelta / 2, y1
								- radius);
					}

					drawGate(g, gate, i);

				} else if (gate instanceof Swap_Gate) {
					radius = numOfQubits <= 5 ? 3 : 2;
					y0 = (2 * (xRegisterSize - gate.getTarget()) + 1) * yDelta
							/ 2 + adjust;
					y1 = (2 * (xRegisterSize - ((multiqubitquantumgate) gate)
							.getSecondQubit()) + 1) * yDelta / 2 + adjust;

					g.drawLine(x - xDelta / 2 - radius, y0 - radius, x - xDelta
							/ 2 + radius, y0 + radius);
					g.drawLine(x - xDelta / 2 - radius, y0 + radius, x - xDelta
							/ 2 + radius, y0 - radius);

					g.drawLine(x - xDelta / 2, y0, x - xDelta / 2, y1);

					g.drawLine(x - xDelta / 2 - radius, y1 - radius, x - xDelta
							/ 2 + radius, y1 + radius);
					g.drawLine(x - xDelta / 2 - radius, y1 + radius, x - xDelta
							/ 2 + radius, y1 - radius);

				} else {
					drawGate(g, gate, i);
				}

				i++;
			} // loop over gates

		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables

	public int prevPosition() {
		position--;
		position = position < 0 ? 0 : position;
		repaint();
		return position;
	}
}
