package ht.helloworld;

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
		
	}
	
	
	
}
