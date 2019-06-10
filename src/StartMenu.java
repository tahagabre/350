
/* 
 * Simply ask user what they would like to do
 * Based on player input, do that thing
 * Default menu, called on whenever each operation is complete
 */
//
public class StartMenu extends Menu{
	
	StartMenu() {
		String nextMenu = super.RequestNextMenu();
		super.MoveToNextMenu(nextMenu, null);
	}
	
}
