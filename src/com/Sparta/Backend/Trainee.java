package com.Sparta.Backend;

import com.Sparta.Network.PostgreSQL.JDBCPostgreSqlConnection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Trainee {
	
	private String firstName;
	private String lastName;
	private String stream;
	private String course;
	private LocalDate startDate;
	private LocalDate endDate;
	private int foreignKey;
   	private final int startDateMax = 3;
   	
   	private final Map<String, Integer> traineeForeignKey = new HashMap<String, Integer>(){{
   		put("c# developer", 2);
   		put("c# tester", 3);
   		put("java developer", 4);
   		put("java tester", 5);
   		put("data analyst", 6);
   		put("business analyst", 7);
   	}};
   	
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
	
	//Stream
	public String getCourse() {
		return this.course;
	} 
	public void setCourse(String course) {
		this.course = course;
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
	
	//Foreign key
	public int getForeignKey() {
		return this.foreignKey;
	}	
	public void setForeignKey(String course) {
		if(this.traineeForeignKey.get(course) != null && 
				this.traineeForeignKey.get(course) > 0) {
			this.foreignKey = this.traineeForeignKey.get(course);
			System.out.println("The value is = " + this.foreignKey);
		}else {
			System.out.println("System: the value can't be retrieved");
		}		
	}
	
	//This method checks whether the trainees start date is valid.
    public boolean checkValidStartDate(LocalDate startDate) {	
    	//Temporary start date retrieve start date from database once set.
    	LocalDate courseStartDate = LocalDate.of(2021, 1, 4);
    	long lengthOfDays = ChronoUnit.DAYS.between(courseStartDate, startDate);
    	if(lengthOfDays <= startDateMax) {
    		return true;
    	}else {
    		return false;	
    	}
    }   

    
}
