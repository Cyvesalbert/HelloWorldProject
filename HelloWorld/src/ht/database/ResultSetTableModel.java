package ht.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

//A TableModel that supplies ResultSet data to a JTable.

//ResultSet rows and columns are counted from 1 and JTable
// rows and columns are counted from 0. When processing
// ResultSet rows or columns for use in a JTable, it is
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
public class ResultSetTableModel extends AbstractTableModel {

	private Connection connection;
	private java.sql.Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	
	// keep track of database connection status
	private boolean connectedToDatabase = false;
	
	// constructor initializez resultSet and obtains its metadata object;
	// Determines number of rows
	public ResultSetTableModel(String url, String userName, String password, String query) throws SQLException{
		// connect to database
		connection = DriverManager.getConnection(url, userName, password);
		
		// create statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		// update database connection status
		connectedToDatabase = true;
		
		// set query and execute it
		setQuery(query);
	}
	
	// get class that represents column type
	public Class getColumnClass(int column) throws IllegalStateException{
		// ensure database connection is available
		if(!connectedToDatabase)
			throw new IllegalStateException("Not connected to database");
		
		// determine java class of column
		try {
			String className = metaData.getColumnClassName(column + 1);
			
			// return class object that represents classname
			return Class.forName(className);
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return Object.class; // if poblems occur above, assume type Object
	}
	
	// get number of columns in resultset
	public int getColumnCount() throws IllegalStateException{
		// ensure database connection is available
		if(!connectedToDatabase)
			throw new IllegalStateException("Not connected to database");
	
		// determine number of columns
		try {
			return metaData.getColumnCount();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return 0; // if problems occur above, return 0 for number of columns
	}
	
	// get name of a particular column in resultset
	public String getColumnName(int column) throws IllegalStateException{
		// ensure databasetion is availale
		if(!connectedToDatabase) 
			throw new IllegalStateException("Not connected to database");
		
		// determine colum name
		try {
			return metaData.getColumnName(column + 1);
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return ""; // if problems return empty string for column name
	}
	
	// return number of rows in resultset
	public int getRowCount() throws IllegalStateException{
		// ensure database connection is available
		if(!connectedToDatabase)
			throw new IllegalStateException("Not connected to database");
			
		return numberOfRows;
	}
	
	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException{
		// ensure database connection is available
		if(!connectedToDatabase)
			throw new IllegalStateException( "Not Connected to Database" );

		// obtain a value at a specified ResultSet row and column
		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return ""; // if problems occur, return empty String object
	}
	
	// set new database query string 
	public void setQuery(String query) throws SQLException, IllegalStateException{
		// ensure database connection is available
		if(!connectedToDatabase)
			throw new IllegalStateException("Not connected to database");
		
		// specify query and execute it 
		resultSet = statement.executeQuery(query);
		
		// obtain meta data for resultSet
		metaData = resultSet.getMetaData();
		
		// determine number of rows in resultset
		resultSet.last(); // move to last row
		numberOfRows = resultSet.getRow(); // get row number
		
		// notify JTable that model has changed
		fireTableStructureChanged();
	}
	
	// close Statement and Connection
	public void disconnectFromDatabase(){
		if ( connectedToDatabase ){
			// close Statement and Connection
			try{
				resultSet.close();
				statement.close();
				connection.close();
			}catch ( SQLException sqlException ){
				sqlException.printStackTrace();
			}finally {// update database connection status
				connectedToDatabase = false;
			} // end finally
		} // end if
	} // end method disconnectFromDatabase
	
}
