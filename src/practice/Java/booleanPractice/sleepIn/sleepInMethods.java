package practice.Java.booleanPractice.sleepIn;

import java.util.Arrays;
import java.util.Scanner;

public class sleepInMethods {
    String Sunday;
    String Monday;
    String Tuesday;
    String Wednesday;
    String Thursday;
    String Friday;
    String Saturday;

    Scanner scnr = new Scanner(System.in);

    public boolean sleepIn(int weekday) {

        if (weekday == 1 || weekday == 2 || weekday == 3 || weekday == 4 || weekday == 5) {
            return false;
        } else if (weekday == 0 || weekday  == 6) {

        }
        return true;
    }

    public int dayToNum(String day) {

        int dayNum = -1;
        String[] daysOfWeek = { null, "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        for (int i = 0; dayNum < daysOfWeek.length; i++) {
            if (day.equalsIgnoreCase(daysOfWeek[i])) {
                dayNum = i;
                break;
            }
        }
        return dayNum;
    }

}
