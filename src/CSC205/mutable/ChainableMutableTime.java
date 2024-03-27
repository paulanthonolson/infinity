package mutable;

/**
 * This is a modified version of MutableTime to allow chaining. In this version,
 * the void methods that makes changes have been updated to have their
 * type set to the class name and all end with "return this;" to return the
 * current object. With this change, it is possible to chain calls to methods
 * such as:
 * 
 * ChainableMutableTime t = new ChainableMutableTime(6, 0);
 * t.addHour(1).addMinute(30);
 */

public class ChainableMutableTime {
    private int hour;
    private int minute;

    public ChainableMutableTime(int hour, int minute) {
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

    public ChainableMutableTime addHour(int hour) {
        this.hour += hour;
        normalize();
        return this;
    }

    public ChainableMutableTime addMinute(int minute) {
        this.minute += minute;
        normalize();
        return this;
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
