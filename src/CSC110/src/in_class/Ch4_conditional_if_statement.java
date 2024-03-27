package in_class;
import java.util.Scanner;

/*
 * conditional statements allow our program to take a path
 * 4 types of conditional statements
 *    if (boolean expression) { statements; }
 *    if (boolean expression) { statements; } else { statements; }
 *    if (boolean expression) { statements; } else if (boolean expression) { statements; } else { statements; }
 *    switch (variable name) case <data value> : { statements; } case <data value> : { statements; } .. default: {statements;}
 *    
 *    Additional operators are logical operators:
 *    AND - &&
 *    OR  - ||
 *    NOT - !
 */
public class Ch4_conditional_if_statement {

	public static void main(String[] args) 
	{
		//STORAGE
		Scanner scnr = new Scanner(System.in);
		boolean isSignal = false;
		char userInput;
		int numOfCars;
		
		//INPUT
		System.out.println("Is there a traffic signal? Enter yes or no");
		userInput = scnr.nextLine().charAt(0); //read the whole string and then pick up the first character
		//isSignal = scnr.nextBoolean();
		
		System.out.println("how many cars are on the road? enter 10 if less than 10, enter 20 if more than 10, etc.");
		numOfCars = scnr.nextInt();
		
		//PROCESS
		
		/*
		 * if (userInput == 'y')
		{
			isSignal = true;
		}
		 */
		if (userInput == 'y')
		{
			isSignal = true;
		}
		else
		{
			isSignal = false;
			System.out.println("There is no traffic signal, cross the intersection carefully!");
		}
		
		
		if (numOfCars <= 10)
		{
			System.out.println("not much traffic");
		}
		else if (numOfCars <= 20)
		{
			System.out.println("still pretty good traffic, not bad");
		}
		else if (numOfCars <= 30)
		{
			System.out.println("roads are getting busy");
		}
		else if ( (numOfCars <= 40) || (numOfCars > 40 && numOfCars <=50) )
		{
			System.out.println("if there isn't a traffic signal, maybe there should be!");
		}
		else
		{
			System.out.println("there are so many cars, slow down!");
		}
		
		//OUTPUT
		System.out.println("Traffic signal? " + isSignal);
		
	}

}
