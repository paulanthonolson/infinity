/*
 * Author: Meha Trivedi
 * Date: 9/9/19, Monday 8:30 am
 * Purpose:  Show how you can read a String variable data
 * 			 and how you can read a single character
 */
package in_class;
import java.util.Scanner; 

public class Show_String_and_char_Input 
{

	public static void main(String[] args) 
	{
		//Declare variables 
		Scanner scnr = new Scanner(System.in);   //make a copy of the scanner library
		String superCali;
		String sentence;
		char answer;
		
		
		//Capture data
		
		superCali = "supercalifragilisticexpealidocious";
		System.out.println("Please enter data value for the super cali variable: ");
		superCali = scnr.next();
		System.out.println("The output of next will only pick up the first word or upto a space " + superCali);
		superCali = scnr.next();
		System.out.println("The output of next will only pick up the first word or upto a space " + superCali);
		superCali = scnr.next();
		System.out.println("The output of next will only pick up the first word or upto a space " + superCali);
		
		scnr.nextLine();
		
		System.out.println("Please enter data value for the sentence variable: ");
		sentence = scnr.nextLine();
		System.out.println("The output of nextline will pick up the entire string " + sentence);
		System.out.println("Do you agree? ");
		answer = scnr.nextLine().charAt(0);
		System.out.println(answer);
		
		System.out.println("End of program");
		scnr.close();
	}

}














