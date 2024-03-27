package in_class;

public class Ch8_Automobile {

	private double fuel;
	private double speed;
	private String license;
	
	public void accelerate(double pedalPressure) {
		if (pedalPressure > .25)
		{
			fuel = fuel - (fuel*5);
			speed = speed + 5;
		}
	}
	public void decelerate(double pedalPressure) {
		
	} 
	
	public Ch8_Automobile() {
		this.fuel = 100;
		this.speed = 55;
		this.license = "MAX";
	}
	
	public Ch8_Automobile(double fuel_init, double speed_init, String license_init) {
		this.set_fuel(fuel_init);
		this.set_speed(speed_init);
		this.set_license(license_init);
	}

	public double get_fuel() {
		return this.fuel;
}
	public void set_fuel(double fuel_in) {
		this.fuel = fuel_in;
}
	public double get_speed() {
		return this.speed;
}
	public void set_speed(double speed_in) {
		this.speed = speed_in;
}
	public String get_license() {
		return this.license;
}
	public void set_license(String license_in) {
		this.license = license_in;
}

}
