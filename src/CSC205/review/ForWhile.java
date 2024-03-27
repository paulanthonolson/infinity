package review;

public class ForWhile {
    public static void main(String[] args) {
        int count;

        // this while loop
        count = 0;
        while (count < 10) {
            System.out.println(count);
            count++;
        }

        // does the same thing as this for loop
        for (count = 0; count < 10; count++) {
            System.out.println(count);
        }
    }
}
