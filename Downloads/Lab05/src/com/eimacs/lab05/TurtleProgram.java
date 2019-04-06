package com.eimacs.lab05;

import java.awt.Graphics;
import java.util.ArrayList;

import com.eimacs.lab05gui.Turtle;

/**
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class TurtleProgram {
	private ArrayList<Action> myActions;

	private boolean isValid;

	public TurtleProgram() {
		myActions = new ArrayList<Action>();
		isValid = false;
	}

	public void addAction(Action e) {
		isValid = false;
		myActions.add(e);
	}

	public String toString() {
		String str = "";
		if (myActions.size() != 0) {
			int i = 0;
			str += myActions.get(i).toString();
			if (myActions.size() != 0 || myActions.size() != 1) {
				for (i = 1; i < myActions.size(); i++) {
					str += "\n" + myActions.get(i).toString();
				}
			}
		}
		return str;
	}

	public void execute(Turtle t, Graphics g) {
		if (isValid) {
			for (Action e : myActions) {
				e.execute(t, g);
			}
		}
	}

	public void setIsValid(boolean valid) {
		isValid = valid;
	}
}
