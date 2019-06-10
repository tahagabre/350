
public class TrueFalse extends Question {
	protected String[] options = new String[2];
	
	TrueFalse(String question) {
		super(question);
		options[0] = "True";
		options[1] = "False";
		super.SetQuestionType("TrueFalse");
	}
	
	public String GetOptions(int index) {
		return options[index];
	}
}
