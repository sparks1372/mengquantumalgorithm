package GUI.ProblemEditor;

import Core.Problem.quantumproblem;

import java.io.File;

public interface problemeditor {

	/**
		 */
	public abstract void edit(quantumproblem quantumproblem);

	public abstract void loadFile(File file);

	public abstract void saveFile(File file);

}
