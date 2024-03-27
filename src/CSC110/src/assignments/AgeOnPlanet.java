package assignments;
import java.util.Scanner;
/*
 * Paul Olson
 * 2/5/23
 * CSC110AB-26730
 * Age On Planet
 * To convert a user's age from Earth years to years old on other planets.
 */

public class AgeOnPlanet {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		final double MERCURY = 87.96;
		final double VENUS = 224.68;
		final double EARTH = 365.26;
		final double MARS = 686.98;
		final double JUPITER = 365.26 * 11.862;
		final double SATURN = 365.26 * 29.456;
		final double URANUS = 365.26 * 84.07;
		final double NEPTUNE = 365.26 * 164.81;
		final double PLUTO = 365.26 * 247.7;
		
		double mercuryAge;
		double venusAge;
		double earthAge;
		double marsAge;
		double jupiterAge;
		double saturnAge;
		double uranusAge;
		double neptuneAge;
		double plutoAge;
		
		System.out.println("Age On Planet: Paul Olson");
		System.out.println("Please enter your age in Earth years: ");
		earthAge = scnr.nextInt();
		
		mercuryAge = earthAge / MERCURY * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ mercuryAge);
		System.out.println(" years old in Mercury years.");
		
		venusAge = earthAge / VENUS * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ venusAge);
		System.out.println(" years old in Venus years.");
		
		System.out.print("You are ");
		System.out.printf("%.3f",+ earthAge);
		System.out.println(" years old in Earth years.");
		
		marsAge = earthAge / MARS * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ marsAge);
		System.out.println(" years old in Mars years.");
		
		jupiterAge = earthAge / JUPITER * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ jupiterAge);
		System.out.println(" years old in Jupiter years.");
		
		saturnAge = earthAge / SATURN * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ saturnAge);
		System.out.println(" years old in Saturn years.");
		
		uranusAge = earthAge / URANUS * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ uranusAge);
		System.out.println(" years old in Uranus years.");
		
		neptuneAge = earthAge / NEPTUNE * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ neptuneAge);
		System.out.println(" years old in Neptune years.");
		
		plutoAge = earthAge / PLUTO * EARTH;
		System.out.print("You are ");
		System.out.printf("%.3f",+ plutoAge);
		System.out.println(" years old in Pluto years.");
		
		scnr.close();

	}

}
