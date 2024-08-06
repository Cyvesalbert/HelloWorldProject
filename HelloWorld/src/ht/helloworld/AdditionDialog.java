package ht.helloworld;

import javax.swing.JOptionPane;

public class AdditionDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// obtain user input from JOptionPane input dialog
		String firstNumber = JOptionPane.showInputDialog("Enter first Integer");
		String secondNumber = JOptionPane.showInputDialog("Enter second integer");

		//convert string inputs to int values for use in a calculation
		int number1 = Integer.parseInt(firstNumber);
		int number2 = Integer.parseInt(secondNumber);;
		
		int sum = number1 + number2;
		JOptionPane.showMessageDialog(null, "the sum is " + sum, "Sum of two integers", JOptionPane.PLAIN_MESSAGE) ;
	}

}
