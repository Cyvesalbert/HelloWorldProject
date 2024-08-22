package ht.ch17;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;

//This program reads a text file and displays each record.
public class ReadTextFile {

	private Scanner input; 
	
	//enable user to open file
	public void openFile() {
		try {
			input = new Scanner(new File("clients.txt"));
		}catch(FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file");
			System.exit(1);
		}
	}
	
	// read record from file
	public void readRecords() {
		AccountRecord record = new AccountRecord(); // object to be written to screen
		
		System.out.printf( "%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance" );
		
		try { // read records from file using Scanner object
			while(input.hasNext()) {
				record.setAccount(input.nextInt()); // read account number
				record.setFirstName(input.next()); // read first name
				record.setLastName(input.next()); // read last name
				record.setBalance(input.nextDouble()); // read balance
				
				// display record contents
				System.out.printf( "%-10d%-12s%-12s%10.2f\n", record.getAcccount(), record.getFirstName(), record.getLastName(), record.getBalance() );
			}
			
		}catch(NoSuchElementException elementException) {
			System.err.println("File improperly formed");
			input.close();
			System.exit(1);
		}catch(IllegalStateException stateException) {
			System.err.println("error reading form file");
			System.exit(1);
		}
		
	}
	
	// close file and terminate application
	public void closeFile() {
		if(input != null)
			input.close();
	}
	
	
	
}
