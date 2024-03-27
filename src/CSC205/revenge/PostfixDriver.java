package revenge;

import java.util.Scanner;

public class PostfixDriver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String expression, again;
        PostfixParser parser;
        ExpressionTree tree;

        System.out.println("Postfix: Paul Olson\n");

        do {
            System.out.println("Enter a valid postfix expression one token "
                    + "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer, operator (+,-,*,/), or variable");
            expression = scnr.nextLine();

            parser = new PostfixParser();
            tree = parser.parse(expression);
            System.out.println();
            System.out.println("Tree:\n" + tree);
            System.out.println();
            System.out.println("Code:\n" + tree.generateCode());
            System.out.println();
            System.out.println("Infix expression: " + tree.infix());
            System.out.println();
            System.out.println("Expression value: " + tree.evaluate());
            System.out.println();
            System.out.print("Evaluate another expression [Y/N]? ");
            again = scnr.nextLine();

            tree.clearVariableMemory();

            System.out.println();
        } while (again.equalsIgnoreCase("y"));

        scnr.close();
    }
}
