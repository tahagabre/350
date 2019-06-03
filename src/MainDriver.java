import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;

public class MainDriver {
	
	static Scanner scanner = new Scanner(System.in);
//	static CreateMenu createMenu = new CreateMenu();
	static Survey form = null;
	static Serializer serializer = new Serializer();
	
	public static void main(String[] args) {
		Start();
	}
	
	static void Start() {
		System.out.println("c/l/d");
		String response = MainDriver.scanner.next();
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
			System.out.println("Survey or test? (s/t)");
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

			String[] filesInDirectory = folder.list();
			System.out.println("Select a file to load:");
			
			for (String file : filesInDirectory) {
				System.out.println(file);
			}
			
			String fileName = scanner.next();
			
			Survey survey = serializer.Load(path + fileName);
			System.out.println(survey);
			survey.Display();
			break;
			
		default:
			System.out.println("Invalid input: Enter 'c' or 'l'");
			ChooseOperation(operation);
			break;
		}
	}
	
	static void RequestSurveyType() {
		System.out.println("Would you like a Survey or Test? (t/s)");
		
		// Create Form
		String formType = scanner.next();
		
		if ( TestFormInput(formType) ) {
			System.out.println("What would you like to name your " + formType + "?");
			String name = scanner.next();
		
			CreateForm(formType, name);
		
			System.out.println("save? y/n");
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
		return input.equals("s") || input.equals("t");
	}
	
	// Choose Survey/Test and start taking Questions
	static void CreateForm(String formType, String name) {
		switch (formType) {
		case "s":
			form = new Survey(name);
			break;
		case "t":
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
