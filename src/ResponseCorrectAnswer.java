import java.util.ArrayList;

public class ResponseCorrectAnswer implements java.io.Serializable{
	ArrayList<String> rca;
	
	ResponseCorrectAnswer() {
		
	}
	
	public void AddAnswer(String answer) {
		rca.add(answer);
	}
}
