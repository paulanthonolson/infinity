package review;

public class ForWhileAdvanced {
    public static void main(String[] args) {
        int count;

        // This is an advanced example. Feel free to ignore it.

        // Making a for and a while loop behave identically is trickier when break and continue
        // are allowed. Here is how to achieve the same effect using try / finally without any catch.
        // Without the try/finally, this would go into an infinite loop once the program reached 5
        // since count would never get incremented again.
        count = 0;
        while (count < 10) {
            try {
                if (count == 5) {
                    continue;
                }
                System.out.println(count);
            } finally {
                count++;
            }
        }

        // does the same thing as this for loop
        for (count = 0; count < 10; count++) {
            if (count == 5) {
                continue;
            }
            System.out.println(count);
        }
    }
}
