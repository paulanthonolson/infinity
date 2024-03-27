 package in_class;

import java.util.Scanner;

public class Ch7_Build_Different_Methods {

	public static void main(String[] args) {
		
		
		
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("This program is about building different methods");
		System.out.println("and calling different methods with different return types and parameters");
		System.out.println("------------------------------------------------------------------------");
		
		System.out.println();
		
		//Calling method 1
		
		No_parameter_example();
		
		//Calling method 2
		
		parameter_int_example(25);
		
		//Calling method 3
		
		double x1;
		x1 = return_double_example(99);
		System.out.println("The value of x1 is " + x1);
		System.out.println();
		
		//Calling method 4
		
		boolean isLessThan;
		isLessThan = parameter_variousDataTypes_example(47, 58.2);
		
		if (isLessThan)
			System.out.println("The value of x is less than y");
		else
			System.out.println("The value of x is NOT less than y");
		
		//Calling method 5
		
		System.out.println (parameter_variousDataTypes_example_returnsString(5,7.2));
		System.out.println();
		
		//Calling method 6
		
		int[] ReturnedList;
		ReturnedList = return_array_Example(99);
		System.out.println(ReturnedList);
		for (int index = 0; index < ReturnedList.length; index++) 
		{
			System.out.println("value of index " + index + " is " + ReturnedList[index]);
		}
		System.out.println();
		
		//Calling method 7
		
		System.out.println(parameterArray_example(ReturnedList));
		System.out.println();
		
		//Calling method 8
		
		Scanner scnr = new Scanner (System.in);
		
		parameterArray_example_passes_Scanner (ReturnedList, scnr);
		
		System.out.println("Print updated list of ReturnedList");
		
		for (int index = 0; index < ReturnedList.length; index++) 
		{
			System.out.println("value of index " + index + " is " + ReturnedList[index]);
		}
		
	
		
		
		
		

	} //end main
	
	/*
	 * Method 1 no return no parameters
	 */
	
	public static void No_parameter_example() {
		System.out.println("Method 1");
		System.out.println("--------------------------------");
		System.out.println("This method has no parameters and no return type");
		System.out.println();
	}
	
	/*
	 * Method 2 no return type
	 */
	
	public static void parameter_int_example(int x) {
		System.out.println("Method 2");
		System.out.println("--------------------------------");
		System.out.println("the value of x is " + x);
		System.out.println();
		
	}
	
	/*
	 * Method 3 
	 */
	
	public static double return_double_example(int x) {
		System.out.println("Method 3");
		System.out.println("--------------------------------");
		System.out.println();
		return (double) x;
	}
		
	/*
	 * Method 4
	 */
	
	public static boolean parameter_variousDataTypes_example (int x, double y) {
			System.out.println("Method 4");
			System.out.println("----------------------------");
			System.out.println();
			if (x < (int) y) {
			return true;
			}
			else return false;
		}
	/*
	 * Method 5
	 */
	
	public static String parameter_variousDataTypes_example_returnsString (int x, double y) {
		System.out.println("Method 5");
		System.out.println("--------------------");
		System.out.println();
		String myStr;
	
		
		if (x == 7)
			myStr = "Lucky Number";
			else 
			{
				y = y * 7.0;
				myStr = "the new value of y is " + y;
			
			}
		return myStr;
	}
	
	/*
	 * Method 6
	 */
	
	public static int[] return_array_Example (int x) {
		
		System.out.println("Method 6");
		System.out.println("-------------------");
		System.out.println();
		
		
		int[] myIntList = new int [x];
		
		for (int index = 0; index < myIntList.length; index++) {
			myIntList[index] = 25;
		}
		return myIntList;
	}
	
	/*
	 * Method 7
	 */
	
	public static double parameterArray_example (int[] ListOfNums) {
		System.out.println("Method 7");
		System.out.println("-------------------");
		System.out.println();
		
		System.out.println("the method accepted an array as an argument");
		System.out.println("an array argument will always be an address:");
		System.out.println();
		System.out.println(ListOfNums);
		
		System.out.println("To print the data of an array we have to use a loop");
		System.out.println();
		
		for (int index = 0; index < ListOfNums.length; index++) {
			System.out.println(ListOfNums[index] + " at index: " + index);
		}
		return (double) ListOfNums[1];
		
	}
	
	/*
	 * Method 8
	 */
	
	public static void parameterArray_example_passes_Scanner (int[] ListOfNums, Scanner scnr) {
		
		int PopulateWith;
		
		System.out.println("Method 8");
		System.out.println("--------------------------");
		System.out.println();
		
		System.out.println("Please enter a number: ");
		PopulateWith = scnr.nextInt();
		System.out.println();
		
		for (int index = 0; index < PopulateWith; index++) {
			ListOfNums [index] = PopulateWith;
			}
	}
	
	
		
		
	
	
	
	
		
	
	} //end class


