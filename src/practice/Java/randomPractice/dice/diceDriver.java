package practice.Java.randomPractice.dice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class diceDriver {
    public static void main(String args[]) {

        diceMethods dice = new diceMethods();
        Scanner scnr = new Scanner(System.in);

        while (true) {

            System.out.println("Are you feeling lucky? Y/N ");
            String userInput = scnr.nextLine();

            if (userInput.equalsIgnoreCase("N")) {
                System.out.println("Thank you for playing!");
                break;
            } else if (userInput.equalsIgnoreCase("Y")) {

                while (true) {
                    try {

                        System.out.println("How many sided die would you like to roll? Between 1 and 1,750,000.  ");
                        int myDice = scnr.nextInt();

                        scnr.nextLine();

                        int rollResult = dice.rollDXX(myDice);

                        System.out.println("Would you like to roll again? Y/N");
                        userInput = scnr.nextLine();

                        if (!userInput.equalsIgnoreCase("Y")) {
                            System.out.println("Thank you for playing!");
                            return;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scnr.nextLine();
                    }
                }

            }

        }

    }

}
