package assignments;
import java.util.Scanner;
import java.util.Random;

/*
 * Project Description								
	This program is going to leading to a game based on Mincecraft:
	
	1.Set the scene of the game:						
		The temperature in fahrenheit, wind_mph, and relative humidity percentage will be a randomly generated value.							
		Scenes the game can have are:  so hot that the weather can cause a heat wave, so cold that the weather can cause a frost bite, or acceptable weather.							
 	2.Prompt the user with a menu, call other methods based on menu choice, repeat the menu 						
	
 */
public class GameDriver_PaulOlson {

	public static void main(String[] args) 
	{
	
		/*******************************************************************************************
		 * Declare variables
		 */
		/*******************************************************************************************
		 * DO NOT CHANGE THESE VARIABLES
		 */
		double temperature; 
		double wind_mph;
		double relative_humidity;
		boolean isFrostBiteScene;
		boolean isHeatStrokeScene;
		int menuChoice;
		
		Scanner scnr = new Scanner(System.in);
		Random randgen = new Random();
		/*******************************************************************************************/
		
		/* STEP 1:
		 * Create and initialize a String array called menuItems. The values of the array
		 * are "Break tree", "Purchase Item", "Fight Enemy", "Quit Game"
		 */
		
		String[] menuItems = {"Break tree", "Purchase Item", "Fight Enemy","Quit Game"};
		
		/*******************************************************************************************
		 * DO NOT CHANGE THE FOLLOWING SCENE CODE
		 */
		/*******************************************************************************************
		 * Set the scene 
		 *    *** too cold -> frost bite 
		 *    *** too hot-> heat stroke 
		 *    *** cold or hot but acceptable weather
		 * 
		 */
		temperature = randgen.nextDouble(155.0) - 45.0; //-45 to 110
		wind_mph = randgen.nextDouble(55.0) + 5;
		relative_humidity = randgen.nextDouble(90.0) + 10;
		
		isFrostBiteScene = isFrostBitePossible(temperature, wind_mph);
		isHeatStrokeScene = isHeatStrokePossible (temperature, relative_humidity);
		
		setScene (temperature, isFrostBiteScene, isHeatStrokeScene);
		
		GameMenu(scnr, randgen, myPlayer, menuItems, isFrostBiteScene, isHeatStrokeScene, EnemiesSpawned);  //call method for primary game menu
		
	}  //end main method
	
	/*******************************************************************************************
	 * DO NOT CHANGE THE FOLLOWING setScene METHOD
	 */
	/********************************************************************************
	 * Method: setScene()
	 * No parameter
	 * No return type
	 */
	public static void setScene(double temperature, boolean isFrostBiteScene, boolean isHeatStrokeScene)
	{
		System.out.printf("Temperature: %.2fF \n", temperature);
		
		if (isFrostBiteScene)
		{
			System.out.println("It's very cold!");
			System.out.println("Get a frostbite today!");
		}
		else if (isHeatStrokeScene)
		{
			System.out.println("It's very hot!");
			System.out.println("Help! I'm melting!");
		}
		else if ( (temperature >= -45) && (temperature < 50) )
			System.out.println("Ccccoooolllld!! Avoid a frostbite");
		else if ( (temperature >= 50) && (temperature <= 85 ) )
			System.out.println("Gorgeous day!");
		else 
			System.out.println("Hot day! Gulp that water down!");
		
	
	} //end method: setScene
	
	/*******************************************************************************************
	 * DO NOT CHANGE THE FOLLOWING isFrostBitePossible METHOD
	 */
	/*******************************************************************************************
	 * Method:isFrostBitePossible
	 * @param temperature
	 * @param wind_mph
	 * @return boolean
	 */
	public static boolean isFrostBitePossible (double temperature, double wind_mph)
	{
	//	Random randgen = new Random();
		double windChill;
		
		
		windChill =  35.74 + (.6215 * temperature) - (35.75 * (Math.pow(wind_mph,.16))) 
				+ (.4275*temperature*(Math.pow(wind_mph,.16)));
				
		
		
		if ( (windChill < -18.0)) // || (temperature < 20.0 && windChill < 0.0) ) //calculates to less than -18
		{
			System.out.printf("Wind %.2f mph\n",wind_mph);
			System.out.printf("Windchill: %.2fF\n", windChill);
			return true;
		}
		else return false;
	} //end method: isFrostBitePossible

	/*******************************************************************************************
	 * DO NOT CHANGE THE FOLLOWING isHeatStrokePossible METHOD
	 */
	/*******************************************************************************************
	 * Method: isHeatStrokePossible
	 * @param temperature
	 * @param relative_humidity
	 * @return boolean
	 */
	public static boolean isHeatStrokePossible (double temperature, double relative_humidity)
	{
		double heatIdx;
		
		//The regression equation of Rothfusz is
				heatIdx = -42.379 + 2.04901523*temperature + 10.14333127*relative_humidity - .22475541*temperature*relative_humidity - .00683783*temperature*temperature - .05481717*relative_humidity*relative_humidity + .00122874*temperature*temperature*relative_humidity + .00085282*temperature*relative_humidity*relative_humidity - .00000199*temperature*temperature*relative_humidity*relative_humidity;
				//System.out.println(heatIdx);
				/*
				 * If the RH is less than 13% and the temperature is between 80 and 112 degrees F,
				 *  then the following adjustment is subtracted from HI: ADJUSTMENT = [(13-RH)/4]*SQRT{[17-ABS(T-95.)]/17}
				 */
				if  ( (relative_humidity < 13.0) && ( (temperature > 80.0) && (temperature < 112.0)) )
				{
					heatIdx = heatIdx - ( ((13.0-relative_humidity)/4.0)*Math.sqrt((17.0-Math.abs(temperature-95.0))/17.0) );
				}
				/*
				 * if the RH is greater than 85% and the temperature is between 80 and 87 degrees F, 
				 * then the following adjustment is added to HI:

				 */
				if ( (relative_humidity >= 85.0) && (temperature >=80.0 && temperature <= 87.0 ) )
				{
					heatIdx = heatIdx + ( ((relative_humidity-85.0)/10.0) * ((87.0-temperature)/5.0) );
				
					/*
					 * The Rothfusz regression is not appropriate when conditions of temperature and humidity warrant 
					 * a heat index value below about 80 degrees F. 
					 * In those cases, a simpler formula is applied to calculate values consistent with Steadman's results:
					 * In practice, the simple formula is computed first and the result averaged with the temperature.
					 */
				
				
					if (heatIdx <= 80.0)
					{
						heatIdx = ( (0.5 * (temperature + 61.0 + ((temperature-68.0)*1.2) + (relative_humidity*0.094))) + temperature)/2.0;
					}
				}
				
				
				if ( (temperature >= 90.0 && heatIdx > 103.0) || (temperature >= 86.0 && heatIdx > 102.0) )
				{
					System.out.printf("Heat Index: %.2fF\n",heatIdx);
					System.out.printf("Relative Humidity: %.2f%s\n",relative_humidity, "%");
					return true;
				}
				else return false;
		
	} //end method: isHeatStrokePossible
	
	
	/*
	 * STEP #2: Methods to be added under each of the blue comment blocks below:
	 * Method: breakTree(), purchaseItem(), fightEnemy()
	 */
	/*******************************************************************************************
	 * Add a method called breakTree()
	 * No return type
	 * No parameter
	 * Version 1: This method will simply print "Under Construction: Break Tree"
	 */

	
	/*******************************************************************************************
	 * Add a method called purchaseItem()
	 * No return type
	 * No parameter
	 * Version 1: This method will simply print "Under Construction: Purchase Item"
	 */

	
	/*******************************************************************************************
	 * Add a method called fightEnemy()
	 * No return type
	 * No parameter
	 * Version 1: This method will simply print "Under Construction: Fight Enemy"
	 */

	/********************************************************************************************

	* Setup Player

	*

	*/

	static Player myPlayer = setPlayer();
	static Enemy[] EnemiesSpawned = new Enemy [GameConstantsAndStaticVars.NUM_OF_ENEMIES];
	
	/*******************************************************************************************

	* Method: findItemIdx will search through a String inventory list and find the index of a particular item.

	* This is a sequential search.

	* @param itemInventory_in

	* @param searchItem

	* @return itemIdx

	*/

	public static int findItemIdx(String[] itemInventory_in, String searchItem)

	{

	int itemidx = -1;

	int index = 0;

	 

	while ( (itemidx == -1) && (index < itemInventory_in.length))

	{

	if (itemInventory_in[index].equals(searchItem))

	{

	itemidx = index;

	}

	else

	itemidx = -1;

	 

	index++;

	} //end while loop

	return itemidx;

	} //end findItemIdx method
	
	private static Player setPlayer() {
		return null;
	}

	/****************************************************************************************

	* Method: printPlayer will print the player information

	* @param playerVar

	*/

	public static void printPlayerAndInventory(Player playerVar)

	{

	System.out.println(playerVar);

	  /* Print player inventory table */

	System.out.println("Player's Current Inventory");

	System.out.print("\t\t Item\t \tCount\t \tDamage caused\n" +

	                "\t\t ----\t \t-----\t \t-------------\n");

	for (int index = 0; index < GameConstantsAndStaticVars.NUM_OF_ITEMS; index++)

	{

	System.out.printf("%20s\t%10d\t%10d\n", playerVar.getItemInventory()[index],

	  playerVar.getItemInventoryCount()[index],

	  playerVar.getDamageCausedbyItem()[index]);

	}

	}
	
	/*******************************************************************************************

	* Method: setup_EnemyMenu will set up the enemy menu based on the Items a player has in inventor   

	* The method "spawns" a new enemy by creating a new instance of Enemy. 

	* @param scnr

	* @param playerVar

	* @param EnemiesSpawned

	* @return int enemyToFight (user's choice)

	*/

	public static int setup_EnemyMenu(Scanner scnr, Player playerVar_in, Enemy[] EnemiesSpawned_in, boolean isFrostBiteScene_in, boolean isHeatStrokeScene_in)
	{

	int enemyToFight = 0;

	int playerIdx;

	System.out.println("Choose which enemy to fight. Pick only the options given");

	/*********************************SPAWN ENEMIES FOR FISTS ********************************************/

	/****************************** WHEN PLAYER DOES NOT HAVE A FROSTBITE ********************************/

	playerIdx = findItemIdx(playerVar_in.getItemInventory(), "fist");

	if ( (playerVar_in.getItemInventoryCount()[playerIdx] != 0) && !(isFrostBiteScene_in) )

	{

	/***********************SPAWN SPIDER*************************/

	if (EnemiesSpawned_in[playerIdx] == null)

	{

	//SPAWN SPIDER

	EnemiesSpawned_in[playerIdx] = new Enemy(); //Spawn Spider and it is the default

	GameConstantsAndStaticVars.numOfEnemiesSpawned = GameConstantsAndStaticVars.numOfEnemiesSpawned + 1;

	}

	System.out.print((playerIdx+1) + ". " + EnemiesSpawned_in[playerIdx].getEnemyName());

	System.out.println(" Enemy Health: " + EnemiesSpawned_in[playerIdx].getEnemyHealth());

	System.out.println(" Damage Enemy Causes: " + EnemiesSpawned_in[playerIdx].getEnemyDamageCaused() );

	/***********************SPAWN ZOMBIE*************************/

	if (EnemiesSpawned_in[playerIdx+1] == null)

	{

	//SPAWN ZOMBIE

	/* STEP 1:  COMPLETE THIS STATEMENT to create a new instance of Enemy.  Parameter values are "Zombie" for the name, "fist" for the EnemyItem, GameConstantsAndStaticVars.ZOMBIE_DAMAGE for the enemyDamage and GameConstantsAndStaticVars.ZOMBIE_HEALTH for the enemyHealth.   */

	EnemiesSpawned_in[playerIdx+1] = new Enemy("Zombie", "fist", GameConstantsAndStaticVars.ZOMBIE_DAMAGE, GameConstantsAndStaticVars.ZOMBIE_HEALTH);

	GameConstantsAndStaticVars.numOfEnemiesSpawned = GameConstantsAndStaticVars.numOfEnemiesSpawned + 1;

	} //end if

	System.out.print((playerIdx+2) + ". " + EnemiesSpawned_in[playerIdx+1].getEnemyName());

	System.out.println(" Enemy Health: " + EnemiesSpawned_in[playerIdx+1].getEnemyHealth());

	System.out.println(" Damage Enemy Causes: " + EnemiesSpawned_in[playerIdx+1].getEnemyDamageCaused() );

	} //end if player has inventory of that item and !(isFrostBiteScene)

	/********************************* SPAWN ENEMIES FOR SWORDS ********************************************/

	/****************************** WHEN PLAYER DOES NOT HAVE A HEAT STROKE ********************************/

	if ( !(isHeatStrokeScene_in) )

	{

	if (playerVar_in.getItemInventoryCount()[playerIdx] != 0) //player has wooden sword

	{

	/***********************SPAWN Wooden Sword Skeleton *************************/

	playerIdx = findItemIdx(playerVar_in.getItemInventory(), "wooden sword");

	if (EnemiesSpawned_in[playerIdx-4] == null)

	{

	//SPAWN Wooden Sword Skeleton

	EnemiesSpawned_in[playerIdx-4] = new Enemy("Wooden Sword Skeleton", "wooden sword", GameConstantsAndStaticVars.WOODEN_SWORD_SKELETON_DAMAGE, GameConstantsAndStaticVars.WOODEN_SWORD_SKELETON_HEALTH);

	GameConstantsAndStaticVars.numOfEnemiesSpawned = GameConstantsAndStaticVars.numOfEnemiesSpawned+1;

	}

	System.out.print((playerIdx-3) + ". " + EnemiesSpawned_in[playerIdx-4].getEnemyName());

	System.out.println(" Enemy Health: " + EnemiesSpawned_in[playerIdx-4].getEnemyHealth());

	if (isFrostBiteScene_in)

	{

	System.out.println("Player has a frostbite! Enemy causes extra damage.");

	System.out.println(" Damage Enemy Causes: " + (EnemiesSpawned_in[playerIdx-4].getEnemyDamageCaused() + 1));

	}

	else

	System.out.println(" Damage Enemy Causes: " + EnemiesSpawned_in[playerIdx-4].getEnemyDamageCaused() );

	} //end if player has wooden sword

	/***********************SPAWN Stone Sword Skeleton *************************/

	playerIdx = findItemIdx(playerVar_in.getItemInventory(), "stone sword");

	if (playerVar_in.getItemInventoryCount()[playerIdx] != 0) //player has stone sword

	{

	if (EnemiesSpawned_in[playerIdx-4] == null) //spawn if already not spawned

	{

	//SPAWN Stone Sword Skeleton

	EnemiesSpawned_in[playerIdx-4] = new Enemy("Stone Sword Skeleton", "stone sword",

	GameConstantsAndStaticVars.STONE_SWORD_SKELETON_DAMAGE,

	GameConstantsAndStaticVars.STONE_SWORD_SKELETON_HEALTH);

	GameConstantsAndStaticVars.numOfEnemiesSpawned = GameConstantsAndStaticVars.numOfEnemiesSpawned+1;

	}

	System.out.print((playerIdx-3) + ". " + EnemiesSpawned_in[playerIdx-4].getEnemyName());

	System.out.println(" Enemy Health: " + EnemiesSpawned_in[playerIdx-4].getEnemyHealth());

	if (isFrostBiteScene_in)

	{

	System.out.println("Player has a frostbite! Enemy causes extra damage.");

	System.out.println(" Damage Enemy Causes: " + (EnemiesSpawned_in[playerIdx-4].getEnemyDamageCaused() + 1));

	}

	else

	System.out.println(" Damage Enemy Causes: " + EnemiesSpawned_in[playerIdx-4].getEnemyDamageCaused() );

	} //end if player has stone sword

	/***********************SPAWN Iron Sword Skeleton *************************/

	playerIdx = findItemIdx(playerVar_in.getItemInventory(), "iron sword");

	if (playerVar_in.getItemInventoryCount()[playerIdx] != 0) //player has iron sword

	{

	if (EnemiesSpawned_in[playerIdx-4] == null) //spawn if already not spawned

	{

	//SPAWN Iron Sword Skeleton

	EnemiesSpawned_in[playerIdx-4] = new Enemy("Iron Sword Skeleton", "iron sword",

	GameConstantsAndStaticVars.IRON_SWORD_SKELETON_DAMAGE,

	GameConstantsAndStaticVars.IRON_SWORD_SKELETON_HEALTH);

	GameConstantsAndStaticVars.numOfEnemiesSpawned = GameConstantsAndStaticVars.numOfEnemiesSpawned+1;

	}

	System.out.print((playerIdx-3) + ". " + EnemiesSpawned_in[playerIdx-4].getEnemyName());

	System.out.println("Enemy Health: " + EnemiesSpawned_in[playerIdx-4].getEnemyHealth());

	if (isFrostBiteScene_in)

	{

	System.out.println("Player has a frostbite! Enemy causes extra damage.");

	System.out.println(" Damage Enemy Causes: " + (EnemiesSpawned_in[playerIdx-4].getEnemyDamageCaused() + 1));

	}

	else

	System.out.println(" Damage Enemy Causes: " + EnemiesSpawned_in[playerIdx-4].getEnemyDamageCaused() );




	} //end if player has iron sword

	} //end if player does not have a heat stroke




	System.out.println("Enter -1 to Stop fighting.");

	enemyToFight = scnr.nextInt();

	return enemyToFight;

	}
	
	/*******************************************************************************************
	 * Method name: simulate_fight will spawn the enemy, determine the winner of a enemy/player fight and
	 *  deduct the appropriate health
	 * @param enemyToFight
	 * @param randgen
	 * @param playerVar
	 * @param EnemiesSpawned
	 */
	public static void simulate_fight(int enemyToFight, Random randgen, Player playerVar, Enemy[] EnemiesSpawned,
										boolean isFrostBiteScene_in, boolean isHeatStrokeScene_in)
	{
		int enemyStrength = 0;
		int playerStrength = 0;
		int playerDamage = 0;
		int enemyDamage = 0;
			
		enemyStrength =  randgen.nextInt();
		playerStrength =  randgen.nextInt();

		/*******************************************************************************************
		 * Print Fight Introduction
		 */
		System.out.println("Enemies Spawned: " + GameConstantsAndStaticVars.numOfEnemiesSpawned);

		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("You have chosen to fight " + EnemiesSpawned[enemyToFight-1].getEnemyName() );
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		System.out.println("Enemy Strength : " + enemyStrength);
		System.out.println("Player Strength : " + playerStrength);
		
		/*******************************************************************************************
		 * Determine player damage
		 */
		switch (enemyToFight)
		{
		case 1: {
					playerDamage = playerVar.DamageCausedbyItem[enemyToFight-1]; //fist
					enemyDamage = EnemiesSpawned[enemyToFight-1].getEnemyDamageCaused(); //get enemy damage
					if (isHeatStrokeScene_in)
					{
						playerVar.setHealth(-1); //player will automatically lose 1 health when fighting spider
						System.out.println("Player loses health due to heat stroke");
					}
					break;
				}
		case 2: {
					playerDamage = playerVar.DamageCausedbyItem[enemyToFight-2]; //fist
					enemyDamage = EnemiesSpawned[enemyToFight-1].getEnemyDamageCaused();
					if (isHeatStrokeScene_in)
					{
						playerVar.setHealth(-1); //player will automatically lose 1 health when fighting zombie
						System.out.println("Player loses health due to heat stroke");
					}
					break;
				}
		case 3, 4, 5: {
					playerDamage = playerVar.DamageCausedbyItem[enemyToFight+3]; //wooden, stone, or iron sword
					if (isFrostBiteScene_in)
					{ 
						enemyDamage = EnemiesSpawned[enemyToFight-1].getEnemyDamageCaused() + 1; //enemy causes more damage
					}
					else
					{
						enemyDamage = EnemiesSpawned[enemyToFight-1].getEnemyDamageCaused();
					}
					break;
				}
		default: { playerDamage = 0; }		
		}
		
		/*******************************************************************************************
		 * Determine winner
		 */
		if (enemyStrength > playerStrength) //enemy is winning
		{
			System.out.println("-----------------------------------------------------------------");
			System.out.println("The " + EnemiesSpawned[enemyToFight-1].getEnemyName() + " won!");
			System.out.println("-----------------------------------------------------------------");
			playerVar.setHealth(-enemyDamage); //damage will be subtracted in the setHealth method
			
			//Print current player data
			System.out.println(playerVar);
			
		} //end enemy is winning
		else if (enemyStrength < playerStrength) //player is winning
		{
			System.out.println("enemy Health : " + EnemiesSpawned[enemyToFight-1].getEnemyHealth() ); 
			EnemiesSpawned[enemyToFight-1].setEnemyHealth(EnemiesSpawned[enemyToFight-1].getEnemyHealth()-playerDamage);
			System.out.println("new enemy health: " + EnemiesSpawned[enemyToFight-1].getEnemyHealth());
			
			if (EnemiesSpawned[enemyToFight-1].getEnemyHealth() == 0)
			{
				System.out.println("**************You have successfully beat the enemy!*****************");
				System.out.println("****************It may spawn again!  Watch out!*********************");
				EnemiesSpawned[enemyToFight-1] = null;
				GameConstantsAndStaticVars.numOfEnemiesSpawned = GameConstantsAndStaticVars.numOfEnemiesSpawned - 1;				
			}
			else //enemy has become weak
			{
				System.out.println("-----------------------------------------------------------------");
				System.out.println("---------------------- Your enemy is weakened! ----------------------");
				System.out.println("-----------------------------------------------------------------");
				System.out.println("Enemy Damage: " + EnemiesSpawned[enemyToFight-1].getEnemyHealth());
				System.out.println("new enemy health: " + EnemiesSpawned[enemyToFight-1].getEnemyHealth());
				System.out.println();
			}
		} //end player is winning
		else  //both strengths are equal
		{
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Both are of equal strength!  You will need to keep fighting or chose to move on!");
			System.out.println("-----------------------------------------------------------------");
		}
	} //simulate_fight

	public static void GameMenu(Scanner scnr, Random randgen, Player myPlayer, String[] MenuItems, boolean isFrostBiteScene_in, boolean isHeatStrokeScene_in, Enemy[] EnemiesSpawned)
	{
		int menuChoice;
		
		do
		{
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
			if (isFrostBiteScene_in)
			{
				System.out.println("You have a frostbite so you could get weaker faster!");
			}
			if (isHeatStrokeScene_in)
			{
				System.out.println("You have a heat stroke!  You are weaker!");
			}
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
			printPlayerAndInventory(myPlayer);
			
			if (myPlayer.getHealth() != 0)
			{
				
				for (int index = 0; index < MenuItems.length; index++ )
				{
					System.out.println(""+ (index + 1) + ". " + MenuItems[index]);
				}
				
				
				System.out.println("Please choose an item from the menu above.");
				menuChoice = scnr.nextInt();
				
				/*
				*  The method calls below are changing compared to the homework you did for Game Development Part 1.
         			*  Review the methods and add the appropriate parameters.  
                                */
				if (menuChoice == 1)
				{
					/*< STEP 1: ADD breakTree method call with the appropriate parameters>*/
				}
				else if (menuChoice == 2)
				{
					/*<STEP 2: Add purchaseItem method call with the appropriate parameters>*/
				}
				else if (menuChoice == 3)
				{
					/*<STEP 3: Add fightEnemy method call with the appropriate parameters> */
				}
				if (menuChoice != 4)
				{
					// Code to execute when menuChoice is not equal to 4
					System.out.println("Wrong menu choice. Try again");
				}
				else
				{
					System.out.println("Game Ending!");
				}
				
				
				} //end if player is still alive
				else
				{
					System.out.println("End of Game!  You Lost!");
					menuChoice = 4;
				}

			} while (menuChoice != 4);
	}

	
	/*******************************************************************************************
	 * Method breakTree() will calculate the wood quantity and add to the player's health (max 10)
	 * No return type
	 * No parameter
	 * Version 1: This method will simply print "Under Construction: Break Tree"
	 * Version 2: Calculate the wood quantity and add to the player's health. 
	 */
	public static void breakTree(Scanner scnr, boolean isFrostBiteScene_in, boolean isHeatStrokeScene_in,
								 Player playerVar_in)
	{
		int numOfTrees;
		int HealthFromApples = 0;
		int WoodFromTree = 0;
		int woodIdx; 
		
		System.out.println("Break Trees (up to 3). Get 2 health per tree. Max Health is 10.");
		
		/*
		 * If the player has a heat stroke, he cannot collect enough wood 
		 * so the player can get only 1 wood per cut tree.   
		 */
		if (isHeatStrokeScene_in)
		{
			
			System.out.println("Due to the heat stroke, you only have energy to get 1 wood per tree");
			System.out.println("How many trees will you punch down? Max 3.");
			numOfTrees = scnr.nextInt();
			//If the user enters more than 3 trees, then we change the value to max of 3 trees.
			if (numOfTrees > 3)
				numOfTrees = 3;
			//Calculate new Wood - less wood due to heat stroke
			WoodFromTree = (numOfTrees);
		}
		else
		{
			System.out.println("Get 2 wood per tree");
			System.out.println("How many trees will you punch down? Max 3.");
			numOfTrees = scnr.nextInt();
			
			//If the user enters more than 3 trees, then we change the value to max of 3 trees.
			if (numOfTrees > 3)
				numOfTrees = 3;
			
			//Calculate new Wood
			WoodFromTree = (numOfTrees * 2);
		}
		
		/*
		 * If the player has a frost bite, then the player cannot increase their health
		 * otherwise when breaking a tree, the player can get 2 health by eating an apple.
		 */
		if (isFrostBiteScene_in)
		{
			System.out.println("Due to the cold, there are no apples to increase your health");
		}
		else
		{
			HealthFromApples = numOfTrees * GameConstantsAndStaticVars.HEALTH_PER_APPLE;
			playerVar_in.setHealth(HealthFromApples);
		}
		//Update Health for the player

		
		//Find the woodIdx and update the Inventory count for the player
		
		woodIdx =  findItemIdx(playerVar_in.getItemInventory(), "wood");
		
		if (woodIdx != -1)
		{
			playerVar_in.updateInventoryCount(WoodFromTree, woodIdx);
			//no damage caused by wood so do not need to update that. 
		}
	}
	
	/*******************************************************************************************
	 * Method purchaseItem() will provide a purchase menu based on materials in player's inventory
	 * No return type
	 * No parameter
	 * Version 1: This method will simply print "Under Construction: Purchase Item"
	 * Verison 2: Provide a purchase menu based on materials in the player's inventory. 
	 * Notes:
	 * The method goes through a 2D array that keeps track of materials required to acquire items. 
	 * A player will always have 2 fists. 
	 * A player acquires wood by breaking trees.
	 * All other materials can be acquired 
	 */
	public static void purchaseItem(Scanner scnr, Player playerVar_in, boolean isHeatStrokeScene_in)
	{
		//System.out.println("Under Construction: Purchase Item");
		int purchaseChoice;
		//this array keeps track of which items can be acquired based on player's current materials
		//inventory
		boolean[] acquire = {false, false, true, true, true, true, true, true, true};
		int AcquireCount;
		char carryItem = 'y';
			
		/* for each column of possibly acquired item, go through the rows and compare the values to acquire 
		 * to what the player has in their inventory.  If they cannot acquire an item,
		 *  the acquire item is set to false.
		 */
		for (int acquireIdx = 2; acquireIdx < playerVar_in.getItemInventory().length; acquireIdx++)
		{
			for (int rowIdx = 1; rowIdx < GameConstantsAndStaticVars.MATERIALS_COST.length-3; rowIdx++ )
			{
				if ( (playerVar_in.getItemInventoryCount()[rowIdx] < GameConstantsAndStaticVars.MATERIALS_COST[rowIdx][acquireIdx] ) )
				{
					acquire[acquireIdx] = false;
				}
			}
		}
		
		/* go through the acquire items to determine if there are any items the player 
		 * can acquire.
		 */
		AcquireCount = 0;
		for (int acquireIdx = 2; acquireIdx < acquire.length; acquireIdx++)
		{
			if (acquire[acquireIdx] == true)
				AcquireCount = AcquireCount + 1;
				
		}
		/*
		 * if there are items that the player can acquire, create a menu 
		 * of those items.
		 * Otherwise, let the user know that they need to acquire more wood. 
		 */
		if ( AcquireCount > 0)
		{
			System.out.println("choose from the menu below: ");
			for (int acquireTrueIdx = 0; acquireTrueIdx < acquire.length; acquireTrueIdx++)
			{
				if (acquire[acquireTrueIdx] == true)
				{
					System.out.print("enter " + acquireTrueIdx + " for ");
					System.out.println(playerVar_in.getItemInventory()[acquireTrueIdx]);
				}
			}
			System.out.println("Enter -1 to exit purchase menu.");

			purchaseChoice = scnr.nextInt();

			if (purchaseChoice != -1)
			{
				if (isHeatStrokeScene_in)
				{
					//empty scnr.nextLine
					scnr.nextLine();
					System.out.println("You cannot carry more items in this heat.");
					System.out.println("You will lose health.");
					System.out.println("Are you sure you want to carry this item? ");
					carryItem = scnr.nextLine().toLowerCase().charAt(0);
					
					if (carryItem == 'y')
					{
						playerVar_in.setHealth(-1);
						playerVar_in.getItemInventoryCount()[purchaseChoice] = playerVar_in.getItemInventoryCount()[purchaseChoice] + 1;
	
						for (int rowIdx = 1; rowIdx < playerVar_in.getItemInventoryCount().length; rowIdx++)
						{
							playerVar_in.getItemInventoryCount()[rowIdx] = playerVar_in.getItemInventoryCount()[rowIdx] - GameConstantsAndStaticVars.MATERIALS_COST[rowIdx][purchaseChoice]; 
						}
					}		
				} //end if heat stroke
				else
				{
					playerVar_in.getItemInventoryCount()[purchaseChoice] = playerVar_in.getItemInventoryCount()[purchaseChoice] + 1;
	
					for (int rowIdx = 1; rowIdx < playerVar_in.getItemInventoryCount().length; rowIdx++)
					{
						playerVar_in.getItemInventoryCount()[rowIdx] = playerVar_in.getItemInventoryCount()[rowIdx] - GameConstantsAndStaticVars.MATERIALS_COST[rowIdx][purchaseChoice]; 
					}
				} //end else no heat stroke
				
			} //end purchase choice is not equal to -1
		} //end if acquire count > 0
		else
		{
			System.out.println("-----------------------------------------------------");
			System.out.println("\tYou need more material to acquire more items. ");
			System.out.println("\tBreak more trees and get more wood!");
			System.out.println("-----------------------------------------------------");
		}
		
	} //end purchase item method
	
	/*******************************************************************************************
	 * Method: fightEnemy() will create enemy instances and allow user to select which enemy to fight.
	 * A winner is randomly selected and the health of the loser is impacted.
	 * No return type
	 * No parameter
	 * Version 1: This method will simply print "Under Construction: Fight Enemy"
	 * Version 2: create enemy instances and allow user to select which enemy to fight. The method 
	 * makes a call to setup enemy menu and simulate fight.
	 */
	public static void fightEnemy(Scanner scnr, Player playerVar, Random randgen, Enemy[] EnemiesSpawned, 
									boolean isFrostBiteScene_in, boolean isHeatStrokeScene_in)
	{
		System.out.println("---------------------------Fight Enemy---------------------------------------");
		int enemyToFight = 0;	
		boolean fight_enemy = true;
		
		do
		{			
			if (playerVar.getHealth() != 0)
			{
				enemyToFight = setup_EnemyMenu(scnr, playerVar, EnemiesSpawned, isFrostBiteScene_in, isHeatStrokeScene_in);
				if ( (enemyToFight >= 1) && (enemyToFight <= GameConstantsAndStaticVars.NUM_OF_ENEMIES) )
				{
					simulate_fight(enemyToFight, randgen, playerVar, EnemiesSpawned, isFrostBiteScene_in, isHeatStrokeScene_in);
				}
				else if (enemyToFight == -1)
				{
					fight_enemy = false;
				}
				else
				{
					System.out.println("Invalid Entry");
				}
			}  //end as long has player has health	
			else
			{
				//player has no health left
				fight_enemy = false;
			}
		} while (fight_enemy == true);
		
	} //end fightEnemy method
	
} //end class: GameDriver