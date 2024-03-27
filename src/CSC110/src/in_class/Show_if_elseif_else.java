package in_class;
/*
 * 2 other if statements that you can build
 * 
 * if else statement:
 * if (boolean expression)
 * {
 * 	statements;
 * }
 * else
 * {
 * 	statements;
 * }
 * 
 * if else if else statement:
 * if (boolean expression)
 * {
 * 	statements;
 * }
 * else if (boolean expression)
 * {
 * 	statements;
 * }
 * else
 * {
 * 	statements;
 * }
 * 
 */
public class Show_if_elseif_else
{

	public static void main(String[] args) 
	{
		boolean isGreen = true;
		boolean isYellow = false;
		
		if (isGreen) //if the light is green,then
		{
			System.out.println("Go! Go! Go!");
		}
		else //otherwise
		{
			System.out.println("Stop!");
		}

		isGreen = false;
		
		//if else if else statment
		
		
		if (isGreen)
		{
			System.out.println("Go! Go! Go!");
		}
		else if (isYellow)
		{
			System.out.println("Slow Down!");
		}
		else
			System.out.println("Stop!");
	}

}
