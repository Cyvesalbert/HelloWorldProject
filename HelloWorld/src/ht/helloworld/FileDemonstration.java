package ht.helloworld;

import java.io.File;
import java.util.Scanner;

//File class used to obtain file and directory information.
public class FileDemonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter file or directory name: ");
		System.out.println(File.separator);
		analyzePath(input.nextLine());
		
	}
	
	// display information about file user specifies
	public static void analyzePath(String path) {
		File name = new File(path); // create file object based on user input
		
		if(name.exists()) { // if name exists, output info about it
			// display file or directory info
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", name.getName(), " exists",
					( name.isFile() ? "is a file" : "is not a file" ),
					( name.isDirectory() ? "is a directory" : "is not a directory" ),
					( name.isAbsolute() ? "is absolute path" :"is not absolute path" ), 
					"Last modified: ", name.lastModified(), "Length: ", name.length() ,
					"Path: ", name.getPath() , "Absolute path: ", name.getAbsolutePath()
					, "Parent: ", name.getParent() );
			
			if(name.isDirectory()) { // output directory listing
				String[] directory = name.list();
				System.out.println("\n\nDirectory contents:\n");
 				
				for(String directoryName : directory) {
					System.out.println(directoryName);
				}
			}
			
		}else { // not file ore directory
			System.out.printf("%s %s ", path, "does not exist");
			
		}
		
		
	}
	
	
	

}
