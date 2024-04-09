package practice.numberPractice;

import java.util.List;

public class numberMethods {
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

    public double mathEval(List<Double> numbers, List<String> operations) {
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            String operation = operations.get(i - 1);
            double num = numbers.get(i);

            switch (operation) {

                case ADD:
                    result += num;
                    break;

                case SUBTRACT:
                    result -= num;
                    break;

                case MULTIPLY:
                    result *= num;
                    break;

                case DIVIDE:
                    if (num != 0) {
                        result /= num;
                    } else {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    break;

                case MODULO:
                    if (num != 0) {
                        result %= num;
                    } else {
                        throw new ArithmeticException("Modulo by zero is not allowed.");
                    }
                    break;

                case POWER:
                    result = Math.pow(result, num);
                    break;

                case GREATER_THAN:
                    result = (result > num) ? 1.0 : 0.0;
                    break;

                case LESS_THAN:
                    result = (result < num) ? 1.0 : 0.0;
                    break;

                case EQUALS:
                    result = (result == num) ? 1.0 : 0.0;
                    break;

                case AND:
                    result = (result != 0.0 && num != 0.0) ? 1.0 : 0.0;
                    break;

                case OR:
                    result = (result != 0.0 || num != 0.0) ? 1.0 : 0.0;
                    break;
            }

        }
        return result;
    }

}
