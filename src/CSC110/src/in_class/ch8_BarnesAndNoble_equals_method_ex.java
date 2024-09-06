package in_class;

public class ch8_BarnesAndNoble_equals_method_ex {

	public static void main(String[] args)
	{
		Ch8_Customers Cust1;
		Cust1 = new Ch8_Customers();
		
		Ch8_Customers Cust2 = new Ch8_Customers();
		
		if (Cust1.equals(Cust2) )
		{
			System.out.println("Customers are the same.");
		}
		else
			System.out.println("these are 2 different people");
	
	}

}
