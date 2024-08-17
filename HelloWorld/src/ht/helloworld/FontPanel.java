package ht.helloworld;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

// display String in different fonts and colors
public class FontPanel extends JPanel {

	// display string in differents fonts and colors
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// set  font to serif, bold, 12pt, and draw a string
		g.setFont(new Font("Serif", Font.BOLD, 12));
		g.drawString("Serif 12 point bold.", 20, 30);
		
		// set font to monospaced, italic, 24pt, and draw a string
		g.setFont( new Font( "Monospaced", Font.ITALIC, 24 ) );
		g.drawString( "Monospaced 24 point italic.", 20, 50 );
		
		// set font to SansSerif (Helvetica), plain, 14pt and draw a string
		g.drawString( "SansSerif 14 point plain.", 20, 70 );
		
		// set font to Serif (Times), bold/italic, 18pt and draw a string
		g.setColor( Color.RED );
		g.drawString( g.getFont().getName() + " " + g.getFont().getSize() + " point bold italic.", 20, 90 );
		
	}
	
	
	
}
