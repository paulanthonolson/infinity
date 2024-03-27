package textfile;

import java.util.Locale;

/**
 * This program doesn't demonstrate using files, but instead provides examples
 * of the options available in format strings including conversion, precision,
 * width, flags, and argument index.
 * See https://docs.oracle.com/javase/tutorial/essential/io/formatting.html for
 * basic usage or
 * https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax
 * for detailed information.
 */

public class FormatExamples {
    public static void main(String[] args) {
        final int MONTH = 7;
        final int DAY = 4;
        final int YEAR = 1776;
        // This example demonstrates how you can use _ inside long numbers in Java to
        // make
        // them easier to read (they are just ignored). The L at the end is required to
        // specify this value is a long since it is larger than 2,147,483,647.
        final long HEX_TEST = 3_737_844_653L;
        final double DOUBLE = 12345.67;
        final int POS_INT = 123456789;
        final int NEG_INT = -123456789;
        final String STRING = "abecedarian";
        final String SEP = "========  ========  ========";

        // Try uncommenting the Locale line and rerun this program to see the changes
        // in numeric formats that use , and .
        // Locale.setDefault(Locale.GERMAN);

        // Reminder that you need %% to get a single percent sign.
        System.out.printf("To get a percent sign you need %%.\n");

        System.out.println();

        // You can use %n to get a newline, but most people just use \n.
        System.out.printf("This example ends with a newline in format style.%n");

        // This example uses the , flag to get commas for groups of three numbers to the
        // left of the decimal and .2 for two digits to the right of the decimal.
        System.out.printf("currency format: %,.2f\n", DOUBLE);
        // This example demonstrates display numbers in scientific notation.
        System.out.printf("scientific notation: %.3e\n", DOUBLE);
        // This example shows that the , flags works with integers as well.
        System.out.printf("separated int: %,d\n", POS_INT);
        // This example shows how to print a number in hexadecimal, in this case using
        // a number that hides a silly joke.
        System.out.printf("long as hex: %x\n", HEX_TEST);

        System.out.println();

        // These examples show how the 0 flag can be used to change the padding
        // from spaces to zeros.
        System.out.printf("US date without leading zeros: *%d/%d/%d*\n", MONTH, DAY, YEAR);
        System.out.printf("US date with leading spaces  : *%2d/%2d/%4d*\n", MONTH, DAY, YEAR);
        System.out.printf("US date with leading zeros   : *%02d/%02d/%04d*\n", MONTH, DAY, YEAR);
        System.out.printf("Date in ISO 8601 format: %04d-%02d-%02d\n", YEAR, MONTH, DAY);

        System.out.println();

        // These formats demonstrate using the + forced sign to force a + or - to appear
        // in front of a number as appropriate.
        System.out.printf("int without forced sign: %d %d\n", POS_INT, NEG_INT);
        System.out.printf("int with forced sign: %+d %+d\n", POS_INT, NEG_INT);

        System.out.println();

        // These examples demonstrate using the - flag to force formatting to
        // left-justified and also show how applying a precision can force a string
        // to be cutoff at the specified size.
        System.out.println(SEP);
        System.out.printf("%8s  %8s  %8s\n", "One", "Two", "Three");
        System.out.printf("%8s  %8s  %8s\n", "Four", "Five", "Six");
        System.out.println(SEP);
        System.out.printf("%-8s  %-8s  %-8s\n", "One", "Two", "Three");
        System.out.printf("%-8s  %-8s  %-8s\n", "Four", "Five", "Six");
        System.out.println(SEP);
        System.out.printf("%-8s  %-8s  %-8s\n", STRING, STRING, STRING);
        System.out.printf("%-8.8s  %-8.8s  %-8.8s\n", STRING, STRING, STRING);
        System.out.println(SEP);

        System.out.println();

        // These examples demonstrate the use of the argument index to specify which
        // argument should be used for a specific format.
        System.out.printf("Arg 1: %s   Arg 1 again: %<s   Arg2: %d\n", STRING, POS_INT);
        System.out.printf("Arg 3: %3$s   Arg 2: %2$d   Arg 1: %1$f\n", DOUBLE, POS_INT, STRING);
    }
}
