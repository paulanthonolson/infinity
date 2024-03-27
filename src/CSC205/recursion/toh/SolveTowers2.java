package recursion.toh;

import java.util.Scanner;

public class SolveTowers2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("How many disks? ");
        int numDisks = scnr.nextInt();

        for (int i = 1; i <= numDisks; i++) {
            System.out.println(i + " disks: " + new TowersOfHanoi(i, false).solve());
        }

        scnr.close();
    }
}
