package pacman;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PacManDriver extends JFrame {
    public PacManDriver() {
        GameBoard gb = new GameBoard();
        add(gb);
        setTitle("PacMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PacManDriver();
        });
    }
}
