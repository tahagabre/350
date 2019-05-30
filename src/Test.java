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
	
	public void AddCorrectAnswer(String answer) {
		correctAnswer.AddAnswer(answer);
	}
	
	public void AskForCorrectAnswer() {
		// Need to make this unique to each type of question
		for (int i = 0; i < GetQuestions().size(); i++ ) {
			Question currentQuestion = GetQuestions().get(i);
			System.out.println(currentQuestion.GetQuestionType());
			
//			switch (currentQuestion.GetQuestionType()) {
//			
//			}
		}
	}
	
	public String GetFormType() {
		return formType;
	}
	
}
