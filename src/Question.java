import java.util.ArrayList;

public class Question implements java.io.Serializable {
	protected String question;
	protected String questionType = null;
	protected ResponseCorrectAnswer response = null;
	protected ResponseCorrectAnswer correctAnswer = null;

	Question(String question) {
		this.question = question;
	}
	
	public void SetCorrectAnswer(ResponseCorrectAnswer rca) {
		this.correctAnswer = rca;
	}
	
	public ResponseCorrectAnswer GetCorrectAnswer() {
		return correctAnswer;
	}

	public void Display() {
		System.out.println(questionType + ": " + question);
	}
	
	public void SetQuestion(String questionPrompt) {
		this.question = questionPrompt;
	}
	
	public String GetQuestion() {
		return question;
	}
	
	protected void SetQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	public String GetQuestionType() {
		return questionType;
	}

}
