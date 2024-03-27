package in_class;

public class Show_typecast {

	public static void main(String[] args) {

		//char x = 'x';
		char zero = '0';
		char one = '1'; //complete this and the rest of the code
		
		int asciiOfx = 120;
		int asciiOfzero;
		int asciiOfone;
		int weightOfoneAtPosition2 = 2;  //2 binary digit positions, hold 2^1 and 2^0 --> 2 and 1
		int bit2_int;
		
		//type cast
	//	asciiOfx = (int) x;
		asciiOfzero = (int) zero;
		asciiOfone = (int) one;
		
		bit2_int = (asciiOfone-48) * weightOfoneAtPosition2;   
		
	//	System.out.println(x);
		System.out.println(asciiOfx);
		System.out.println("Weight of 2nd position in binary number is " + bit2_int);
		
		System.out.println( (char) asciiOfx   );
		
		System.out.println(asciiOfzero);
		System.out.println(asciiOfone);
		

	}

}
