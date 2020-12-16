package com.Sparta.Backend;

import java.time.LocalDate;

public class Trainee {
	
	private String firstName;
	private String lastName;
	private String stream;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Trainee() {}
	
	//First name
	public String getFirstName() {
		return this.firstName;
	} 
	public void setFirstName(String LastName) {
		this.firstName = LastName;
	}
	
	//Last name
	public String getLastName() {
		return this.lastName;
	} 
	public void setLastName(String LastName) {
		this.lastName = LastName;
	}
	
	//Stream
	public String getStream() {
		return this.stream;
	} 
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	//Start date
	public LocalDate getStartDate() {
		return this.startDate;
	} 
	public void setStartDate(LocalDate startDate) {
		//convert string to local date
		this.startDate = startDate;
	}
	
	//End Date
	public LocalDate getEndDate() {
		return this.endDate;
	} 
	public void setEndDate(LocalDate endDate) {
		//convert string to local date
		this.endDate = endDate;
	}
}
