package com.Sparta.Backend;

import com.Sparta.Backend.Trainee;
import com.Sparta.Network.PostgreSQL.JDBCPostgreSqlConnection;

public class SystemFeatures {

	static JDBCPostgreSqlConnection dbConnection;
	
	public static void addTrainee(Trainee trainee) {
		dbConnection = new JDBCPostgreSqlConnection();
		dbConnection.addTraineeToDb(trainee.getFirstName(), trainee.getLastName(), trainee.getStream());
	}
	
	
}
