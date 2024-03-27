package assignments;
import java.util.Random;
/*
 * Paul Olson
 * 3/9/23
 * CSC110AB-26730
 * For Loop Variety
 * To demonstrate the different use cases a for loop has.
 */
public class ForLoopVariety {

	public static void main(String[] args) {
		Random randGen = new Random();
		
		int i;
		int x;
		int random;
		
		System.out.println("Paul Olson - For Loops");
		
		for (i = 1; i <= 10; i++) {
		    System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (i = 0; i <= 30; i = i + 5) {
		    System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (i = 10; i >=0; i--) {
		    System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (i = 0; i < 10; i++) {
		    System.out.print("*");
		}
		
		System.out.println();
		
		for (i = 0; i < 3; i++) {//NEED TO ADD NUMBERED LINES
			for (int column = 0; column <= 3; column++)
			
		{for (x = 0; x < 10; x++)
			System.out.print("*");}
			System.out.println();
		}
		
		for (i = 0; i < 5; i++) {
		random = randGen.nextInt(99) + 0;
		System.out.print(random + " ");
		}
		
		System.out.println();
		
		for (i = 0; i < 5; i++) {
			random = randGen.nextInt(5) + 7;
			System.out.print(random + " ");
			}
		
		System.out.println();
		
		for (i = 1;i <= 10;i++) {
			if (i == 5) 
				continue;
			System.out.print(i + " ");
			}
		
		System.out.println();
		
		for (i = 1;i <= 100;i++) {
			if (i % 5 == 0 && i % 7 == 0) {
				break;
			}
			System.out.print(i + " ");
		}
		
	}

}
