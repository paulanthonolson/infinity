package mutable;

/**
 * This is an example of an immutable class. An immutable class does not allow
 * changing the value of the object after it has been created. Such classes
 * often includes methods that will take the existing object and create a new
 * version of the object with a requested change applied.
 */

public class ImmutableTime {
    private int hour;
    private int minute;

    public ImmutableTime(int hour, int minute) {
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

    public ImmutableTime addHour(int hour) {
        return new ImmutableTime(this.hour + hour, this.minute);
    }

    public ImmutableTime addMinute(int minute) {
        return new ImmutableTime(this.hour, this.minute + minute);
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
