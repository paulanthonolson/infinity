package revenge;

import java.util.Scanner;

import stack.LinkedStack;
import stack.StackInterface;

public class PostfixParser {
    public ExpressionTree parse(String expression) {
        StackInterface<ExpressionTree> treeStack = new LinkedStack<ExpressionTree>();
        Scanner parser = new Scanner(expression);
        ExpressionTree operand1, operand2;
        String token;
        char first;
        ExpressionTree result;

        while (parser.hasNext()) {
            token = parser.next();
            first = token.charAt(0);

            if (first == '+' || first == '-' || first == '*' || first == '/') {
                operand2 = treeStack.pop();
                operand1 = treeStack.pop();
                result = new ExpressionTree(ExpressionToken.createOperator(first), operand1, operand2);
                treeStack.push(result);
            } else if (Character.isDigit(first)) {
                result = new ExpressionTree(ExpressionToken.createConstant(Integer.parseInt(token)));
                treeStack.push(result);
            } else if (Character.isLowerCase(first)) {
                result = new ExpressionTree(ExpressionToken.createVariable(first));
                treeStack.push(result);
            }
        }

        parser.close();
        return treeStack.pop();
    }
}
