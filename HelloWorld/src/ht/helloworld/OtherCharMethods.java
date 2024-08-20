package ht.helloworld;

//Character class non-static methods.
public class OtherCharMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Character c1 = 'A';
		Character c2 = 'a';
		
		System.out.printf("c1 = %s\nc2 = %s\n\n" , c1.charValue(), c2.toString());
		
		if(c1.equals(c2))
			System.out.println("c1 and c2 are equal\n");
		else
			System.out.println("c1 and c2 are not equals");
	}

}
