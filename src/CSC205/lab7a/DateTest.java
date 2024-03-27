package lab7a;

import positionallist.*;

public class DateTest {
    public static void main(String[] args) {
        PositionalList<Date> list = new LinkedPositionalList<>();

        // This is part of step 6
        // Date.setChronological(false);

        list.addOrdered(new Date(3000, 1, 1));
        list.addOrdered(new Date(1776, 7, 4));
        list.addOrdered(new Date(2026, 7, 4));
        list.addOrdered(new Date(2022, 11, 1));
        list.addOrdered(new Date(2022, 11, 2));
        list.addOrdered(new Date(2022, 11, 3));
        list.addOrdered(new Date(2000, 12, 31));

        for (Date d : list) {
            System.out.println(d);
        }
    }
}
