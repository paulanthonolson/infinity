package stackexamples.maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MazeMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1;
    private static final String helpText = "Up arrow - increase squares\n" +
            "Down arrow - decrease squares\n" +
            "Left arrow - Restart\n" +
            "Right arrow - Take one step\n" +
            "C - Close off target\n" +
            "A - Autopilot toggle\n" +
            "F - Autopilot faster\n" +
            "S - Autopilot slower\n";

    public MazeMenuBar(final JFrame parent) {
        super();
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenu.add(helpMenuItem);
        add(helpMenu);
        helpMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(parent, helpText, "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
