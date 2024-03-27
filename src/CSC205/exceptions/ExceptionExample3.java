package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample3 {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
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
                }
            } catch (ClassCastException cce) {
                System.out.println("   Caught the ClassCastException");
            } catch (ArrayIndexOutOfBoundsException aie) {
                System.out.println("   Caught the ArrayIndexOutOfBounds");
            }

            catch (NullPointerException npe) {
                System.out.println("   Caught the NullPointerException");
            } catch (InputMismatchException ime) {
                System.out.println("   Caught the InputMismatchException");
            }
            // catch (ArithmeticException ae) {
            // System.out.println(" Caught the ArithmeticExcpetion");
            // }
            catch (Exception e) {
                System.out.println("   Caught another Exception");
            } finally {
                System.out.println("   Finally reached - continue normally.\n");
            }
        }
    }

}
