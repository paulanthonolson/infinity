/*
 * package practice.numberPractice;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * import java.util.Scanner;
 * 
 * public class numberDriver {
 * public static void main(String args[]) {
 * numberMethods calc = new numberMethods();
 * Scanner scnr = new Scanner(System.in);
 * 
 * List<String> operations = new ArrayList<>();
 * List<Double> numbers = new ArrayList<>();
 * 
 * String Y = null;
 * String N = null;
 * 
 * while (true) {
 * System.out.println("Would you like to create a variable? Y/N");
 * String userConfirm = scnr.nextLine();
 * 
 * if (userConfirm.equalsIgnoreCase("N")) {
 * System.out.println("Thank you for visiting!");
 * break;
 * } else if (userConfirm.equalsIgnoreCase("Y")) {
 * 
 * System.out.print("Enter the number of variables needed: ");
 * int numberOfVariables = scnr.nextInt();
 * scnr.nextLine();
 * 
 * int[] userVariables = new int[numberOfVariables];
 * 
 * for (int i = 0; i < numberOfVariables; i++) {
 * System.out.print("Enter a value for num" + (i + 1) + ": ");
 * double userInput = scnr.nextDouble();
 * scnr.nextLine();
 * numbers.add((double) userInput);
 * }
 * 
 * for (int i = 0; i < numberOfVariables; i++) {
 * System.out.println("num" + (i + 1) + " = " + numbers.get(i));
 * }
 * 
 * for (int i = 0; i < numberOfVariables; i++) {
 * 
 * System.out.println("Would you like to perform a math function on num " + (i +
 * 1) + " (Y/N)");
 * String mathChoice = scnr.next();
 * scnr.nextLine();
 * 
 * if (mathChoice.equalsIgnoreCase("Y")) {
 * System.out.println("Enter the operation (+, -, *, /, %, ^, >, <, =, &, |):");
 * String operation = scnr.nextLine();
 * 
 * 
 * 
 * operations.add(operation);
 * 
 * } else
 * mathChoice.equalsIgnoreCase("N");
 * {
 * System.out.println("Thank you for visiting!");
 * break;
 * }
 * 
 * }
 * double result = calc.mathEval(numbers, operations);
 * System.out.println("Result: " + result);
 * }
 * 
 * }
 * }
 * }
 */