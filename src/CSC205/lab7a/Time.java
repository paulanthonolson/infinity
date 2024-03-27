package lab7a;

public class Time implements Comparable<Time> {
    private int hour;
    private int min;
    private boolean pm;

    public Time(int hour, int min, boolean pm) {
        this.hour = hour;
        this.min = min;
        this.pm = pm;

    }

    public int compareTo(Time otherTime) {
        int result = this.hour - otherTime.hour;

        if (result == 0) {
            result = this.min - otherTime.min;
        }

        return result;

    }

    public String toString() {
        return String.format("%02d:%02 %s", hour, min, pm);
    }

}
