package practice;
import java.util.Scanner;
public class lab_4_23_1 {

	public static void main(String[] args) {
	Scanner scnr = new Scanner (System.in);
	
	System.out.println("Please enter a month:");
	String inputMonth = scnr.nextLine();
    
    if ((inputMonth != "January" || inputMonth != "February" || inputMonth != "March" ||
          inputMonth != "April" || inputMonth != "May" || inputMonth != "June" ||
          inputMonth != "July" || inputMonth != "August" || inputMonth != "September" ||
          inputMonth != "October" || inputMonth != "November" || inputMonth != "December")) {
          System.out.println("Invalid");
          }

	}

}
