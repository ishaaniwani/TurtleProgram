package com.eimacs.lab05gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.eimacs.lab05.MoveBack;
import com.eimacs.lab05.MoveForward;
import com.eimacs.lab05.TurnLeft;
import com.eimacs.lab05.TurnRight;
import com.eimacs.lab05.TurtleProgram;

/**
 *
 * @author IMACS Curriculum Development Group
 * @version 2.0 January 14, 2015
 */
public class TurtleController extends JPanel implements ActionListener {
	/** This TurtleController's program display area */
	private JTextArea myProgramDisplay;
	/** This TurtleController's program */
	private TurtleProgram myTurtleProgram;
	private TurtlePlane myTurtlePlane;

	/**
	 * Class constructor
	 */
	public TurtleController(TurtlePlane tp) {
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createRaisedBevelBorder());
		setBackground(Color.gray);
		setPreferredSize(new Dimension(180, 350));

		myTurtlePlane = tp;
		myTurtlePlane.setTurtleController(this);
		initialize();
	}

	/**
	 * Gets this TurtleController's program
	 * 
	 * @return this TurtleController's program
	 */
	public TurtleProgram getTurtleProgram() {
		return myTurtleProgram;
	}

	/**
	 * Overrides ActionListener's actionPerformed method
	 * 
	 * @param e the event provoking an action to be performed
	 */
	public void actionPerformed(ActionEvent e) {
		String actionName = e.getActionCommand();

		if ("Forward".equals(actionName)) {
			String input = getInput("How many steps?");
			if (input != null && !input.trim().equals("")) {
				int steps = Integer.parseInt(input);
				myTurtleProgram.addAction(new MoveForward(steps));
			}
		} else if ("Back".equals(actionName)) {
			String input = getInput("How many steps?");
			if (input != null && !input.trim().equals("")) {
				int steps = Integer.parseInt(input);
				myTurtleProgram.addAction(new MoveBack(steps));
			}
		} else if ("Left".equals(actionName)) {
			String input = getInput("How many steps?");
			if (input != null && !input.trim().equals("")) {
				double steps = Double.parseDouble(input);
				myTurtleProgram.addAction(new TurnLeft(steps));
			}
		} else if ("Right".equals(actionName)) {
			String input = getInput("How many steps?");
			if (input != null && !input.trim().equals("")) {
				double steps = Double.parseDouble(input);
				myTurtleProgram.addAction(new TurnRight(steps));
			}
		} else if ("Reset".equals(actionName)) {
			myTurtleProgram = new TurtleProgram();
		} else if ("Execute".equals(actionName)) {
			getTurtleProgram().setIsValid(true);
		} else {
			JOptionPane.showMessageDialog(this, actionName);
		}

		displayProgram();
		executeProgram(); 
	}

	/**
	 * The class initializer
	 */
	private void initialize() {
		myTurtleProgram = new TurtleProgram();

		// add action buttons
		String[] buttons = { "Forward", "Back", "Left", "Right" };
		for (String bName : buttons)
			addButton(bName);

		// add text area for displaying the program
		myProgramDisplay = new JTextArea(12, 10);
		myProgramDisplay.setEditable(false);
		JScrollPane areaScrollPane = new JScrollPane(myProgramDisplay);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(areaScrollPane);

		// add control buttons
		addButton("Execute");
		addButton("Reset");
	}

	/**
	 * Adds a button to this TurtleController
	 * 
	 * @param buttonName the name (and action command) of the button
	 */
	public void addButton(String buttonName) {
		JButton newButton = new JButton(buttonName);
		newButton.setActionCommand(buttonName);
		newButton.addActionListener(this);
		add(newButton);
	}

	public void displayProgram() {
		myProgramDisplay.setText(myTurtleProgram.toString());
	}

	private String getInput(String prompt) {
		return JOptionPane.showInputDialog(this, prompt);
	}

	public void executeProgram() {
		myTurtlePlane.drawPlane();
	}
}
