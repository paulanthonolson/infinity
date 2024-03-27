package lab7a;

import positionallist.*;

public class PointTest {
    public static void main(String[] args) {
        PositionalList<Point> list = new LinkedPositionalList<Point>();

        list.addOrdered(new Point(1.0, 0.0));
        list.addOrdered(new Point(1.0, 0.01));
        list.addOrdered(new Point(2.0, 1.0));
        list.addOrdered(new Point(2.0, 0.99999));
        list.addOrdered(new Point(1.5, 0.0));

        // The output should be
        // 1.0,0.0
        // 1.0,0.01
        // 1.5,0.0
        // 2.0,0.99999
        // 2.0,1.0

        for (Point p : list) {
            System.out.println(p);
        }
    }

}
