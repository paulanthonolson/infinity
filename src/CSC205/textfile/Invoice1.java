package textfile;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

// This example mirrors the approach demonstrated in the zyBook used in many 110 classes.

public class Invoice1 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "order.txt";
        String outputFileName = "invoice.txt";
        FileInputStream fis = null;
        Scanner inFS = null;
        FileOutputStream fos = null;
        PrintWriter outFS = null;
        int quantity;
        double price;
        String item;
        double extension;
        double total = 0;

        fis = new FileInputStream(inputFileName);
        inFS = new Scanner(fis);
        fos = new FileOutputStream(outputFileName);
        outFS = new PrintWriter(fos);

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

        inFS.close();
        outFS.close();
    }
}
