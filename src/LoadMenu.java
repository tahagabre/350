
/*
 *  Called from Start.
 *  Ask if we are loading a survey or test
 *  Display all files in /Surveys or /Tests
 *  Call serializer.load with whatever user input
 *  
 *  Ask here for:
 *  	String fileName for file name
 *  	String formType so we know what directory
 *  
 *  Aggregation:
 *  	Serializer
 */
import java.io.*;

// Add Error case where we call super.Request when there are no files in selected directory
public class LoadMenu extends Menu {
	private Serializer serializer;
	
	private String directory = "";
	private String fileName = "";
	
	private Survey survey;
	
	LoadMenu(boolean calledBySpecialMenu) {
		
		if ( AreDirectoriesEmpty() ) {
			System.out.println("There are no files saved. Create and save a Survey/Test before using this operation.");
			super.MoveToNextMenu("B", null); 
		}
		
		serializer = new Serializer();
		
		RequestFormType();
		
		survey = serializer.Load(this.directory + this.fileName);
		System.out.println(survey.GetFormType() + " loaded.");
		
		if (!calledBySpecialMenu) {
			String nextMenu = super.RequestNextMenu();
			super.MoveToNextMenu(nextMenu, null);
		}
	}
	
	protected void RequestFormType() {
		System.out.println("Would you like to load a Survey or Test? (s/t)");
		String formType = MainDriver.scanner.next();
		boolean isEmpty = false;
		
		switch (formType) {
		case "s":
			this.directory += "./Surveys/";
			isEmpty = isDirectoryEmpty("s");
			break;
		case "t":
			this.directory += "./Tests/";
			isEmpty = isDirectoryEmpty("t");
			break;
		default:
			System.out.println("Invalid input: please input 's' or 't'.");
			directory = "";
			RequestFormType();
			break;
		}
		
		if (isEmpty) {
			System.out.println("There are no files in the system for the form you selected.");
			this.directory = "";
			RequestFormType();
		}
		
		else {
			System.out.println("Which of these files would you like to load?");
			DisplayDirectory(formType);
		}
	}
	
	protected void DisplayDirectory(String formType) {
		File directory;
		File[] filesInDir;
		
		switch (formType) {
		case "s":
			directory = new File("./Surveys/");
			filesInDir = directory.listFiles();
			
			for (File file : filesInDir) {
				System.out.println(file.getName());
			}
			
			break;
		case "t":
			directory = new File("./Tests/");
			filesInDir = directory.listFiles();
			
			for (File file : filesInDir) {
				System.out.println(file.getName());
			}
			
			break;
		default:
			System.out.println("Invalid input: please input 's' or 't'.");
			System.out.println("Would you like to load a Survey or Test? (s/t)");
			
			this.directory = "";
			formType = MainDriver.scanner.next();
			DisplayDirectory(formType);
			break;
		}
		
		this.fileName = MainDriver.scanner.next();
		ValidateFile(this.fileName);
	}
	
	protected void ValidateFile(String fileName) {
		File fileToLoad = new File(this.directory + this.fileName);
		
		if ( !fileToLoad.exists() ) {
			System.out.println("The system cannot find the file " + this.directory + this.fileName);
			this.fileName = "";
			RequestFormType();
		}
		
	}
	
	private boolean AreDirectoriesEmpty() {
		return ( isDirectoryEmpty("s") && isDirectoryEmpty("t") );
	}
	
	private boolean isDirectoryEmpty(String directory) {
		if (directory.equals("s")) {
			File surveys = new File("./Surveys/");
			File[] filesInSurveys = surveys.listFiles();
			return filesInSurveys.length == 0;
		}
		
		else {
			File tests = new File("./Tests/");
			File[] filesInTests = tests.listFiles();
			return filesInTests.length == 0;
		}
	}
	
	public Survey GetSurvey() {
		return survey;
	}
}
