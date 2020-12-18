package com.Sparta.Client;

public class AppDisplayContent {

	
	public static void displayIntroduction() {		
		System.out.println(" ");
    	System.out.println("|-----------------------------------|");
	    System.out.println("|Welcome to the user employee system|");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|1.|Add a trainee to the system     |");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|2.|Load trinee information         |");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|3.|Update a trainees details       |");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|4.|Delete a trainee from system    |");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|5.|Exit program                    |");
	    System.out.println("|-----------------------------------|");
	   
	   	System.out.println(" ");	
	   	System.out.println("Instruction: To select from the menu please type an operation:");	
	}
	
	public static void displayUpdateFeatures() {		
		System.out.println("System: Which featrure Would you like to update?");
		System.out.println(" ");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|1.|First name                      |");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|2.|Last name                       |");
	    System.out.println("|-----------------------------------|");
	    System.out.println("|3.|Stream                          |");
	    System.out.println("|-----------------------------------|");
	   
	   	System.out.println(" ");	
	   	System.out.println("Instruction: To select from the menu please type an operation:");	
	}
	
	public static void displayTrainees() {
		System.out.println("----------------------[List of Trainees]-----------------------");
	}
}

