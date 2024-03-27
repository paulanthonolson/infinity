package textfile;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// This example mirrors the approach demonstrated in the zyBook used in many 110 classes.

public class AddLineNumbers {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		FileInputStream fis = null;
		Scanner inFS = null;
		String inputFileName;
		File outFile = null;
		FileOutputStream fos = null;
		PrintWriter outFS = null;
		String outputFileName;
		int lineNumber = 0;
		String text;

		try {
			System.out.println("Enter input file name (original.txt is a good sample): ");
			inputFileName = scnr.nextLine();
			fis = new FileInputStream(inputFileName);
			inFS = new Scanner(fis);

			while (true) {
				System.out.println("Enter output file name (numbered.txt is a good choice): ");
				outputFileName = scnr.nextLine();
				outFile = new File(outputFileName);
				if (outFile.exists()) {
					System.out.println("That file already exists, please specify a different filename");
				} else {
					break;
				}
			}
			fos = new FileOutputStream(outFile);
			outFS = new PrintWriter(fos);

			while (inFS.hasNextLine()) {
				text = inFS.nextLine();
				lineNumber++;
				outFS.printf("%4d: %s\n", lineNumber, text);
			}

			System.out.println("Add numbers to " + lineNumber + " lines");
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception: " + e.getMessage());
		} finally {
			if (inFS != null) {
				inFS.close();
			}
			if (outFS != null) {
				outFS.close();
			}
		}
	}
}
