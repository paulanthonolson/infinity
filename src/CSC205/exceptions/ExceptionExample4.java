package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample4 {

    public static void main(String[] args) {

        for (int i = 1; i <= 6; i++) {
            try {
                switch (i) {
                    case 1:
                        System.out.println("Case 1: Class Cast Exception");
                        Object o = new Scanner(System.in);
                        String st = (String) o;
                        break;

                    case 2:
                        System.out.println("Case 2: Array Index Out Of Bounds Exception");
                        int[] p = new int[10];
                        p[10] = 0;
                        break;

                    case 3:
                        System.out.println("Case 3: Null Pointer Exception");
                        String s = null;
                        System.out.println("String is " + s.length() + " characters long");
                        break;

                    case 4:
                        System.out.println("Case 4: Input Mismatch Exception");
                        System.out.print("   Enter an integer: ");
                        new Scanner(System.in).nextInt();
                        break;

                    case 5:
                        System.out.println("Case 5: Arithmetic Exception");
                        int v = 10 / 0;
                        break;

                    case 6:
                        System.out.println("Case 6: Special Array Index Exception");
                        throw new ArrayIndexOutOfBoundsException("That element doesn't exist!");
                }
            } catch (ClassCastException cce) {
                System.out.println("   Caught the ClassCastExcpetion");
            }
            // catch (ArrayIndexOutOfBoundsException aie) {
            // System.out.println(" Caught the ArrayIndexOutOfBounds");
            // }
            catch (Exception e) {
                System.out.println("   Caught an Exception: " + e);
                System.out.println("   Message is " + e.getMessage());
                // e.printStackTrace();
                e.printStackTrace(System.out);
            } finally {
                System.out.println("   Finally reached - continue normally.\n");
            }
        }
    }

}
