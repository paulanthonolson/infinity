/*
 * Author: Meha Trivedi
 * Date: 8/26/19
 * Purpose:  Showing variable declarations and data types
 * 
 */
package in_class;


public class Show_Vars_DataTypes 
{

	public static void main(String[] args) 
	{
		//declare a character
		// char is the Data Type
		// myChar is the Variable to store the data
		// char myChar; is an instruction or statement telling the computer the kind of data
		//  I want it to remember
		char myChar;
		char mycharInteger;
		
		// the following instruction assigns a data value of 'a' to the memory location of myChar
		myChar = 'a';
		mycharInteger = '5';
		
		System.out.println("My character is the letter: " + myChar + "!!!");
		System.out.println(mycharInteger + 20);

		/**********************************************
		 * declaring int
		 */
		int myInt;
		myInt = 5;
		System.out.println(myInt);
		
		System.out.println(myInt + 20);
		
		System.out.println(myInt);
		
		myInt = myInt + 20;
		System.out.println(myInt);
		
		/*********************************************
		 * declaring double
		 */
				
		double myDouble;
		myDouble = 6.2345;
		System.out.print("First Line \n");
		System.out.println("My double value is " + myDouble);
		System.out.printf("My double value is %.2f", myDouble);
		System.out.println();
		System.out.printf("My double value is %.2f and my integer value is %d \n", myDouble, myInt);
		System.out.println("Last \t Line");
		
		//short myShort = 128983;
		long myLong;
		myLong = 876453628292462378L;
		
		System.out.println("My long number is " + myLong);
		
		
		
		
		
		
	}  //end of the main method

} //end of the class













