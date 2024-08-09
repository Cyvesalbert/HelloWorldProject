package ht.helloworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame {

	private JPanel mousePanel; // panel in which mouse events will occur
	private JLabel statusBar; // label that displays event info
	
	// MouseTrackerFrame constructor sets up GUI and registers mouse event handlers
	public MouseTrackerFrame() {
		super("Desmonstrating Mouse events");
		 mousePanel = new JPanel(); // create panel
		 mousePanel.setBackground(Color.WHITE); // set background color
		 add(mousePanel, BorderLayout.CENTER); // add panel to JFrame
		 
		 statusBar = new JLabel("Mouse outside JPanel");
		 add(statusBar, BorderLayout.SOUTH); // add label to JFrame
		 
		 // create and register listener for mouse and mouse motion events
		 MouseHandler handler = new MouseHandler();
		 mousePanel.addMouseListener(handler);
		 mousePanel.addMouseMotionListener(handler);
		
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener{

		
		@Override
		public void mouseDragged(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Dragged at [%d, %d]", event.getX(), event.getY()));

		}

		@Override
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Moved at [%d, %d]", event.getX(), event.getY()));

			
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			// mouseListener event handlers handle event when mouse released immediately after press
			statusBar.setText(String.format("Clicked at [%d, %d]", event.getX(), event.getY()));
			
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Pressed at [%d, %d]", event.getX(), event.getY()));

		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Released at [%d, %d]", event.getX(), event.getY()));

			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Mouse entered at [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.GREEN);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Mouse outside JPanel");
			mousePanel.setBackground(Color.WHITE);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
