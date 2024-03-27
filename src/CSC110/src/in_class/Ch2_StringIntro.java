package in_class;
import java.util.Scanner;

/*
 * Author:
 * Date: 2/7/2022
 * Purpose: capture fruit names
 *          capture fruit prices
 */
public class Ch2_StringIntro
{

	public static void main(String[] args)
	{
		//STORAGE
		Scanner scnr = new Scanner(System.in);

		String fruitName;
		double fruitPrice;
		String fruitName2;
		double fruitPrice2;
		
		//INPUT
		System.out.println("Enter a fruit name");
		fruitName = scnr.nextLine();
		
		System.out.println("Enter a fruit price");
		fruitPrice = scnr.nextDouble();
		
		//add an empty scnr.nextLine
		scnr.nextLine();
		
		//read second fruit
		System.out.println("Enter a second fruit name");
		fruitName2 = scnr.nextLine();
		
		System.out.println("Enter a second fruit price");
		fruitPrice2 = scnr.nextDouble();
		
		//OUTPUT
		System.out.printf("fruit name: %s \t fruit price: %.2f \n", fruitName, fruitPrice);
		System.out.printf("fruit name: %s \t fruit price: %.2f \n", fruitName2, fruitPrice2);
		
		//close Scanner
		scnr.close();
	}

}
