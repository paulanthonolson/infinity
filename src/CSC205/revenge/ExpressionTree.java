package revenge;

import queue.LinkedQueue;
import queue.QueueInterface;
import stack.LinkedStack;
import stack.StackInterface;
import tree.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionTree extends LinkedBinaryTree<ExpressionToken> {
    Scanner scnr = new Scanner(System.in);

    private List<Character> variableMemory = new ArrayList<>();
    private List<Integer> valueMemory = new ArrayList<>();
    private int nextAddress = 0;

    public ExpressionTree(ExpressionToken element) {
        this(element, null, null);
    }

    public ExpressionTree(ExpressionToken element, ExpressionTree leftSubtree, ExpressionTree rightSubtree) {
        super();
        addRoot(element);
        attach(root, leftSubtree, rightSubtree);
    }

    public int evaluate() {
        return evaluateNode(root);
    }

    private int evaluateNode(Node<ExpressionToken> root) {
        int result, operand1, operand2;
        ExpressionToken element;

        element = root.getElement();

        if (element.isOperator()) {
            operand1 = evaluateNode(root.getLeft());
            operand2 = evaluateNode(root.getRight());
            result = computeTerm(element.getOperator(), operand1, operand2);
        } else if (element.isVariable()) {
            char variableName = element.getVariable();
            int variableIndex = variableMemory.indexOf(variableName);
            if (variableIndex == -1) {
                System.out.print("Enter the value for the variable " + variableName + ": ");
                int value = scnr.nextInt();
                variableMemory.add(variableName);
                valueMemory.add(value);
                result = value;
            } else {
                result = valueMemory.get(variableIndex);
            }
        } else {
            result = element.getConstant();
        }

        return result;
    }

    public void clearVariableMemory() {
        variableMemory.clear();
        valueMemory.clear();
    }

    private static int computeTerm(char operator, int operand1, int operand2) {
        int result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }

        return result;
    }

    public String infix() {

        return infixNode(root);
    }

    private String infixNode(Node<ExpressionToken> root) {
        ExpressionToken element = root.getElement();

        if (element.isOperator()) {
            String leftExpr = infixNode(root.getLeft());
            String rightExpr = infixNode(root.getRight());
            return "(" + leftExpr + " " + element.getOperator() + " " + rightExpr + ")";
        } else if (element.isVariable()) {
            return "" + element.getVariable();
        } else {
            return "" + element.getConstant();
        }
    }

    public void allocateMemoryForVariables() {
        variableMemoryNode(root);
    }

    private void variableMemoryNode(Node<ExpressionToken> root) {
        ExpressionToken element = root.getElement();

        if (element.isVariable() && !variableMemory.contains(element.getVariable())) {
            char variable = element.getVariable();
            variableMemory.add(variable);

            System.out.println("Assigning memory for variable '" + variable + "' at address " + nextAddress);
            nextAddress++;
        }
        variableMemoryNode(root.getLeft());
        variableMemoryNode(root.getRight());
    }

    public String generateCode() {
        String code = "";

        String v = getVar();
        code = generateCodeNode(root, v) + "Result in " + v;
        putVar(v);

        return code;
    }

    private String generateCodeNode(Node<ExpressionToken> root, String v) {
        String code, operand1Code, operand2Code;
        ExpressionToken element;

        element = root.getElement();

        if (element.isOperator()) {
            operand1Code = generateCodeNode(root.getLeft(), v);
            String vr = getVar();
            operand2Code = generateCodeNode(root.getRight(), vr);
            code = operand1Code +
                    operand2Code +
                    "    " + getOperation(element.getOperator()) + " " +
                    v + ", " + v + ", " + vr + "\n";
            putVar(vr);
        } else {
            code = "    li  " + v + ", " + element.getConstant() + "\n";
        }

        return code;
    }

    private static String getOperation(char operator) {
        String result = "???";

        switch (operator) {
            case '+':
                result = "add";
                break;
            case '-':
                result = "sub";
                break;
            case '*':
                result = "mul";
                break;
            case '/':
                result = "div";
                break;
        }

        return result;
    }

    private static StackInterface<String> vars;

    static {
        vars = new LinkedStack<String>();
        vars.push("$v1");
        vars.push("$v0");
        vars.push("$a3");
        vars.push("$a2");
        vars.push("$a1");
        vars.push("$a0");
        vars.push("$s7");
        vars.push("$s6");
        vars.push("$s5");
        vars.push("$s4");
        vars.push("$s3");
        vars.push("$s2");
        vars.push("$s1");
        vars.push("$s0");
        vars.push("$t9");
        vars.push("$t8");
        vars.push("$t7");
        vars.push("$t6");
        vars.push("$t5");
        vars.push("$t4");
        vars.push("$t3");
        vars.push("$t2");
        vars.push("$t1");
        vars.push("$t0");
    }

    private static String getVar() {
        return vars.pop();
    }

    private static void putVar(String v) {
        vars.push(v);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        QueueInterface<Node<ExpressionToken>> nodes = new LinkedQueue<>();
        Node<ExpressionToken> current;
        int printDepth = this.height(root);
        int possibleNodes = (int) Math.pow(2, printDepth + 1) - 1;
        int currentLevel = 0;
        int previousLevel = -1;
        double log2 = Math.log(2);

        nodes.enqueue(root);

        for (int countNodes = 1; countNodes <= possibleNodes; countNodes++) {
            current = nodes.dequeue();
            currentLevel = (int) (Math.log(countNodes) / log2);
            if (currentLevel > previousLevel) {
                if (currentLevel > 0) {
                    result.append("\n");
                }
                previousLevel = currentLevel;
                appendSpaces(result, Math.pow(2, printDepth - currentLevel) - 1);
            } else {
                appendSpaces(result, Math.pow(2, printDepth - currentLevel + 1) - 1);
            }
            if (current != null) {
                result.append(current.getElement());
                nodes.enqueue(current.getLeft());
                nodes.enqueue(current.getRight());
            } else {
                appendSpaces(result, 1);
                nodes.enqueue(null);
                nodes.enqueue(null);
            }
        }

        return result.toString();
    }

    private static void appendSpaces(StringBuilder sb, double spaces) {
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
    }
}
