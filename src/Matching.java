import java.util.ArrayList;

public class Matching extends Ranking {
	private ArrayList<String> secondOptions;
	
	Matching(String question, ArrayList<String> secondOptions) {
		super(question);
		this.secondOptions = secondOptions;
		super.SetQuestionType("Matching");
	}
	
}
