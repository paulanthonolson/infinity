package in_class;
import java.util.Scanner;
public class Ch6_CreateArrays2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		double[]fruitPrices = new double[3];
		String[]fruitNames = new String[3];
		
		int numOfFruits = 3;
		
		System.out.println("Please enter " + numOfFruits + " fruit names and price.");
		
		for (int index = 0; index < fruitNames.length; index++) { //single loop for two processess
			fruitNames[index] = scnr.nextLine();
			fruitPrices[index] = scnr.nextDouble();
			scnr.nextLine();
		}
		
		scnr.close();
	
	}

}
