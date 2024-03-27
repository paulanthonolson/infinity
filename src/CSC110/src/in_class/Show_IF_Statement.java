package in_class;
/*
 * Purpose:  Show a basic if Statement
 * 
 * Branching with an if statement
 * 
 * What an if statement looks like:
 * 
 * 	if (boolean expression that evaluates to true or false)
 *  {
 *  	statements;
 *  }
 * 
 * 
 */
public class Show_IF_Statement 
{

	public static void main(String[] args)
	{
		//declare variables
		
		boolean isSignal = true;
		boolean isRed = true;
		boolean isGreen = false;
		
		//if statement
		if (isSignal == true) //then
				System.out.println("There is a signal light on the road!");
		
		
		//write the conditional if statement that if isRed is false then print "Go!"
		if (isRed == false) // (isRed != true)
		{
			System.out.println("Go!");
		}
		
		if (isSignal && isGreen)  //(isSignal == true && isGreen == true)
		{
			System.out.println("Go!");
		}

	}

}
