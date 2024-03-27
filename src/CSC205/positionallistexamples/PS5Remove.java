package positionallistexamples;

import java.io.IOException;
import java.util.Iterator;

public class PS5Remove {
    // See PS2Save and PS3Load for better examples of handling of file exceptions
    // using try and catch.
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProgramOfStudy ps = ProgramOfStudy.load("ProgramOfStudy.csc");

        System.out.println("Program of Study before remove");
        System.out.println(ps);

        System.out.println();
        System.out.println("Removing courses with no grades.");
        Iterator<Course> itr = ps.iterator();
        while (itr.hasNext()) {
            Course course = itr.next();
            if (!course.hasTaken()) {
                itr.remove();
            }
        }

        System.out.println();
        System.out.println("Program of Study after remove");
        System.out.println(ps);

        // Save modified version that has only graded courses
        ps.save("ProgramOfStudy.csc");
    }
}
