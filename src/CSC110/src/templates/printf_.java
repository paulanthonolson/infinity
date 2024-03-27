package templates;

public class printf_ {

	public static void main(String[] args) {
		
		// %d - Used to print an integer value
		int x = 10;
		System.out.printf("The value of x is: %d", x);
		
		// %f - Used to print a floating-point value
		double pi = 3.14159;
		System.out.printf("The value of pi is: %.2f", pi);
		
		// %s - Used to print a string value
		String name = "John";
		System.out.printf("My name is %s", name);
		
		// %c - Used to print a character value
		char letter = 'A';
		System.out.printf("The first letter of the alphabet is %c", letter);
		
		// %b - Used to print a boolean value
		boolean isJavaCool = true;
		System.out.printf("Java is cool: %b", isJavaCool);
		
		// %x - Used to print an integer value in hexadecimal format
		int num = 255;
		System.out.printf("The hexadecimal representation of %d is: %x", num, num);
	}

}
