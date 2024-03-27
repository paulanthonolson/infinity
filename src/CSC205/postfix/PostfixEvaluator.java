package postfix;

import java.util.Scanner;
import stack.*;

public class PostfixEvaluator {
    private final static String ADD = "+";
    private final static String SUBTRACT = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";
    private final static String MODULO = "%";
    private final static String POWER = "^";
    private final static String GREATER_THAN = ">";
    private final static String LESS_THAN = "<";
    private final static String EQUALS = "=";
    private final static String AND = "&";
    private final static String OR = "|";
    private final static String IF = "?";
    private final static String NEGATIVE = "~";
    private final static String FACTORIAL = "!";
    private final static String ABSOLUTE_VALUE = "@";

    // TODO: Add constants here for the other operators

    public double evaluate(String expr) throws InvalidTokenException, TooManyOperandsException {
        StackInterface<Double> stack = new ArrayStack<>();
        Scanner parser = new Scanner(expr);
        String token;
        double op1;
        double op2;
        double op3;
        double result;

        while (parser.hasNext()) {
            if (parser.hasNextDouble()) {
                result = parser.nextDouble();
                stack.push(result);
            } else {
                token = parser.next();
                if (isBinaryOperator(token)) {
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = evaluateBinaryOperator(token, op1, op2);
                    stack.push(result);
                } else if (isUnaryOperator(token)) {
                    // TODO: Add code here similar to the code above but adjusted for unary
                    // operators
                    op1 = stack.pop();
                    result = evaluateUnaryOperator(token, op1);
                    stack.push(result);
                } else if (isTernaryOperator(token)) {
                    // TODO: Add code here similar to the code above but adjusted for the ternary
                    // operator
                    op3 = stack.pop();
                    op2 = stack.pop();
                    op1 = stack.pop();
                    result = evaluateTernaryOperator(token, op1, op2, op3);
                    stack.push(result);

                } else {
                    throw new InvalidTokenException(("Invalid token: " + token));
                }
            }
        }

        // TODO: Add some logic here to detect if there were too many operands and throw
        // TooManyOperandsException
        if (stack.size() != 1) {
            throw new TooManyOperandsException("Too many operands.");
        }

        return (stack.pop());
    }

    private boolean isBinaryOperator(String token) {
        // TODO: Expand this logic to recognize more binary operators
        return (token.equals(ADD) ||
                token.equals(SUBTRACT) ||
                token.equals(MULTIPLY) ||
                token.equals(DIVIDE) ||
                token.equals(MODULO) ||
                token.equals(POWER) ||
                token.equals(GREATER_THAN) ||
                token.equals(LESS_THAN) ||
                token.equals(EQUALS) ||
                token.equals(AND) ||
                token.equals(OR));
    }

    private boolean isUnaryOperator(String token) {
        // TODO: Change the return false to code that returns the result for unary
        // operators
        return (token.equals(NEGATIVE) ||
                token.equals(FACTORIAL) ||
                token.equals(ABSOLUTE_VALUE));
    }

    private boolean isTernaryOperator(String token) {
        // TODO: Change the return false to code that returns the result for the ternary
        // operator
        return (token.equals(IF));
    }

    private double evaluateBinaryOperator(String operation, double op1, double op2) {
        // TODO: Expand this logic to handle more binary operators
        double result = 0.0;

        switch (operation) {
            case ADD:
                result = op1 + op2;
                break;

            case SUBTRACT:
                result = op1 - op2;
                break;

            case MULTIPLY:
                result = op1 * op2;
                break;

            case DIVIDE:
                result = op1 / op2;
                break;

            case MODULO:

                result = op1 % op2;
                break;

            case POWER:
                result = Math.pow(op1, op2);
                break;

            case GREATER_THAN:
                result = (op1 > op2) ? 1.0 : 0.0;
                break;

            case LESS_THAN:
                result = (op1 < op2) ? 1.0 : 0.0;
                break;

            case EQUALS:
                result = (op1 == op2) ? 1.0 : 0.0;
                break;

            case AND:
                result = (op1 != 0.0 && op2 != 0.0) ? 1.0 : 0.0;
                break;

            case OR:
                result = (op1 != 0.0 || op2 != 0.0) ? 1.0 : 0.0;
                break;
        }

        return result;
    }

    private double evaluateUnaryOperator(String operation, double op1) {
        // TODO: Replace return 0 with code similar to evaluateBinaryOperator

        double result = 0.0;

        switch (operation) {
            case NEGATIVE:
                result = -1 * op1;
                break;

            case FACTORIAL:
                result = 1;
                for (int i = 1; i <= op1; i++) {
                    result *= i;
                }
                break;

            case ABSOLUTE_VALUE:
                result = Math.abs(op1);
                break;
        }
        return result;
    }

    private double evaluateTernaryOperator(String operation, double op1, double op2, double op3) {
        // TODO: Replace return 0 with code similar to evaluateBinaryOperator
        double result = 0.0;
        switch (operation) {
            case IF:
                result = (op1 != 0.0) ? op2 : op3;
        }
        return result;
    }
}
