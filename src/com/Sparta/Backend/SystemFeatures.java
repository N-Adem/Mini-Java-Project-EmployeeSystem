package com.Sparta.Backend;

import com.Sparta.Backend.Trainee;
import com.Sparta.Network.PostgreSQL.JDBCPostgreSqlConnection;

/*This class was designed to handle all the main functionality of the program, where currently the CRUD operations
 * will be.*/
public class SystemFeatures {
	static JDBCPostgreSqlConnection dbConnection;
	
	public static void addTrainee(Trainee trainee) {
		dbConnection = new JDBCPostgreSqlConnection();
		dbConnection.addTraineeToDb(trainee.getFirstName(), trainee.getLastName(), trainee.getStream());
	}
	
	public static Trainee createTrainee() {
		Trainee tempTrainee = new Trainee();
	    System.out.println("Please enter first name:");
	    String firstName = SystemInput.inputToString();
	    System.out.println("The firstName typed is " + firstName);
	    tempTrainee.setFirstName(firstName);
	    System.out.println("Please enter last name:");
	    String lastName = SystemInput.inputToString();
	    System.out.println("The lastName typed is " + lastName);
	    tempTrainee.setLastName(lastName);
	    System.out.println("Please enter stream:");
	    String stream = SystemInput.inputToString();
	    System.out.println("The stream typed is " + stream);
	    tempTrainee.setStream(stream);
	    //tempTrainee.setCourse("C# course");
		return tempTrainee;
	}
	
	public static void updateTrainee() {
		int selection = SystemInput.inputToInt();
		System.out.println("What is the first name of the trainee?");
		String firstName = SystemInput.inputToString();
		dbConnection.updateTraineeInDb(selection, firstName);
	}
	
	public static void deleteTrainee() {
		System.out.println("System: Please type in the name of the person you want to delete");
		String name = SystemInput.inputToString();
		dbConnection.deleteTraineeFromDb(name);
	}
	
	//Gets called to end the program by returning a false flag.
	public static boolean endProgram() {
		System.out.println("System: Logging off .....");
		return false;
	}
	
	public static MenuSelect menuOption() {
		int option = SystemInput.inputToInt();
		switch(option) {
		case 1: return MenuSelect.INSERTTRAINEE;
		case 2: return MenuSelect.READTRAINEE;
		case 3: return MenuSelect.UPDATETRAINEE;
		case 4: return MenuSelect.DELETETRAINEE;
		case 5: return MenuSelect.EXITPROGRAM;
		}
		return null;
	}
	
}
