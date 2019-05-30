
public class ShortAnswer extends Essay {
	private int capacity = 40;
	String questionType = null;
	
	ShortAnswer(String question) {
		super(question);
		questionType = "ShortAnswer";
	}
	
	public String GetQuestionType() {
		return questionType;
	}
}
