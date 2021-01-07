package com.Sparta.Network.PostgreSQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.sql.Date;

import com.Sparta.Test.Data.PopulateDB;
import com.Sparta.Backend.SystemInput;

public class JDBCPostgreSqlConnection {
	
	private final String url = "jdbc:postgresql://localhost:5432/Sparta_Management";
	private final String user = "postgres";
	private final String password = "SpartaDB";
	private final String traineeDbName = "trainee";
	private Connection connection;
	PreparedStatement ps;
	ResultSet resultSet = null;
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
	public void addTraineeToDb(String firstName, String lastName, String stream, int foreignKey, 
			LocalDate startDate, LocalDate endDate) {
		//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
		try {
			Date sqlStartDate = Date.valueOf(startDate);
			Date sqlEndDate = Date.valueOf(endDate);
			connection = DriverManager.getConnection(url,user,password);
			PreparedStatement ps = connection.prepareStatement("insert into trainee (first_name, last_name, stream, course_id, "
					+ "start_date, end_date) "
					+ "values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, stream);
			ps.setInt(4, foreignKey);
			ps.setDate(5, sqlStartDate);
			ps.setDate(6, sqlEndDate);
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
		public void readTraineeFromDb() {
			//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
			try {
				connection = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = connection.prepareStatement("select * from trainee");
				//ps.setInt(4, courseId);
				ResultSet readResult = ps.executeQuery();
				while(readResult.next()) {
					System.out.println("first name: " + readResult.getString("first_name") + ", last name: " 
				+ readResult.getString("last_name") + ", stream: " + readResult.getString("stream"));
				}
			}catch(SQLException ex) {
				System.out.println("Error: not able to add user to trainee DB " + ex);
			}		
		} 
	
		//-----------------------------------[Update feature]------------------------------------------------------------------------------------
		//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
			public void updateTraineeInDb(int updateSelection, String firstName) {
				//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
				int selection = updateSelection;
				String text = " ";
				String notifyChange = " ";
				try {
					connection = DriverManager.getConnection(url,user,password);
					switch(selection) {
					case 1:
						System.out.println("Please type the new first name below: ");
						text = SystemInput.inputToString();
						ps = connection.prepareStatement("update trainee set first_name = ? where first_name = ?");
						notifyChange = "first name";
						break;
					case 2: 
						System.out.println("Please type the new last name below: ");
						text = SystemInput.inputToString();
						ps = connection.prepareStatement("update trainee set last_name = ? where first_name = ?");
						notifyChange = "last name";
						break;
					case 3:
						System.out.println("Please type the new stream below: ");
						text = SystemInput.inputToString();
						ps = connection.prepareStatement("update trainee set stream = ? where first_name = ?");
						notifyChange = "stream";
						break;
					default: System.out.println("Your selection isn't valid please try again.");
						break;
					}
					ps.setString(1, text);
					ps.setString(2, firstName);
					int rowValue = ps.executeUpdate();
					if(rowValue > 0) {
						System.out.println("Trainee's " + notifyChange + " been updated.");
					}else {
						System.out.println("Trainee wasn't successfully added to DB.");
					}
				}catch(SQLException ex) {
					System.out.println("Error: not able to add user to trainee DB " + ex);
				}		
			} 
			//-----------------------------------[Delete feature]------------------------------------------------------------------------------------ 	
			//This method like the one above adds a trainee to the trainee db, but via the prepared statement technique.
			public void deleteTraineeFromDb(String firstName) {
				//Note create a stream checker to then assign the right foreign key to the insert, also check that the null is correct per column.
				try {
					connection = DriverManager.getConnection(url,user,password);
					PreparedStatement ps = connection.prepareStatement("delete from trainee where first_name = ?");
					ps.setString(1, firstName);
					int rowValue = ps.executeUpdate();
					if(rowValue < 0) {
						System.out.println("Trainee wasn't successfully removed from db.");
					}else {
						System.out.println("Trainee wasn successfully removed from db.");
					}
				}catch(SQLException ex) {
					System.out.println("Error: not able to add user to trainee DB " + ex);
				}		
			} 
			
	//Calls a method from test data which populates the course db with pre-written course data. 
	public void populateDB() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			PopulateDB.addCoursesToDb(connection);
		}catch(SQLException ex) {
			System.out.println("");
		}
	
	}
	
	//Retrieves the start date from the database.
	public LocalDate retreiveStartDateFromDb(int traineeForeignKey) {
		LocalDate startDate = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
			String selectStartDateQuery = "select start_date from course where id = ?";
			PreparedStatement ps = connection.prepareStatement(selectStartDateQuery);
			ps.setInt(1, traineeForeignKey);
			this.resultSet = ps.executeQuery();
			if(this.resultSet.next()) {
				startDate = this.resultSet.getDate("start_date").toLocalDate();
				return startDate;
			}else {
				System.out.println("System: Start date wasn't retrieved from database properly.");
			}
		}catch(SQLException ex) {
			System.out.println("Error: Not able to rerieve start date from db. " + ex);
		}	
		return startDate;
	} 
	
	//Retrieves the start date from the database.
		public LocalDate retreiveEndDateFromDb(int traineeForeignKey) {
			LocalDate startDate = null;
			try {
				connection = DriverManager.getConnection(url,user,password);
				String selectStartDateQuery = "select end_date from course where id = ?";
				PreparedStatement ps = connection.prepareStatement(selectStartDateQuery);
				ps.setInt(1, traineeForeignKey);
				this.resultSet = ps.executeQuery();
				if(this.resultSet.next()) {
					startDate = this.resultSet.getDate("end_date").toLocalDate();
					return startDate;
				}else {
					System.out.println("System: End date wasn't retrieved from database properly.");
				}
			}catch(SQLException ex) {
				System.out.println("Error: Not able to rerieve end date from db. " + ex);
			}	
			return startDate;
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
