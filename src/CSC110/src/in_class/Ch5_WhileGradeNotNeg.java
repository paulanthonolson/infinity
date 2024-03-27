package in_class;
import java.util.Scanner;
public class Ch5_WhileGradeNotNeg {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		int grade;
		
		System.out.println("Please enter your grade");
		grade = scnr.nextInt();
		
		while (grade > 0) {
			System.out.println(grade);
			grade = scnr.nextInt();
						}

	}

}
