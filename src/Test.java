import java.util.ArrayList;

public class Test extends Survey {
	private String formType = "Test";
	
	Test(String name) {
		super(name);
		AskForCorrectAnswer();
	}
	
	// Empty Constructor
	Test() {
		super();
		AskForCorrectAnswer();
	}
	
	public void Display(boolean shouldDisplayAnswer) {
		super.Display();
		ArrayList<Question> questions = super.GetQuestions();
		
		if (shouldDisplayAnswer) {
			System.out.println("Correct Answers:");
			for (int i = 0; i < questions.size(); i++) {
				System.out.println( questions.get(i).GetCorrectAnswer().GetResponse() );
			}
		}
	}
	
	public ArrayList<Question> GetQuestions() {
		return questions;
	}
	
	public void AskForCorrectAnswer() {
		// Need to make this unique to each type of question
		for (int i = 0; i < GetQuestions().size(); i++ ) {
			Question currentQuestion = GetQuestions().get(i);
			System.out.println(currentQuestion.GetQuestion());
			
			SetCorrectAnswer(currentQuestion);
			
		}
	}
	
	// May need to duplicate this to Survey for adding Responses.
	public void SetCorrectAnswer(Question question) {
		String answer;
		ResponseCorrectAnswer rca = null;
		
		switch ( question.GetQuestionType() ) {
		case "TrueFalse":
			System.out.println("What is the correct answer? (T/F)");
			MainDriver.scanner.nextLine();
			answer = MainDriver.scanner.nextLine();
			String trueFalse = null;
			
			if (answer.equals("T") ) {
				trueFalse = ((TrueFalse) question).GetOptions(0);
			}
			else if (answer.equals("F")) {
				trueFalse = ((TrueFalse) question).GetOptions(1);
			}
			
			rca = new ResponseCorrectAnswer(trueFalse);
			question.SetCorrectAnswer(rca);
			System.out.println(question.GetCorrectAnswer().GetResponse());
			
			break;
		case "MultipleChoice":
			System.out.println("Which of these options is the correct answer? (1 - 4)");
			question.Display();
			
			int choice = MainDriver.scanner.nextInt();
			ResponseCorrectAnswer correctAnswer = 
					( (MultipleChoice) question).GetOptions().get(choice - 1);
			question.SetCorrectAnswer(correctAnswer);
			break;
		case "Essay":
			System.out.println("What is the correct answer?");
			
			answer = MainDriver.scanner.nextLine();
			rca = new ResponseCorrectAnswer(answer);
			break;
		case "ShortAnswer":
			System.out.println("What is the correct answer?");
			answer = MainDriver.scanner.next();
			rca = new ResponseCorrectAnswer(answer);
			break;
		case "Ranking":
			break;
		case "Matching":
			break;
		default:
			break;
		}
	}
	
	public String GetFormType() {
		return formType;
	}
	
}