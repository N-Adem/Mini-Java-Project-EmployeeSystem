package com.Sparta.Client;

import com.Sparta.Network.PostgreSQL.*;
import com.Sparta.Backend.SystemFeatures;
import com.Sparta.Backend.SystemInput;
import com.Sparta.Backend.Trainee;

public class Main {
	
    public static void main(String[] args) {
    	boolean systemActive = true;
    	boolean programExit = false;
    	JDBCPostgreSqlConnection connect = new JDBCPostgreSqlConnection();
    	
    	//Test application to database connection.
    	connect.startConnection();
    	System.out.println("Some data");
    	
    	
    	System.out.println("|-----------------------------------|");
	    System.out.println("|Welcome To the user employee system|");
	    System.out.println("|-----------------------------------|");
	    
	    //Test Code: check to see if the functionality adds a trainee to the database.
	    System.out.println("Please enter first name:");
	    Trainee tempTrainee = new Trainee();
	    String firstName = SystemInput.InputToString();
	    System.out.println("The firstName typed is " + firstName);
	    tempTrainee.setFirstName(firstName);
	    System.out.println("Please enter last name:");
	    String lastName = SystemInput.InputToString();
	    System.out.println("The lastName typed is " + lastName);
	    tempTrainee.setLastName(lastName);
	    System.out.println("Please enter stream:");
	    String stream = SystemInput.InputToString();
	    System.out.println("The stream typed is " + stream);
	    tempTrainee.setLastName(stream);
	    
	    SystemFeatures.addTrainee(tempTrainee);
	    connect.closeConnection();
	    System.out.println("Program has ended.");
    }
    
    
    
}
