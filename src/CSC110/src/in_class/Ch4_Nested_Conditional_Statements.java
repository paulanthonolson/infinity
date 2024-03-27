package in_class;
import java.util.Scanner;
public class Ch4_Nested_Conditional_Statements {

	public static void main(String[] args) {
		java.util.Scanner scnr = new Scanner(System.in);
		
		int dollars;
		int quarters;
		int dimes;
		int nickels;
		int pennies;
		
		System.out.println("Enter number of dollars: ");
		dollars = scnr.nextInt();
		
		System.out.println("Enter number of quarters: ");
		quarters = scnr.nextInt();
		
		System.out.println("Enter number of dimes: ");
		dimes = scnr.nextInt();
		
		System.out.println("Enter number of nickels: ");
		nickels = scnr.nextInt();
		
		System.out.println("Enter number of pennies: ");
		pennies = scnr.nextInt();
		
		if (dollars > 0) 
		{
			if (dollars == 1) {
		 		System.out.println("You have " + dollars + " dollar.");}
		 	else  
		 		{System.out.println("You have " + dollars + " dollar.");}
		}
		
		if (quarters > 0) 
		{
			if (quarters == 1) {
		 		System.out.println("You have " + quarters + " quarter.");}
		 	else  
		 		{System.out.println("You have " + quarters + " quarters.");}
		}
		
		if (dollars > 0) 
		{
			if (dimes == 1) {
		 		System.out.println("You have " + dimes + " dime.");}
		 	else  
		 		{System.out.println("You have " + dimes + " dimes.");}
		}
		
		if (nickels > 0) 
		{
			if (nickels == 1) {
		 		System.out.println("You have " + nickels + " nickel.");}
		 	else  
		 		{System.out.println("You have " + nickels + " nickels.");}
		}
		
		if (pennies > 0) 
		{
			if (pennies == 1) {
		 		System.out.println("You have " + pennies + " penny.");}
		 	else  
		 		{System.out.println("You have " + pennies + " pennies.");}
		}
	}
}
		
