package com.Sparta.Client;

import com.Sparta.Backend.Trainee;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class MainTest {
	LocalDate startDate = LocalDate.now();
	DateTimeFormatter dateFormat;
	
	@Test
	void createTraineeAndCheckAvailability() {
		dateFormat = DateTimeFormatter.ofPattern("yyyy MM dd");
		startDate.format(dateFormat);
		Trainee trainee = new Trainee();	
		trainee.setFirstName("Jeff");
		trainee.setLastName("Jones");
		trainee.setCourse("java development");
		trainee.setStream("development");
		trainee.setStartDate(startDate);
		trainee.setEndDate(startDate.plusDays(30));	
		assertNotNull(trainee);
		assertEquals(true,trainee.checkValidStartDate(trainee.getStartDate()));
	}

	@Test
	void checkStartDate() {}
	
}
