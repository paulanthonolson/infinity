package recursion.sierpinski;
// This program was downloaded from https://courses.cs.washington.edu/courses/cse143/16wi/lectures/Sierpinski.java

// Program that draws the Sierpinski fractal.

import java.awt.*;
import java.util.*;

public class Sierpinski {
    public static final int SIZE = 512; // height/width of DrawingPanel

    public static void main(String[] args) {
        // prompt for level
        Scanner console = new Scanner(System.in);
        System.out.print("What level do you want (6 is a good first test, more than 20 is not recommended)? ");
        int level = console.nextInt();
        System.out.println("The window showing the fractal may be hidden behind this window");

        // initialize drawing panel
        DrawingPanel p = new DrawingPanel(SIZE, SIZE);
        p.setBackground(new Color(212, 254, 249));
        Graphics g = p.getGraphics();

        // compute triangle endpoints and begin recursion
        int triangleHeight = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0);
        Point p1 = new Point(0, triangleHeight);
        Point p2 = new Point(SIZE / 2, 0);
        Point p3 = new Point(SIZE, triangleHeight);
        drawFigure(level, g, p1, p2, p3);
        console.close();
    }

    // Draws a Sierpinski fractal to the given level inside the triangle
    // whose vertices are (p1, p2, p3).
    public static void drawFigure(int level, Graphics g,
            Point p1, Point p2, Point p3) {
        if (level == 1) {
            // base case: simple triangle
            Polygon p = new Polygon();
            p.addPoint(p1.x, p1.y);
            p.addPoint(p2.x, p2.y);
            p.addPoint(p3.x, p3.y);
            g.fillPolygon(p);
        } else {
            // recursive case, split into 3 triangles
            Point p4 = midpoint(p1, p2);
            Point p5 = midpoint(p2, p3);
            Point p6 = midpoint(p1, p3);

            // recurse on 3 triangular areas
            drawFigure(level - 1, g, p1, p4, p6);
            drawFigure(level - 1, g, p4, p2, p5);
            drawFigure(level - 1, g, p6, p5, p3);
        }
    }

    // returns the midpoint of p1 and p2
    public static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}
