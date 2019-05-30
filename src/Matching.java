import java.util.ArrayList;

public class Matching extends Ranking {
	private ArrayList<String> secondOptions;
	String questionType = null;
	
	Matching(String question, ArrayList<String> secondOptions) {
		super(question);
		this.secondOptions = secondOptions;
		questionType = "Matching";
	}
	
	public String GetQuestionType() {
		return questionType;
	}
}
