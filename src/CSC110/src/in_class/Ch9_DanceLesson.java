package in_class;
import java.util.Scanner;

public class Ch9_DanceLesson
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        try 
        {
        
        	System.out.println("Enter number of male dancers:");
        	int men = keyboard.nextInt();

        	System.out.println("Enter number of female dancers:");
        	int women = keyboard.nextInt();
        
        
        

        if (men == 0 && women == 0)
        
        {
        	throw new Exception("Lesson is cancelled. No students.");

        }
        
        else if (men == 0)
        
        {
            System.out.println("Lesson is canceled. No men.");
            System.exit(0);
        }
        
        else if (women == 0)
        
        {
            System.out.println("Lesson is canceled. No women.");
            System.exit(0);
        }
        
       // women >= 0 && men >= 0
       if (women >= men)
            System.out.println("Each man must dance with " +
                          women/(double)men + " women.");
        else
            System.out.println("Each woman must dance with " +
                                      men/(double)women + " men.");
        System.out.println("Begin the lesson.");
        
        }
        
        catch (Exception excpt)
        
        {
        	System.out.println(excpt.getMessage());
        	System.out.println(0);
        }
        
        
        
       
    }
}
