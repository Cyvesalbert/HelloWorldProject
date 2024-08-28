package ht.ch17;

//Testing class ReadSequentialFile
public class ReadSequentialFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadSequentialFile application = new ReadSequentialFile();
		
		application.openFile("clients.txt");
		application.readRecords();
		application.closeFile();
	}

}
