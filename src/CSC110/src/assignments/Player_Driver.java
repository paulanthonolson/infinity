package assignments;

public class Player_Driver {

	public static void main(String[] args) {
		
		Player_PaulOlson myPlayerReferenceVar = new Player_PaulOlson();
	
		myPlayerReferenceVar.setPlayerName("Paul");
		myPlayerReferenceVar.setHealth(10);
		myPlayerReferenceVar.setItemInventory(new String [GameConstantsAndStaticVars.NUM_OF_ITEMS]);
		myPlayerReferenceVar.setItemInventoryCount(new int [GameConstantsAndStaticVars.NUM_OF_ITEMS]);
		myPlayerReferenceVar.setDamageCausedbyItem(new int [GameConstantsAndStaticVars.NUM_OF_ITEMS]);
		
		System.out.println(myPlayerReferenceVar);
		
		Player_PaulOlson myPlayerReferenceVar_again = new Player_PaulOlson();
		
		myPlayerReferenceVar_again.setPlayerName("Paul");
		myPlayerReferenceVar_again.setHealth(10);
		myPlayerReferenceVar_again.setItemInventory(new String [GameConstantsAndStaticVars.NUM_OF_ITEMS]);
		myPlayerReferenceVar_again.setItemInventoryCount(new int [GameConstantsAndStaticVars.NUM_OF_ITEMS]);
		myPlayerReferenceVar_again.setDamageCausedbyItem(new int [GameConstantsAndStaticVars.NUM_OF_ITEMS]);
		
		
		
		if (myPlayerReferenceVar.equals(myPlayerReferenceVar_again))
		{
			System.out.println("The players are the same.");
		}
		else
		{
			System.out.println("The players are different.");
		}
		
	}

}
