package in_class;
/*
 * Paul Olson
 * 4/18/23
 * 
 * CLASS DEFINITION
 * 
 * Characteristics/Instance Variables
 * first initial: char 
 * last name: String
 * pronouns: String
 * age: int
 * average spending: double
 *
 */

public class Ch8_Customers {
	
	
	private char firstInitial;
	private String lastName;
	private String proNouns;
	private int age;
	private double avgSpending;
	private Ch8_Books[] bookList;
/*
 * Constructors
 * 	-construct the object and initialize instance variables
 * 	-public
 *  -do not require a return type
 *  -same name as the class
 *  -no parameters (known as the default constructor)
 *  -parameters as ALL instance variables
 *  -parameters of mixed set of instance variables
 *  
 *  Helper Methods
 */



// default constructor	
public Ch8_Customers() 
{ 
		this.age = (21);
		this.avgSpending = 0.0;
		this.firstInitial = 'J';
		this.lastName = "Unknown";
		this.proNouns = "He/Him";
		this.setBookList(null);
		
}

// constructor with mixed parameters
public Ch8_Customers(int age_init, double avgSpending_init, char firstInitial_init, String lastName_init, String proNouns_init, Ch8_Books[] bookList_init) 
{
		this.set_age (age_init);
		this.set_avgSpending (avgSpending_init);
		this.set_firstInitial (firstInitial_init);
		this.set_lastName (lastName_init);
		this.set_proNouns (proNouns_init);
		this.setBookList(bookList_init);
}

// getters and setters
public int get_age() 
{
		return this.age;
}

public void set_age(int age_in) 
{
	if ((age_in < 0) || (age_in > 105))
		this.age = -1;
		this.age = age_in;
}

public double get_avgSpending() 
{
		return this.avgSpending;
}

public void set_avgSpending(double avgSpending_in) 
{
		this.avgSpending = avgSpending_in;
}

public char get_firstInitial() {
		return this.firstInitial;
}

public void set_firstInitial(char firstInitial_in) 
{
		this.firstInitial = firstInitial_in;
}

public String get_lastName() {
		return this.lastName;
}

public void set_lastName(String lastName_in) 
{
		this.lastName = lastName_in;
}

public String get_proNouns() 
{
		return this.proNouns;
}

public void set_proNouns(String proNouns_in) 
{
		this.proNouns = proNouns_in;
}

public Ch8_Books[] getBookList() {
	return bookList;
}

public void setBookList(Ch8_Books[] bookList) {
	this.bookList = bookList;
}
	
} // end class
