// You are not allowed to make any changes to this file.

// You are not allowed to use this class from Game. It may only be used by LCRDie.

package lcr;

import java.util.Random;

public class Die {
    private int value;
    private int smallest;
    private int largest;

    public Die() {
        this(1, 6);
    }

    public Die(int smallest, int largest) {
        this.smallest = smallest;
        this.largest = largest;
        roll();
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        Random randGen = new Random();
        value = smallest + randGen.nextInt(largest - smallest + 1);
    }

    public String toString() {
        return "Value: " + value;
    }
}
