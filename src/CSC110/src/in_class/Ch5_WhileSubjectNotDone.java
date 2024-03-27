package in_class;
import java.util.Scanner;
public class Ch5_WhileSubjectNotDone {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		String subject;
		
		System.out.println("Enter a subject");
		subject = scnr.nextLine();
		
		while (!(subject.equals("done"))) {
			System.out.println(subject);
			System.out.println("Enter a subject");
			subject = scnr.nextLine();
										}

	}

}
