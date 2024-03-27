package in_class;

public class Ch6_AssignArrays_and_CompareDataInArrays {

	public static void main(String[] args) {
		
		double[] pricesJanurary = {1.29, 9.99, 22.50, 4.55, 7.15, 6.49};
		double[] pricesFebruary = {1.29, 10.99, 22.50, 4.55, 7.35, 6.49};
		
		// pricesFebruary = pricesJanurary;
		
		System.out.println("Jan address: " + pricesJanurary);
		System.out.println("Feb address: " + pricesFebruary);
		
	
		for (int index = 0; index < pricesJanurary.length; index++) {
			System.out.print("Jan Index" + (index) + " " + pricesJanurary[index] + "\t");
			System.out.println("Feb Index" + (index) + " " + pricesFebruary[index]);
		}

	}

}
