package in_class;

public class Ch4If_Statements {

	public static void main(String[] args) {
		
		double weightOfPet1;
		double weightOfPet2;
		final double IDEALWEIGHTOFPET = 23.5;
		
		weightOfPet1 = 12.4;
		weightOfPet2 = 23.0;
		
		if (weightOfPet1  < IDEALWEIGHTOFPET) 
		{
			System.out.println("The weight of pet1 needs to increase to " + IDEALWEIGHTOFPET);
		}
		
		System.out.println("pet1: " + weightOfPet1);
		System.out.println("pet2: " + weightOfPet2);

	}

}
