package assignments;

public class Player
{
	/*
	 * Unified Modeling Language (UML)
	 * 
	 * INSTANCE VARIABLES
	 * - playerName: String
	 * - health: Int
	 * 
	 * CONSTRUCTORS
	 * 
	 * Default constructor Player_PaulOlson() 
	 * Constructor with all parameters
	 * 
	 * METHODS
	 * + getPlayerName(): String
	 * + getHealth(): Int
	 * + getItemInventory(): String
	 * + getItemInventoryCount(): int
	 * + getDamageCausedbyItem(): int
	 * 
	 * HELPER METHODS
	 * 
	 * toString() overide
	 * Equals method
	 */
	/***************************************************************************************************
	 * Instance Variables
	 */
	private String playerName;
	private int health;
	
	/*****The ItemInventory array will represent the item inventory that the player can have.
	 * Items:
	 * index 0 represents : fist
	 * index 1 represents : wood
	 * index 2 represents : wood pickaxe
	 * index 3 represents : stone
	 * index 4 represents : stone pickaxe
	 * index 5 represents : iron
	 * index 6 represents : wooden sword
	 * index 7 represents : stone sword
	 * index 8 represents : iron sword
	 * 
	 * index 0 will always exist :  fists
	 * other items will be null and added as player collects inventory
	 */

	private String[] ItemInventory;// Note, this is just the reference variable. The list of items will be created later.
	
	/*****The ItemInventoryCount array will represent the item inventory count that the player can have.
	 * Items:
	 * index 0 represents : fist
	 * index 1 represents : wood
	 * index 2 represents : wood pickaxe
	 * index 3 represents : stone
	 * index 4 represents : stone pickaxe
	 * index 5 represents : iron
	 * index 6 represents : wooden sword
	 * index 7 represents : stone sword
	 * index 8 represents : iron sword
	 * 
	 * index 0 will always exist :  2
	 * other items will be 0 and added to as player collects inventory
	 */
	private int[] ItemInventoryCount; // // Note, this is just the reference variable. The list of item counts will be created later.
	
	/*****The DamageCausedByItem array will represent the damage the item can cause per item.
	 * 	 * * Note: Although some array values will always cause 0 damage,
	 *     		  	we will keep them to simplify programming technique and can allow damage
	 * 				in a later version should you chose to continue building the game after 
	 * 				our class is over. 
	 * Item Damage:
	 * index 0 represents : fists causing -1
	 * index 1 represents : wood causes 0 damage
	 * index 2 represents : wood pickaxe causes 0 damage
	 * index 3 represents : stone causes 0 damage
	 * index 4 represents : stone pickaxe causes 0 damage
	 * index 5 represents : iron causes 0 damage
	 * index 6 represents : wooden sword causes -2 damage
	 * index 7 represents : stone sword causes -3 damage
	 * index 8 represents : iron sword causes -4 damage
	 * 
	 * index 0 will always exist : -1

	 */
	int[] DamageCausedbyItem; // // Note, this is just the reference variable. The list of damage values will be created later.
	
	/***************************************************************************************************
	 * CONSTRUCTORS
	 */
	
	/**
	 * Default Constructor
	 */
	public Player() 
	{
		/*Step 1: Edit this default constructor 
		 * to use the setter methods and set these values
		 * 
		 * Player Name to "Unknown"
		 * Health to GameConstantsAndStaticVars.PLAYER_HEALTH_MAX
		 * ItemInventory to null  //array has no list
		 * ItemInventoryCount to null //array has no list
		 * DamageCausedbyItem to null //array has no list
		 */
		
		this.setPlayerName("Unknown");
		this.setHealth(GameConstantsAndStaticVars.PLAYER_HEALTH_MAX);
		this.setItemInventory(null);
		this.setItemInventoryCount(null);
		this.setDamageCausedbyItem(null);
	}


	/** All Parameter Constructor
	 * @param playerName
	 * @param health
	 * @param damage
	 * @param itemInventory
	 * @param itemInventoryCount
	 * @param damageCausedbyItem
	 */
	public Player(String playerName_initial, int health_initial, 
					String[] itemInventory_initial, int[] itemInventoryCount_initial,
					int[] damageCausedbyItem_initial) 
	{
		this.setPlayerName(playerName_initial);
		this.setHealth(health_initial);
		this.setItemInventory(itemInventory_initial);  //an array address is being assigned
		this.setItemInventoryCount(itemInventoryCount_initial); //an array address is being assigned
		this.setDamageCausedbyItem(damageCausedbyItem_initial);  //an array address is being assigned
	}

	/***************************************************************************************************
	 * Getters and Setters
	 */
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName_in) {
		this.playerName = playerName_in;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 * a positive or negative argument value is expected because
	 *  the health will either decrease or increase 
	 */
	public void setHealth(int health_in) 
	{
		int newHealth;
		
		newHealth = this.getHealth() + health_in;
		
		/*
		 * Step 2: 
		 * Add an if statement here. 
		 * 
		 * if the newHealth value is greater than the GameConstantsAndStaticVars.PLAYER_HEALTH_MAX
		 * constant value then set the health = the constant value
		 * otherwise set the health = newHealth.
		 * 
		 * So, it would look start to look like :
		 * if (newHealth > GameConstantsAndStaticVars.PLAYER_HEALTH_MAX) ...
		 */
		if (newHealth > GameConstantsAndStaticVars.PLAYER_HEALTH_MAX) 
		{
			health = GameConstantsAndStaticVars.PLAYER_HEALTH_MAX;
		}
		
		else 
		{
			health = newHealth;
		}
	}

	/**
	 * @return the itemInventory
	 */
	public String[] getItemInventory() {
		return ItemInventory;
	}

	/**
	 * @param itemInventory the itemInventory to set
	 */
	public void setItemInventory(String[] itemInventory_in) {
		ItemInventory = itemInventory_in;
	}

	/**
	 * @return the itemInventoryCount
	 */
	public int[] getItemInventoryCount() {
		return ItemInventoryCount;
	}

	/**
	 * @param itemInventoryCount the itemInventoryCount to set
	 */
	public void setItemInventoryCount(int[] itemInventoryCount_in) {
		ItemInventoryCount = itemInventoryCount_in;
	}

	/**
	 * @return the damageCausedbyItem
	 */
	public int[] getDamageCausedbyItem() {
		return DamageCausedbyItem;
	}

	/**
	 * @param damageCausedbyItem the damageCausedbyItem to set
	 */
	public void setDamageCausedbyItem(int[] damageCausedbyItem_in) {
		DamageCausedbyItem = damageCausedbyItem_in;
	}
	
	public String drawStars()
	{
	String healthStr = "";
	int playerHealth = getHealth();
	
	for (int i = 0; i < playerHealth; i++)
		{
		healthStr = healthStr + "*";
		}
	return healthStr;
	}

	/***************************************************************************************************
	 * Helper Methods
	 */
	
	@Override
	public String toString() {
		
		String playerStr; 
		
		playerStr = "Player Information: \n" + "Name: " + this.getPlayerName() + "\n" +
				"Health: " + this.getHealth() + "\n" + drawStars() + "\n";
		
		return playerStr;
	}

	/**
	 * 
	 * @param MaterialCount
	 * @param inventoryCountIdx
	 */
	public void updateInventoryCount(int MaterialCount, int inventoryCountIdx)
	{
		this.ItemInventoryCount[inventoryCountIdx] = this.ItemInventoryCount[inventoryCountIdx] + MaterialCount;
	}
	
	/**
	 * 
	 * @param ItemDamage
	 * @param DamageCausedByItemIdx
	 */
	public void updateDamageCausedbyItem(int ItemDamage, int DamageCausedByItemIdx)
	{
		this.DamageCausedbyItem[DamageCausedByItemIdx] = ItemDamage;
	}

	//Equals method
	public boolean equals(Player player_obj) 
	{
		if 
		( 
			( this.getPlayerName().equals(player_obj.getPlayerName())) &&
			( this.getHealth()==(player_obj.getHealth()))
			
		)
		{
		return true;
		}
		
		else
			
		{
			return false;
		}
	}

}
