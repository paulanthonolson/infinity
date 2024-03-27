package in_class;
import java.util.Scanner;


public class Ch5_ForLoopExample {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		/*initial expression;
		 * boolean expression;
		 * update expression
		 * 
		 * Special: Use a for loop when you know exactly how many repetitions the body needs to run
		 */
		
		System.out.println("Please enter a digit less than 11.");
		
		
		for (int digit = scnr.nextInt(); digit < 11; digit = digit + 1) // for loop syntax matters
		{
			System.out.println("I can count to 10. See " + digit);

		}
	}

}
