package review;

import java.util.Scanner;

public class ArrayAverageAny {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] x;

        System.out.print("How many integers would you like to average? ");
        int size = scnr.nextInt();
        x = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter next integer: ");
            x[i] = scnr.nextInt();
        }
        int avg = average(x);
        System.out.println("Average is " + avg);

        scnr.close();
    }

    private static int average(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum / x.length;
    }

}
