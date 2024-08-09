package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

// demonstrating mouse clicks and distinguishing betweeen mouse buttons
public class MouseDetailsFrame extends JFrame {

	private String details; // String that is displayed in the status bar
	private JLabel statusBar; // JLabel that appears at bottom of windows
	
	// constructor sets title bar String and register mouse listener
	public MouseDetailsFrame() {
		super("mouse clicked and buttons");
		
		statusBar = new JLabel("click the mouse");
		add(statusBar, BorderLayout.SOUTH);
		addMouseListener(new MouseClickHandler()); // add handler
		
		
	}
	
	// inner class to handle mouse Events
	private class MouseClickHandler extends MouseAdapter{
		// handle mouse clicked event and determine which button was pressed
		public void mouseClicked(MouseEvent event) {
			int xPos = event.getX(); // get X position of mouse
			int yPos = event.getY(); // get Y position of mouse
			
			details = String.format("Clicked %d time(S)	", event.getClickCount());
			
			if(event.isMetaDown()) // right mouse button
				details += " with right mouse button";
			else if(event.isAltDown()) // middle mouse button
				details += " with center mouse button";
			else // left mouse button
				details += " with left mouse button";
			
			statusBar.setText(details);
				
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
