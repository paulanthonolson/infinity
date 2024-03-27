package in_class;
import java.util.Scanner;
public class Ch5_TriangleofStars {

	public static void main(String[] args) {
    	/**********
    	 * Storage
    	 */
	    Scanner keyboard = new Scanner(System.in);
	    int numberOfStars;

	    System.out.println("Enter an integer from 1 to 50: ");
	    numberOfStars = keyboard.nextInt();
	    System.out.println();

	    if(numberOfStars < 1)
	    	System.out.println("Invalid number: must be at least one.");
	    else if(numberOfStars > 50)
	        System.out.println("Invalid number: cannot exceed 50.");
	    else //valid input, print triangle of stars
	    {
	        //In this first half, line 1 has 1 star, line 2 has 2 starts, etc. 
	        		
	        for(int lineCount = 1; lineCount <= numberOfStars; lineCount++)
	        {
	        	for(int StarCount = 1; StarCount <= lineCount; StarCount++)
	        	{
	        		System.out.print("*");
				}
	        	System.out.println();
	        } // end first half for

	        /*
	          In this second half, the next printed line needs to have numberOfStarts - 1 and 
	          the line after that needs to have one less than that, etc. until we have 
	          no more lines to print
	          
	          Write this nested for loop.
	        */

	        for(int lineCount = numberOfStars - 1; lineCount >= 1; lineCount--)
            {
                for(int StarCount = 1; StarCount <= lineCount; StarCount++)
                {
                    System.out.print("*");
                }
                System.out.println();
            } // end second half
	        
	    } // end else

	}

}
