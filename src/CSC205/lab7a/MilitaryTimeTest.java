package lab7a;

import positionallist.*;

public class MilitaryTimeTest {
    public static void main(String[] args) {
        PositionalList<MilitaryTime> list = new LinkedPositionalList<>();

        list.addOrdered(new MilitaryTime(1, 2));
        list.addOrdered(new MilitaryTime(0, 0));
        list.addOrdered(new MilitaryTime(14, 1));
        list.addOrdered(new MilitaryTime(12, 0));
        list.addOrdered(new MilitaryTime(13, 2));
        list.addOrdered(new MilitaryTime(11, 59));
        // 13:02 is intentionally repeated
        list.addOrdered(new MilitaryTime(13, 2));
        list.addOrdered(new MilitaryTime(23, 59));

        for (MilitaryTime m : list) {
            System.out.println(m);
        }
    }
}
