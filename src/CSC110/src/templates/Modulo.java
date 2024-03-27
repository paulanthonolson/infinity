package templates;
import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	      int userMinutes; // User input: Minutes
	      int outHours;    // Output hours
	      int outMinutes;  // Output minutes (remaining)

	      System.out.print("Enter minutes: ");
	      userMinutes = scnr.nextInt();

	      outHours   = userMinutes / 60;
	      outMinutes = userMinutes % 60;

	      System.out.print(userMinutes  + " minutes is ");
	      System.out.print(outHours     + " hours and ");
	      System.out.println(outMinutes + " minutes.");

	}

}
