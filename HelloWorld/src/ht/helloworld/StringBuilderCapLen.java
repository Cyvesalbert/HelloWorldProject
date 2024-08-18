package ht.helloworld;

//StringBuilder length, setLength, capacity and ensureCapacity methods
public class StringBuilderCapLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//e StringBuilder constructor that takes a String argument initializes the capacity to the length of
		//the string passed as an argument plus 16.
		StringBuilder buffer = new StringBuilder("Hello, how are you?"); 
		System.out.printf( "buffer = %s\nlength = %d\ncapacity = %d\n\n", buffer.toString(), buffer.length(), buffer.capacity());
		
		buffer.ensureCapacity(75); // expands the capacity of the string builder
		System.out.printf( "New capacity = %d\n\n", buffer.capacity());
		
		buffer.setLength(10);
		System.out.printf( "New length = %d\nbuffer = %s\n", buffer.length(), buffer.toString() );
	}

}
