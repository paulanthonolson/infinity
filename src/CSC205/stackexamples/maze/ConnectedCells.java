package stackexamples.maze;

import java.awt.Point;

public class ConnectedCells {
    public Point cell1, cell2;

    public ConnectedCells(Point cell1, Point cell2) {
        // Rearrange adjacent cells into canonical order to normalize hashCode and
        // simplify equals.
        if (cell1.y < cell2.y || (cell1.y == cell2.y && cell1.x <= cell2.x)) {
            this.cell1 = cell1;
            this.cell2 = cell2;
        } else {
            this.cell1 = cell2;
            this.cell2 = cell1;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof ConnectedCells) {
            ConnectedCells other = (ConnectedCells) o;
            result = cell1.equals(other.cell1) && cell2.equals(other.cell2);
        }

        return result;
    }

    @Override
    public int hashCode() {
        return (cell1.x << 21) ^ (cell1.y << 14) ^ (cell2.x << 7) ^ cell2.y;
    }

    @Override
    public String toString() {
        return cell1.x + "," + cell1.y + "/" + cell2.x + "," + cell2.y + "\n";
    }
}
