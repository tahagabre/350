import java.util.ArrayList;

public class Question implements java.io.Serializable {
	protected String question;
	String questionType = null;
	
	protected ArrayList<ResponseCorrectAnswer> responses;
	protected ResponseCorrectAnswer correctAnswer = null;

	Question(String question) {
		this.question = question;
		responses = new ArrayList<ResponseCorrectAnswer>();
	}
	
	// Should only be predetermined on MultipleChoice, Ranking, Matching
	// Otherwise, should call constructor at runtime
	public void AddResponse(ResponseCorrectAnswer response) {
		responses.add(response);
	}

	public void AddCorrectAnswer(ResponseCorrectAnswer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public ArrayList<ResponseCorrectAnswer> GetResponses() {
		return responses;
	}
	
	public ResponseCorrectAnswer GetCorrectAnswer() {
		return correctAnswer;
	}

	public void Display() {
		System.out.println(question);
	}

	public String GetQuestion() {
		return question;
	}
	
	public String GetQuestionType() {
		return questionType;
	}

}
