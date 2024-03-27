package review;

import java.util.Scanner;

public class CharacterMethods {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a string to be examined");
        String chars = scnr.nextLine();
        // This is an easy way to go through all the characters of a String
        for (char c : chars.toCharArray()) {
            String description = "";
            if (Character.isUpperCase(c)) {
                description += " uppercase";
            }
            if (Character.isLowerCase(c)) {
                description += " lowercase";
            }
            if (Character.isLetter(c)) {
                description += " letter";
            }
            if (Character.isDigit(c)) {
                description += " digit";
            }
            if (Character.isWhitespace(c)) {
                description += " whitespace";
            }
            if (description.equals("")) {
                description = " symbol";
            }
            char upper = Character.toUpperCase(c);
            char lower = Character.toLowerCase(c);
            System.out.println(c + " is" + description +
                    ", in uppercase " + upper +
                    ", in lowercase " + lower +
                    ", in decimal " + (int) c);
        }
        scnr.close();
    }
}
