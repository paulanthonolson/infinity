package in_class;
import java.util.Scanner;
public class Ch5_WhileLoopColorMenu {

	public static void main(String[] args) {
	Scanner scnr = new Scanner (System.in);
	
	char color_choice;
	String color_name;
	
	System.out.println("Please select your favorite color: ");
	System.out.println("(B)lue, (G)reen, (R)ed");
	color_choice = scnr.nextLine().charAt(0);
	
	switch (color_choice) {
	case 'b', 'B':
	case 'g', 'G':
	case 'r', 'R':
		color_name = "Blue";
		color_name = "Green";
		color_name = "Red";
		break;
	default: {
		color_name = "Unkknown";
	}

	
		System.out.println("favorite color choice is " + color_choice);
		System.out.println("and favorite color is" + color_name);
	
	
	
	
		}
	
	}

}
