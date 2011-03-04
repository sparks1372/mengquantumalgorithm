package GUI.ProblemEditor.Implementation;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import Jama.Matrix;
import Utils.Complex;

class MyTestCaseTableModel extends AbstractTableModel {
	private final boolean	DEBUG		= false;
	private final String[]	columnNames	= { "|State>", "Real", "Imaginary" };
	private Object[][]		data;

	public MyTestCaseTableModel() {
		data = new Object[0][3];
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void internalSetValueAt(Object value, int row, int col) {
		if (DEBUG) {
			System.out.println("Setting value at " + row + "," + col + " to "
					+ value + " (an instance of " + value.getClass() + ")");
		}

		data[row][col] = value;

		if (DEBUG) {
			System.out.println("New value of data:");
			printDebugData();
		}
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col == 0) {
			return false;
		} else {
			return true;
		}
	}

	private void printDebugData() {
		int numRows = getRowCount();
		int numCols = getColumnCount();

		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + data[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public void reset(int testcases) {
		data = new Object[testcases][3];
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {
		if (DEBUG) {
			System.out.println("Setting value at " + row + "," + col + " to "
					+ value + " (an instance of " + value.getClass() + ")");
		}

		data[row][col] = value;
		fireTableCellUpdated(row, col);

		if (DEBUG) {
			System.out.println("New value of data:");
			printDebugData();
		}
	}
}

public class TestCaseEditor extends JPanel implements TableModelListener {
	private final MyTestCaseTableModel	tm;
	private Matrix						m;
	private final JTable				tctable;
	private static String				zero_string	= "0";

	public TestCaseEditor() {
		tm = new MyTestCaseTableModel();
		tm.addTableModelListener(this);
		tctable = new JTable(tm);

		JScrollPane scrollPane = new JScrollPane(tctable);
		tctable.setFillsViewportHeight(true);

		// tctable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// int width = 100;
		//
		// for (int vColIndex = 0; vColIndex < tctable.getColumnCount();
		// vColIndex++) {
		// TableColumn col = tctable.getColumnModel().getColumn(vColIndex);
		// col.setPreferredWidth(width);
		// }

		this.add(scrollPane);
	}

	public void setMatrix(Matrix m) {
		double qubits = Math.log(m.getRowDimension()) / Math.log(2);
		this.m = m;
		tm.reset(m.getRowDimension());
		for (int index = 0; index < m.getRowDimension(); index++) {
			String b_str = Integer.toBinaryString(index);
			while (b_str.length() < qubits) {
				b_str = zero_string.concat(b_str);
			}
			tm.internalSetValueAt(b_str, index, 0);
			tm.internalSetValueAt(m.get(index, 0).real(), index, 1);
			tm.internalSetValueAt(m.get(index, 0).imag(), index, 2);
		}
		tm.fireTableDataChanged();
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int i = e.getFirstRow();
		Complex s = new Complex((Double) tm.getValueAt(i, 1),
				(Double) tm.getValueAt(i, 2));
		m.set(i, 0, s);
	}
}
