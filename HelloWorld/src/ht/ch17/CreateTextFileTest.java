package ht.ch17;

//Testing the CreateTextFile class
public class CreateTextFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreateTextFile application = new CreateTextFile();
		
		application.openFile("clients.txt");
		application.addRecords();
		application.closeFile();
	
	}

}
