import java.util.ArrayList;

public class ResponseCorrectAnswer implements java.io.Serializable{
	String response = null;
	
	ResponseCorrectAnswer(String answer) {
		this.response = response;
	}
	
	ResponseCorrectAnswer() {
		
	}
	
	public String GetResponse() {
		return response;
	}
}
