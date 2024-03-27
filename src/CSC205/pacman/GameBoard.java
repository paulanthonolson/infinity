package pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener, KeyListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private PacMan pm;
    private Ghost blinky;
    private Ghost pinky;
    private Ghost inky;
    private Ghost clyde;
    private Timer timer;

    public GameBoard() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        pm = new PacMan(50, 50);
        blinky = new Ghost(200, 50, "Blinky", Color.RED, pm);
        pinky = new Ghost(350, 50, "Pinky", Color.PINK, pm);
        inky = new Ghost(500, 50, "Inky", Color.CYAN, pm);
        clyde = new Ghost(650, 50, "Clyde", Color.ORANGE, pm);

        timer = new Timer(50, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
        blinky.draw(g2);
        pinky.draw(g2);
        inky.draw(g2);
        clyde.draw(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pm.move();
        blinky.move();
        pinky.move();
        inky.move();
        clyde.move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pm.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
