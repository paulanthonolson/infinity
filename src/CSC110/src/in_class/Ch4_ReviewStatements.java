package in_class;
import java.util.Scanner;
public class Ch4_ReviewStatements {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);	
		
		int num1;
		int num2;
		boolean isAdditionCorrect;
		
		int result;
		
		System.out.println("Enter num1");
		num1 = scnr.nextInt();
		
		System.out.println("enter num2");
		num2 = scnr.nextInt();
		
		result = num1 + num2;
		
		System.out.println("The result is " + result);
		
		System.out.println("Is the result correct? Answer true or false. ");
		isAdditionCorrect = scnr.nextBoolean();
		
		if (isAdditionCorrect == true) {System.out.println("You answered true.");}
		else if (isAdditionCorrect != true) {System.out.println("You answered false.");}
		
		scnr.close();
	}	

}
