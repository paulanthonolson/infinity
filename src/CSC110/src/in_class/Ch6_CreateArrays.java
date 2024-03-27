package in_class;
import java.util.Scanner;
public class Ch6_CreateArrays {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		int[]myFavNumbers = new int[5];
		
		String[]fruitNames = new String[3];
		
		double[]fruitPrices = new double[3];
		
		System.out.println("Enter the number of fruit ");
		myFavNumbers[4] = scnr.nextInt();
		
		
		System.out.println("Enter the fruit name ");
		fruitNames[2] = scnr.nextLine();
		
		scnr.nextLine();
		
		System.out.println("Enter the fruit price");
		fruitPrices[1] = scnr.nextDouble();
		System.out.println("Enter the fruit price");
		fruitPrices[2] = scnr.nextDouble();
		
		
	
	}

}
