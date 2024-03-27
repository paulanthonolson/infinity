package lab7a;

public class Ticket implements Comparable<Ticket> {
    private char row;
    private int column;

    public Ticket(char row, int column) {
        this.row = row;
        this.column = column;
    }

    public int compareTo(Ticket otherTicket) {
        int result;

        result = this.row - otherTicket.row;

        if (result == 0) {
            result = this.column - otherTicket.column;
        }

        return result;
    }

    public String toString() {
        return row + "-" + column;
    }

}
