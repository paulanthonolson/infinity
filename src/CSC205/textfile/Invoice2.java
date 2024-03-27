package textfile;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// This approach uses try/catch to remove the need to have "throws FileNotFoundException" on main.

public class Invoice2 {
    public static void main(String[] args) {
        String inputFileName = "order.txt";
        String outputFileName = "invoice.txt";
        Scanner inFS = null;
        PrintWriter outFS = null;
        int quantity;
        double price;
        String item;
        double extension;
        double total = 0;

        try {
            inFS = new Scanner(new FileInputStream(inputFileName));
            outFS = new PrintWriter(outputFileName);

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
            outFS.printf("Total: $%.2f\n", total);
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
