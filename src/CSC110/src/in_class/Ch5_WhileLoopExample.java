package in_class;
import java.util.Scanner;
public class Ch5_WhileLoopExample {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		
		
		System.out.println("Please enter a digit less than 10.");
		int digit = scnr.nextInt(); // first: an initial expression
		
		while (digit <= 10) { //second: a boolean expression
			System.out.println("I can count to 10. See: " + digit);
			digit = digit + 1; //third an update expression
		}
		
		System.out.println("The value of the digit after the loop is " + digit);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scnr.close();

	}

}
