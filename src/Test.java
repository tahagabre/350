import java.util.ArrayList;

public class Test extends Survey {
	private String formType = "Test";
	private ResponseCorrectAnswer correctAnswer;
	
	Test(String name) {
		super(name);
		AskForCorrectAnswer();
	}
	
	// Empty Constructor
	Test() {
		super();
		correctAnswer = null;
		AskForCorrectAnswer();
	}
	
	public ArrayList<Question> GetQuestions() {
		return questions;
	}
	
	public ResponseCorrectAnswer GetCorrectAnswer() {
		return correctAnswer;
	}
	
	public void AskForCorrectAnswer() {
		// Need to make this unique to each type of question
		for (int i = 0; i < GetQuestions().size(); i++ ) {
			Question currentQuestion = GetQuestions().get(i);
			System.out.println("This Question Type: " + currentQuestion.GetQuestionType());
			
			String answer;
			ResponseCorrectAnswer rca = null;
			
			// Call super.AddResponse(), check if the response lives in Survey or Test
			switch ( currentQuestion.GetQuestionType() ) {
			case "TrueFalse":
				System.out.println("What is the correct answer?");
				answer = MainDriver.scanner.next();
				rca = new ResponseCorrectAnswer(answer);
				super.AddResponse(rca);
				break;
			case "MultipleChoice":
				System.out.println("Which of these options");
				GetQuestions().get(i).Display();
				break;
			case "Essay":
				System.out.println("What is the correct answer?");
				answer = MainDriver.scanner.next();
				rca = new ResponseCorrectAnswer(answer);
				super.AddResponse(rca);
				break;
			case "ShortAnswer":
				System.out.println("What is the correct answer?");
				answer = MainDriver.scanner.next();
				rca = new ResponseCorrectAnswer(answer);
				super.AddResponse(rca);
				break;
			case "Ranking":
				break;
			case "Matching":
				break;
			default:
				break;
			}
		}
	}
	
	public String GetFormType() {
		return formType;
	}
	
}
