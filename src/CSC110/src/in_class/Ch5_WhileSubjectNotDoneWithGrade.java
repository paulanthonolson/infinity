package in_class;
import java.util.Scanner;
public class Ch5_WhileSubjectNotDoneWithGrade {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		String subject;
		int grade;
		
		System.out.println("Enter a subject");
		subject = scnr.nextLine();
		
		
		
		while (!(subject.equals("done"))) {
			System.out.println(subject);
			System.out.println("Please enter a grade");
			grade = scnr.nextInt();
				{
				while (grade > 0) {
					System.out.println(grade);
					System.out.println("Please enter a grade");
					grade = scnr.nextInt();
					System.out.println("Enter a subject");
					subject = scnr.nextLine();
					scnr.nextLine();
									}
		
				}
			System.out.println("Enter a subject");
			subject = scnr.nextLine();
										}
			
	}

}
