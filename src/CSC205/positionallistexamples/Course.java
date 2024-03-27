package positionallistexamples;

import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable {
    private String prefix;
    private int number;
    private String title;
    private String grade;

    public Course(String prefix, int number, String title) {
        this(prefix, number, title, "");
    }

    public Course(String prefix, int number, String title, String grade) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        if (grade == null) {
            this.grade = "";
        } else {
            this.grade = grade;
        }
    }

    public String getPrefix() {
        return prefix;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getGrade() {
        return grade;
    }

    public String getCourseName() {
        return prefix + number;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean hasTaken() {
        return !grade.equals("");
    }

    @Override
    public String toString() {
        String result = prefix + " " + number + ": " + title;
        if (hasTaken())
            result += "  [" + grade + "]";
        return result;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Course) {
            Course otherCourse = (Course) other;
            if (prefix.equals(otherCourse.getPrefix()) &&
                    number == otherCourse.getNumber())
                result = true;
        }
        return result;
    }

    @Override
    public int compareTo(Course otherCourse) {
        int result;

        result = prefix.compareTo(otherCourse.getPrefix());
        if (result == 0) {
            result = number - otherCourse.getNumber();
        }

        return result;
    }
}
