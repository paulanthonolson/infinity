package in_class;
import java.util.Scanner;
public class Ch6_numArrayForLoop {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		int n1, n2, n3;
		int sum = 0;
		double avg;
		
		int[]myIntList = new int[3];
		
		System.out.println("Enter three integers");
		
		for (int index = 0; index < myIntList.length; index++) {
			myIntList[index] = scnr.nextInt();
		}
		
		for (int index = 0; index < myIntList.length; index++) {
			System.out.println("The value at the " + index + " index is " + myIntList[index]);
			
		}
		
		n1 = myIntList[0];
		sum = sum + n1;
		
		n2 = myIntList[1];
		sum = sum + n2;
		
		n3 = myIntList[2];
		sum = sum + n3;
		
		avg = sum / 3.0;
		
		System.out.println("value of sum is " + sum);
		System.out.println("value of average is " + avg);
		
		scnr.close();

	}

}
