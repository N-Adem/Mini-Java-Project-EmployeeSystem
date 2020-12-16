package com.Sparta.Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*This class was created to handle all the system input and convert the read input to the
 *required data type. The class can handle all conversions from input to primitive data type including boolean.
 * */ 
public class SystemInput {
	
	private static InputStreamReader sr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(sr);
	
	//Converts the read input to a string.
	 public static String inputToString(){
	        String inputWord = " ";
	        try{
	            inputWord = br.readLine();
	        }catch(IOException ioEx){
	            System.out.println("There was an issue with the char input " + ioEx);
	        }
	        return inputWord;
	 }
	 
	 //Converts the read input to an integer
	 public static int inputToInt(){  
	        int inputToIntValue = 0;
	        try{
	            inputToIntValue = Integer.parseInt(br.readLine());
	            if(inputToIntValue > 0) {
	            	return inputToIntValue;
	            }
	        }catch(IOException ioEx){
	            System.out.println("There was an issue with the char input " + ioEx);
	        }
	        
	        return 0;
	 }
	 
}
