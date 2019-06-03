
import java.util.ArrayList;
public class MultipleChoice extends TrueFalse {
	String[] questionPrefix = new String[] {"1. ", "2. ", "3. ", "4. "};
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
	
	public void Display() {
		for ( int i = 0; i < options.size(); i++ ) {
			System.out.println(questionPrefix[i] + options.get(i) );
		}
	}
}
