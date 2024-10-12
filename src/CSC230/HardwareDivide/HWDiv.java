package HardwareDivide;
import java.util.Scanner;


public class HWDiv {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hardware Division - Paul Olson");
        System.out.println("Enter a positive 64-bit dividend and a positive 32-bit divisor: ");
        
        System.out.print("Dividend: ");
        long dividend = scanner.nextLong();

        System.out.print("Divisor: ");
        int divisor = scanner.nextInt();

        long quotient = HWDiv_Quotient(dividend, divisor);
        long remainder = HWDiv_Remainder(dividend, divisor);

        System.out.println("Algorithm result: " + dividend + " / " + divisor + " = " + quotient + ", Remainder: " + remainder );
        System.out.println("Java result: " + dividend + " / " + divisor + " = " + (dividend / divisor) + ", Remainder: " + (dividend % divisor));
        
        scanner.close();

    }

    private static long HWDiv_Quotient(long dividend, int divisor){
        if (divisor == 0){
            throw new ArithmeticException("Division by zero");
        }

        long quotient = 0;
        long remainder = 0;
        long longDivisor = divisor;

        for (int i = 63; i>=0; i--){
            remainder = (remainder << 1) | ((dividend >> i) & 1);

            if (remainder >= longDivisor){
                remainder -= longDivisor;
                quotient |= 1L << i;
            }
        }

        return quotient;
    }

    private static long HWDiv_Remainder(long dividend, int divisor){
        if (divisor == 0){
            throw new ArithmeticException("Division by zero");
        }

        long remainder = 0;
        long longDivisor = divisor;

        for (int i = 63; i >= 0; i--){
            remainder = (remainder << 1) | ((dividend >> i) & 1);

            if (remainder >= longDivisor){
                remainder -= longDivisor;
            }
        }

        return remainder;
    }
}
