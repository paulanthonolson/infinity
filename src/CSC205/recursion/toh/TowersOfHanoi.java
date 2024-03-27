package recursion.toh;

public class TowersOfHanoi {
    private int totalDisks;
    private boolean verbose;
    private int moveNum;

    public TowersOfHanoi(int disks, boolean verbose) {
        totalDisks = disks;
        this.verbose = verbose;
        moveNum = 0;
    }

    public int solve() {
        moveTower(totalDisks, 'A', 'C', 'B');
        return moveNum;
    }

    private void moveTower(int numDisks, char from, char to, char temp) {
        if (numDisks == 1) {
            moveOneDisk(from, to);
        } else {
            moveTower(numDisks - 1, from, temp, to);
            moveOneDisk(from, to);
            moveTower(numDisks - 1, temp, to, from);
        }
    }

    private void moveOneDisk(char from, char to) {
        moveNum++;

        if (verbose) {
            System.out.println(moveNum + ": Move one disk from " + from + " to " + to);
        }
    }
}
