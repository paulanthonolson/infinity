// You may change the number of players for testing, but do not make any other changes to this file.

package lcr;

public class GameDriver {
    public static void main(String[] args) {
        Game g = new Game(5);
        Player winner = g.play();
        System.out.println("Winner: #" + (winner != null ? winner.getNumber() : "null"));
    }
}
