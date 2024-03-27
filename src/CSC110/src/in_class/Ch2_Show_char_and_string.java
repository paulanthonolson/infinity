package in_class;
import java.util.Scanner;
/*
 * Paul Olson
 * 1/30/23
 * To show char data type and string data type
 */

public class Ch2_Show_char_and_string {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		char first_letter, second_letter, third_letter;
		
		first_letter = 'C';
		second_letter = 'a';
		third_letter = 't';
		
		System.out.println("" + first_letter + second_letter + third_letter);
		
		String animal;
		animal = "Cat";
		
		System.out.println(animal);
		
		String sentence;
		sentence = "I like mint!";
				
		char first_letter_sentence = sentence.charAt(0);
		char ninth_letter_sentence = sentence.charAt(8);
		char last_letter_sentence = sentence.charAt(11);
		
		System.out.println("The first letter of sentence at index 0 is " + first_letter_sentence);
		System.out.println("The ninth letter of sentence at index 8 is " + ninth_letter_sentence);
		System.out.println("The last letter of sentence at index 11 is " + last_letter_sentence);	
		
		System.out.println("The length of the string is " + sentence.length() + " characters.");
		
		int index_I = sentence.indexOf('I');
		int index_  = sentence.indexOf(' ');
		int index_l = sentence.indexOf('l');
		int index_t = sentence.indexOf('t');
		int index_exp = sentence.indexOf('!');
		
		System.out.println("The index for the capital I in my sentence is " + index_I);
		System.out.println("The index for the space in my sentence is " + index_ );
		System.out.println("The index for the lowercase l in my sentence is " + index_l);
		System.out.println("The index for the lowercase t in my sentence is " + index_t);
		System.out.println("The index for the exclamation point is " + index_exp);
		
		scnr.close();
	}

}
