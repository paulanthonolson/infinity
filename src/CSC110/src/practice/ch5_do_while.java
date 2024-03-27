package practice;
import java.util.Scanner;

public class ch5_do_while {

	public static void main(String[] args) {
	
		Scanner scnr = new Scanner(System.in);
		String myName;
		
		do
		{
			System.out.println("please enter a name: ");
			System.out.println("enter done to quit");
			myName = scnr.nextLine();
			
			if (!(myName.toLowerCase().equals("done")))
				System.out.println(myName);
			
		} while ( !(myName.toLowerCase().equals("done")));
		
		System.out.println("end of program");

	}

}
