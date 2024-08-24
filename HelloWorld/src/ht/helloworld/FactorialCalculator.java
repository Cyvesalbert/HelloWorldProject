package ht.helloworld;

//Factorial calculations with a recursive method
import java.math.BigInteger;

//Recursive factorial method.
public class FactorialCalculator {
	
	// recursive method factorial ( assumes its parameter is >= 0
	public static long factorial(long number) {
		long result = 1;
		
		// iterative declaration of method factorial
		for(long i = number; i >= 1; i--) {
			result *= i;
		}
		
		return result;
	}

	// output factorials for values 0-21
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// calculate the factorials of 0 through 10
		for(int counter = 0; counter <= 10; counter++) {
			System.out.printf("%d! = %d\n", counter, factorial(counter));
		}
		
		
	}

}
