package in_class;

public class Ch8_Books {
/*
 * Instance variables
 * Constructors
 * Getter/Setters Methods
 * 
 * Unified Modeling Language (UML)
 * INSTANCE VARIABLES
 * - title: String
 * - author: String
 * - price: double
 * - rating: int
 * METHODS
 * + getTitle(): String
 * + getAuthor(): String
 * + getPrice(): double
 * + getRating(): int
 */
	private String author;
	private String title;
	private double ISBN;
	private int rating;
	
	public Ch8_Books() 
	{
		this.set_author("Jones");
		this.set_title("My Life");
		this.set_ISBN(1234.5678);
		this.set_rating(4);
	}
	
	public Ch8_Books (String author_init, String title_init, double ISBN_init) 
	{
		this.set_ISBN(ISBN_init);
		this.set_author(author_init);
		this.set_title(title_init);
	}
	
	public String get_author() 
	{
		return this.author;
	}
	
	public void set_author(String author_in) 
	{
		this.author = author_in;
	}
	
	public String get_title() 
	{
		return this.title;
	}
	
	public void set_title(String title_in) 
	{
		this.title = title_in;
	}
	
	public double get_ISBN() 
	{
		return this.ISBN;
	}
	
	public void set_ISBN(double ISBN_in) 
	{
		this.ISBN = ISBN_in;
	}
	
	public int get_Rating()
	{
		return this.rating;
	}
	
	public void set_rating(int rating_in)
	{
		this.rating = rating_in;
	}
	
	public String drawStars()
	{
	String stars = "";
		for (int count = 0; count < this.get_Rating(); count++)
		{
			stars = stars + "*";
		}
		stars = stars + "\n";
		return stars;
	}
	
	public String toString()
	{
		String book_str;
		
		book_str = "Book Information\n" + "author: " + this.get_author() + "\n" + "title" + this.get_title() + "\n" + "ISBN" + this.get_ISBN() + "\n" + "Price" + this.get_Rating() + "\n";
		return book_str;
	}
	
	public boolean equals(Ch8_Books book_obj) 
	{
		if ( ( this.get_author().equals(book_obj.get_author())) &&
			 ( this.get_title().equals(book_obj.get_title()))  &&
			 ( this.get_ISBN() == book_obj.get_ISBN() )
			 )
		{
		return true;
		}
		
		else
			
		{
			return false;
		}
	}
	
	
	
} //end class
