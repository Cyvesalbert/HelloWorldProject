package ht.ch17;

//Testing the ReadTextFile class.
public class ReadTextFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		ReadTextFile application = new ReadTextFile();
		
		application.openFile();
		application.readRecords();
		application.closeFile();
		
	}

}
