package in_class;
import java.util.Scanner;
public class Ch4_If_Else_If_Boolean {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		boolean isSignalGreen;
		boolean isSignalRed;
		
		isSignalGreen = scnr.nextBoolean();
		isSignalRed = scnr.nextBoolean();
		
		System.out.println("Is the light green? true or false");
		
		if (isSignalGreen == true) {System.out.println("There is a green light!"); }
		else if (isSignalGreen != true) {System.out.println("There is a red light!");}

	}

}
