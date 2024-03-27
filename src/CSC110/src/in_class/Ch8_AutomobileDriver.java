package in_class;

public class Ch8_AutomobileDriver {

	public static void main(String[] args) {

		Ch8_Automobile patsCar = new Ch8_Automobile();
		
		System.out.println("There is " + patsCar.get_fuel() + " units of fuel.");
		System.out.println("You are going " + patsCar.get_speed() + " MPH.");
		System.out.println("The license plate is " + patsCar.get_license());
		System.out.println();

	}

}
