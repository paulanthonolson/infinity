package mutable;

/**
 * This is an example of a mutable class. A mutable class includes methods that
 * will change the value of an object after it has been created. This is the
 * the common way that building classes is taught.
 */
public class MutableTime {
    private int hour;
    private int minute;

    public MutableTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        normalize();
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void addHour(int hour) {
        this.hour += hour;
        normalize();
    }

    public void addMinute(int minute) {
        this.minute += minute;
        normalize();
    }

    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    // This private method forces hour between 0-23 and minute between 0-59
    private void normalize() {
        hour += minute / 60;
        minute = minute % 60;
        if (minute < 0) {
            hour--;
            minute += 60;
        }
        hour = hour % 24;
        if (hour < 0) {
            hour += 24;
        }
    }
}
