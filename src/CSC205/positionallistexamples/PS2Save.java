package positionallistexamples;

import java.io.IOException;
import positionallist.*;

// When you run this program, the file it creates can be found in the Explorer pane by scrolling to the bottom of the files.

public class PS2Save {
    public static void main(String[] args) {
        ProgramOfStudy ps = new ProgramOfStudy();

        ps.addCourseToRear(new Course("CSC", 110, "Introduction to Computer Science", "A"));
        // Remember where csc120 was inserted for later
        Position<Course> csc120Psn = ps.addCourseToRear(new Course("CSC", 120, "Digital Design Fundamentals"));
        ps.addCourseToRear(new Course("CSC", 205, "Object-Oriented Programming and Data Structures"));
        ps.addCourseToRear(new Course("THE", 201, "The Theatre Experience"));

        System.out.println("Added four courses");
        System.out.println(ps);

        ps.addCourseAfter(csc120Psn, new Course("CSC", 230, "Computer Organization and Assembly Language"));

        System.out.println("Added CSC230 after CSC120");
        System.out.println(ps);

        Course theatre = ps.findCourse("THE", 201);
        theatre.setGrade("A-");

        System.out.println("Changed THE201 grade");
        System.out.println(ps);

        ps.replaceCourse(csc120Psn, new Course("INT", 105, "Introduction to Interior Design", "B+"));

        System.out.println("Replaced CSC120 with INT105");
        System.out.println(ps);

        try {
            ps.save("ProgramOfStudy.csc");
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }
}
