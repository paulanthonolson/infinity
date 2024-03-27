package in_class;
/*
 * Paul Olson
 * 4/20/23
 * CSC110AB-26730
 * Ch8_CarDealership
 */

public class Ch8_CarDealership 
{
	String storeName;
	int yearOpened;
	double averagePrice;
	
	public Ch8_CarDealership() {
		this.storeName = "My Cozy Slipper";
		this.yearOpened = (2001);
		this.averagePrice = 19.99;
	}
	
	public Ch8_CarDealership(String storeName_init, int yearOpened_init, double averagePrice_init) {
		this.set_storeName(storeName_init);
		this.set_yearOpened(yearOpened_init);
		this.set_averagePrice(averagePrice_init);
	}
	
	public String get_storeName() 
	{
		return this.storeName;
	}
	
	public void set_storeName(String storeName_in) 
	{
		this.storeName = storeName_in;
	}
	
	public int get_yearOpened() 
	{
		return this.yearOpened;
	}
	
	public void set_yearOpened(int yearOpened_in) 
	{
		this.yearOpened = yearOpened_in;
	}
	
	public double get_averagePrice() 
	{
		return this.averagePrice;
	}
	
	public void set_averagePrice(double averagePrice_in) 
	{
		this.averagePrice = averagePrice_in;
	}
	

}
