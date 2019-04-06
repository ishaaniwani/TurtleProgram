package com.eimacs.lab05;

import java.awt.Graphics;

import com.eimacs.lab05gui.Turtle;

/**
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class TurnRight extends Action {
	private double myAngle;

	public TurnRight(double angle) {
		myAngle = angle;
	}

	public String toString() {
		return "Right " + myAngle;
	}

	public void execute(Turtle t, Graphics g) {
		t.setHeading(t.getHeading() + myAngle);
	}
}
