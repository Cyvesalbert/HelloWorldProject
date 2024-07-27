package ht.helloworld;

public class PayableInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Payable[] payableObjects = new Payable[4];
		
		
		payableObjects[ 0 ] = new Invoice( "01234", "seat", 2, 375.00 );
		
		payableObjects[ 1 ] = new Invoice( "56789", "tire", 4, 79.95 );
		
		payableObjects[ 2 ] = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );

		payableObjects[ 3 ] = new SalariedEmployee( "Lisa", "Barnes", "888-88-8888", 1200.00 );

		System.out.println("Invoices and Employees processed polymorphically:\n" );
		
		for(Payable currentPayable : payableObjects) {
			System.out.printf( "%s \n%s: $%,.2f\n\n", currentPayable.toString()
					, "payment due", currentPayable.getPaymentAmount() );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
