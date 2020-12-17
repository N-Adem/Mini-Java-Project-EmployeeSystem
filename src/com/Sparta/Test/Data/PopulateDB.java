package com.Sparta.Test.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDB {
	
	
	/*//This methods adds user there trainee table via the statement approach.
	public void addTraineeToDb(String firstName, String lastName, String stream) {
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			String sqlAddUserQuery = "INSERT INTO trainee (first_name, last_name, stream, start_date, end_date)" 
					+ " VALUES ("+firstName+", "+ lastName+", "+stream+",'2020-09-03', '2020-12-03')";
					
			Statement state = connection.createStatement();
			int row = state.executeUpdate(sqlAddUserQuery);	
			if(row > 0) {
				System.out.print("A new user has been added to the table trainee");
			}	
		}catch(SQLException ex) {
			System.out.println("Error: not able to add user to trainee DB " + ex);
		}		
	} */
	

	//This method allows the user to add a new course to course db.  
	public static void addCourseToDb(Connection connection) {
		try {
			String sql = "INSERT INTO course (name, specialism, startDate, end_date)" 
					+ " VALUES ('C# course', 'development', '2020-09-03', '2020-12-03')";					
			Statement state = connection.createStatement();
			int row = state.executeUpdate(sql);	
			if(row > 0) {
				System.out.print("A new statement has been added.");
			}	
		}catch(SQLException ex) {
			System.out.println("Insert"); 
		}		
	} 
	
}
