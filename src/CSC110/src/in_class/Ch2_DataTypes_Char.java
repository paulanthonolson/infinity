package in_class;
/*
 * Paul Olson
 * 1/30/23
 * Demonstrate the boolean data types
 */
public class Ch2_DataTypes_Char {

	public static void main(String[] args) {
		
		char letterC; //define variable
		letterC = 'C'; //assign variable a value
		
		char myspace;
		myspace = ' ';
		
		System.out.println (letterC);
		System.out.println ("" + myspace + letterC); //remember to begin with quotations or Java will add values
		System.out.println ("" + letterC + myspace + letterC);
		System.out.println (letterC + myspace + letterC); //note that the quotations were left out resulting in ASCII sum 
	}

}
