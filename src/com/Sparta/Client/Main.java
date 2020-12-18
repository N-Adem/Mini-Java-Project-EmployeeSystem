package com.Sparta.Client;

import com.Sparta.Network.PostgreSQL.*;
import com.Sparta.Backend.SystemFeatures;
import com.Sparta.Backend.SystemInput;
import com.Sparta.Backend.MenuSelect;
import com.Sparta.Backend.Trainee;


/*I have abstracted all the code logic to a client server architectural model, where I would 
 * the main only to be used for the programs main logic flow to be called. The client side should 
 * only handle display rendering and the applications main loop.
 * */
public class Main {
	
    public static void main(String[] args) {
    	boolean systemActive = true;
    	JDBCPostgreSqlConnection connect = new JDBCPostgreSqlConnection();
    	Trainee trainee;
    	//[Start state of the program connection to the db required before display.]
    	connect.startConnection();
    	  	
    	//Main application logic.
	    while(systemActive){    
	    	AppDisplayContent.displayIntroduction();
	    	MenuSelect option = SystemFeatures.menuOption();

	    	switch(option) {
	    	case INSERTTRAINEE:  
	    	    trainee = SystemFeatures.createTrainee();
	    		SystemFeatures.addTrainee(trainee);
	    		break;
	    	case READTRAINEE:
	    		AppDisplayContent.displayTrainees();
	    		connect.readTraineeFromDb();
	    		break;
	    	case UPDATETRAINEE:
	    		AppDisplayContent.displayUpdateFeatures();
	    		SystemFeatures.updateTrainee();
	    		break;
	    	case DELETETRAINEE:
	    		SystemFeatures.deleteTrainee();
	    		break;
	    	case EXITPROGRAM: 
	    		systemActive = SystemFeatures.endProgram();
	    		break;
	    	default: System.out.println("That command is invalid please try again.");
	    		break;
	    	}
	    	//End of application 
	    	if(systemActive == false) {
	    		break;	
	    	}    
	    }
	    //[Program has reached an exit state db connection ended].
	    System.out.println(" ");
	    connect.closeConnection();
    }
    
    
    
}
