/*
 * Author: Meha Trivedi
 * Date: 8/26/19
 * Purpose: Show how to capture data from the user
 */
package in_class;

import java.util.Scanner;

public class Show_UserInput 
{
	public static void main(String[] args) 
	{
		//declare variables
		//to read data from the user, we will use a pre-built utility called Scanner
		Scanner scnr = new Scanner(System.in);
		
		int myFavNum;
		myFavNum = 7;
		
		System.out.println("Please enter your favorite number: ");
		myFavNum = scnr.nextInt();
		
		System.out.println("My favorite number is " + myFavNum);
		
		
		
		scnr.close();
	} //end of main method
} //end of class
