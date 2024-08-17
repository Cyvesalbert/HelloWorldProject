package ht.helloworld;

//String methods startsWith and endsWith.
public class StringStartEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strings = { "started", "starting", "ended", "ending" };
		
		// test method startswith
		for(String string : strings) {
			if(string.startsWith("st"))
				System.out.printf("\"%s\" starts with \"st\"\n", string );
		}
		
		System.out.println();
		
		// test methods start with starting from position 2 of string
		for(String string : strings) {
			if(string.startsWith("art", 2))
					System.out.printf("\"%s\" starts with \"art\" at position 2\n", string );
		}
		
		System.out.println();
	
		// test methods endswith
		for(String string : strings) {
			if(string.endsWith("ed"))
				System.out.printf( "\"%s\" ends with \"ed\"\n", string );
		}
	}

}
