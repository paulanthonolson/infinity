package stackexamples.maze;

import javax.swing.JFrame;

public class MazeRunner extends JFrame {
    private Maze maze;

    public MazeRunner() {
        setTitle("Maze");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 640);

        setJMenuBar(new MazeMenuBar(this));

        maze = new Maze();
        maze.addKeyListener(maze);
        maze.setFocusable(true);

        add(maze);
        setVisible(true);
    }

    public Maze getMaze() {
        return maze;
    }

    public static void main(String[] args) {
        MazeRunner mazeRunner = new MazeRunner();
        Maze maze = mazeRunner.getMaze();

        while (true) {
            try {
                maze.searchForSolution(0, 0);
                while (true) {
                    maze.pause(false);
                }
            } catch (RestartException e) {
                maze.createAldousBroderMaze();
            }
        }
    }
}
