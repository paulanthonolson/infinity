package practice.numberPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class numberDriver2 {
    public static void main(String args[]) {

        numberMethods calc = new numberMethods();
        Scanner scnr = new Scanner(System.in);

        List<Double> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        System.out.println("Choose an action:");
        System.out.println("1. Create variables.");
        System.out.println("2. Assign variables values.");
        System.out.println("3. Perform a math operation.");
        System.out.println("4. Show current variables and operations.");
        System.out.println("5. Calculate result.");
        System.out.println("6. Exit.");

        int userInput = scnr.nextInt();
        scnr.nextLine();

        switch (userInput) {

            case 1:
                System.out.println("How many variables do you want to create?");
                int numberOfVariables = scnr.nextInt();
                scnr.nextLine();
                break;

            case 2:
                System.out.println("Assign the variables values.");
                userInput = scnr.nextInt();
                scnr.nextLine();
                double[] userVariables = new double[userInput];
                break;

            case 3:
                System.out.println("Enter the operation (+, -, *, /, %, ^, >, <, =, &, |):\"");
                String operation = scnr.nextLine();
                operations.add(operation);
                break;

            case 4:
                System.out.println("Current variables: ");

                for (int i = 0; i < numbers.size(); i++) {
                    System.out.println("num" + (i + 1) + " = " + numbers.get(i));
                }

                System.out.println("Current operations");

                for (int i = 0; i < operations.size(); i++) {
                    System.out.println((i + 1) + operations.get(i));
                }

        }

    }
}
