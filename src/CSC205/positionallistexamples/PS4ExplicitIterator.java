package positionallistexamples;

import java.util.Iterator;
import positionallist.*;

public class PS4ExplicitIterator {
    public static void main(String[] args) {
        Course csc110 = new Course("CSC", 110, "Introduction to Computer Science", "A");
        Course csc120 = new Course("CSC", 120, "Digital Design Fundamentals");
        Course csc205 = new Course("CSC", 205, "Object-Oriented Programming and Data Structures");
        Course the201 = new Course("THE", 201, "The Theatre Experience", "B");

        PositionalList<Course> unordered = new LinkedPositionalList<Course>();

        unordered.addLast(csc110);
        unordered.addLast(csc205);
        unordered.addLast(the201);
        unordered.addLast(csc120);

        // Although iterators are not required to produce their elements in any
        // particular order, the LinkedPositionalList iterator produces its elements in
        // the correct order for the list.

        System.out.println("Unordered list with explicit iterator");
        Iterator<Course> itr1 = unordered.iterator();
        while (itr1.hasNext()) {
            Course c = itr1.next();
            System.out.println(c);
        }

        PositionalList<Course> ordered = new LinkedPositionalList<Course>();

        ordered.addOrdered(csc110);
        ordered.addOrdered(csc205);
        ordered.addOrdered(the201);
        ordered.addOrdered(csc120);

        System.out.println();
        System.out.println("Ordered list with explicit iterator");
        Iterator<Course> itr2 = ordered.iterator();
        while (itr2.hasNext()) {
            Course c = itr2.next();
            System.out.println(c);
        }
    }
}
