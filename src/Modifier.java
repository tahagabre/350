
/* Call super(true)
	For each question, ask if user wants to change prompt
	
	Then, conditional for each question:
		MultipleChoice, Ranking, and Matching, ask if user wants to change options
	
	If a Test, ask if user wants to change answer
	
 */
public class Modifier {
	private Survey survey;
	private Serializer serializer;
	
	Modifier(Survey survey) {
		this.survey = survey;
		serializer = new Serializer();
		
		ModifyQuestions();
		serializer.Save(survey);
	}
	
	private void ModifyQuestions() {
		for (Question q : survey.GetQuestions()) {
			System.out.println("Question Type: " + q.GetQuestionType());
			RequestPromptChange(q);
			// If MC, R, or M, ask for changes
			if (survey.GetFormType().equals("Test")) {
				RequestNewCorrectAnswer(q);
			}
		}
	}
	
	private void RequestPromptChange(Question question) {
		System.out.println("This question's prompt is: " + question.GetQuestion());
		System.out.println("Would you like to change this prompt? (y/n)");
		
		MainDriver.scanner.nextLine();
		String shouldChangePrompt = MainDriver.scanner.nextLine();
		switch (shouldChangePrompt) {
		case "y":
			SetNewPrompt(question);
			break;
		case "n":
			return;
		default:
			System.out.println("Invalid input: please input 'y' or 'n'.");
			RequestPromptChange(question);
			break;
		}
	}

	private void SetNewPrompt(Question question) {
		System.out.println("What would you like to change the prompt to?");
		MainDriver.scanner.nextLine();
		String newPrompt = MainDriver.scanner.nextLine();
		question.SetQuestion(newPrompt);
		System.out.println("New Prompt: " + question.GetQuestion());
	}
	
	private void RequestNewCorrectAnswer(Question question) {
		System.out.println("This question correct answer is: " + question.GetCorrectAnswer().GetResponse());
		System.out.println("Would you like to change this correct answer? (y/n)");
		
		MainDriver.scanner.nextLine();
		String shouldChangeCorrectAnswer = MainDriver.scanner.nextLine();
		switch (shouldChangeCorrectAnswer) {
		case "y":
			((Test)survey).SetCorrectAnswer(question);
			break;
		case "n":
			return;
		default:
			System.out.println("Invalid input: please input 'y' or 'n'.");
			RequestNewCorrectAnswer(question);
			break;
		}
	}
	
}
