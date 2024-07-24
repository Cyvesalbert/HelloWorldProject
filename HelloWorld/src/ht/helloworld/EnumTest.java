package ht.helloworld;

import java.util.EnumSet;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("All books:\n");
		
		for(Book book : Book.values()) {
			System.out.printf("\"%-10s%-45s%s\\n", book, book.getTitle(), book.getCopyrightYear());
		}
		
		System.out.println( "\nDisplay a range of enum constants:\n" );
		
		for(Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
			System.out.printf( "%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear());
		}
		
		
	}

}
