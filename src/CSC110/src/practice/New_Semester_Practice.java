package practice;
import java.util.Scanner;

/* To practice what I learned in the previous semester */

public class New_Semester_Practice {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println ("Please enter a number less than 100: ");
		
			for (int digit = scnr.nextInt(); digit < 101; digit = digit + 1)
				{
					System.out.println ("Counting from 1 to 100 " + digit);
					
					for (digit = scnr.nextInt(); digit > 0; digit = digit - 1)
					{
					System.out.println ("Counting down from number " + digit);
					}
				}
			

	}

}
