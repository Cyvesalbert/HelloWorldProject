package ht.applet;

import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

//Applet that adds two double values entered via input dialogs.
public class AdditionApplet extends JApplet{

	private double sum; // sum of values entered by the user
	
	// initialize applet by obtaining values from user
	public void init() {
		// obtain first number from user
		String firstNumber = JOptionPane.showInputDialog("Enter first floatting point value");
		 
		// obtain second number from user
		String secondNumber	= JOptionPane.showInputDialog("Enter second floatting point value");
		
		// convert numbers from type String to type double
		double number1 = Double.parseDouble(firstNumber);
		double number2 = Double.parseDouble(secondNumber);
		
		sum = number1 + number2; // add numbers
	}
	
	// draw results in a rectangle on applet's background
	public void paint(Graphics g) {
		super.paint(g); // call superclass version of method paint
		
		// draw rectangle starting from 15,10 that is 270
		// pixels wide and 20 pixels tall
		g.drawString("The sum is ", 25, 25);
	}
}
