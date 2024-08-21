package ht.helloworld;

import java.util.Scanner;

//StringTokenizer object used to tokenize strings.
public class TokenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//get Sentence
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sebtence and press enter");
		
		String sentence = scanner.nextLine();
		
		// process user sentence 
		String[] tokens = sentence.split(" ");
		System.out.printf("Number of elements: %d\nThe tokens are:\n", tokens.length);
		
		for(String token : tokens) {
			System.out.println(token);
		}
	
	}

}
