package in_class;

public class Show_Strings_Organized
{

	public static void main(String[] args) 
	{
		//declare variables
		String longtext = "Supercalifragilisticexpealidocious";
		int length_longtext;
		int index_from_longtext;
		char character_x;
		
		//process
		length_longtext = longtext.length();
		index_from_longtext = longtext.indexOf('r');
		character_x = longtext.charAt(longtext.indexOf('x'));
		
		//output
		System.out.println(longtext);
		System.out.println(longtext.charAt(0));
		System.out.println(longtext.charAt(12));
		System.out.println(length_longtext);
		System.out.println("xxxxThe character at index 33 is : " + longtext.charAt(33));
		System.out.println("Index of the character r is : " + index_from_longtext);
		System.out.println(character_x);

	}

}
