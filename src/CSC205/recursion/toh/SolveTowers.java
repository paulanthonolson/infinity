package recursion.toh;

import java.util.Scanner;

public class SolveTowers {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("How many disks? ");
        int numDisks = scnr.nextInt();

        TowersOfHanoi towers = new TowersOfHanoi(numDisks, true);
        towers.solve();

        scnr.close();
    }
}
