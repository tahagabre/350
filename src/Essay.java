
public class Essay extends Question {
	String questionType = null;
	
	Essay(String question) {
		super(question);
		questionType = "Essay";
	}
	
	public String GetQuestionType() {
		return questionType;
	}
	
}
