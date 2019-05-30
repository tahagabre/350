import java.util.ArrayList;
import java.util.Scanner;

class QuestionFactory {
	private static Scanner scanner = new Scanner(System.in);
	
	QuestionFactory() {}
	
	public static Question Create(String questionType, String prompt) {
		Question question = null;
		
		switch (questionType) {
			case "T/F":
				System.out.println("About to create a TrueFalse");
				question = new TrueFalse(prompt);
				System.out.println("TrueFalse Created");
				break;
			
			case "MultipleChoice":
				int index = 0;
				int choicesQuantity;
				
				System.out.println("How many choices do you want for this question?");
				choicesQuantity = scanner.nextInt();
				ArrayList<String> choices = new ArrayList<String>();
				
				while ( choices.size() < choicesQuantity ) {
					System.out.println("Enter choice #" + (choices.size() + 1) );
					choices.add( scanner.next() );
					index ++;
				}
				question = new MultipleChoice(prompt, choices);
				System.out.println("MultipleChoice Created");
				break;
			case "Essay":
				System.out.println("About to create a Essay");
				question = new Essay(prompt);
				System.out.println("Essay Created");
				break;
			case "ShortAnswer":
				System.out.println("About to create a ShortAnswer");
				question = new ShortAnswer(prompt);
				System.out.println("ShortAnswer Created");
				break;
			case "Ranking":
				System.out.println("About to create a Ranking");
				question = new Ranking(prompt);
				System.out.println("Ranking Created");
				break;
			case "Matching":
				System.out.println("About to create Matching");
				System.out.println("Matching Created");
				// Prompt user for second options
//				Matching matching = new Matching(prompt, secondOptions);
				break;
			default:
					// Throw error
		}
		
		return question;
	}
}
