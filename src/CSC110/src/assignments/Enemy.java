package assignments;
/*
* UML: Class: Enemy

* -----------------------------------------------------------------------------

* Instance Variables

* -----------------------------------------------------------------------------

* - enemyName: String

* - enemyItem: String

* - enemyDamageCaused: int

* - enemyHealth: int

* -----------------------------------------------------------------------------

* Constructors

* -----------------------------------------------------------------------------

* default constructor: Enemy() using set method to initialize data

* * enemyName to "Spider"

* EnemyItem to "fist"

* EnemyDamageCaused to GameConstantsAndStaticVars.SPIDER_DAMAGE

* EnemyHealth to GameConstantsAndStaticVars.SPIDER_HEALTH

* -----------------------------------------------------------------------------

* Methods

* -----------------------------------------------------------------------------

* + getEnemyName(): String

* + getEnemyItem(): String

* + getEnemyDamageCaused(): int

* + getEnemyHealth(): int

* + setEnemyName(String enemyName_in): void

* + setEnemyItem(String enemyItem_in): void

* + setEnemyDamageCaused(int enemyDamageCaused_in) : void

* + setEnemyHealth(int enemyHealth_in) : void

* -----------------------------------------------------------------------------

* Other Methods

* -----------------------------------------------------------------------------

* + toString(): String

*/
public class Enemy 
{
	private String enemyName;
	private String enemyItem;
	private int enemyDamageCaused;
	private int enemyHealth;
	
	//Default constructor
	public Enemy()
	{
		this.enemyName = "Spider";
		this.enemyItem = "fist";
		this.enemyDamageCaused = GameConstantsAndStaticVars.SPIDER_DAMAGE;
		this.enemyHealth = GameConstantsAndStaticVars.SPIDER_HEALTH;
	}
	
	//Constructor with parameters
	public Enemy(String enemyName_init, String enemyItem_init, int enemyDamageCaused_init, int enemyHealth_init) 
	{
		this.setEnemyName (enemyName_init);
		this.setEnemyItem (enemyItem_init);
		this.setEnemyDamageCaused (enemyDamageCaused_init);
		this.setEnemyHealth (enemyHealth_init);
	}
	
	public String toString()
	{
		return "Enemy Name: "  + enemyName + "\n" + "Enemy item: " + enemyItem + "\n" + "Enemy damage caused: " + 
				enemyDamageCaused + "\n" + "Enemy health: " + enemyHealth + "\n";
	}
	

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}
	public String getEnemyItem() {
		return enemyItem;
	}
	public void setEnemyItem(String enemyItem) {
		this.enemyItem = enemyItem;
	}
	public int getEnemyDamageCaused() {
		return enemyDamageCaused;
	}
	public void setEnemyDamageCaused(int enemyDamageCaused) {
		this.enemyDamageCaused = enemyDamageCaused;
	}
	public int getEnemyHealth() {
		return enemyHealth;
	}
	public void setEnemyHealth(int enemyHealth) {
		this.enemyHealth = enemyHealth;
	}
}
