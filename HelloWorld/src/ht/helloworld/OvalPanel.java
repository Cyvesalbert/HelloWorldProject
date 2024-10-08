package ht.helloworld;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

//A customized JPanel class.
public class OvalPanel extends JPanel {

	private int diameter = 10; // default diameter of 10
	
	// draw an oval of the specified diameter
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillOval(10, 10, diameter, diameter); // draw circle
	}
	
	// validate and set diameter then repaint
	public void setDiameter(int newDiameter) {
		// if diameter invalid, default to 10
		diameter = (newDiameter >= 0 ? newDiameter : 10);
		repaint(); // repaint panel
	}
	
	// used by layout manager to determine minimum size
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	
	
	
	
	
	
}
