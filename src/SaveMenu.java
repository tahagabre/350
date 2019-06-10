
/*
 *  Called on after a Survey/Test is created.
 *  Ask what the name of the file should be
 *  Call serializer.save with fileName
 *  
 *  Dependencies:
 *  	Survey/Test
 *  
 *  Aggregation:
 *  	Serializer
 */

public class SaveMenu extends Menu{
	private Serializer serializer;
	
	SaveMenu(Survey survey) {
		
		if ( survey == null ) {
			System.out.println("You must create a Survey/Test before saving.");
			super.MoveToNextMenu("B", null);
		}
		
		serializer = new Serializer();
		serializer.Save(survey);
		
		String nextMenu = super.RequestNextMenu();
		super.MoveToNextMenu(nextMenu, null);
	}
}
