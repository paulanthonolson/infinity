package lab7a;

public class MilitaryTime implements Comparable<MilitaryTime> {
    private int hour;
    private int min;

    public MilitaryTime(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public int compareTo(MilitaryTime otherMilitaryTime) {
        int result;

        result = this.hour - otherMilitaryTime.hour;

        // If the hour is the same for both times, result will be 0 and we need to
        // consider the minutes
        if (result == 0) {
            result = this.min - otherMilitaryTime.min;
        }

        return result;
    }

    public String toString() {
        return String.format("%02d:%02d", hour, min);
    }
}
