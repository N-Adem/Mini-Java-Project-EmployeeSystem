package com.Sparta;

import com.Sparta.Network.PostgreSQL.*;

public class Main {
	
	
    public static void main(String[] args) {
    	JDBCPostgreSqlConnect connect = new JDBCPostgreSqlConnect();
    	
    	//Test application to database connection.
    	connect.startConnection();
    	System.out.println("Some data");
    	connect.closeConnection();
    	
    	System.out.println("|-----------------------------------|");
	    System.out.println("|Welcome To the user employee system|");
	    System.out.println("|-----------------------------------|");
	    
    }
}
