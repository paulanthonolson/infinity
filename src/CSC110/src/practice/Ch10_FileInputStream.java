package practice;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Ch10_FileInputStream {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fileByteStream = null; // File input stream
	      Scanner inFS = null;                   // Scanner object
	      int fileNum;                           // Data value from file
	      int fileNum2;
	      int fileNum3;

	      // Try to open file
	      System.out.println("Opening file myfile.txt.");
	      fileByteStream = new FileInputStream("FileStream.txt");
	      inFS = new Scanner(fileByteStream);
	 
	      // File is open and valid if we got this far (otherwise exception thrown)
	      System.out.println("Reading and printing numbers.");

	      while (inFS.hasNextInt()) {
	         fileNum = inFS.nextInt();
	         System.out.println("num: " + fileNum);
	      }

	      // Done with file, so try to close it
	      System.out.println("Closing file myfile.txt.");
	      fileByteStream.close(); // close() may throw IOException if fails

	}

}
