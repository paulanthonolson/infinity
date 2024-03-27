package in_class;
/*
 * Paul Olson
 * 1/24/2023
 * Write the first program to print hello scholars
 */
public class ch1_HelloScholars
{
	//the following is the main method or starting point of a java program
	public static void main(String[] args) 
	{
		double balance;
		
		balance = 23;
System.out.println ("Hello scholars");
System.out.println ("Hola como es tas?");
System.out.println ("this statement has ln.");
System.out.print   ("this statement does not create a new line ");
System.out.printf  ("printf does not move to next line, printf is print formatted"); //will discuss printf later
System.out.println ();
System.out.println ("syso hold ctrl and space"); //shortcut for system output
System.out.println ("Food Item\t Price\t Quantity"); // \t = tab
System.out.println ("banana\t\t .50\t 5");
System.out.println ("this\nwill\nprint\nwords\non\nnew\nlines");

System.out.printf("On a balance of $" + balance);
	}

}
