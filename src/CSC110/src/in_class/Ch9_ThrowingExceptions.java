package in_class;
import java.util.Scanner;

public class Ch9_ThrowingExceptions 
{
	Scanner scnr = new Scanner(System.in);
    double gasVolume;
    double oilVolume;
    double mixRatio = 0.0;
    
    {

    try 
    {
       gasVolume = scnr.nextDouble();
       oilVolume = scnr.nextDouble();

       mixRatio = gasVolume / oilVolume;

       if (Double.isNaN(mixRatio)) 
       {
          throw new Exception("mixRatio is NaN!");
       }

       System.out.println("mixRatio: " + mixRatio);
    }
    catch (Exception excpt) 
    {
       System.out.println(excpt.getMessage());
    }
  }
}
