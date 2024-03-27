package in_class;
import java.util.Scanner;
/*
 * Paul Olson
 * 1/30/23
 * show how to read the different data types from the keyboard
 */

public class Ch2_Read_Data_Types {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		boolean isMehaSleepy = true;
		
		char yesOrno;
		
		System.out.println ("Is Meha sleepy?");
		isMehaSleepy = scnr.nextBoolean();
		
		scnr.nextLine();
		
		System.out.println("Is Meha sleepy? " + isMehaSleepy);
		
		System.out.println("Choose Y or N: ");
		yesOrno = scnr.nextLine().charAt(0);
		
		System.out.println("The user chose " + yesOrno);
		
		
		
		scnr.close();

	}

}
