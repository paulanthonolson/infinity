package practice;
import java.util.Scanner;

public class Ch7_Challenge_7_10_1 {
	   
	public static void updateScoreVals(int[] scoreVals, int updateVal) {
	      int i;

	      for (i = 0; i < scoreVals.length; ++i) {
	          scoreVals[i] = scoreVals[i] - updateVal;
	      }
	   }
	public static void printScoreVals(int[] scoreVals) {
	       int i;

	       for (i = 0; i < scoreVals.length; ++i) {
	           System.out.println(scoreVals[i]);
	       }
	   }

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	      final int NUM_SCORES = 3;
	      int[] quizScores = new int[NUM_SCORES];
	      int scoreUpdate = 4;
	      int i;

	      for (i = 0; i < quizScores.length; ++i) {
	          quizScores[i] = scnr.nextInt();
	      }

	      updateScoreVals(quizScores, scoreUpdate);
	      printScoreVals(quizScores);
	}

}
