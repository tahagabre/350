import java.io.File;

/* 
 * Ask user what saved form they'd like to display
 * load + display
 */
public class DisplayMenu extends LoadMenu{
	
	private Serializer serializer;
	
	DisplayMenu() {
		super(true);
		Survey survey = super.GetSurvey();
		Display(survey);
		
		String nextMenu = super.RequestNextMenu();
		super.MoveToNextMenu(nextMenu, null);
		
	}
	
	private void Display(Survey survey) {
		// Print survey name
		System.out.println("Survey Name: " + survey.GetName());
		
		// Print all of surveys questions
		System.out.println("Questions: ");
		for (Question q : survey.GetQuestions()) {
			System.out.println(q.GetQuestion());
			if (!q.GetCorrectAnswer().GetResponse().equals(null)) {
				String correctAnswer = q.GetCorrectAnswer().GetResponse();
				System.out.println("Correct answer: " + correctAnswer);
			}
		}
	}

}
