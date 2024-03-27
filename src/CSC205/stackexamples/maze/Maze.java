package stackexamples.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Maze extends JPanel implements KeyListener {
    private enum MazeCell {
        FRONTIER,
        EXPLORING,
        EXPLORED,
        TARGET
    }

    // Choosing down and right before up and left would be more efficient
    // but the inefficient approach provides more stack demonstrations.
    private static final Point[] directions = {
            new Point(-1, 0), // up
            new Point(0, -1), // left
            new Point(0, 1), // down
            new Point(1, 0) // right
    };

    private static final long serialVersionUID = 1;
    private static final int borderWidth = 1;
    private static final int feedbackWidth = 60;
    private static final Color paleGray = new Color(224, 224, 224);

    private int maxX = 4, maxY = 4;
    private int autoPilotSpeed = 0;
    private int changeSize = 0;
    private LinkedBlockingQueue<KeyEvent> keyEvents = new LinkedBlockingQueue<>();
    private HashSet<ConnectedCells> connectedCellsSet = new HashSet<>();
    private Stack<Point> solutionStack = new Stack<>();
    private JTextArea feedback = new JTextArea();
    // maze is accessed as maze[y][x]
    private MazeCell[][] maze;

    public Maze() {
        createAldousBroderMaze();
        setLayout(null);
        feedback.setBounds(0, 0, feedbackWidth, 1200);
        feedback.setMargin(new Insets(5, 5, 5, 5));
        feedback.setEditable(false);
        feedback.setFocusable(false);
        feedback.setFont(feedback.getFont().deriveFont(18f));
        add(feedback);
    }

    /**
     * Use the Aldous-Broder Algorithm to create a minimum spanning tree maze.
     * Assume we will always start searching in the upper left and target the lower
     * right.
     */
    public void createAldousBroderMaze() {
        int x, y;

        if (changeSize != 0) {
            maxX = Math.max(3, maxX + changeSize);
            maxY = Math.max(3, maxY + changeSize);
            changeSize = 0;
        }

        maze = new MazeCell[maxY][maxX];
        for (y = 0; y < maxY; y++) {
            Arrays.fill(maze[y], MazeCell.FRONTIER);
        }

        x = 0;
        y = 0;
        maze[maxY - 1][maxX - 1] = MazeCell.TARGET;
        boolean[][] visited = new boolean[maxY][maxX];
        visited[y][x] = true;
        connectedCellsSet.clear();
        solutionStack.clear();

        // Take a random walk around the maze. Each time we wander into an unvisited
        // cell,
        // create a connection between the old cell and the new cell.
        for (int remaining = maxX * maxY - 1; remaining > 0;) {
            Point direction = directions[(int) (Math.random() * directions.length)];
            int nextX = x + direction.x, nextY = y + direction.y;

            if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY) {
                if (!visited[nextY][nextX]) {
                    connectedCellsSet.add(new ConnectedCells(new Point(x, y), new Point(nextX, nextY)));
                    visited[nextY][nextX] = true;
                    remaining--;
                }

                x = nextX;
                y = nextY;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int padding = 10;
        int leftOffset = feedbackWidth + padding;
        int cellSize = Math.max(1,
                Math.min((this.getHeight() - padding * 2) / maxY, (this.getWidth() - leftOffset - padding) / maxX));

        g.translate(leftOffset, padding);

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                Color color;
                switch (maze[y][x]) {
                    case EXPLORED:
                        color = paleGray;
                        break;
                    case TARGET:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(cellSize * x, cellSize * y, cellSize, cellSize);
            }
        }

        @SuppressWarnings("unchecked")
        Stack<Point> solutionStackCopy = (Stack<Point>) solutionStack.clone();
        String solutionText = "";

        while (!solutionStackCopy.empty()) {
            Point p = solutionStackCopy.pop();
            g.setColor(Color.GREEN);
            g.fillRect(p.x * cellSize, p.y * cellSize, cellSize, cellSize);

            if (solutionText.length() == 0) {
                g.setColor(Color.RED);
                g.fillOval(p.x * cellSize + borderWidth, p.y * cellSize + borderWidth, cellSize - 2 * borderWidth,
                        cellSize - 2 * borderWidth);
            }

            solutionText += p.x + "," + p.y + "\n";
        }

        g.setColor(Color.BLACK);
        for (int y = 0; y < maxY; y++) {
            // Leave entrance side open
            if (y > 0) {
                drawVerticalSide(g, cellSize, 0, y);
            }
            // Leave exit side open
            if (y < maxY - 1) {
                drawVerticalSide(g, cellSize, maxX, y);
            }

            for (int x = 0; x < maxX; x++) {
                // On the first pass, draw the top and bottom borders
                if (y == 0) {
                    drawHorizontalSide(g, cellSize, x, 0);
                    drawHorizontalSide(g, cellSize, x, maxY);
                }

                Point xy = new Point(x, y);
                if (x < maxX - 1 && !connectedCellsSet.contains(new ConnectedCells(xy, new Point(x + 1, y)))) {
                    drawVerticalSide(g, cellSize, x + 1, y);
                }
                if (y < maxY - 1 && !connectedCellsSet.contains(new ConnectedCells(xy, new Point(x, y + 1)))) {
                    drawHorizontalSide(g, cellSize, x, y + 1);
                }
            }
        }

        feedback.setText(solutionText);
    }

    private void drawHorizontalSide(Graphics g, int cellSize, int x, int y) {
        g.fillRect(cellSize * x - borderWidth, cellSize * y - borderWidth, cellSize + borderWidth * 2, borderWidth * 2);
    }

    private void drawVerticalSide(Graphics g, int cellSize, int x, int y) {
        g.fillRect(cellSize * x - borderWidth, cellSize * y - borderWidth, borderWidth * 2, cellSize + borderWidth * 2);
    }

    public void pause(boolean solving) throws RestartException {
        boolean restart = false;
        boolean waiting = true;
        KeyEvent keyEvent;

        repaint();
        while (waiting || !keyEvents.isEmpty()) {
            try {
                if (solving && autoPilotSpeed > 0) {
                    keyEvent = keyEvents.poll(autoPilotSpeed, TimeUnit.MILLISECONDS);
                    waiting = false;
                } else {
                    keyEvent = keyEvents.take();
                }
            } catch (InterruptedException e) {
                keyEvent = null;
            }

            if (keyEvent != null) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        maxX++;
                        maxY++;
                        restart = true;
                        break;

                    case KeyEvent.VK_DOWN:
                        if (maxY + changeSize > 3 && maxX + changeSize > 3) {
                            maxX--;
                            maxY--;
                            restart = true;
                        }
                        break;

                    case KeyEvent.VK_LEFT:
                        restart = true;
                        break;

                    case KeyEvent.VK_RIGHT:
                        waiting = false;
                        break;

                    case 'A': // Toggle autopilot
                        autoPilotSpeed = autoPilotSpeed == 0 ? 512 : 0;
                        waiting = !waiting;
                        break;

                    case 'C': // Close off the target cell
                    {
                        Point xy = new Point(maxX - 1, maxY - 1);
                        connectedCellsSet.remove(new ConnectedCells(xy, new Point(maxX - 2, maxY - 1)));
                        connectedCellsSet.remove(new ConnectedCells(xy, new Point(maxX - 1, maxY - 2)));
                        repaint();
                    }
                        break;

                    case 'F': // Faster autopilot speed
                        if (autoPilotSpeed > 1) {
                            autoPilotSpeed >>= 1;
                        }
                        break;

                    case 'S': // Slower autopilot speed
                        if (autoPilotSpeed < 16384) {
                            autoPilotSpeed <<= 1;
                        }
                        break;
                }

                if (restart) {
                    throw new RestartException();
                }
            }
        }
    }

    // This recursive function searches for a path throw the maze. It pauses during
    // moves
    // to allow the maze shown on the screen to sync up and to detect and handle
    // other
    // key events.
    public boolean searchForSolution(int x, int y) throws RestartException {
        // Base case: found our way to the target
        if (maze[y][x] == MazeCell.TARGET) {
            solutionStack.add(new Point(x, y));
            autoPilotSpeed = 0;
            return true;
        }

        if (maze[y][x] == MazeCell.FRONTIER) {
            // Recursive case: this cell requires exploring
            maze[y][x] = MazeCell.EXPLORING;
            Point xy = new Point(x, y);
            solutionStack.add(xy);
            pause(true);

            for (Point direction : directions) {
                if (connectedCellsSet.contains(new ConnectedCells(xy, new Point(x + direction.x, y + direction.y))) &&
                        searchForSolution(x + direction.x, y + direction.y)) {
                    return true;
                }
            }

            solutionStack.pop();
            maze[y][x] = MazeCell.EXPLORED;
            pause(true);
        }

        // Base case: this cell is no longer in the frontier
        return false;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // As keys are pressed, place them into a queue to be processed
        // during the next time slice.
        if (ke.getID() == KeyEvent.KEY_PRESSED) {
            keyEvents.add(ke);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

}
