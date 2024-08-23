package ht.ch17;

//Testing class CreateSequentialFile
public class CreateSequentialFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreateSequentialFile application = new CreateSequentialFile();
		
		application.openFile();
		application.addRecords();
		application.closeFile();
	}

}
