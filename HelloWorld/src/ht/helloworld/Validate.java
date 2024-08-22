package ht.helloworld;

import java.util.Scanner;

//Validate user information using regular expressions.
public class Validate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first name:");
		String firstName = scanner.nextLine();
		System.out.println("Please enter last Name:");
		String lastName = scanner.nextLine();
		System.out.println("Please enter address:");
		String address = scanner.nextLine();
		System.out.println("Please enter city:");
		String city = scanner.nextLine();
		System.out.println("Please enter state:");
		String state = scanner.nextLine();
		System.out.println("Please enter zip:");
		String zip = scanner.nextLine();
		System.out.println("Please enter phone:");
		String phone = scanner.nextLine();
		
		// validate user input and display error message
		System.out.println("\nvalidate result");
		
		if(!ValidateInput.validateFirstName(firstName))
			System.out.println("invalid first Name");
		else if(!ValidateInput.validateLastName(lastName))
			System.out.println("invalid last Name");
		else if(!ValidateInput.validateAddress(address))
			System.out.println("invalid address");
		else if(!ValidateInput.validateCity(city))
			System.out.println("invalid city");
		else if(!ValidateInput.validateState(state))
			System.out.println("invalid state");
		else if(!ValidateInput.validateZip(zip))
			System.out.println("invalid zip");
		else if(!ValidateInput.validatePhone(phone))
			System.out.println("invalid phone");
		else 
			System.out.println("valid input thank you");
		
		
	}

}
