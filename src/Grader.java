import java.util.ArrayList;

// Checks if user response == correctAnswer
/*
 * Each test can be graded.
 * Grading is automatic.
 * All questions are worth equal points.
 * Essay questions cannot be graded.
 * If there are 10 questions, 1 essay question and a student gets 8 of the 9
 * 	non essay questions correct, the program should output 80/90 as the actual grade
*/
public class Grader {
	private Test test;
	private ArrayList<ResponseCorrectAnswer> responses;
	
	private double grade = 0.0;
	private int correctAnswers = 0;
	private int totalAnswers = 0;
	
	Grader(Test test, ArrayList<ResponseCorrectAnswer> responses) {
		System.out.println("Test Name: " + test.GetName());
		this.test = test;
		this.responses = responses;
		
		totalAnswers = CalculateTotalAnswers();
		CheckAnswers();
		Report();
	}
	
	private int CalculateTotalAnswers() {
		int total = 0;
		
		for (Question q : test.GetQuestions()) {
			
			if (q.GetQuestionType().equals("Essay")) {
				continue;
			}
			
			total++;
		}
		
		System.out.println("Total number of questions to grade: " + total);
		return total;
		
	}
	
	// Iterate through questions 0..i, check if responses.get(i) is equal to questions.get(i)
	private void CheckAnswers() {
		int score = 0;
		for (Question q : test.GetQuestions()) {
			int i = 0;
			String correctAnswer = q.GetCorrectAnswer().GetResponse();
			String userResponse = responses.get(i).GetResponse();
			
			System.out.println("User Responses: " + userResponse);
			System.out.println("Correct Answer: " + correctAnswer);
			
			if (q.GetQuestionType().equals("Essay")) {
				continue;
			}
			
			if (userResponse.equals(correctAnswer)) {
				score++;
				this.correctAnswers++;
			}
			
			i++;
		}
		
		this.grade = score / this.totalAnswers;
	}
	
	public double GetGrade() {
		return this.grade;
	}
	
	public void Report() {
		System.out.println("Correct Answers: " + correctAnswers);
		System.out.println("Grade: " + (grade * 100) + "%");
	}
	
	
}
