package in_class;

public class Show_Strings 
{

	public static void main(String[] args) 
	{
		//declare variables
		String longtext = "Supercalifragilisticexpealidocious";
		int length_longtext;
		int index_from_longtext;
		char character_x;
		
		
		System.out.println(longtext);
		
		System.out.println(longtext.charAt(0));
		System.out.println(longtext.charAt(12));
		
		length_longtext = longtext.length();
		System.out.println(length_longtext);
		
		System.out.println("The character at index 33 is : " + longtext.charAt(33));
		
		index_from_longtext = longtext.indexOf('r');
		System.out.println("Index of the character r is : " + index_from_longtext);
		
		character_x = longtext.charAt(longtext.indexOf('x'));
		System.out.println(character_x);

	}

}
