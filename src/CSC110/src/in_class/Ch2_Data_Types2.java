package in_class;
import java.util.Scanner;
/*
 * Paul Olson
 * 1/31/23
 * To follow along with notes from class and explore data types and Scanner
 */

public class Ch2_Data_Types2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("begin program");
		
		byte b;
		b = 127;
		
		short s;
		s = 32000;
		
		int i;
		i = 1000000;
		
		long l;
		l = 90000000000000L;
		
		float f;
		f = 10.234f;
		
		double d;
		d = 10.23456789;
		
		boolean isMonsterHungry;
		isMonsterHungry = true;
		
		System.out.println("What size is a byte? ");
		b = scnr.nextByte();
		System.out.println("What size is a short? ");
		s = scnr.nextShort();
		System.out.println("What size is an int? ");
		i = scnr.nextInt();
		System.out.println("What size is a long? ");
		l = scnr.nextLong();
		System.out.println("What size is a float? ");
		f = scnr.nextFloat();
		System.out.println("What size is a double? ");
		d = scnr.nextDouble();
		System.out.println("Is the monster hungry? ");
		scnr.nextBoolean();
		
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(isMonsterHungry);
		
		
		
		
		
		
		
		
		
		
		
		
		scnr.close();
		System.out.println("end program");

	}

}
