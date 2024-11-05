package ht.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//Displaying the contents of the Authors table.
public class DisplayAuthors {

	// database url
	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3307/books";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null; // manages connection
		Statement statement = null; // query statement
		ResultSet resultSet = null; // manages results
		
		// connect to database books and query
		try { // establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, "root", "M02P@$$,MYSQL");
			
			// create statement for querying database
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery(
					"SELECT AuthorID, FirstName, LastName FROM Authors");
			
			
			// process query results
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Authors Table of books database:\n");
			
			for(int i = 1; i <= numberOfColumns; i++) {
				System.out.printf("%-8s\t", metaData.getColumnName(i));
				
			}
			
			System.out.println();
			
			while(resultSet.next()) {
				for(int i = 1; i <= numberOfColumns; i++) {
					System.out.printf( "%-8s\t", resultSet.getObject( i ) );
				}
				System.out.println();
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {// ensure resultSet, statement and connection are closed
			try{
				resultSet.close();
				statement.close();
				connection.close();
			}catch ( Exception exception ){
				exception.printStackTrace();
			} // end catch
			} // end finally
			
		}
}

