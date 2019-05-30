
public class TrueFalse extends Question {
	protected String[] options = new String[2];
	String questionType = null;
	
	TrueFalse(String question) {
		super(question);
		options[0] = "True";
		options[1] = "False";
		questionType = "TrueFalse";
	}
	
	public String GetQuestionType() {
		return questionType;
	}
}
