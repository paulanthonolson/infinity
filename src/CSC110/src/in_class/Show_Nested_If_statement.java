package in_class;
import java.util.Scanner;
/*
 * Author: Meha Trivedi
 * Date: 2/13/19
 * Purpose:  show nested if statements
 * Algorithm:
 * 1. Declare variables:  isSignal: boolean, color: char
 * 2. Ask the user if they see a signal
 * 3. If they do, ask them for the color.  
 * 4. If the color is R, tell them to stop, 
 *    if it's green, tell them to Go!, 
 *    if it's yellow, tell them to Slow Down!
 *    For any other color, tell them "Say What?!  Where are you!" 
 * 5. Output:  the message based on the color of the light
 * 6. End the program with "Drive safely!  Don't use this program while you are driving!"
 */
public class Show_Nested_If_statement 
{

	public static void main(String[] args) 
	{
		char yes_no = 'y'; 
		boolean isSignal;
		char color; //R, G, Y
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("You are driving down the street, do you see a signal light?  Yes or No.");
		yes_no = keyboard.nextLine().charAt(0);
		
		if (yes_no == 'y')
			isSignal = true;
		else
			isSignal = false;
		
		if (isSignal)
		{
			System.out.println("What color is the signal");
			color = keyboard.nextLine().charAt(0);
			
			if (color == 'R')
			{
				System.out.println("You better stop at Red!");
			}
			else if ( (color == 'G') || (color == 'g') )
			{
				System.out.println("Hurry up!  Go!!! ");
			}
			else if (color == 'Y')
				System.out.println("Slow Down!!!");
			else
				System.out.println("Say What?!  Where are you!");
		}
		else //isSignal is false
		{
			System.out.println("Smooth Sailing!!");
		}
		
		System.out.println("Drive safely!  Don't use this program while you are driving!");

	}

}
