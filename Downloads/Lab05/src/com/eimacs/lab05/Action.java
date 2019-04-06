package com.eimacs.lab05;

import java.awt.Graphics;

import com.eimacs.lab05gui.Turtle;

/**
 *
 * @author IMACS Curriculum Development Group
 * @version 2.0 January 14, 2015
 */
public abstract class Action
{
    /**
     * Class constructor
     */
    public Action()
    {
    }  
    public abstract void execute( Turtle t, Graphics g );
}
