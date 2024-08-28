package ht.ch17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Writing objects sequentially to a file with class ObjectOutputStream.
public class CreateSequentialFile {
	
	public  static ObjectOutputStream output; // outputs data to file
	
	// allow user to specify file name
	public static void openFile(String fichier) {
		try { // open file
			output = new ObjectOutputStream(new FileOutputStream(fichier));
		}catch(IOException ioException) {
			System.err.println("Error opening file");
		}
	}
	
	// add records to file
	public void addRecords() {
		AccountRecordSerializable record; // object to be written to file
		int accountNumber = 0; // account number for record object
		String firstName; // first name for the record object
		String lastName; // last name for the record object
		double balance; // balance for the reord object
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf( "%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator ", "when you are prompted to enter input.",
				 "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter", "On Windows type <ctrl> z then press Enter" );
		System.out.printf( "%s\n%s", "Enter account number (> 0), first name, last name and balance.", "? " );
		
		while(input.hasNext()) {// loop until end of file indicator
			
			try { // output vues to file
				accountNumber = input.nextInt(); // read account number
				firstName = input.next(); // read first name
				lastName = input.next(); // read last name
				balance = input.nextDouble(); // read balance
				
				if(accountNumber > 0) {
					//create new record
					record = new AccountRecordSerializable(accountNumber, firstName, lastName, balance);
					output.writeObject(record);
				}else {
					System.out.println("Account number must be greater than 0")	;
				}
			}catch(IOException ioException) {
				System.err.println("error writing to file");
				return;
			}catch(NoSuchElementException elementException) {
				System.err.println("Invalid input. please try again");
				input.nextLine(); // discard input so user can try again
			}
			
			System.out.printf( "%s %s\n%s", "Enter account number (>0),", "first name, last name and balance.", "? " );
		}
	}
		
		// close file and terminate application
		public static void closeFile() {
			try { // close file
				if(output != null)
					output.close();
			}catch(IOException ioException) {
				System.err.println("Error closing file"	);
				System.exit(1);
			}
		
			
	}
	
}
