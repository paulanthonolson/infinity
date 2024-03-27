package review;

// In most uses of switch/case, we need a break statement at
// the end of each case. This is an example where we specifically
// do not a break statement as all of the following cases
// still apply.

import java.util.Scanner;

public class SwitchDaysOfChristmas {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Which day of Christmas is it?");
        int day = scnr.nextInt();

        switch (day) {
            case 12:
                System.out.println("12 Drummers Drumming");
            case 11:
                System.out.println("11 Pipers Piping");
            case 10:
                System.out.println("10 Lords a-Leaping");
            case 9:
                System.out.println("9 Ladies Dancing");
            case 8:
                System.out.println("8 Maids a-Milking");
            case 7:
                System.out.println("7 Swans a-Swimming");
            case 6:
                System.out.println("6 Geese a-Laying");
            case 5:
                System.out.println("5 Gold Rings");
            case 4:
                System.out.println("4 Calling Birds");
            case 3:
                System.out.println("3 French Hens");
            case 2:
                System.out.println("2 Turtle Doves, and ");
            case 1:
                System.out.println("A Partridge in a Pear Tree");
        }

        scnr.close();
    }
}
