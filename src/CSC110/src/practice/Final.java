package practice;
import java.util.Scanner;


public class Final {
	 public static void sortArray(int[] myArr, int arrSize) 
	 {
	      int i;
	      int j;
	      int temp;
	      int maxVal;
	      int maxValIndex;
	   
	      for (i = 0; i < arrSize; ++i) {
	         maxVal = myArr[i];
	         maxValIndex = i;
	         for (j = i+1; j < arrSize; ++j) {
	            if (myArr[j] > maxVal) {
	               maxVal = myArr[j];
	               maxValIndex = j;
	            }
	         }
	         temp = myArr[i];
	         myArr[i] = myArr[maxValIndex];
	         myArr[maxValIndex] = temp;
	      }
	  } 

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	      
		int[] userNums = new int[20];
		int numVals;
	    int userInput;
	       
	    numVals = scnr.nextInt();
	    
	    // ADD CODE HERE that uses a for loop for the numVals and populates the userNums array data elements using scanner
	    for (int i = 0; i < numVals; ++i) 
	    	{
			   userNums[i] = scnr.nextInt();
			  
			}

	    // ADD CODE HERE to call sortArray with the appropriate arguments
	    
	  sortArray(userNums, 20);
	    
	    
	    
	    for (int i = 0; i < numVals; ++i) 
	    {
	         System.out.print(userNums[i] + ",");
	    }
	    
	    System.out.println();
	      
	      

	} //end main
	


} //end class
