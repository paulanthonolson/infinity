package in_class;
/*
 * This program will use the Ch8 customers class definition
 */

public class Ch8_CustomersDriver {

	public static void main(String[] args) {
		
		// construct a new Customer as an object in memory
		Ch8_Customers cust1 = new Ch8_Customers();
		
		System.out.println("Customer data created with default constructor");
		System.out.println("**************************************");
		System.out.println(cust1.get_age());
		System.out.println(cust1.get_avgSpending());
		System.out.println(cust1.get_firstInitial());
		System.out.println(cust1.get_lastName());
		System.out.println(cust1.get_proNouns());
		System.out.println();
		
		
		cust1.set_age(4500);
		
		System.out.println("Customer data after changing age value");
		System.out.println("**************************************");
		System.out.println(cust1.get_avgSpending());
		System.out.println(cust1.get_avgSpending());
		System.out.println(cust1.get_firstInitial());
		System.out.println(cust1.get_lastName());
		System.out.println(cust1.get_proNouns());
		System.out.println();
		
		// construct cust2 with ALL instance variable parameters
		Ch8_Customers cust2 = new Ch8_Customers(4500, 290.45, 'J', "Nutt","He/Him", new Ch8_Books[3]);
		
		System.out.println("Customer data created with constructor using all instance variables");
		System.out.println("**************************************");
		System.out.println(cust2.get_age());
		System.out.println(cust2.get_avgSpending());
		System.out.println(cust2.get_firstInitial());
		System.out.println(cust2.get_lastName());
		System.out.println(cust2.get_proNouns());
		System.out.println();
		
	} //end main

} //end class
