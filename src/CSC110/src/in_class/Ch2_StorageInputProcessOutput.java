package in_class;
import java.util.Scanner;  //Step 1 in getting data from user
/*
 * Author: Meha Trivedi
 * Date: 1/31/2022
 * Program: Ch2_StorageInputProcessOutput
 * Purpose:  Show how to capture input from the keyboard
 *                how to save data into memory (variables)
 *                how to process data 
 *                how to output data
 *           Take 2 numbers from the user, add them and print the result.
 */
public class Ch2_StorageInputProcessOutput
{ //begin class
	

	public static void main(String[] args) 
	{ //begin main
		
		//STORAGE
		Scanner scnr = new Scanner(System.in);  //scnr is the name of the variable that points to a copy (new) of Scanner to read
												//data from the keyboard (System.in)
												//copy gets created in computers memory
		int num1; //variable name: num1, data type: int for integer, stored in computer memory
		int num2; //variable, num2, to hold another integer data value	
		int result;
		
		
		/*****************************************************************************
		 * INPUT
		 * Prompt
		 */
		System.out.println("Please enter a whole number. The program will add 2 numbers and give you the result.");
		num1 = scnr.nextInt(); //read Integer from the keyboard
		System.out.println("Enter a second number");
		num2 = scnr.nextInt();
		
		
		//PROCESS
		//ADD num1 and num2 together
		result = num1 + num2;
		
		
		//OUTPUT
		System.out.println(num1);  //print variable data and don't surround with quotation marks
		System.out.println(num2);
		System.out.println(result);
		
		System.out.println("End of program!");

		
		//close scnr
		scnr.close();
		
	} //end main

} //end class
