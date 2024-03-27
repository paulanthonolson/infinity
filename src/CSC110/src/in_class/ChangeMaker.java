package in_class;
import java.util.Scanner;
/*
 * Author:
 * Date:
 * Purpose:
 * Algorithm (PLAN):
 * 1.   Declare storage variables:
 * 			amount: int
 * 			originalAmount : int
 * 2.  Capture input from the user and save it in the orignalAmount.  The data needs to be a whole 
 *     number with 100 representing a $1.
 *     
 * 3.  Use divide and modulus to help find the change of the whole number.
 * 4.  Display the result for each coin, quarter, dime, nickel, and penny
 */
public class ChangeMaker
{
    public static void main(String[] args)
    {
    	// 1 .... Declare variables
        int amount, originalAmount,
            quarters, dimes, nickels, pennies;
        Scanner keyboard = new Scanner(System.in);

        //2 ..... data input
        System.out.println("Enter a whole number with 100 representing $1");
        System.out.println("I will find a combination of coins");
        System.out.println("that equals that amount of change.");

        originalAmount = keyboard.nextInt( );

        //3 ..... processing
        
        amount = originalAmount;
        quarters = amount / 25;
        amount = amount % 25;
        dimes = amount / 10;
        amount = amount % 10;
        nickels = amount / 5;
        amount = amount % 5;
        pennies = amount;

        //4 .... output/display/result
        System.out.println(originalAmount +
                           " cents in coins can be given as:");
        System.out.println(quarters + " quarters");
        System.out.println(dimes + " dimes");
        System.out.println(nickels + " nickels and");
        System.out.println(pennies + " pennies");
    }
}