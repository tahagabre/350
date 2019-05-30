import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;

public class MainDriver {
	
	static Scanner scanner = new Scanner(System.in);
	
	static Survey form = null;
	static Serializer serializer = new Serializer();
	
	public static void main(String[] args) {
		Start();
	}
	
	static void Start() {
		System.out.println("Would you like to create or load a survey? (c/l)");
		String response = scanner.next();
		
		ChooseOperation(response);
	}
	
	static void ChooseOperation(String operation) {
		String path = null;
		
		switch (operation) {
		case "c":
			RequestSurveyType();
			break;
			
		case "l":
			File folder = null;
			System.out.println("Would you like to load a Test or Survey? (t/s)");
			
			if (scanner.next().equals("s")) {
				folder = new File("./Surveys");
				path = "./Surveys/";
			}
			
			else if (scanner.next().equals("t")) {
				folder = new File("./Tests");
				path = "./Tests/";
			}
			
			else {
				System.out.println("Invalid input: Enter 't' or 's'");
				ChooseOperation("l");
			}
			
			System.out.println( folder.exists() );
			String[] filesInDirectory = folder.list();
			System.out.println("Select a file to load:");
			
			for (String file : filesInDirectory) {
				System.out.println(file);
			}
			
			String fileName = scanner.next();
			
			Survey survey = serializer.Load(path + fileName);
			break;
			
		default:
			System.out.println("Invalid input: Enter 'c' or 'l'");
			ChooseOperation(operation);
			break;
		}
	}
	
	static void RequestSurveyType() {
		System.out.println("Would you like a Survey or Test?");
		
		// Create Form
		String formType = scanner.next();
		
		if ( TestFormInput(formType) ) {
			System.out.println("What would you like to name your " + formType + "?");
			String name = scanner.next();
		
			CreateForm(formType, name);
		
			System.out.println("Would you like to save this Survey? (y/n)");
			String shouldSave = scanner.next();
			
			if ( shouldSave.equals("y") ) {
				serializer.Save(form, name);
			}
			
		}
		
		else {
			System.out.println("Invalid input: Select Survey or Test.");
			RequestSurveyType();
		}
	}
	
	static boolean TestFormInput(String input) {
		return input.equals("Survey") || input.equals("Test");
	}
	
	// Choose Survey/Test and start taking Questions
	static void CreateForm(String formType, String name) {
		switch (formType) {
		case "Survey":
			form = new Survey(name);
			break;
		case "Test":
			form = new Test(name);
			break;
		default:
			System.out.println("Please input Survey or Test");
			scanner.nextLine();
			formType = scanner.next();
			CreateForm(formType, name);
			break;
		}
	}
}
