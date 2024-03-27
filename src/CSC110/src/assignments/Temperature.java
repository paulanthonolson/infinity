package assignments;
import java.util.Scanner;
/*
 * Paul Olson
 * 2/2/23
 * CSC110AB-26730
 * Temperature
 * To demonstrate the use of type casting. At least one variable has to be written as a double or else 
 * Java defaults to calculating as an integer and floating-point division is not performed.
 * 
 */

public class Temperature {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		double Fahrenheit;
		double Celsius;
		double Kelvin;
		double Delisle;
		double Romer;
		
		System.out.println("Temperature: Paul Olson");
		System.out.println("Please enter a temperature value in Fahrenheit: ");
		Fahrenheit = scnr.nextDouble();
		
		Celsius = (Fahrenheit - 32) * 5.0/9.0;
		System.out.print(Fahrenheit + "\u00B0 Fahrenheit is ");
		System.out.printf ("%.4f", Celsius);
		System.out.println("\u00B0 Celcius.");
		
		Kelvin = Celsius + 273.15;
		System.out.print(Fahrenheit + "\u00B0 Fahrenheit is ");
		System.out.printf ("%.4f", Kelvin);
		System.out.println("\u00B0 Kelvin.");
		
		Delisle = (100 - Celsius) * 3.0/2.0;
		System.out.print(Fahrenheit + "\u00B0 Fahrenheit is ");
		System.out.printf ("%.4f", Delisle);
		System.out.println("\u00B0 Delisle.");
		
		Romer = (Fahrenheit - 32) * 7.0/24.0 + 15.0/2.0;
		System.out.print(Fahrenheit + "\u00B0 Fahrenheit is ");
		System.out.printf ("%.4f", Romer);
		System.out.println("\u00B0 Romer.");
		
		
		scnr.close();

	}

}
