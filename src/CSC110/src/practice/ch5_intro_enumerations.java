package practice;
import java.util.Scanner;
/*
 * Enumerations
 * 
 * enum <name> {list of values seperated by a comma, capitalized}
 */

public class ch5_intro_enumerations {
	
	public enum LightState {RED, GREEN, YELLOW}

	public static void main(String[] args) {

		Scanner scnr = new Scanner (System.in);
		int myNum;
		
		LightState lightvalue;
		
		lightvalue = LightState.GREEN;
		
		System.out.println(lightvalue.values().length);
		
		if (lightvalue == LightState.GREEN)
			System.out.println("go, go, go");
		
		for (LightState x : LightState.values())
		{
			System.out.println(x);
			switch (x)
			{
				case GREEN: {
							System.out.println("go, go go");
							}
				case YELLOW: {
							System.out.println("slow down");
							}
				case RED: {
							System.out.println("stop");
							break;
						}
				default: System.out.println("not an enum value");
			}
		}

	}

}
