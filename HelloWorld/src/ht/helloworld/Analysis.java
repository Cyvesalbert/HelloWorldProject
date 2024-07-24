package ht.helloworld;

import java.util.Scanner;

public class Analysis {//

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int passes = 0;
		int failures = 0;
		int studentCounter = 1;
		
		Scanner input = new Scanner(System.in);
		int result;
		
		while (studentCounter <= 10) {
			System.out.print("Enter exam result (1 = pass, 2 = fail): ");
			result = input.nextInt();
			
			if(result == 1){
				passes = passes + 1;
			}else {
				failures = failures + 1;
			}
			
			studentCounter = studentCounter + 1;
		}
		
		System.out.printf("\nNumber of passes: %d\n", passes);
		System.out.printf("Number of failures: %d", failures);
		
		if(passes > 8)
			System.out.println("\nBonus to instructor!");
		
		
		
		
		
		
		
		
		
	}

}
