package revenge;

public class ExpressionToken {
    private enum TokenType {
        CONSTANT, OPERATOR, VARIABLE
    };

    private TokenType type;
    private int constant;
    private char operator;
    private char variable;

    private ExpressionToken(TokenType type) {
        this.type = type;
    }

    public static ExpressionToken createConstant(int constant) {
        ExpressionToken et = new ExpressionToken(TokenType.CONSTANT);
        et.constant = constant;
        return et;
    }

    public static ExpressionToken createOperator(char operator) {
        ExpressionToken et = new ExpressionToken(TokenType.OPERATOR);
        et.operator = operator;
        return et;
    }

    public static ExpressionToken createVariable(char variable) {
        ExpressionToken et = new ExpressionToken(TokenType.VARIABLE);
        et.variable = variable;
        return et;
    }

    public boolean isConstant() {
        return (type == TokenType.CONSTANT);
    }

    public boolean isOperator() {
        return (type == TokenType.OPERATOR);
    }

    public boolean isVariable() {
        return (type == TokenType.VARIABLE);
    }

    public int getConstant() {
        return constant;
    }

    public char getOperator() {
        return operator;
    }

    public char getVariable() {
        return variable;
    }

    public String toString() {

        if (isOperator()) {
            return "" + operator;
        } else if (isConstant()) {
            return "" + constant;
        } else {
            return "" + variable;
        }
    }
}
