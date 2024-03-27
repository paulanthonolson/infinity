package in_class;

import java.util.Random;

public class Show_Random 
{

	public static void main(String[] args) 
	{
		//class is Random
		//object created in memory is rndgen
		Random rndgen = new Random();
		
		System.out.println( (int) ( Math.random() * 10 )) ;
		
		System.out.println(rndgen.nextInt(20));
		
		//END PROGRAM - using Escape Sequences \n, \t, etc.
		System.out.println("\n\t --------------------END OF PROGRAM----------------------");
		
	}

}
