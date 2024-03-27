package mutable;

import java.util.ArrayList;

public class JDKExamples {
    public static void main(String[] args) {
        // String is immutable
        String str1;
        String str2;
        String str3;

        str1 = "Hello World";
        str2 = str1;
        str2.replace("Hello", "Hi");
        str3 = str1.replace("Hello", "G'day");

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);

        // ArrayList is mutable
        ArrayList<Integer> list1;
        ArrayList<Integer> list2;

        list1 = new ArrayList<Integer>();
        list2 = list1;
        list1.add(1);
        list2.add(2);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
    }
}
