package recursion;

import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter string for generating combinations: ");
        String base = scnr.nextLine();
        System.out.println("Enter length of combinations to generate (k): ");
        int k = scnr.nextInt();
        combine(base, k);
        scnr.close();
    }

    public static void combine(String base, int k) {
        combine(base, k, "");
    }

    /*
     * Generate combinations of the provided base string and length.
     */
    private static void combine(String base, int k, String prefix) {
        // Base case
        if (prefix.length() == k) {
            System.out.println(prefix);
            return;
        }

        // Recursive case
        for (int i = 0; i < base.length(); i++) {
            char head = base.charAt(i);
            String tail = base.substring(i + 1);
            combine(tail, k, prefix + head);
        }
    }
}