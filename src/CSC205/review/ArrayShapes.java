package review;

import java.util.Scanner;

// Warning: This program has two bugs. Can you find and fix them?

public class ArrayShapes {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int sides;
        String name;
        String[] shapes = { "point", "line", "triangle", "square", "pentagon", "hexagon", "heptagon", "octagon" };

        System.out.println("How many sides? ");
        sides = scnr.nextInt();

        if (sides >= 0 && sides < shapes.length) {
            name = shapes[sides - 1];
        } else {
            name = "IDK";
        }
        System.out.println("A " + sides + " sided polygon is called a " + name);

        scnr.close();
    }
}
