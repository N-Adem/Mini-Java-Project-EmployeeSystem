package com.Sparta.Test.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDB {
	
	private static final String cSharpDev = "insert into course (name, specialism, start_date, end_date)"
			+ "VALUES ('C# course', 'development', '04-01-2021', '26-02-2021')";
	private static final String cSharpTest = "insert into course (name, specialism, start_date, end_date)"
			+ "VALUES ('C# course', 'testing', '04-01-2021', '26-02-2021')";
	private static final String javaDev = "insert into course (name, specialism, start_date, end_date)"
			+ "VALUES ('Java course', 'development', '04-01-2021', '26-02-2021')";
	private static final String javaTest = "insert into course (name, specialism, start_date, end_date)"
			+ "VALUES ('Java course', 'testing', '04-01-2021', '26-02-2021')";
	private static final String dataCourse = "insert into course (name, specialism, start_date, end_date)"
			+ "VALUES ('Data course', 'data analysis', '04-01-2021', '26-02-2021')";
	private static final String ba = "insert into course (name, specialism, start_date, end_date)"
			+ "VALUES ('Business', 'business analyst', '04-01-2021', '26-02-2021')";
	
	
	//This method allows the user to add a new course to course db.  
	public static void addCoursesToDb(Connection connection) {
		try {			
			Statement statement = connection.createStatement();
			statement.addBatch(cSharpDev);
			statement.addBatch(cSharpTest);
			statement.addBatch(javaDev);
			statement.addBatch(javaTest);
			statement.addBatch(dataCourse);
			statement.addBatch(ba);
			int[] rowCount = statement.executeBatch();
			for(int row : rowCount) {
				System.out.println("System: Row number[" + row + "] added to the course database");
			}
		}catch(SQLException ex) {
			System.out.println("Insert"); 
		}		
	} 
	
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
	
}
