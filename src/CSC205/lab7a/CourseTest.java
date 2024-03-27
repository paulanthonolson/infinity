package lab7a;

import positionallist.*;

public class CourseTest {
    public static void main(String[] args) {
        PositionalList<Course> list = new LinkedPositionalList<>();

        list.addOrdered(new Course("CSC", 205, "Object Oriented Programming and Data Structures"));
        list.addOrdered(new Course("csc", 120, "Digital Design Fundamentals"));
        list.addOrdered(new Course("CSC", 110, "an Introduction to Computer Science"));
        list.addOrdered(new Course("THE", 201, "The Dramatic Experience"));
        list.addOrdered(new Course("MAT", 100, "X"));

        for (Course c : list) {
            System.out.println(c);
        }
    }
}
