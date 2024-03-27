package positionallistexamples;

import java.io.IOException;

public class PS6FailFast {
    // See PS2Save and PS3Load for better examples of handling of file exceptions
    // using try and catch.
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProgramOfStudy ps = ProgramOfStudy.load("ProgramOfStudy.csc");

        System.out.println("Loaded from disk");

        for (Course course : ps) {
            // Changing the content of the elements is allowed
            course.setGrade("A");
            System.out.println(course);
            // Changing the list while we iterate is not allowed
            ps.addCourseToRear(new Course("ENG", 101, "Intro to Composition"));
        }
    }
}
