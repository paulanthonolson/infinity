package Cache;

import java.util.Scanner;

public class CacheDriver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Cache c;
		
		System.out.println("*** Cache Simulator ***\n");

		//Read Cache Information
		System.out.println("Cache Information:");
		System.out.print("   Address size, in bits? ");
		int addressSize = keyboard.nextInt();
		System.out.print("   Word size, in bits? ");
		int wordSize = keyboard.nextInt();
		System.out.print("   Block size, in words? ");
		int blockSize = keyboard.nextInt();
		System.out.print("   Number of Lines? ");
		int numLines = keyboard.nextInt();

		System.out.println("\nTest Parameters:");
		System.out.print("   Starting Address? ");
		int startAddr = keyboard.nextInt();
		System.out.print("   Ending Address? ");
		int endAddr = keyboard.nextInt();
		System.out.print("   Increment? ");
		int incAddr = keyboard.nextInt();
		System.out.print("   Number of Iterations? ");
		int numIterations = keyboard.nextInt();

		c =  new Cache("CSC230", addressSize, wordSize, blockSize, numLines);
		
		System.out.println("\n");
		c.print();		
		
		for (int i = 0; i < numIterations; i++) {
			for(int address = startAddr; address <= endAddr; address += incAddr) {
				c.readLocation(address);
				System.out.println();
			}
		}
		
		c.stats();
		
		keyboard.close();
	}
}

