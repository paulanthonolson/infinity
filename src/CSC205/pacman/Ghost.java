package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Ghost extends Player {
    private PacMan pm;
    private Font nameFont;

    public Ghost(int x, int y, String name, Color color, PacMan pm) {
        super(x, y, name, color);
        this.pm = pm;
        nameFont = new Font("default", Font.BOLD, 14);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        // top of head
        g2.fillOval(getX(), getY(), WIDTH, HEIGHT);
        // body
        g2.fillRect(getX(), getY() + HEIGHT / 2, WIDTH, HEIGHT / 2);
        // eyes
        g2.setColor(Color.WHITE);
        g2.fillOval(getX() + 10, getY() + 10, 10, 10);
        g2.fillOval(getX() + WIDTH - 20, getY() + 10, 10, 10);
        // center name near bottom
        g2.setColor(Color.BLACK);
        g2.setFont(nameFont);
        Rectangle2D nameSize = g2.getFontMetrics().getStringBounds(getName(), g2);
        int left = getX() + (WIDTH - (int) nameSize.getWidth()) / 2;
        int bottom = getY() + HEIGHT - 4;
        g2.drawString(getName(), left, bottom);
    }

    @Override
    public void move() {
        // move toward PacMan by comparing where this ghost is versus where PacMan is
        if (getX() > pm.getX()) {
            setX(getX() - 1);
        }
        if (getX() < pm.getX()) {
            setX(getX() + 1);
        }
        if (getY() > pm.getY()) {
            setY(getY() - 1);
        }
        if (getY() < pm.getY()) {
            setY(getY() + 1);
        }
    }
}
