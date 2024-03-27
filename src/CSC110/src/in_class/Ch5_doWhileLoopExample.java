package in_class;
import java.util.Scanner;
public class Ch5_doWhileLoopExample {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		
		System.out.println("Please enter a digit less than 11.");
		int digit = scnr.nextInt(); //initial expression
		
		do
		{
			System.out.println("I can count to 10. See: " + digit);
			digit = digit + 1;//update expression
		}	while (digit < 11);//boolean expression

	}

}
