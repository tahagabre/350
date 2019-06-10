
import java.util.ArrayList;
public class MultipleChoice extends TrueFalse {
	String[] questionPrefix = new String[] {"1. ", "2. ", "3. ", "4. "};
	private ArrayList<ResponseCorrectAnswer> options;
	
	MultipleChoice(String question, ArrayList<ResponseCorrectAnswer> options) {
		super(question);
		this.options = options;
		super.SetQuestionType("MultipleChoice");
	}
	
	public ArrayList<ResponseCorrectAnswer> GetOptions() {
		return options;
	}
	
	public void Display() {
		for ( int i = 0; i < options.size(); i++ ) {
			System.out.println(questionPrefix[i] + options.get(i).GetResponse() );
		}
	}
}
