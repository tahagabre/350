import java.util.ArrayList;

public class Survey implements java.io.Serializable {
	
	protected ArrayList<Question> questions;
	protected String name;
	
	private String formType = "Survey";
	
	Survey(String name) {
		
		questions = new ArrayList<Question>();
		this.name = name;
		
		CreateQuestion();
	}
	
	// Empty Constructor 
	Survey() {
		questions = null;
		name = null;
	}
	
	public void AddQuestion(Question newQuestion) {
		questions.add(newQuestion);
		System.out.println("There are now " + questions.size() + " questions in this survey.");
	}
	
	public ArrayList<Question> GetQuestions() {
		return questions;
	}
	
	public String GetFormType() {
		return formType;
	}
	
	public String GetName() {
		return name;
	}
	
	public void Display() {
		switch (formType) {
		case "Survey":
			for (int i = 0; i < questions.size(); i++) {
				System.out.print("Question " + (i + 1) + ": ");
				questions.get(i).Display();
			}
			break;
		case "Test":
			( (Test) this).Display(true);
			break;
		}
		
	}
	
	// Need to add response to question
	private void CreateQuestion() {
		if ( TestFormInput(formType) ) {
			TakeQuestion();
		
			System.out.println("Finished adding question to your " + formType + ". Would you like to add another question? (y/n)");
			
			MainDriver.scanner.nextLine();
			
			if ( MainDriver.scanner.next().equals("y") ) {
				TakeQuestion();
			}
			
			else if ( MainDriver.scanner.next().equals("n") ) {
				System.out.println("Done with this " + formType);

				MainDriver.scanner.nextLine();
			}
			
		}
		
		else {
			System.out.println("Please input Survey or Test");
			formType = MainDriver.scanner.next();
			TakeQuestion();
		}
	}
	
	// Perhaps send to an input/output class
	private boolean TestFormInput(String input) {
		return input.equals("Survey") || input.equals("Test");
	}
	
	private void TakeQuestion() {
	
		System.out.println("What type of question would you like to create?");
		System.out.println("T/F, MultipleChoice, ShortAnswer, Essay, Matching, Ranking?");
		String questionType = MainDriver.scanner.next();
		String prompt;
		Question q;
		
		switch (questionType) {
			case "T/F":
				System.out.println("Please input question prompt");
				MainDriver.scanner.nextLine();
				prompt = MainDriver.scanner.nextLine();
								
				q = QuestionFactory.Create(questionType, prompt);
				AddQuestion(q);
				break;
				
			case "MultipleChoice":
				System.out.println("Please input question prompt");
				MainDriver.scanner.nextLine();
				prompt = MainDriver.scanner.nextLine();
				
				q = QuestionFactory.Create(questionType, prompt);
				AddQuestion(q);
				break;
				
			case "ShortAnswer":
				System.out.println("Please input question prompt");
				MainDriver.scanner.nextLine();
				prompt = MainDriver.scanner.nextLine();
				
				q = QuestionFactory.Create(questionType, prompt);
				AddQuestion(q);
				break;
				
			case "Essay":
				System.out.println("Please input question prompt");
				MainDriver.scanner.nextLine();
				prompt = MainDriver.scanner.nextLine();
				
				q = QuestionFactory.Create(questionType, prompt);
				AddQuestion(q);
				break;
				
			case "Matching":
				System.out.println("Please input question prompt");
				MainDriver.scanner.nextLine();
				prompt = MainDriver.scanner.nextLine();
				
				q = QuestionFactory.Create(questionType, prompt);
				AddQuestion(q);
				break;
				
			case "Ranking":
				System.out.println("Please input question prompt");
				MainDriver.scanner.nextLine();
				prompt = MainDriver.scanner.nextLine();;
				
				q = QuestionFactory.Create(questionType, prompt);
				AddQuestion(q);
				break;
				
			default:
				System.out.println("Please input T/F, MultipleChoice, ShortAnswer, Essay, Matching, Ranking");
				TakeQuestion();
		}
	}
	
}
