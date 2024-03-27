package in_class;
/*
 * Author: Meha Trivedi
 * Date: 9/4/18
 * Purpose: show data type examples
 * 
 */
public class Show_TypeCasting
{

	public static void main(String[] args) 
	{
		//declare data types
		byte mybyte;
		short myshort;
		int myint;
		long mylong;
		
		//mybyte = 1024 - this is a type mismatch, 1024 is too big
		//mbyte = 128 - 128 is still too big because 127 is the max
		mybyte = 127;

		myshort = (short)(mybyte*mybyte);
		
		myint = (int)(myshort*myshort);
		
		myint = 2147483647;
		
		//mylong = ((long)(myint) * (long)(myint));
		
		mylong = (long)(myint) * myint;
		
		System.out.println("myshort value is = " + myshort);
		System.out.println("myint value is = " + myint);
		System.out.println("mylong value is = " + mylong);
	}

}
