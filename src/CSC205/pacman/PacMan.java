package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class PacMan extends Player {
    private int direction;

    public PacMan(int x, int y) {
        super(x, y, "PacMan", Color.YELLOW);
        direction = 270;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillArc(getX(), getY(), WIDTH, HEIGHT, direction + 45, 270);
    }

    @Override
    public void move() {
        int speed = 6;

        switch (direction) {
            case 0:
                setX(getX() + speed);
                break;
            case 90:
                setY(getY() - speed);
                break;
            case 180:
                setX(getX() - speed);
                break;
            case 270:
                setY(getY() + speed);
                break;
        }

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                direction = 90;
                break;
            case KeyEvent.VK_DOWN:
                direction = 270;
                break;
            case KeyEvent.VK_LEFT:
                direction = 180;
                break;
            case KeyEvent.VK_RIGHT:
                direction = 0;
                break;
        }
    }
}
