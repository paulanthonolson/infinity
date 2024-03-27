package lab7a;

import positionallist.*;

public class TimeTest {
    public static void main(String[] args) {
        PositionalList<Time> list = new LinkedPositionalList<>();

        list.addOrdered(new Time(1, 2, false));
        list.addOrdered(new Time(12, 0, false));
        list.addOrdered(new Time(12, 1, false));
        list.addOrdered(new Time(2, 1, true));
        list.addOrdered(new Time(12, 1, true));
        list.addOrdered(new Time(12, 0, true));
        // 01:02 am is intentionally repeated
        list.addOrdered(new Time(1, 2, false));
        list.addOrdered(new Time(1, 2, true));
        list.addOrdered(new Time(11, 59, true));

        for (Time t : list) {
            System.out.println(t);
        }
    }
}
