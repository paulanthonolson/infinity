package exceptions;

// When we create a custom exception, we should include constructors for how
// we want to allow the user to throw exceptions.
public class BadFlightException extends Exception {

    // This constructor allows the user to throw exceptions like:
    // throw new BadFlightException();
    public BadFlightException() {
        super();
    }

    // This constructor allows the user to throw exceptions like:
    // throw new BadFlightException("Source and destination cannot be the same");
    public BadFlightException(String msg) {
        super(msg);
    }
}
