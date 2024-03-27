package in_class;
import java.util.Scanner;
public class Ch9_ThrowingExceptions2 {

	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
	      double massVal = 0;   // Object mass (kg)
	      double volumeVal = 0; // Object volume (m^3)
	      double densityCalc;   // Resulting density

	      try {
	         massVal = scnr.nextDouble();

	         // Error checking, non-negative mass
	         if (massVal < 0.0) {
	            throw new Exception("Invalid mass");
	         }

	         volumeVal = scnr.nextDouble();

	         // Error checking, non-negative volume
	         if (volumeVal < 0.0) {
	            throw new Exception("Invalid volume");
	         }

	         densityCalc = massVal / volumeVal;

	         System.out.print("Density: " + densityCalc);
	      }
	      catch (Exception excpt) {
	         // Prints the error message passed by the throw statement.
	         System.out.print(excpt.getMessage());
	      }

	}

}
