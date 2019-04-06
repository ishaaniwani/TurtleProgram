package com.eimacs.lab05;

import java.awt.Graphics;

import com.eimacs.lab05gui.Turtle;

/**
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class TurnLeft extends Action {
	private double myAngle;

	public TurnLeft(double angle) {
		myAngle += angle;
	}

	public String toString() {
		return "Left " + myAngle;
	}

	public void execute(Turtle t, Graphics g) {
		t.setHeading(t.getHeading() - myAngle);
	}
}
