import java.io.*;

public class Serializer {
	
	Serializer() {}
	
	public void Save(Survey survey, String filename) {
		try {
	         FileOutputStream fileOut = null;
	         System.out.println( survey.GetFormType() );
	         
	         if ( survey.GetFormType().equals("Survey") ) {
	        	 fileOut = new FileOutputStream("./Surveys/" + filename);
	         }
	         
	         else if ( survey.GetFormType().equals("Test") ) {
	        	 fileOut = new FileOutputStream("./Tests/" + filename);
	         }
	         
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(survey);
	         out.close();
	         fileOut.close();
	      }
		
		catch (IOException error) {
	         error.getMessage();
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
}
