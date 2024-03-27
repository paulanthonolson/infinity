package review;

import java.util.Scanner;

public class SwitchMonthDays {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter year");
        int year = scnr.nextInt();
        System.out.println("Enter month");
        int month = scnr.nextInt();
        int days;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;

            case 2:
                // Start off by assuming non-leap year
                days = 28;
                // Check for possible leap year
                if (year % 4 == 0) {
                    // If so, exclude century years that are not divisible by 400
                    // 1900 and 2100 are not leap years, but 2000 is.
                    if (year % 100 != 0 || year % 400 == 0) {
                        days = 29;
                    }
                }
                break;

            default:
                days = -1;
        }

        System.out.println(days + " days hath " + month);

        scnr.close();
    }
}
