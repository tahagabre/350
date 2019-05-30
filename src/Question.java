import java.util.ArrayList;

public class Question implements java.io.Serializable{
	protected String question;
	String questionType = null;
	
	Question(String question) {
		this.question = question;
	}
	
	public void Display() {
		System.out.println(question);
	}
	
	public String GetQuestionType() {
		return questionType;
	}
	
}
