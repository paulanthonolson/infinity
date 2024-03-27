package lab7a;

public class Course implements Comparable<Course> {
    private String prefix;
    private int number;
    private String title;

    public Course(String prefix, int number, String title) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
    }

    public String toString() {
        String result = prefix + " " + number + ": " + title;
        return result;
    }

    public int compareTo(Course otherCourse) {
        int result;

        // First compare the prefix. Since these are Strings, use their compareTo
        // method.
        result = prefix.compareToIgnoreCase(otherCourse.prefix);

        // If the prefixes are identical, compare the numbers
        if (result == 0) {
            // Since these are numbers, we use subtraction.
            // The typical case is our number minus the other number
            // to make them sort from smallest to largest.
            result = this.number - otherCourse.number;
            result = -result;
        }

        // result = -result;

        return result;
    }
}
