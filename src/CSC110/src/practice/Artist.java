package practice;

public class Artist 
{
	   
	   // TODO: Declare private fields - artistName, birthYear, deathYear
	   
	   private String artistName;
	   private int birthYear;
	   private int deathYear;
	   
	   // TODO: Define default constructor
	   
	   public Artist()
	   {
	      this.artistName = "null";
	      this.birthYear = 0000;
	      this.deathYear = 0000;
	   }
	   
	   // TODO: Define second constructor to initialize 
	   //       private fields (artistName, birthYear, deathYear)
	   
	   public Artist(String artistName_init,int birthYear_init,int deathYear_init)
	   {
	      this.set_artistName (artistName_init);
	      this.set_birthYear (birthYear_init);
	      this.set_deathYear (deathYear_init);
	   }
	   
	private void set_deathYear(int deathYear_init) 
	{
		
	}

	private void set_birthYear(int birthYear_init) 
	{
		
	}

	private void set_artistName(String artistName_init) 
	{
		
	}

	// TODO: Define get methods: getName(), getBirthYear(), getDeathYear()
	   
	public String get_artistName()
	  {
	    return this.artistName;
	  }
	   
	public int get_birthYear()
	  {
	    return this.birthYear;
	  }
	   
	public int get_deathYear()
	  {
	    return this.deathYear;
	  }

	   // TODO: Define printInfo() method
	   //       If deathYear is entered as -1, only print birthYear
	   
	   public void printInfo() 
	   {
		   System.out.print(this.artistName + ", born in " + this.birthYear);
	      
	    if (this.deathYear != -1) 
	      {
	         System.out.println(", died in " + this.deathYear);
	      } 
	      else 
	         {
	            System.out.println();
	         }
	   }
}
