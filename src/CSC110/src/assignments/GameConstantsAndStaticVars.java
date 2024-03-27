package assignments;
/*
 * Author: Meha Trivedi
 * Please note that this file is to hold a list of constants 
 * and static variables associated to the Game project for the
 * CSC110AB course at EMCC.
 * 
 * The game is based on my very high level understanding of the Minecraft game
 * All credit of any gaming ideas taken from the game goes to the original creators of Minecraft.
 */
public class GameConstantsAndStaticVars 
{
	
	public static final int NUM_OF_RAW_MATERIALS = 6;  //constant and public
	public static final int NUM_OF_ITEMS = 9;  //constant and public
	public static int numOfEnemiesSpawned = 0; //not constant, can update in other classes and public

	/* Acquire Items x Material Needed to Acquire: 2Dimensional 8x8 Array
	 * As you can see there are many zeroes in this data set.
	 * However, setting up the programming structure this way allows us 
	 * to code it without hardcoding in the other programs.
	 * 
	 * /*
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
	 * Columns: Items to Acquire
	 * Rows: 	Materials Needed to Acquire
	 * 
	 * 	//1 fist -> 1 wood
		//4 wood -> 1 wood pick ax 
		//4 wood -> 1 wood sword
		//1 wood pickaxe -> 1 stone
		//2 wood, 1 stone -> stone pickaxe
		//2 wood , 1 stone -> stone sword
		//1 stone pickaxe -> 1 iron
		//2 wood , 1 iron -> iron sword		
	 * */
	 
	public static final int[][] MATERIALS_COST = {
			{0,1,0,0,0,0,0,0,0}, //fist needed
			{0,0,4,0,2,0,4,2,2}, //wood needed 
			{0,0,0,1,0,0,0,0,0}, //wood pickaxe needed
			{0,0,0,0,1,0,0,1,0}, // stone needed 
			{0,0,0,0,0,1,0,0,0}, // stone pickaxe needed
			{0,0,0,0,0,0,0,0,1}, // iron needed
			{0,0,0,0,0,0,0,0,0}, // wooden sword needed 
			{0,0,0,0,0,0,0,0,0}, //stone sword needed
			{0,0,0,0,0,0,0,0,0}, //iron sword needed
			
	};
	/* PLAYER CONSTANTS
	 * 
	 * DEFAULT VALUES
	 *  Player Health = 10
	 *  Health gained per apple = +3
	 * 	ITEMS = {"fist", "wood", "wooden pickaxe", "stone", "stone pickaxe", "iron",
											"wooden sword", "stone sword", "iron sword"};
		ITEM default Values:
		fist = 2
											
	 * Item = fists, 
	 * DAMAGE
	 * Item				DamageCaused
	 * ------------		-------------
		Fist			1
		Wooden Sword	2
		Stone Sword		3
		Iron Sword		4
	 */
	public static final int PLAYER_HEALTH_MAX = 10;
	public static final int HEALTH_PER_APPLE = 2;
	public static final String[] ITEMS = {"fist", "wood", "wooden pickaxe", "stone", "stone pickaxe", "iron",
			"wooden sword", "stone sword", "iron sword"};
	public static final int[] PLAYER_CAUSED_DAMAGE = {1, 0, 0, 0, 0, 0, 2, 3, 4};
	
	public static final int FISTS = 2;
	
	//Player Caused Damage
	public static final int FIST_DAMAGE = 1;
	public static final int WOOD_SWORD_DAMAGE = 2;
	public static final int STONE_SWORD_DAMAGE = 3;
	public static final int IRON_SWORD_DAMAGE = 4;
	
	/* ENEMY CONSTANTS
	 * NUMBER OF ENEMIES = 5
	 * 
	 * ENEMY HEALTH
	 * 	Spider					1
		Zombie					1
		Wooden Sword Skeleton	2
		Stone Sword Skeleton	3
		Iron Sword Skeleton		4
	 * ENEMY DAMAGE
	 * 	Enemy					Damage Caused		Item
	 *  ---------------------------------------------------------
		Spider					1					fist
		Zombie					1					fist
		Wooden Sword Skeleton	2					Wooden Sword
		Stone Sword Skeleton	3					Stone Sword
		Iron Sword Skeleton		4					Iron Sword
	 */

	//Num of Possible Enemies
	public static final int NUM_OF_ENEMIES = 5;
	//Enemy Health
	public static final int SPIDER_HEALTH = 1;
	public static final int ZOMBIE_HEALTH = 1;
	public static final int WOODEN_SWORD_SKELETON_HEALTH = 2;
	public static final int STONE_SWORD_SKELETON_HEALTH = 3;
	public static final int IRON_SWORD_SKELETON_HEALTH = 4;
	
	//Enemy Damage
	public static final int SPIDER_DAMAGE = 1;
	public static final int ZOMBIE_DAMAGE = 1;
	public static final int WOODEN_SWORD_SKELETON_DAMAGE = 2;
	public static final int STONE_SWORD_SKELETON_DAMAGE = 3;
	public static final int IRON_SWORD_SKELETON_DAMAGE = 4;
	
	/************************************************************************************

	* Method setPlayer() will initialize player data and create a new instance of Player

	*/

	public static Player setPlayer()

	{

	/*

	* Setup Player with the ability to start with the fist and be able to set up 8

	* additional items. 

	* Item at index 0 is the fist. 

	* Initially, the player is setup with just a fist.

	*/

	String[] ItemInventory_initial = new String[GameConstantsAndStaticVars.NUM_OF_ITEMS];  //create a String array

	int[] ItemInventoryCount_initial = new int[GameConstantsAndStaticVars.NUM_OF_ITEMS]; //create an array for item count

	int[] DamageCausedbyItem_initial = new int[GameConstantsAndStaticVars.NUM_OF_ITEMS]; //create an array of damage caused by item

	//Initialize some values

	ItemInventory_initial = GameConstantsAndStaticVars.ITEMS;

	ItemInventoryCount_initial[0] = GameConstantsAndStaticVars.FISTS;

	DamageCausedbyItem_initial = GameConstantsAndStaticVars.PLAYER_CAUSED_DAMAGE; //positive number

	 

	//Create a player object:

	Player playerVar = new Player("Ima Nutt", 10, ItemInventory_initial,ItemInventoryCount_initial, DamageCausedbyItem_initial);

	      return playerVar;

	      }

	/******************************************************************************************************************************************/
}
