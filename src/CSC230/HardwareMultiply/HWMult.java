package HardwareMultiply;

import java.util.Scanner;

public class HWMult {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hardware Multiplier - Paul Olson\n");
        System.out.println("Enter two postive 32-bit integers to multiply: ");
        
        System.out.print("Multiplier: ");
        int multiplier = scanner.nextInt();

        System.out.print("Multiplicand: ");
        int multiplicand = scanner.nextInt();

        long product = HW_Mult(multiplier, multiplicand);

       
        System.out.println("Algorithm result: " + product);
        System.out.println("Java result: " + ((long) multiplier * multiplicand));

        scanner.close();

    }
    
    private static long HW_Mult(int multiplier, int multiplicand){
        long product = 0;

        long longMultiplicand = multiplicand;
        
        for (int i = 0; i < 32; i++) {
            if ((multiplier & 1) != 0) {
                product += longMultiplicand;
            }
            longMultiplicand <<= 1;
            multiplier >>>= 1;
        }
        return product;
    }

    
}
