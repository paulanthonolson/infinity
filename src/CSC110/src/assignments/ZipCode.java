package assignments;
import java.util.Scanner;
/*
 * Paul Olson
 * 2/23/23
 * CSC110AB-26730
 * ZipCode
 * A program to switch through zipCode values.
 */
public class ZipCode {

	public static void main(String[] args) {
	Scanner scnr = new Scanner (System.in);
	
	System.out.println("Please enter your Zip Code: ");
	
	String zipCode = scnr.nextLine();
	char firstDigit = zipCode.charAt(0);
	
	
	
	 switch (firstDigit) {
     	case '0':
     	case '2':
     	case '3':
         System.out.println(zipCode + " is on the East Coast.");
         	break;
     	case '4':
     	case '5':
     	case '6':
         System.out.println(zipCode + " is in the Central Plains area.");
         	break;
     	case '7':
         System.out.println(zipCode + " is in the South.");
         	break;
     	case '8':
     	case '9':
         System.out.println(zipCode + " is in the West.");
         	break;
     default:
         System.out.println(zipCode + " is an invalid Zip Code.");
         	break;
	 }
			
		scnr.close();
	}

}
