package lab7a;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int compareTo(Date otherDate) {
        int result;

        result = this.year - otherDate.year;

        if (result == 0) {
            result = this.month - otherDate.month;
        }
        if (result == 0) {
            result = this.day - otherDate.day;
        }

        return result;
    }

    public String toString() {
        return String.format("%02d-%02d-%02d", year, month, day);
    }

}
