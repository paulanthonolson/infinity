package practice;

public class ch5_for_nested_loop1 {

	public static void main(String[] args) {
		
		for (int row = 1; row <= 12; row ++)
		{
			for (int column = 0; column <= 12; column++)
			{
				if (column == 0)
					System.out.print(row + "\t");
				else
					System.out.print((row*column) + "\t");
					
			}
			System.out.println();
		}
		System.out.println("End of program");
	}

}
