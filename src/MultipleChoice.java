
import java.util.ArrayList;
public class MultipleChoice extends TrueFalse {
	String[] questionPrefix = new String[] {"A. ", "B. ", "C. ", "D. "};
	ArrayList<String> options;
	String questionType = null;
	
	MultipleChoice(String question, ArrayList<String> options) {
		super(question);
		this.options = options;
		questionType = "MultipleChoice";
	}
	
	public String GetQuestionType() {
		return questionType;
	}
	
	public ArrayList<String> GetOptions() {
		return options;
	}
}
