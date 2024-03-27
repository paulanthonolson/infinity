package recursion;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Duplicate characters are not supported in this implementation");
        System.out.print("Enter string for generating permutations: ");
        String base = scnr.nextLine();
        System.out.println("Enter length of permutations to generate (k): ");
        int k = scnr.nextInt();
        permute(base, k);
        scnr.close();
    }

    public static void permute(String base, int k) {
        permute(base, k, "");
    }

    /**
     * Generate permutations of the provided base string. Base strings with
     * duplicate characters will not generate any permutations.
     */
    private static void permute(String base, int k, String prefix) {
        // Base case
        if (prefix.length() == k) {
            System.out.println(prefix);
            return;
        }

        // Recursive case
        for (char letter : base.toCharArray()) {
            if (prefix.indexOf(letter) < 0) {
                permute(base, k, prefix + letter);
            }
        }
    }
}
