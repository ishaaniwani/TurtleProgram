package com.eimacs.lab05gui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author IMACS Curriculum Development Group
 * @version 2.0 January 14, 2015
 */
public class TurtleWindow extends JFrame
{
    /** This TurtleWindow's TurtleController */
    private TurtleController myTurtleController;
    
    private TurtlePlane myTurtlePlane; 
    
    /**
     * Class constructor
     */
    public TurtleWindow()
    {
        super( "AP Lab 05" );
        myTurtlePlane = new TurtlePlane();
        myTurtleController = new TurtleController(myTurtlePlane);
        
        initialize();
    }
    
    /**
     * The class initializer
     */
    private void initialize()
    {
        JPanel layoutPanel = new JPanel();
        layoutPanel.setLayout( new FlowLayout() );
        layoutPanel.add( myTurtleController );
        
        layoutPanel.add( myTurtlePlane );
        
        getContentPane().add( layoutPanel );
        
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        pack();
        setSize( 500, 440 );
        setLocationRelativeTo( null );
        setVisible( true );
    }
}
