package com.Sparta.Network.PostgreSQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class JDBCPostgreSqlConnect {
	
	private final String url = "jdbc:postgresql://localhost:5432/Sparta_Management";
	private final String user = "postgres";
	private final String password = "SpartaDB";
	
	public JDBCPostgreSqlConnect() {}
	
	//Starts the database session.
	public void startConnection() {
		try {			
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("Connection to the DB was successful.");			
		}catch(SQLException ex) {
			System.out.println("Error connecting to the database " + ex);
		}
	}
	
	//This method closes the database connection.
	public void closeConnection() {
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			connection.close();
			System.out.println("Connection successfully closed.");
		}catch(SQLException ex) {
			System.out.println("Database connection wasn't able to correctly close " + ex);
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
	
	/*
	//This method updates the course database.  
	public void addCourseToDb(Connection connection, String courseName, String specialality, 
			LocalDateTime startDate, LocalDateTime endDate) {
		try {
			String sql = "INSERT INTO Course (name, specialism, startDate, end_date)" 
					+ " VALUES ('C# course', 'development', '2020-09-03', '2020-12-03')";
					
			Statement state = connection.createStatement();
			int row = state.executeUpdate(sql);	
			if(row > 0) {
				System.out.print("A new statement has been added.");
			}	
		}catch(SQLException ex) {
			System.out.println("Insert");
		}		
	} */

	//End of class
}
