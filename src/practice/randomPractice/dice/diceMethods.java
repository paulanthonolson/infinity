package practice.randomPractice.dice;

import java.util.Random;

public class diceMethods {
    Random random = new Random();

    public int rollDXX(int myDice) {
        if (myDice < 1) {
            throw new IllegalArgumentException("Number of sides must be at least 1.");
        } else if (myDice > 1750000) {
            throw new IllegalArgumentException("Out of bounds");
        }

        int[] dXX = new int[myDice];

        for (int i = 0; i < myDice; i++) {
            dXX[i] = i + 1;
        }

        int randIndex = (int) (Math.random() * myDice);
        int result = dXX[randIndex];

        System.out.println("You rolled a: " + result);

        return result;
    }

}