// You must makes changes to this file.

package lcr;

/**
 * This class uses the adapter pattern using a classic six-sided die to act as
 * an LCR die.
 * 
 * The four predicate methods must return true or false consistent with the
 * value of the classic die and the following:
 * 
 * 1, 2, 3 are dots
 * 4 is left
 * 5 is center
 * 6 is right
 */

public class LCRDie {
    private Die classicDie = new Die();

    public void roll() {
        // add logic to roll the classic die here (just one line needed)
        classicDie.roll();
    }

    public boolean isDot() {
        // replace this so it returns true/false based on the rules at the top

        return classicDie.getValue() < 4;
    }

    public boolean isLeft() {
        // this is already set up based on the rules at the top
        return classicDie.getValue() == 4;
    }

    public boolean isCenter() {
        // replace this so it returns true/false based on the rules at the top
        return classicDie.getValue() == 5;
    }

    public boolean isRight() {
        // replace this so it returns true/false based on the rules at the top
        return classicDie.getValue() == 6;
    }

    public String toString() {
        // replace this so it returns "dot", "left", "center", or "right" depending on
        // the current value of the classic die
        if (classicDie.getValue() < 4) {
            return "dot";
        } else if (classicDie.getValue() == 4) {
            return "left";
        } else if (classicDie.getValue() == 5) {
            return "center";
        } else if (classicDie.getValue() == 6) {
            return "right";
        } else {
            return "";
        }

    }
}
