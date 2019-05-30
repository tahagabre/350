
public class Ranking extends Question {
	String questionType = null;
	
	Ranking(String question) {
		super(question);
		questionType = "Ranking";
	}
	
	public String GetQuestionType() {
		return questionType;
	}
}
