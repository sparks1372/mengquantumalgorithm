/**
 * @Author = Sam Ratcliff
 */
package Core.CircuitEvolution.QPace4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Core.CircuitEvolution.QPace4.terminal.Instruction;

/**
 * @author Sam Ratcliff
 * 
 */
public class Params_Writer {

	private FileWriter			out;
	private final String		fname;
	private static final String	parent_line				= "parent.0 = QPACE4/basic_functionset.params";
	private static final String	fixed_line_1			= "gp.fs.size = 1";
	private static final String	fixed_line_2			= "gp.fs.0.size = ";
	private static final String	fixed_line_3			= "gp.fs.0.func.";
	private static final String	fixed_line_4			= "generations = ";
	private static final String	fixed_line_5			= "pop.subpop.0.size = ";
	private static final String	fixed_line_6			= "breedthreads = ";
	private static final String	fixed_line_7			= "evalthreads = ";

	private static final String	fixed_eqal				= " = ";
	private static final String	fixed_instr				= Instruction.class
																.getName();
	private static final String	fixed_node_constraint	= ".nc";
	private static final String	fixed_dot				= ".";
	private static final String	fixed_nc_instr			= "terminalinst";
	private static final int	base_node_count			= 24;

	/**
	 * @param filename
	 * @throws IOException
	 */
	public Params_Writer(String filename) throws IOException {
		fname = filename;
	}

	public void updateParams(boolean[] avail_gates, int gen, int pop, int bth,
			int eth) {
		int true_count = 0;
		for (boolean avail_gate : avail_gates) {
			if (avail_gate) {
				true_count++;
			}
		}

		int node_count = base_node_count + true_count;
		int current_node = base_node_count;

		try {
			out = new FileWriter(fname);
			BufferedWriter osw = new BufferedWriter(out);
			osw.write(parent_line);
			osw.newLine();
			osw.write(fixed_line_1);
			osw.newLine();
			osw.write(fixed_line_4);
			osw.write(Integer.toString(gen));
			osw.newLine();
			osw.write(fixed_line_5);
			osw.write(Integer.toString(pop));
			osw.newLine();
			osw.write(fixed_line_6);
			osw.write(Integer.toString(bth));
			osw.newLine();
			osw.write(fixed_line_7);
			osw.write(Integer.toString(eth));
			osw.newLine();
			osw.write(fixed_line_2);
			osw.write(Integer.toString(node_count));
			osw.newLine();
			osw.write("select.tournament.size = ");
			int t = (int) Math.ceil(0.01 * pop);
			t = t < 5 ? 5 : t;
			osw.write(Integer.toString(t));
			osw.newLine();
			osw.write("breed.elite.0 =  ");
			osw.write(Integer.toString((int) Math.ceil(0.001 * pop)));
			osw.newLine();

			for (int index = 0; index < avail_gates.length; index++) {
				if (avail_gates[index]) {

					osw.write(fixed_line_3);
					osw.write(Integer.toString(current_node));
					osw.write(fixed_eqal);
					osw.write(fixed_instr);
					osw.newLine();
					osw.write(fixed_line_3);
					osw.write(Integer.toString(current_node));
					osw.write(fixed_node_constraint);
					osw.write(fixed_eqal);
					osw.write(fixed_nc_instr);
					osw.newLine();
					osw.write(fixed_line_3);
					osw.write(Integer.toString(current_node));
					osw.write(fixed_dot);
					osw.write(Instruction.INST_ID);
					osw.write(fixed_eqal);
					osw.write(Integer.toString(index));
					osw.newLine();
					current_node++;
				}

			}

			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}