package exceptions;

public class ExceptionExample1 {
    public static void main(String args[]) {
        int num1 = 0, num2 = 0;

        try {
            num2 = 62 / num1;
            System.out.println("Division worked");
        } catch (ArithmeticException e) {
            System.out.println("Error: Don't divide a number by zero!");
            num2 = -1;
        } finally {
            System.out.println("Numbers are " + num1 + " and " + num2);
        }
        System.out.println("I'm out of try-catch-finally block in Java.");
    }
}
