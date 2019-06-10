import java.util.ArrayList;

// Fills out a Survey/Test
public class Examiner {
	private Survey survey;
	private Serializer serializer;
	
	Examiner(Survey survey) {
		this.survey = survey;
		serializer = new Serializer();
		
		survey.Display();
		ArrayList<ResponseCorrectAnswer> rcas = TakeResponse();
		serializer.Save(rcas, survey.GetName());
	}
	
	private ArrayList<ResponseCorrectAnswer> TakeResponse() {
		// The responses we save in system
		ArrayList<ResponseCorrectAnswer> responses = 
				new ArrayList<ResponseCorrectAnswer>();
		
		for (Question q : survey.GetQuestions()) {
			System.out.println("Submit a response for question:");
			System.out.println( q.GetQuestion() );
			
			MainDriver.scanner.nextLine();
			String input = MainDriver.scanner.nextLine();
			ResponseCorrectAnswer userAnswer = CreateResponse(q, input);
			
			responses.add(userAnswer);
		}
		
		return responses;
	}
	
	private ResponseCorrectAnswer CreateResponse(Question question, String userResponse) {
		String answer;
		ResponseCorrectAnswer rca = null;
		
		switch ( question.GetQuestionType() ) {
		case "TrueFalse":
			
			String trueFalse = "";
			
			if (userResponse.equals("T") ) {
				trueFalse = ((TrueFalse) question).GetOptions(0);
			}
			else if (userResponse.equals("F")) {
				trueFalse = ((TrueFalse) question).GetOptions(1);
			}
			
			rca = new ResponseCorrectAnswer(trueFalse);
			break;
		case "MultipleChoice":
			question.Display();
			
			int choice = MainDriver.scanner.nextInt();
			
			ResponseCorrectAnswer correctAnswer = 
					( (MultipleChoice) question).GetOptions().get(choice - 1);
			
			break;
		case "Essay":
			rca = new ResponseCorrectAnswer(userResponse);
			break;
		case "ShortAnswer":
			rca = new ResponseCorrectAnswer(userResponse);
			break;
		case "Ranking":
			break;
		case "Matching":
			break;
		default:
			break;
		}
		
		return rca;
	}
}
