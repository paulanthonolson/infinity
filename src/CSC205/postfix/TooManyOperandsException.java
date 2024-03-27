package postfix;

public class TooManyOperandsException extends Exception {
    public TooManyOperandsException(String msg) {
        super(msg);
    }
}
