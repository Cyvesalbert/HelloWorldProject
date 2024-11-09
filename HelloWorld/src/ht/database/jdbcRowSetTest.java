package ht.database;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import com.sun.*;
// Sun's JdbcRowSet implementatio
//Displaying the contents of the Authors table using JdbcRowSet
public class jdbcRowSetTest {
	// JDBC driver name and database URL
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3307/books";
	static final String USERNAME = "root";
	static final String PASSWORD = "M02P@$$,MYSQL";
	
	// constructor connect to database. processes
	// results and displays in window
	public jdbcRowSetTest() {
		// connectto database books and query database
		try {
			// specify properties of jdbcrowset
			JdbcRowSet rowSet = new JdbcRowSet();
			rowSet.setUrl(DATABASE_URL); // set database url
			rowSet.setUsername(USERNAME); // set username
			rowSet.setPassword(PASSWORD); // set password
			rowSet.setCommand("SELECT * FROM Authors"); // set query
			rowSet.execute(); // execute query
			
			// process query resultsss
			ResultSetMetaData metaData = rowSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Authors table of books database:\n");
			
			// display rowset header
			for(int i = 1; i <= numberOfColumns; i++) {
				System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
				
			System.out.println();
			
			// display each row
			while(rowSet.next()){
				for(int j = 1; j <= numberOfColumns; j++)
					System.out.printf( "%-8s\t", rowSet.getObject( i ) );
				System.out.println();
				}
			
			// close the underlying resultset, statement and connection
			rowSet.close();
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
		// launch the application
		public static void main(String args[]) {
			jdbcRowSetTest application = new jdbcRowSetTest();
		}
	}
}
