package com.eimacs.lab05gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.eimacs.lab05.APPoint;

public class TurtlePlane extends JPanel {
	private TurtleController myTurtleController;

	public TurtlePlane() {
		setBorder(BorderFactory.createLoweredBevelBorder());
		setBackground(Color.decode("0xEDFFED"));
		setPreferredSize(new Dimension(300, 400));
	}

	public void drawPlane() {
		repaint();
	}

	public void paintMe(Graphics g) {
		Turtle t = new Turtle();

		APPoint startPoint = t.getPosition();
		startPoint.setX(150);
		startPoint.setY(200);

		myTurtleController.getTurtleProgram().execute(t, g);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintMe(g);
	}

	public void setTurtleController(TurtleController tc) {
		myTurtleController = tc;
	}
} 