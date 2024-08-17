package ht.helloworld;

// string class constructors
public class StringConstructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] charArray = { 'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y' };
		String s = new String("Hello");
		
		// using String constructors
		String s1 = new String();
		String s2 = new String(s);
		String s3 = new String(charArray);
		String s4 = new String(charArray, 6, 3);
		
		
		System.out.printf("s1 = %s\ns2 = %s\ns3 = %s\ns4 = %s\n", s1, s2, s3, s4 ); // display strings
	}

}
