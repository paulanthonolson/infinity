package in_class;

public class StringProcessingDemo {

	public static void main(String[] args) {
		String sentence = "I hate text processing!";
		
		int index_I = sentence.indexOf("I");
		int index_x = sentence.indexOf("x");
		int index_t = sentence.indexOf("t");
		char fifth_letter = sentence.charAt(5);
		char seventh_letter = sentence.charAt(7);
				System.out.print (index_I);
				System.out.print (index_x);
				System.out.print (index_t);
				System.out.print (fifth_letter);
				System.out.print (seventh_letter);

	}

}
