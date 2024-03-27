package lab3a;

// See https://csem.cc/link/csc205ab/arrayshifts

import java.util.Arrays;

public class ArrayShifts {
    public static void main(String[] args) {
        // version1();
        // version2();
        version3();
    }

    public static void version1() {
        char[] arr = new char[5];
        int next = 0;

        System.out.println(next + " " + Arrays.toString(arr));

        // The arr[9] values are all incorrect and must be changed to the appropriate
        // values.

        arr[0] = 'O';
        next++;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[1] = arr[0];
        arr[0] = 'G';
        next++;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[2] = arr[1];
        arr[1] = arr[0];
        arr[0] = 'N';
        next++;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[3] = arr[2];
        arr[2] = arr[1];
        arr[1] = arr[0];
        arr[0] = 'I';
        next++;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[4] = arr[3];
        arr[3] = arr[2];
        arr[2] = arr[1];
        arr[1] = arr[0];
        arr[0] = 'B';
        next++;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[1] = arr[2];
        arr[2] = arr[3];
        arr[3] = arr[4];
        arr[4] = arr[3];
        next--;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[1] = arr[2];
        arr[2] = arr[3];
        arr[3] = arr[4];
        next--;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[1] = arr[2];
        arr[2] = arr[3];
        next--;
        System.out.println(next + " " + Arrays.toString(arr));

        arr[0] = arr[1];
        next--;
        System.out.println(next + " " + Arrays.toString(arr));

        next--;
        System.out.println(next + " " + Arrays.toString(arr));
    }

    public static void version2() {
        System.out.println("loops2");
        char[] arr = new char[5];
        int next = 0;
        char[] letters = { 'O', 'G', 'N', 'I', 'B' };

        for (char letter : letters) {
            // Start: add some logic to shift the letters over
            for (int i = next; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            // End: shift code
            arr[0] = letter;
            next++;
            System.out.println(next + " " + Arrays.toString(arr));
        }

        while (next > 0) {

            for (int i = 0; i < next - 1; i++) {
                arr[i] = arr[i + 1];

            }
            // Start: add some logic to shift the letters back
            arr[next - 1] = ' ';
            // End: shift code
            next--;
            System.out.println(next + " " + Arrays.toString(arr));
        }
    }

    public static void version3() {
        System.out.println("SimpleList2");
        SimpleList2<Character> list = new SimpleList2<>();
        char[] letters = { 'O', 'G', 'N', 'I', 'B' };

        for (char letter : letters) {
            list.addFirst(letter);
            System.out.println(list);
        }

        while (list.size() > 0) {
            list.removeFirst();
            System.out.println(list);
        }
    }
}