package pacman;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Player {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private int x;
    private int y;
    private String name;
    protected Color color;

    public Player(int x, int y, String name, Color color) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setX(int x) {
        // The following logic "clamps" the value provided to be
        // between 0 and GameBoard.WIDTH. Java 21 introduces a
        // new method to allow this short form:
        // this.x = Math.clamp(x, 0, maxWidth);
        // See setY for a shorter version using the conditional operator.
        int maxWidth = GameBoard.WIDTH - Player.WIDTH - 1;
        if (x < 0) {
            this.x = 0;
        } else if (x > maxWidth) {
            this.x = maxWidth;
        } else {
            this.x = x;
        }
    }

    public void setY(int y) {
        // See setX for a longer version.
        int maxHeight = GameBoard.HEIGHT - Player.HEIGHT - 1;
        this.y = y < 0 ? 0 : (y > maxHeight ? maxHeight : y);
    }

    public abstract void draw(Graphics2D g2);

    public abstract void move();
}
