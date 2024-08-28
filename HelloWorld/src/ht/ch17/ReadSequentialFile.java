package ht.ch17;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//Reading a file of objects sequentially with ObjectInputStream
// and displaying each record.
public class ReadSequentialFile {

	private static ObjectInputStream input;
	
	// enable user to select file to open
	public static void openFile(String fichier) {
		try { // open file
			setInput(new ObjectInputStream(new FileInputStream(fichier)));
		}catch(IOException ioException) {
			System.err.println("error opening file");
		}
	}
	
	// read records from file
	public void readRecords() {
		AccountRecordSerializable record;
		System.out.printf( "%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance" );
		
		try { // input the values from the file
			while(true) {
				record = (AccountRecordSerializable) getInput().readObject();
				
				// display record contents
				System.out.printf( "%-10d%-12s%-12s%10.2f\n", record.getAcccount(), record.getFirstName(), record.getLastName(), record.getBalance() );
			}
		}catch(EOFException endOfFileException) {
			return; // end of file was reached
		}catch(ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object");
		}catch(IOException ioException) {
			System.err.println("error during read from file");
		}
		
		
	}
	
	// close file and terminate application
	public void closeFile() {
		try { // close file and exit
			if(getInput() != null)
				getInput().close();
		}catch(IOException ioException) {
			System.err.println("Error closing file");
			System.exit(1);
		}
	}

	public static ObjectInputStream getInput() {
		return input;
	}

	public static void setInput(ObjectInputStream input) {
		ReadSequentialFile.input = input;
	}
	
	
	
	
	
	
	
	
	
	
	
}
