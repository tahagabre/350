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
	
	public void Display() {
		super.Display();
		ArrayList<Question> questions = super.GetQuestions();
		System.out.println("Correct Answers:");
		for (int i = 0; i < questions.size(); i++) {
			System.out.println( questions.get(i).GetCorrectAnswer().GetResponse() );
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
			
			String answer;
			ResponseCorrectAnswer rca = null;
			
			// Call super.AddResponse(), check if the response lives in Survey or Test
			switch ( currentQuestion.GetQuestionType() ) {
			case "TrueFalse":
				System.out.println("What is the correct answer? (T/F");
				answer = MainDriver.scanner.next();
				String trueFalse = null;
				
				if (answer.equals("T") ) {
					trueFalse = ((TrueFalse) currentQuestion).GetOptions(0);
				}
				else if (answer.equals("F")) {
					trueFalse = ((TrueFalse) currentQuestion).GetOptions(1);
				}
				rca = new ResponseCorrectAnswer(trueFalse);
				currentQuestion.AddCorrectAnswer(rca);
				System.out.println(currentQuestion.GetCorrectAnswer().GetResponse());
				
				break;
			case "MultipleChoice":
				System.out.println("Which of these options? (1 - 4)");
				currentQuestion.Display();
//				int choice = MainDriver.scanner.nextInt();
//				currentQuestion.choices[choice]
				break;
			case "Essay":
				System.out.println("What is the correct answer?");
				answer = MainDriver.scanner.next();
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
	}
	
	public String GetFormType() {
		return formType;
	}
	
}