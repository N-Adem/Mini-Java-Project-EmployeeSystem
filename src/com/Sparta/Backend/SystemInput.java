package com.Sparta.Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInput {
	
	private static InputStreamReader sr = new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(sr);
	
	 public static String InputToString(){
	        String inputWord = " ";
	        try{
	            inputWord = br.readLine();
	        }catch(IOException ioEx){
	            System.out.println("There was an issue with the char input " + ioEx);
	        }
	        return inputWord;
	    }
}
