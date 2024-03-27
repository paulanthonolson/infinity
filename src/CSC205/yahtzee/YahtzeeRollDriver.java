package CSC205.yahtzee;

public class YahtzeeRollDriver {
    public static void main(String[] args) {
        YahtzeeRoll roll;

        // This file is not graded. Feel free to change the values to try different
        // combinations of dice against YahtzeeRoll.

        roll = new YahtzeeRoll(1, 2, 3, 4, 5);
        System.out.println(roll);

        roll = new YahtzeeRoll(5, 5, 5, 5, 5);
        System.out.println(roll);
    }
}
