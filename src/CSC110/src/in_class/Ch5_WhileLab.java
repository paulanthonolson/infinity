package in_class;
import java.util.Scanner;
public class Ch5_WhileLab {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		System.out.println("Enter a non-negative number: ");
		System.out.println("Place a negative number at the end: ");
		System.out.println("to serve as an end marker.");
		
		int sum = 0;
		int next;
		boolean areMore = true;
		
		while(areMore)
		{
			next = scnr.nextInt();
			if (next < 0)
				areMore = false;
			else
				sum = sum + next;
		}
		System.out.println("The sum of the numbers is " + sum);

	}

}
