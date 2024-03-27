package recursion;

import linkedlist.SinglyLinkedList;

public class RecursiveMethods {

    public static int sum(int num) {
        if (num < 0) {
            return 0;
        }
        if (num == 0) {
            return 0;
        } else {
            return num + sum(num - 1);
        }
    }

    public static int factorial(int num) {

        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }

    }

    public static int power(int base, int exp) {

        if (exp == 0) {
            return 1;
        } else {
            return base * power(base, exp - 1);

        }

    }

    public static int fib(int num) {

        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

    public static int gcd(int x, int y) {

        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void reverseList(SinglyLinkedList<Integer> list) {
        if (list.isEmpty()) {
            return;
        } else {
            int firstElement = list.first();

            list.removeFirst();
            reverseList(list);
            list.addLast(firstElement);
        }

    }

    static int testRun = 0;
    static int testPassed = 0;
    static int testFailed = 0;

    public static void otest(String description, Object computedValue, Object correctValue) {
        String prefix;
        String suffix;

        testRun++;

        if (computedValue.equals(correctValue)) {
            testPassed++;
            prefix = "+";
            suffix = "";
        } else {
            testFailed++;
            prefix = "-";
            suffix = ", expected " + correctValue;
        }

        System.out.println(prefix + " " + description + " returned " + computedValue + suffix);
    }

    public static void itest(String description, Integer computedValue, Integer correctValue) {
        otest(description, computedValue, correctValue);
    }

    public static void main(String[] args) {
        itest("sum(5)", sum(5), 15);
        itest("factorial(5)", factorial(5), 120);
        itest("power(10, 0)", power(10, 0), 1);
        itest("power(2, 3)", power(2, 3), 8);
        itest("power(3, 2)", power(3, 2), 9);
        itest("power(10, 4)", power(10, 4), 10000);
        itest("fib(0)", fib(0), 0);
        itest("fib(1)", fib(1), 1);
        itest("fib(2)", fib(2), 1);
        itest("fib(3)", fib(3), 2);
        itest("fib(4)", fib(4), 3);
        itest("fib(5)", fib(5), 5);
        itest("gcd(3, 6)", gcd(3, 6), 3);
        itest("gcd(8, 60)", gcd(8, 60), 4);

        SinglyLinkedList<Integer> nums = new SinglyLinkedList<>();
        nums.addLast(1);
        nums.addLast(5);
        nums.addLast(12);
        nums.addLast(17);
        reverseList(nums);
        otest("reversed", nums.toString(), "[ 17, 12, 5, 1 ]");

        System.out.println();
        System.out.println(
                "For " + testRun + " tests, " +
                        testPassed + " passed and " +
                        testFailed + " failed");
    }
}
