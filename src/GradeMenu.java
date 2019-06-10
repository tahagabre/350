import java.io.File;
import java.util.ArrayList;

// Will only search in Tests folder
public class GradeMenu extends Menu {
	private Serializer serializer;
	private Grader grader;
	
	private Test test;
	private ArrayList<ResponseCorrectAnswer> responses;
	
	GradeMenu() {
		
		if ( DirectoryIsEmpty() ) {
			System.out.println("There are no Tests to grade. Create and save a Test before trying to Grade.");
			super.MoveToNextMenu("B", null); 
		}
		
		serializer = new Serializer();
		String fileName = RequestFileName();
		
		test = (Test) serializer.Load("./Tests/" + fileName);
		responses = serializer.LoadResponses("./Responses/" + test.GetName());
		
		grader = new Grader(test, responses);
		
		String nextMenu = super.RequestNextMenu();
		super.MoveToNextMenu(nextMenu, null);
	}
	
	private String RequestFileName() {
		System.out.println("Which of these Tests would you like to grade?");
		DisplayTestDirectory();
		
		MainDriver.scanner.nextLine();
		String file = MainDriver.scanner.nextLine();
		
		ValidateFile(file, "./Tests/");
		ValidateFile(file, "./Responses/");
		
		return file;
	}
	
	protected void ValidateFile(String filePath, String folder) {
		File fileToLoad = new File(folder + filePath);
		
		if ( !fileToLoad.exists() ) {
			System.out.println("The system cannot find the file " + filePath);
			RequestFileName();
		}
		
	}
	
	private void DisplayTestDirectory() {
		File directory = new File("./Tests/");
		File[] filesInDir = directory.listFiles();
		
		for (File file : filesInDir) {
			System.out.println(file.getName());
		}
	}
	
	private boolean DirectoryIsEmpty() {
		File tests = new File("./Tests/");
		File[] filesInTests = tests.listFiles();
		return filesInTests.length == 0;
	}
}
