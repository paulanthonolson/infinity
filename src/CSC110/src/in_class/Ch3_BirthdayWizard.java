package in_class;
import java.util.Scanner;

public class Ch3_BirthdayWizard {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		int birthYear;
		int currentYear;
		int yearsOld;
		
		
		System.out.println("Please enter the year you were born: ");
		birthYear = scnr.nextInt();
		
		System.out.println("Please enter the current year: ");
		currentYear = scnr.nextInt();
		
		yearsOld = currentYear - birthYear;
		
		System.out.println("You are " + yearsOld);
		
		scnr.close();

	}

}
