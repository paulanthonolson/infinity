
package lcr;

public class Game {

    private int pot = 0;

    private int activePlayers;

    private CircularlyLinkedList<Player> playerList = new

    CircularlyLinkedList<>();

    public Game(int numberOfPlayers) {
        activePlayers = numberOfPlayers;

        for (int i = 1; i <= numberOfPlayers; i++) {
            Player p = new Player(i);
            playerList.addLast(p);
        }
    }

    public Player play() {
        System.out.println(this);

        while (activePlayers > 1) {

            Player current = playerList.first();
            Player left = playerList.second();
            Player right = playerList.last();
            playerList.rotate();

            takeTurn(current, left, right);

        }

        Player winner = null;

        while (activePlayers == 1) {

            Player current = playerList.first();

            if (current.getChips() > 0) {
                winner = current;
                break;
            }

            playerList.rotate();
        }

        return winner;
    }

    private void takeTurn(Player current, Player left, Player right) {

        if (current.getChips() == 0) {

            return;
        }

        int totalDice = current.getChips();

        if (totalDice > 3) {
            totalDice = 3;
        }

        System.out.print("#" + current.getNumber() + " has: " + totalDice + " - " + "rolls: ");

        LCRDie dice = new LCRDie();

        for (int i = 0; i < totalDice; i++) {

            dice.roll();
            System.out.print(dice + " ");

            if (dice.isLeft()) {
                current.subtractChip();
                left.addChip();

                if (left.getChips() == 1) {

                    activePlayers++;
                }

            } else if (dice.isRight()) {
                current.subtractChip();
                right.addChip();

                if (right.getChips() == 1) {

                    activePlayers++;
                }

            } else if (dice.isCenter()) {
                current.subtractChip();
                pot++;
            } else if (dice.isDot()) {

            }

            if (current.getChips() == 0) {
                activePlayers--;

            }
        }
        System.out.println("");

        System.out.println(this);

    }

    public String toString() {
        return "Pot: " + pot + " - Active: " + activePlayers + " - Players: " + playerList;
    }
}
