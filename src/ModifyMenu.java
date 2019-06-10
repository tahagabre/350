
public class ModifyMenu extends LoadMenu{
	
	private Modifier modifier;
	
	ModifyMenu() {
		super(true);
		Survey survey = super.GetSurvey();
		
		modifier = new Modifier(survey);
		
		String nextMenu = super.RequestNextMenu();
		super.MoveToNextMenu(nextMenu, null);
	}
	
	
}
