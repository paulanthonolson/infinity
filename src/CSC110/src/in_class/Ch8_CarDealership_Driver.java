package in_class;

public class Ch8_CarDealership_Driver {

	public static void main(String[] args) {

		Ch8_CarDealership Avondale_Toyota = new Ch8_CarDealership("Avondale Toyota", 1999, 25999.00);
	
		System.out.println(Avondale_Toyota.get_storeName());
		System.out.println(Avondale_Toyota.get_yearOpened());
		System.out.println(Avondale_Toyota.get_averagePrice());

	}

}
