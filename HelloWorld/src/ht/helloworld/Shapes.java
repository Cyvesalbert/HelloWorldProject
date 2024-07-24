package ht.helloworld;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Shapes extends JPanel {


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
        int height = getHeight();                                                                                                                                                          
        
		int centerX = width / 2;
        int centerY = height / 2;
        int numberOfCircles = 12;
        int radiusIncrement = 10;
        
        for (int i = 0; i < numberOfCircles; i++) {
            int radius = (i + 1) * radiusIncrement;
            int diameter = radius * 2;
            int upperLeftX = centerX - radius;
            int upperLeftY = centerY - radius;

            g.drawOval(upperLeftX, upperLeftY, diameter, diameter);
        }
		
	}
	
	
	
	
	
	
}




