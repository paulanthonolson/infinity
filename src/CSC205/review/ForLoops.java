package review;

public class ForLoops {
    public static void main(String[] args) {
        int count;

        System.out.println("Count from 0 to 9 using < to stop");
        for (count = 0; count < 10; count++) {
            System.out.println(count);
        }

        System.out.println("Count from 1 to 10 using <= to stop");
        for (count = 1; count <= 10; count++) {
            System.out.println(count);
        }

        System.out.println("Print 5 lines with leading number, ), and same number of asterisks");
        // Lines starting with number and ) followed by the same number of asterisks as
        // the number
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + ") ");
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Print multiplication table");
        // Multiplication table
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                System.out.printf("%3d ", (x * y));
            }
            System.out.println();
        }
    }
}
