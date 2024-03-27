package lab3b;

public class Day {
    private String fullName;
    private String abbreviation;
    private boolean weekday;

    public Day(String fullName, boolean weekday) {
        this.fullName = fullName;
        this.weekday = weekday;
        abbreviation = fullName.substring(0, 3);
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public boolean getWeekday() {
        return weekday;
    }

    public String toString() {
        return fullName;
    }
}
