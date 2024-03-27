package stackexamples;

import java.util.Scanner;
import stack.*;

public class Balanced3 {
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
        for (char c : expression.toCharArray()) {
            try {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        buffer.push(c);
                        break;
                    case ')':
                        if (buffer.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (buffer.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (buffer.pop() != '{') {
                            return false;
                        }
                        break;
                }
            } catch (EmptyCollectionException e) {
                return false;
            }
        }
        return buffer.isEmpty();
    }
}
