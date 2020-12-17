package com.Sparta.Network.PostgreSQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.Sparta.Test.Data.PopulateDB;
import com.Sparta.Backend.SystemInput;

public class JDBCPostgreSqlConnection {
	
	private final String url = "jdbc:postgresql://localhost:5432/Sparta_Management";
	private final String user = "postgres";
	private final String password = "SpartaDB";
	private final String traineeDbName = "trainee";
	private Connection connection;
	public JDBCPostgreSqlConnection() {}
	
	//Starts the database session.
	public void startConnection() {
		try {			
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("System: Connection to the DB was successful.");			
		}catch(SQLException ex) {
			System.out.println("System: Error connecting to the database " + ex);
		}
	}
	
	//This method closes the database connection.
	public void closeConnection() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			connection.close();
			System.out.println("System: Connection successfully closed.");
		}catch(SQLException ex) {
			System.out.println("System: Database connection wasn't able to correctly close " + ex);
		}
	}
	
	//Select id from course to assign to trainee as a foreign key.
	public int generateForeignKey(String courseName) {
		try {
			connection = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = connection.prepareStatement("select id from course"
					+ "where name = ?");
			ps.setString(1, courseName);
			int courseId = ps.executeUpdate();
			if(courseId > 0) {
				System.out.println("Id succesfully otained, value: " + courseId);
			}else {
				System.out.println("Id wasn't successfully retrieved.");
			}
		}catch(SQLException ex) {
			System.out.println("Error: not able to execute command " + ex);
		}		
		return 1;
	}
	//-----------------------------------[Create feature]------------------------------------------------------------------------------------
	//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
	public void addTraineeToDb(String firstName, String lastName, String stream) {
		//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
		try {
			connection = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = connection.prepareStatement("insert into trainee (first_name, last_name, stream) "
					+ "values (?, ?, ?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, stream);
			//ps.setInt(4, courseId);
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
	//-----------------------------------[Read feature]------------------------------------------------------------------------------------
	//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
		public void readTraineeFromDb(String firstName, String lastName, String stream) {
			//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
			try {
				connection = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = connection.prepareStatement("insert into trainee (first_name, last_name, stream) "
						+ "values (?, ?, ?)");
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, stream);
				//ps.setInt(4, courseId);
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
	
		//-----------------------------------[Update feature]------------------------------------------------------------------------------------
		//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
			public void updateTraineeInDb(int updateSelection) {
				//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
				int selection = updateSelection;
				switch(selection) {
				case 1: 
				case 2:
				case 3:
				case 4:
					default: System.out.println("Your selection isn't valid please try again.");
				}
				try {
					connection = DriverManager.getConnection(url,user,password);
					PreparedStatement ps = connection.prepareStatement("update trainee set =''");
					//ps.setInt(4, courseId);
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
			//-----------------------------------[Delete feature]------------------------------------------------------------------------------------ 	
			//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
			public void deleteTraineeFromDb(String firstName, String lastName, String stream) {
				//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
				try {
					connection = DriverManager.getConnection(url,user,password);
					PreparedStatement ps = connection.prepareStatement("insert into trainee (first_name, last_name, stream) "
							+ "values (?, ?, ?)");
					ps.setString(1, firstName);
					ps.setString(2, lastName);
					ps.setString(3, stream);
					//ps.setInt(4, courseId);
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
			
	//Calls a method from test data which populates the course db with pre-written course data. 
	public void populateDB() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			PopulateDB.addCourseToDb(connection);
		}catch(SQLException ex) {
			System.out.println("");
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
	
	//End of class
}
