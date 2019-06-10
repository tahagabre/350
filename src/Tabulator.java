import java.util.ArrayList;

// Tabulates Surveys/Tests
/*
 * True/False: Output the total True responses and total False responses.
 * Multiple Choice: Output the total number of responses for each choice.
 * Short Answer: Output the total number of each response. Do not worry about combining
		spelling issues and such.
	Essay Answer: Simply list all of the answers
	Matching and Ranking: List the number of each permutation submitted and the permutation.
*/
public class Tabulator {
	private Survey survey;
	private ArrayList<ResponseCorrectAnswer> responses;
	private ArrayList<Integer> tabs;
	
	Tabulator(Survey survey, ArrayList<ResponseCorrectAnswer> responses) {
		this.survey = survey;
		this.responses = responses;
	}
	
	
}
