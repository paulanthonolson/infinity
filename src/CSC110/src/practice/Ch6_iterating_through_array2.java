package practice;
import java.util.Scanner;
public class Ch6_iterating_through_array2 {
	/*
	 * Program that finds the max item.
	 */

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	      final int NUM_ELEMENTS = 8;             // Number of elements
	      int[] userVals = new int[NUM_ELEMENTS]; // Array of user numbers
	      int i;                                  // Loop index
	      int maxVal;                             // Computed max

	      // Prompt user to populate array
	      System.out.println("Enter " + NUM_ELEMENTS + " integer values...");
	      
	      for (i = 0; i < userVals.length; ++i) {
	         userVals[i] = scnr.nextInt();
	         System.out.println("Value: " + userVals[i]);
	      }

	      // Determine largest (max) number
	      maxVal = userVals[0];                   // Largest so far
	      
	      for (i = 0; i < userVals.length; ++i) {
	         if (userVals[i] > maxVal) {
	            maxVal = userVals[i];
	         }
	      }
	      System.out.println("Max: " + maxVal);

	}

}
