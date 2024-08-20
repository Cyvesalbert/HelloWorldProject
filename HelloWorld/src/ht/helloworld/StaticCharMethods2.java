package ht.helloworld;

import java.util.Scanner;

//Character class static conversion methods.
public class StaticCharMethods2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		// get radix
		System.out.println("Please enter a radix: ");
		int radix = scanner.nextInt();
		
		// get user choice
		System.out.printf( "Please choose one:\n1 -- %s\n2 -- %s\n", "Convert digit to character", "Convert character to digit" );
		int choice = scanner.nextInt();
		
		// process request
		switch(choice) {
		case 1: // convert digit to character
			System.out.println("Enter a digit: ");
			int digit = scanner.nextInt();
			System.out.printf("Convert digit to character: %S\n", Character.forDigit(digit, radix));
			break;
		case 2: // convert character to digit
			System.out.println("Enter a character");
			char character = scanner.next().charAt(0);
			System.out.printf("Convert Character to digit: %s\n", Character.digit(character, radix));
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
