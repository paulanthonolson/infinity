package practice.Java.booleanPractice.sleepIn;

import java.util.Scanner;

public class sleepInDriver {
    public static void main(String args[]) {

        Scanner scnr = new Scanner(System.in);
        sleepInMethods sleepIn = new sleepInMethods();

        while (true) {
            System.out.println("Would you like to know if you can sleep in? Y/N");
            String userInput = scnr.nextLine();
            if (userInput.equalsIgnoreCase("N")) {
                System.out.println("Thank you for visiting!");
                break;
            } else if (userInput.equalsIgnoreCase("Y")) {

                System.out.println("Please enter the day of the week to determine if you can sleep in.");
                userInput = scnr.nextLine();

                int dayNum = sleepIn.dayToNum(userInput);
                sleepIn.sleepIn(dayNum);

                System.out.println(sleepIn.sleepIn(dayNum));

            }
        }
    }
}