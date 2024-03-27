package lab1b;

public class Die {
    private int smallest;
    private int largest;
    private int value;

    public Die(int smallest, int largest) {
        this.smallest = smallest;
        this.largest = largest;
        roll(); // Call roll to establish a default value
    }

    public Die() {
        this(1, 6);
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        value = smallest + (int) (Math.random() * (largest - smallest + 1)); // Standard RNG
    }

}
