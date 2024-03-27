package practice;
import java.util.Scanner;
public class ch5_nested_loop_while_loop {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		
		String subject;
		int grade;
		
		System.out.println("please enter a subject");
		subject = scnr.nextLine();
		
		while (!(subject.toLowerCase().equals("done"))) // sets to lowercase and compares to the word done
		{
			System.out.println("Subject: " + subject);
			
			System.out.println("Please enter the grade");
			grade = scnr.nextInt();
			
			while (grade >= 0)
			{
				System.out.println("grade: " + grade);
				System.out.println("please enter another grade or -1 when done");
				grade = scnr.nextInt();
			}
			scnr.nextLine();
			
			System.out.println("Please enter the next subject, or Done when you are done entering grades.");
			subject = scnr.nextLine();
		}
		
		System.out.println("End of program");

	}

}
