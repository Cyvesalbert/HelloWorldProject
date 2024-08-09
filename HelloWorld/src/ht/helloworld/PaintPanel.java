package ht.helloworld;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

// using class MoueMotionAdapter
public class PaintPanel extends JPanel {

	private int pointCount = 0; // count number of points
	
	// array of 10000 java.awt.point references
	private Point[] points = new Point[10000];
	
	// set up GUI and register mouse event handler
	public PaintPanel() {
		// handle frame mouse  motion event
		addMouseMotionListener(
				new MouseMotionAdapter() { // anonymous inner class
					// store drag coordinates and repaint
					public void mouseDragged(MouseEvent event) {
						if(pointCount < points.length) {
							points[pointCount] = event.getPoint(); // find point
							++pointCount; // increment number of points in array
							repaint();
						}
					}
				}
				
				);
	}
	
	// draws ovals in a 4 by 4 bounding box at a specified locations on windows
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clears drawing area
		
		// draw all points in array
		for(int i = 0; i < pointCount; i++) {
			g.fillOval(points[i].x, points[i].y, 4, 4);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
