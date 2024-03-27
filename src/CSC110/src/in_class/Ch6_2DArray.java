package in_class;
import java.util.Scanner;
public class Ch6_2DArray {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		int NumOfWeeks_row = 2;
		int NumOfSubjects_col = 3;
		String[] subjects;
		double[][]mySubjectGrades;
		
		System.out.println("Please enter how many subjects you are working with ");
		NumOfSubjects_col = scnr.nextInt();
		
		System.out.println("Please enter how many weeks you are working with ");
		NumOfWeeks_row = scnr.nextInt();
		
		
		subjects = new String [NumOfSubjects_col];
		mySubjectGrades = new double[NumOfWeeks_row][NumOfSubjects_col];
		
		scnr.nextLine();
		System.out.println("Array size/Number of subjects " + subjects.length);
		
		
		/*
		 * populate the subjects array
		 */
		
		for (int index = 0; index < subjects.length; index++) {
			
			System.out.println("please enter subject " + (index + 1));
			subjects[index] = scnr.nextLine();
			}
		
		/*
		 * populate the 2D array
		 */
		
		for (int index_row = 0; index_row < NumOfWeeks_row; index_row++) {
			{
				for (int index_col = 0; index_col< NumOfSubjects_col; index_col++) {
					System.out.println("please enter the grade for the subject " + subjects[index_col] + " during week " + index_row);
					mySubjectGrades[index_row][index_col] = scnr.nextDouble();
					
				}
			}
			
			
		}
		
		
		/*
		 * output
		 */
		
		for (int index_row = 0; index_row < NumOfWeeks_row; index_row++) {
			{
				for (int index_col = 0; index_col< NumOfSubjects_col; index_col++) {
					
					System.out.println(mySubjectGrades[index_row][index_col]);
					
				}
			}
			
			
		}
		
		for (int index = 0; index < subjects.length; index++) {
			
			System.out.println(subjects[index]);
		
			
			}
		

	}

}
