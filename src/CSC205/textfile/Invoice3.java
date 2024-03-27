package textfile;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

// This version demonstrates a variant of try often called try-with-resources.

public class Invoice3 {
    public static void main(String[] args) {
        String inputFileName = "order.txt";
        String outputFileName = "invoice.txt";
        int quantity;
        double price;
        String item;
        double extension;
        double total = 0;

        // This form of try is often referred to as try-with-resources.
        // The things in ( ) after the try that successfully opened will automatically
        // be closed when the try ends.
        try (Scanner inFS = new Scanner(new File(inputFileName));
                PrintWriter outFS = new PrintWriter(outputFileName);) {
            outFS.println("Qty  Description             Unit     Ext");

            while (inFS.hasNextInt()) {
                quantity = inFS.nextInt();
                price = inFS.nextDouble();
                // The Scanner is at the space right after the price.
                // The space will be read and included by nextLine().
                // Adding .strip() to the end remove leading and trailing spaces.
                item = inFS.nextLine().strip();
                extension = quantity * price;
                total += extension;
                outFS.printf("%3d  %-20s  %6.2f  %6.2f\n", quantity, item, price, extension);
            }

            outFS.println();
            outFS.printf("Total: $%4.2f\n", total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}