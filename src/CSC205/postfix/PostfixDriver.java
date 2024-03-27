package postfix;

import stack.*;

import java.util.Scanner;
import java.text.DecimalFormat;

public class PostfixDriver {
    /**
     * Reads and evaluates multiple postfix expressions.
     */
    public static void main(String[] args) {
        String expression, again;
        double result;
        DecimalFormat df = new DecimalFormat("#.#####");

        Scanner scnr = new Scanner(System.in);

        do {
            PostfixEvaluator evaluator = new PostfixEvaluator();

            System.out.println("Enter a valid postfix expression one token "
                    + "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an double or an operator (+,-,*,/)");
            expression = scnr.nextLine();

            // TODO: Add logic somewhere in this section of the program to
            // catch EmptyCollectionException and TooManyOperandsException
            // and print appropriate messages
            try {
                // Notice how the thing that can throw an exception plus the lines
                // that depend on getting a value back from that thing all appear within the
                // try.
                result = evaluator.evaluate(expression);
                System.out.println();
                System.out.println("That expression equals " + df.format(result));
            } catch (InvalidTokenException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (EmptyCollectionException e) {
                System.out.println("Too few operands.");
            } catch (TooManyOperandsException e) {
                System.out.println("Too many operands.");
            }

            System.out.print("Evaluate another expression [Y/N]? ");
            again = scnr.nextLine();
            System.out.println();
        } while (!again.equalsIgnoreCase("n"));

        scnr.close();
    }
}
