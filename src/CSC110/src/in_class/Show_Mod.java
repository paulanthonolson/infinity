package in_class;
import java.util.Scanner;

public class Show_Mod {

	public static void main(String[] args)
{
		int a, b;
		int c = 0;
		
		double dbl_num = 4.0, dbl_num2 = 3.0, dbl_num3;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("enter num1");
		a = keyboard.nextInt();
		
		System.out.println("enter num2");
		b = keyboard.nextInt();
		
		c = a % b;
		
		System.out.println("the remainder of a/b is " + c);
		System.out.println("the remainder of double values is " + (dbl_num%dbl_num2) );

	}

}
