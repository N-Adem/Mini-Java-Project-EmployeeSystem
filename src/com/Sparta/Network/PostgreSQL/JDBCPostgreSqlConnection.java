package com.Sparta.Network.PostgreSQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class JDBCPostgreSqlConnection {
	
	private final String url = "jdbc:postgresql://localhost:5432/Sparta_Management";
	private final String user = "postgres";
	private final String password = "SpartaDB";
	private final String traineeDbName = "trainee";
	
	public JDBCPostgreSqlConnection() {}
	
	//Starts the database session.
	public void startConnection() {
		try {			
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("System: Connection to the DB was successful.");			
		}catch(SQLException ex) {
			System.out.println("System: Error connecting to the database " + ex);
		}
	}
	
	//This method closes the database connection.
	public void closeConnection() {
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			connection.close();
			System.out.println("System: Connection successfully closed.");
		}catch(SQLException ex) {
			System.out.println("System: Database connection wasn't able to correctly close " + ex);
		}
	}
	
	//Check whether a table exists in the Sparta_Management DB.
	private void tableExists(Connection connection, String tableName) {
		try {
			DatabaseMetaData dbm = connection.getMetaData();
			ResultSet tables = dbm.getTables(null, null, tableName, null);
			if (tables.next()) {
				System.out.println("Table exists");
			}
			else {
				System.out.println("Table doesn't exists");
			}
		}catch(SQLException ex) {
			System.out.println("Error accessing the database for table check " + ex);
		}		
	}
	
	//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
	public void addTraineeToDb(String firstName, String lastName, String stream) {
		//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = connection.prepareStatement("insert into trainee (first_name, last_name, stream) "
					+ "values (?, ?, ?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, stream);
			int rowValue = ps.executeUpdate();
			if(rowValue > 0) {
				System.out.println("Trainee successfully added to DB.");
			}else {
				System.out.println("Trainee wasn't successfully added to DB.");
			}
		}catch(SQLException ex) {
			System.out.println("Error: not able to add user to trainee DB " + ex);
		}		
	} 


	//End of class
}
