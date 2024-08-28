package ht.ch17;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Writing data to a sequential text file with class Formatter.
public class CreateTextFile {

	private static Formatter output; // object used to output text to file
	
	// enable user to open file
	public static void openFile(String fichier) {
		try {
			output = new Formatter(fichier); // open the file
		}catch(SecurityException securityException) {
			System.err.println("You do  not have write access to this file");
			System.exit(1); // terminate the program
		}catch(FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening or creating file");
			System.exit(1);
		}
	}
	
	// add records to file
	public void addRecords() {
		AccountRecord record = new AccountRecord();
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf( "%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ", "when you are prompted to enter input.",
				 "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter", "On Windows type <ctrl> z then press Enter" );
	    System.out.printf( "%s\n%s", "Enter account number (> 0), first name, last name and balance.", "? " );
	    
	    while(input.hasNext()) { // loop until end of file indicator
	    	try { // output values to file
	    		// retrieve data to be output
	    		record.setAccount(input.nextInt()); //  read account number
	    		record.setFirstName(input.next()); // read first name
	    		record.setLastName(input.next()); // read last name
	    		record.setBalance(input.nextDouble()); // read balance
	    		
	    		if(record.getAcccount() > 0) {
	    			// write new record
	    			output.format("%d %s %s %.2f\n", record.getAcccount(), record.getFirstName(), record.getLastName(), record.getBalance());
	    			System.out.println("Record added successfully");
	    		}else {
	    			System.out.println("Acount number must be greater than 0");
	    		}
	    	}catch(FormatterClosedException formatterClosedException) {
	    		System.err.println("Error writing to file");
	    		return;
	    	}catch(NoSuchElementException noSuchElementException) {
	    		System.err.println("Invalid input. please try again");
	    		input.nextLine(); // discard input so user can try again
	    	}
	    	
	    	System.out.printf( "%s %s\n%s", "Enter account number (>0),", "first name, last name and balance.", "? " );
	    }
	    
	    System.out.println("Thank you. bye bye!");
	    	    
	}
	
	// close file
	public void closeFile() {
		if(output != null)
			output.close();
	}
}
