// You are not allowed to make any changes to this file.

package lcr;

public class Player {
    private int number;
    private int chips;

    public Player(int number) {
        this.number = number;
        chips = 3;
    }

    public int getNumber() {
        return number;
    }

    public int getChips() {
        return chips;
    }

    public int addChip() {
        return ++chips;
    }

    public int subtractChip() {
        if (chips == 0) {
            throw new IllegalStateException("#" + number + " has no chips to subtract");
        }
        return --chips;
    }

    public String toString() {
        return "#" + number + " has " + chips;
    }
}
