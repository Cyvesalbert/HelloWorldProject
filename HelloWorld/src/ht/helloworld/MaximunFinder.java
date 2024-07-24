package ht.helloworld;

import java.util.Scanner;

public class MaximunFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 3 floating points values separated by spaces");
		
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		
		double result = maximum(number1, number2, number3);
		
		System.out.println("Maximun is : " + result);
	}

	
	public static double maximum(double x, double y, double z) {
		double maximumValue = Math.max(x, Math.max(y, z));
		
		return maximumValue;
	}
}
