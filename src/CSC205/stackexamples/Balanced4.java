package stackexamples;

import java.util.Scanner;
import stack.*;

public class Balanced4 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter an expression");
        String expression = scnr.nextLine();
        if (isMatched(expression)) {
            System.out.println("Expression is balanced");
        } else {
            System.out.println("Expression is not balanced");
        }
        scnr.close();
    }

    public static boolean isMatched(String expression) {
        StackInterface<Character> buffer = new ArrayStack<>();
        String pairs = "()[]{}";
        for (char c : expression.toCharArray()) {
            int at = pairs.indexOf(c);
            if (at >= 0) {
                // even positions open, odd positions close
                if (at % 2 == 0) {
                    buffer.push(c);
                } else if (buffer.isEmpty() || buffer.pop() != pairs.charAt(at - 1)) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }
}
