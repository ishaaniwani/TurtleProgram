package com.eimacs.lab05;

import java.awt.Graphics;

import com.eimacs.lab05gui.Turtle;

/**
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class MoveBack extends Action {
	private int mySteps;

	public MoveBack(int steps) {
		mySteps += steps;
	}

	public String toString() {
		return "Back " + mySteps;
	}

	public void execute(Turtle t, Graphics g) {
		APPoint p = t.getPosition();
		double h = Math.toRadians(t.getHeading());

		APPoint newPoint = new APPoint(p.getX() - mySteps * Math.sin(h), p.getY() + mySteps * Math.cos(h));

		t.lineTo(newPoint, g);
	}
}
