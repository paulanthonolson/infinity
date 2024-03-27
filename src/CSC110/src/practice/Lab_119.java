package practice;
import java.util.Scanner;

public class Lab_119 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	      
		  char baseChar;
	      char headChar;
	      
	      System.out.println ("Define baseChar");
	      baseChar = scnr.nextLine().charAt(0);
	      System.out.println ("Define headChar");
	      headChar = scnr.nextLine().charAt(0);
	      
	   
	      
	      System.out.println ("     " + baseChar);
	      System.out.println ("     " + baseChar + baseChar);
	      System.out.println ("" + baseChar + baseChar + baseChar + baseChar + headChar + headChar + headChar + headChar);
	      System.out.println ("     " + baseChar + baseChar);
	      System.out.println ("     " + baseChar);
	      
	      
	      
	      
	      scnr.close();
	      
	}

}
