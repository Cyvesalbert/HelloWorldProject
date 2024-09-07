package ht.applet;

import java.awt.Graphics;

import javax.swing.JApplet;

//Applet that draws a String.
public class WelcomeApplet extends JApplet {
	// draw text on applet's background
	public void paint(Graphics g) {
		// call superclass version of method paint
		super.paint(g);
		
		// draw a String at x-coordinate 25 and y-coordinate 25
		g.drawString("Welcome to java programming", 25, 25);
	}

}
