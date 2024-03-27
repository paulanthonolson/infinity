package in_class;

public class Ch2_StoreInitializeOutput01
{

	public static void main(String[] args) 
	{
			
		/**********************************************
		 * Storage 
		 * declare and initialize
		 */
		int num0 = 0, num1 = 1;
		
		//int num1 = 1;
		
		/********************************************
		 * output
		 */
		
		System.out.print("This program eventually should print an arrow of 0s and 1s\n");
		System.out.print("\t" + num1 + "\n");
		System.out.println("\t" + num1 + num1);
		System.out.println("" + num0 + num0 + num0 + num0 + num0 + num0 + num0 + num0 + num1 + num1 + num1);
		
		//if wanted to add and add spaces 
		System.out.println("       " + (num0 + num1 + num1) );
	}

}
