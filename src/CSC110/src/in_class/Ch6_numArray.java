package in_class;
import java.util.Scanner;
public class Ch6_numArray {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		int n1, n2, n3;
		int sum = 0;
		double avg;
		
		int[]myIntList = new int[3];
		
		System.out.println("Enter three integers");
		
		myIntList[0] = scnr.nextInt();
		myIntList[1] = scnr.nextInt();
		myIntList[2] = scnr.nextInt();
		
		System.out.println("value of data element at index 0 " + myIntList[0]);
		System.out.println("value of data element at index 0 " + myIntList[1]);
		System.out.println("value of data element at index 0 " + myIntList[2]);
		
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
