package positionallistexamples;

import positionallist.*;

public class PS1OrderedUnordered {
    public static void main(String[] args) {
        Course csc110 = new Course("CSC", 110, "Introduction to Computer Science", "A");
        Course csc120 = new Course("CSC", 120, "Digital Design Fundamentals");
        Course csc205 = new Course("CSC", 205, "Object-Oriented Programming and Data Structures");
        Course the201 = new Course("THE", 201, "The Theatre Experience", "B");

        PositionalList<Course> unordered = new LinkedPositionalList<>();

        unordered.addLast(csc110);
        unordered.addLast(csc205);
        unordered.addLast(the201);
        unordered.addLast(csc120);

        System.out.println("Unordered list");
        // We use first and after to move through the list.
        // See later for using the iterator as another way to move through the list.

        // We use first and after to move through the unordered list, but could have
        // used
        // the iterator like the later example.
        for (Position<Course> psn = unordered.first(); psn != null; psn = unordered.after(psn)) {
            Course c = psn.getElement();
            System.out.println(c);
        }

        PositionalList<Course> ordered = new LinkedPositionalList<Course>();

        ordered.addOrdered(csc110);
        ordered.addOrdered(csc205);
        ordered.addOrdered(the201);
        ordered.addOrdered(csc120);

        System.out.println();
        System.out.println("Ordered list");
        // We use the iterator to move through the ordered list, but could have used
        // first and after like the earlier example does.
        for (Course c : ordered) {
            System.out.println(c);
        }
    }
}
