package lab3b;

public class CircularlyLinkedListDriver {
    public static void main(String[] args) {
        CircularlyLinkedList<Day> dayList = new CircularlyLinkedList<>();

        dayList.addLast(new Day("Monday", true));
        dayList.addLast(new Day("Tuesday", true));
        dayList.addLast(new Day("Wednesday", true));
        dayList.addLast(new Day("Thursday", true));
        dayList.addLast(new Day("Friday", true));
        dayList.addLast(new Day("Saturday", false));
        dayList.addLast(new Day("Sunday", false));

        for (int i = 0; i < 14; i++) {
            // Pay very careful attention to how and why this logic works
            Day yesterday = dayList.last();
            Day today = dayList.first();
            dayList.rotate();
            Day tomorrow = dayList.first();

            System.out.printf("Today: %-9s  Yesterday: %-9s  Tomorrow: %-9s\n",
                    today, yesterday, tomorrow);
        }
    }
}
