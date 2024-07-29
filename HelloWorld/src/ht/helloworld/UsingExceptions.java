package ht.helloworld;

public class UsingExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			throwException();
		}catch(Exception exception) {
			System.err.println("Exception handled in main");		
		}
		doesNotThrowException();
			
	
	
	}
	
	public static void throwException() throws Exception{
		try {
			System.out.println("Method throwException");
		}catch(Exception exception) {
			System.err.println("Exception handled in method throwException");
			throw exception;
			
			//code here would not be reach would cause compilation error
			
		}finally {
			System.err.println("finally executed in throwException");
		}
		// code here would not be reached; would cause compilation errors
	}
	
	public static void doesNotThrowException() {
		try {
			System.out.println("Method doesNotThrowException");
		}catch(Exception exception) {
			System.err.println(exception);
		}finally {
			System.err.println("Finally executed in doesNotThrowException");
		}
		
		System.out.println("End of method doesNotThrowException");
	}

}
