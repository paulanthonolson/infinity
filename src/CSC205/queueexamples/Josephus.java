package queueexamples;

import java.util.Scanner;
import queue.*;

public class Josephus {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        CircularQueueInterface<Integer> line = new LinkedCircularQueue<>();
        int members;
        int skipCount;
        String again;

        System.out.println("Josephus");

        do {
            members = getBoundedInt(scnr, "How many members of the group?", 2, 1000);
            skipCount = getBoundedInt(scnr, "What is the skip count?", 1, 1000);

            // Enqueue 1 through number of members into line.
            for (int i = 1; i <= members; i++) {
                line.enqueue(i);
            }

            // Loop until only 1 remains
            while (line.size() > 1) {
                // Rotate through skipCount - 1 members
                for (int i = 0; i < skipCount - 1; i++) {
                    line.rotate();
                }
                // Eliminate the member at the skipCount
                System.out.printf("Eliminate %d\n", line.dequeue());
            }

            // Add logic here to print the remaining number.
            System.out.printf("Survivor %d\n", line.dequeue());

            System.out.println("Try again (yes/no)?");
            again = scnr.next().toLowerCase();
        } while (again.startsWith("y"));

        scnr.close();
    }

    public static int getBoundedInt(Scanner scnr, String prompt, int min, int max) {
        int result;

        while (true) {
            System.out.println(prompt);
            // Check if there is an integer available
            if (scnr.hasNextInt()) {
                result = scnr.nextInt();
                // After reading the integer, call nextLine to flush the newline from the input
                // buffer in case the next thing requested from the scanner uses nextLine().
                scnr.nextLine();
                if (result >= min && result <= max) {
                    return result;
                }
                System.out.printf("Number must be between %d and %d\n", min, max);
            } else {
                System.out.println("That is not a number");
                // Flush the invalid input from the input buffer.
                scnr.nextLine();
            }
        }
    }
}
