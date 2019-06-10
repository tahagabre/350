import java.util.ArrayList;

// Menu to invoke Examiner in response to User Input
public class ExaminerMenu extends LoadMenu {
	private Examiner examiner;
	
	ExaminerMenu() {
		super(true);
		Survey survey = super.GetSurvey();
		examiner = new Examiner(survey);
		
		String nextMenu = super.RequestNextMenu();
		super.RequestNextMenu();
	}
}
