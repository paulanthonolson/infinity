package in_class;
import java.util.Scanner;
/*
 * Paul Olson
 * 1/30/23
 * Create int and double variables, store data in them and print the data.
 * Add the scanner utility so our program reads from the keyboard
 */
public class Show_int_and_double_datatypes {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in); //declare variables
		int favoriteNum; //int allows storing of positive and negative integers
		double priceofProduct; //double allows storing of positive and negative fractional numbers
		
		favoriteNum = 5; //assign a value to favoriteNum
		priceofProduct = 10.50; //assign value to priceofProduct
		
		
		System.out.println ("Please enter your favorite number:"); //Ask data from user
		favoriteNum = scnr.nextInt(); //Assign value to Scanner
		
		System.out.println ("Please enter the price of the product:");
		priceofProduct = scnr.nextDouble();
		
		System.out.println ("My favorite number is " + favoriteNum + ".");
		System.out.println ("$" + priceofProduct + " is affordable.");
		
		
		
		
		scnr.close();

	}

}
