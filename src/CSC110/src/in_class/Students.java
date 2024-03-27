package in_class;

/*
 * This is the place where you describe the Student Once 
 * (for example, type up the form for the doctor's office)
 */
public class Students 
{

	/***************************************
	 * Characteristics/Variables
	 */
	private String name;
	String[] textbooks;
	int StudentIDNum;
	String major;
	double budget;
	int yearOfGraduation;
	
	/*******************************************
	 * Behavior/Methods that impact the data of the variables
	 */
	
	//purpose of this method is to assign a data value to the name variable
	public void setName(String name_in)
	{
		name = name_in;
	}
	
	public String getName()
	{
		return name;
	}
}
