package ht.helloworld;

public class UsingChainedExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			method1();
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		
		
	}

	public static void method1() throws Exception{
		try {
			method2();
		}catch(Exception exception) {
			throw new Exception("Exception thrown in method1", exception);
		}
	}
	
	public static void method2() throws Exception{
		try {
			method3();
		}catch(Exception exception) {
			throw new Exception("Exception thrown in method2", exception);
		}
	}
	
	public static void method3() throws Exception{
		throw new Exception("Exeption thrown in method3");
	}
	
}
