package in_class;

public class Show_boolean_expression {

	public static void main(String[] args)
	{
	
		boolean isGreen = false;  //declare and initialize
		boolean isGreenTrue;
		
		boolean isSignal = true;
		boolean isSignalTrue = (isSignal == true);
		isSignalTrue = isSignal;
		
		isGreenTrue = (isGreen == true);
		
		//System.out.println("boolean expression would be: (isGreen == true) and it evaluates to " + (isGreen == true) );
		System.out.println("boolean expression would be: (isGreen == true) and it evaluates to " + isGreenTrue );

		
	}

}
