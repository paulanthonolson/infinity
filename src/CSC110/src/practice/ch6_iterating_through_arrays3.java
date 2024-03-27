package practice;

public class ch6_iterating_through_arrays3 {

	public static void main(String[] args) {
		   final int NUM_ELEMENTS = 4;
		      int [] userVals = new int[NUM_ELEMENTS];
		      int i;
		   
		      userVals[0] = -2;
		      userVals[1] = 4;
		      userVals[2] = -6;
		      userVals[3] = 8;
		   
		      for (i = 0; i < userVals.length; ++i) {
		         if (userVals[i] < 0) {
		            userVals[i] = -1 * userVals[i];
		         }
		         System.out.println(userVals[i]);
		      }
	}

}
