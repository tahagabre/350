/* Dialogue-centric class, intended on communicating with the user and dynamically
	transitioning from one operation to the other
*/

public abstract class Menu {
	
	public String RequestNextMenu() {
		System.out.println("What would you like to do? Create, Display, Save, Load,"
				+ " Modify, Fill Out, Grade or Tabulate a Survey/Test?"
				+ "You may also Quit or Back to start menu.");
		System.out.println("C/D/S/L/M/F/G/T/B");
		
		String menu = MainDriver.scanner.next();
		return menu;
	}
	
	// Optional survey param for operations that are dependent on a Survey, such as Save
	// If operation is not dependent, pass null
	public void MoveToNextMenu(String menu, Survey survey) {
		switch (menu) {
		case "C":
			CreateMenu createMenu = new CreateMenu();
			break;
		case "D":
			DisplayMenu displayMenu = new DisplayMenu();
			break;
		case "S":
			// NEED to set currentSurvey outside of this function first to avoid NullPointerException
			SaveMenu saveMenu = new SaveMenu(survey);
			break;
		case "L":
			LoadMenu loadMenu = new LoadMenu(false);
			break;
		case "M":
			ModifyMenu modifyMenu = new ModifyMenu();
			break;
		case "F":
			ExaminerMenu examinerMenu = new ExaminerMenu();
			break;
		case "G":
			GradeMenu gradeMenu = new GradeMenu();
			break;
		case "T":
			TabulateMenu tabulateMenu = new TabulateMenu();
			break;
		case "Q":
			System.out.println("Done with this program. Exiting now.");
			return;
		case "B":
			StartMenu startMenu = new StartMenu();
			break;
		default:
			System.out.println("Please input 'C', 'D', 'S', 'L', "
					+ "'M', 'F', 'G', 'T', 'Q', or 'B'.");
			RequestNextMenu();
			break;
		}
	}
	
}
