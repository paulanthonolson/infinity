package in_class;

public class ch8_BarnesAndNoble_equals_method_ex {

	public static void main(String[] args)
	{
		ch8_Customers Cust1;
		Cust1 = new ch8_Customers();
		
		ch8_Customers Cust2 = new ch8_Customers();
		
		if (Cust1.equals(Cust2) )
		{
			System.out.println("Customers are the same.");
		}
		else
			System.out.println("these are 2 different people");
	
	}

}
