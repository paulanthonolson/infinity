package lab7a;

import positionallist.*;

public class VersionTest {
    public static void main(String[] args) {
        PositionalList<Version> list = new LinkedPositionalList<>();

        list.addOrdered(new Version("2.0"));
        list.addOrdered(new Version("10.0"));
        list.addOrdered(new Version("0.2"));
        list.addOrdered(new Version("0.0.99"));
        list.addOrdered(new Version("0.0.9.9"));
        list.addOrdered(new Version("0.10"));
        list.addOrdered(new Version("0.1.2"));
        list.addOrdered(new Version("0.00"));

        // These should be displayed in the order
        // 0.00, 0.0.9.9, 0.0.99, 0.1.2, 0.2, 0.10, 2.0, 10.0
        // in the same format in which they were originally specified

        for (Version v : list) {
            System.out.println(v);
        }
    }
}
