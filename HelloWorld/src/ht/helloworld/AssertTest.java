package ht.helloworld;

import java.util.Scanner;

public class AssertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 10");
		
		int number = input.nextInt();
		
		assert (number >= 0 && number <= 10) : "bad number " + number;
		
		System.out.printf("You enterd %d\n", number);
		
	}

}
