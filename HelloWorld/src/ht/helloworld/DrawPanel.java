package ht.helloworld;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
	
//		g.drawLine(0, 0, width, height);
//		g.drawLine(0, height, width, 0);
		

		 int steps = 100; // Number of steps
	        int stepX = width / steps;
	        int stepY = height / steps;

	        // Top-left corner
	        int x1 = 0, y1 = 0;
	        int x2 = stepX, y2 = height;
	        while (x1 <= width && y2 >= 0) {
	            g.drawLine(x1, y1, x2, y2);
	            x1 += stepX;
	            y2 -= stepY;
	        }

	        // Top-right corner
	        x1 = width; y1 = 0;
	        x2 = width - stepX; y2 = height;
	        while (x1 >= 0 && y2 >= 0) {
	            g.drawLine(x1, y1, x2, y2);
	            x1 -= stepX;
	            y2 -= stepY;
	        }

	        // Bottom-left corner
	        x1 = 0; y1 = height;
	        x2 = stepX; y2 = 0;
	        while (x1 <= width && y2 <= height) {
	            g.drawLine(x1, y1, x2, y2);
	            x1 += stepX;
	            y2 += stepY;
	        }

	        // Bottom-right corner
	        x1 = width; y1 = height;
	        x2 = width - stepX; y2 = 0;
	        while (x1 >= 0 && y2 <= height) {
	            g.drawLine(x1, y1, x2, y2);
	            x1 -= stepX;
	            y2 += stepY;
	        }
	    

	}
	
	
}
