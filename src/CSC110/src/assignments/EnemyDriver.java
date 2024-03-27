package assignments;

public class EnemyDriver {

	public static void main(String[] args) 
	{
		Enemy IceMonster = new Enemy();
		
		IceMonster.setEnemyName("Frost");
		IceMonster.setEnemyItem("icicle sword");
		IceMonster.setEnemyDamageCaused(5);
		IceMonster.setEnemyHealth(5);
		
		System.out.println(IceMonster);

	}

}
