package positionallistexamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import positionallist.*;

public class ProgramOfStudy implements Iterable<Course>, Serializable {
    private PositionalList<Course> list;

    public ProgramOfStudy() {
        list = new LinkedPositionalList<>();
    }

    public Position<Course> addCourseToRear(Course course) {
        return list.addLast(course);
    }

    public Position<Course> findCoursePsn(String prefix, int number) {
        // We use first and after to move through the list.
        // See toString for using the iterator as another way to move through the list.
        for (Position<Course> psn = list.first(); psn != null; psn = list.after(psn)) {
            Course course = psn.getElement();
            if (prefix.equals(course.getPrefix()) &&
                    number == course.getNumber()) {
                return psn;
            }
        }
        // No match, return null
        return null;
    }

    public Course findCourse(String prefix, int number) {
        Position<Course> psn = findCoursePsn(prefix, number);
        return psn != null ? psn.getElement() : null;
    }

    public Position<Course> addCourseAfter(Position<Course> target, Course newCourse) {
        return list.addAfter(target, newCourse);
    }

    public Position<Course> replaceCourse(Position<Course> target, Course newCourse) {
        // Insert the new course right after the target
        Position<Course> newCoursePosition = list.addAfter(target, newCourse);
        // then remove the target so only the new course remains
        list.remove(target);
        return newCoursePosition;
    }

    public String toString() {
        String result = "";

        // We use the iterator to move through the list.
        // See find for using first and after as another way to move through the list.
        for (Course course : list) {
            result += course + "\n";
        }

        return result;
    }

    public Iterator<Course> iterator() {
        return list.iterator();
    }

    // Both save and load demonstrate using the "try with resource" that was added
    // in JDK 8. This try takes care of calling the close method on file resources
    // even if an exception happens during file input or output. This form of try
    // allows but does not require any catch or finally statements.

    public void save(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        }
    }

    // This is a static method that should be called using ProgramOfStudy.load
    public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
            return pos;
        }
    }
}
