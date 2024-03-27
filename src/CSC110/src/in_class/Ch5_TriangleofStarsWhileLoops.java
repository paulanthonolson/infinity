package in_class;
import java.util.Scanner;
public class Ch5_TriangleofStarsWhileLoops {

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
	        		
	    	while (numberOfStars <= 50) { //second: a boolean expression
				while (numberOfStars <= 50) { 
					System.out.println("*");
					numberOfStars = numberOfStars + 1; //third an update expression
				}
				
			}

	       
	    
	        
	    } // end else

	}

}
