package in_class;
import java.util.Scanner;

public class Ch2_DataTypes {

	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		
		long long_var = 2145347483649L;
	//	short short_var = 32767;
		char char_x = 'x';
		String myString = "lettersABCsymbols@%^Numbers45465232 My name is Meha! ";
		
		System.out.println(long_var);
		long_var = scnr.nextLong();
		System.out.println(long_var);
		
		scnr.nextLine();  //reads nothing and throws it away moves to line
		
		System.out.println(char_x);
		System.out.println("please enter a letter or a symbol");
		char_x = scnr.nextLine().charAt(0);
		
		System.out.println("the character is " + char_x);
		System.out.println("" + char_x + char_x);
		
		//PRINT STRING
		System.out.println("my string is : " +  myString);
		
		//READ STRING FROM KEYBOARD
		System.out.println("Please enter a String");
		myString = scnr.nextLine();
		System.out.println(myString);
		
		//READ A WORD OF A STRING FROM KEYBOARD
		System.out.println("Please enter another String");
		myString = scnr.next();
		System.out.println("Only reads the word: " + myString);
		
		System.out.println("Please enter yet another String"); 
		myString = scnr.nextLine();
		System.out.println(myString);
		
		scnr.close();
	}

}
