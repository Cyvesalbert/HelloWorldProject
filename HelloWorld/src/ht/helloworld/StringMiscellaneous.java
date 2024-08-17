package ht.helloworld;

// This application demonstrates the length, charAt and getChars
// methods of the String class.
public class StringMiscellaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "hello there";
		char[] charArray = new char[5];
		
		System.out.printf("s1: %s", s1);
		
		// test length method
		System.out.printf("\nlength of s1: %d", s1.length());
		
		// loop through characters in s1 with chartat and display reversed
		System.out.print("\nThe string reversed is: ");
		
		for(int count = s1.length() - 1; count >= 0; count--) {
			System.out.printf("%c ", s1.charAt(count));
		}
		
		// copy characters from string into chararray
		s1.getChars(0, 5, charArray, 0);
		System.out.print("\n the character array is: ");
		
		for(char character : charArray) {
			System.out.print(character);
		}
		
		System.out.println();
		}

}
