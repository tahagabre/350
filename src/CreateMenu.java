
/*
 * Request Survey Type
 * Create selected Survey Type
 * Ask for name
 * Ask to save
 * 
 * Dependencies:
 * 
*/

public class CreateMenu extends Menu {
	
	private Survey form = null;
	
	CreateMenu() {
		String formType = RequestSurveyType();
		CreateForm(formType);
		RequestSave();
	}
	
	private String RequestSurveyType() {
		System.out.println("Would you like a Survey or Test? (s/t)");
		
		// Create Form
		String formType = MainDriver.scanner.next();
		
		if ( !ValidFormInput(formType) ) {
			System.out.println("Invalid input: Select Survey or Test.");
			return RequestSurveyType();
		}
		
		return formType;

	}
	
	private boolean ValidFormInput(String input) {
		return input.equals("s") || input.equals("t");
	}
	
	private void CreateForm(String formType) {
		
		System.out.println("What would you like to name your " + formType + "?");
		String name = MainDriver.scanner.next();
		
		switch (formType) {
		
		case "s":
			form = new Survey(name);
			break;
		
		case "t":
			form = new Test(name);
			break;
		
		default:
			System.out.println("Please input Survey or Test");
			MainDriver.scanner.nextLine();
			formType = MainDriver.scanner.next();
			CreateForm(formType);
			break;
		}
	}
	
	private void RequestSave() {
		System.out.println("Would you like to save this Survey/Test? (y/n)");
		MainDriver.scanner.nextLine();
		String shouldSave = MainDriver.scanner.next();
		
		switch (shouldSave) {
		case "y":
			super.MoveToNextMenu("S", form);
			break;
		case "n":
			String nextMenu = super.RequestNextMenu();
			super.MoveToNextMenu(nextMenu, null);
			break;
		default:
			System.out.println("Invalid input. Please input 'y' or 'n'");
			RequestSave();
			break;
		}
	}
}
