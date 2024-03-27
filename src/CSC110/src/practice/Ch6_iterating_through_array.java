package practice;
import java.util.Scanner;
public class Ch6_iterating_through_array {
	/*
	 *  Program that computes the sum of an array's elements.
	 */

	public static void main(String[] args){
	Scanner scnr = new Scanner(System.in);
      
	  final int NUM_ELEMENTS = 8;             // Number of elements
      int[] userVals = new int[NUM_ELEMENTS]; // User numbers
      int i;                                  // Loop index
      int sumVal;                             // For computing sum

      // Prompt user to populate array
      System.out.println("Enter " + NUM_ELEMENTS + " integer values...");
      
      for (i = 0; i < userVals.length; ++i) {
         userVals[i] = scnr.nextInt();
         System.out.println("Value: " + userVals[i]);
      }

      // Determine sum
      sumVal = 0;
      for (i = 0; i < userVals.length; ++i) {
         sumVal = sumVal + userVals[i];
      }
      System.out.println("Sum: " + sumVal);
      
      scnr.close();
   }

	
}


