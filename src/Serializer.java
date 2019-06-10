import java.io.*;
import java.util.ArrayList;

public class Serializer {
	
	Serializer() {}
	
	public void Save(Survey survey) {
		try {
	         FileOutputStream fileOut = null;
	 
	         if ( survey.GetFormType().equals("Survey") ) {
	        	 
	        	 fileOut = new FileOutputStream("./Surveys/" + survey.GetName());
	         }
	         
	         else if ( survey.GetFormType().equals("Test") ) {
	        	 fileOut = new FileOutputStream("./Tests/" + survey.GetName());
	         }
	         
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(survey);
	         out.close();
	         fileOut.close();
	         System.out.println(survey.GetFormType() + " saved as " + survey.name);
	      }
		
		catch (IOException error) {
	         System.out.println(error.getMessage() );
	      }
	}
	
	public void Save(ArrayList<ResponseCorrectAnswer> rcas, String fileName) {
		try {
	         FileOutputStream fileOut = null;
	 
	         fileOut = new FileOutputStream("./Responses/" + fileName);
	         
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(rcas);
	         out.close();
	         fileOut.close();
	         System.out.println("RCA ArrayList saved as " + fileName);
	      }
		
		catch (IOException error) {
	         System.out.println(error.getMessage() );
	      }
	}
	
	public Survey Load(String filename) {
		try { 
			  
            // Reading the object from a file 
            FileInputStream file = null;
            file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
  
            Survey survey = (Survey)in.readObject(); 
            
            in.close(); 
            file.close(); 
            
            return survey;
		} 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught");
            System.out.println(ex.getMessage());
            return null;
        }
		
		catch (ClassNotFoundException classError) {
	         System.out.println("Survey class not found");
	         classError.printStackTrace();
	         return null;
      	}
	}
	
	public ArrayList<ResponseCorrectAnswer> LoadResponses(String filename) {
		try { 
            // Reading the object from a file 
            FileInputStream file = null;
            file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
  
            ArrayList<ResponseCorrectAnswer> responses = (ArrayList<ResponseCorrectAnswer>)in.readObject(); 
            
            in.close(); 
            file.close(); 
            
            return responses;
		} 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught");
            System.out.println(ex.getMessage());
            return null;
        }
		
		catch (ClassNotFoundException classError) {
	         System.out.println("Responses ArrayList class not found");
	         classError.printStackTrace();
	         return null;
      	}
	}
}
