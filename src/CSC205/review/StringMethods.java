package review;

import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your name");
        String myName = scnr.nextLine();

        // Test a few String methods
        System.out.println("Name: " + myName);
        System.out.println("Length: " + myName.length());
        System.out.println("First letter: " + myName.charAt(0));
        System.out.println("Last letter: " + myName.charAt(myName.length() - 1));
        System.out.println("All upper case: " + myName.toUpperCase());
        System.out.println("Location of first A in name: " + myName.toUpperCase().indexOf("A"));

        // Split name into first and last name. Consider:
        // 0123456789
        // Pat Smith
        // space will get the value of 3. The first name is from 0-2 and the last name
        // starts at 4.
        int space = myName.toUpperCase().indexOf(" ");
        if (space >= 0) {
            // This version of substring extracts the characters from the first number
            // (start at 0 in this case)
            // up to but not including the second number (space has the right value since we
            // want everything up
            // to that character, but not the space itself)
            String firstName = myName.substring(0, space);
            // This version fo substring extracts the characters from the first number
            // (start just after the space)
            // all the way to the end of the string since there is no second number.
            String lastName = myName.substring(space + 1);
            System.out.println("First name: " + firstName);
            System.out.println("Last name: " + lastName);
        }

        scnr.close();
    }
}
