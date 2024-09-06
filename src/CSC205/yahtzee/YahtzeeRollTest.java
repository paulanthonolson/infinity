package yahtzee;

// These are the tests to use against your implementation of YahtzeeRoll.
// Do not make any changes to this file.

// See https://csem.cc/link/csc205ab/module-g - Enable JUnit Testing in VS Code
// for information on how to enable and run tests

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class YahtzeeRollTest {
    @Test
    public void aces() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(2, 3, 4, 5, 6);
        assertEquals(0, roll.aces());

        roll = new YahtzeeRoll(1, 1, 1, 3, 3);
        assertEquals(3, roll.aces());
    }

    @Test
    public void twos() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 3, 4, 5, 6);
        assertEquals(0, roll.twos());

        roll = new YahtzeeRoll(2, 2, 2, 5, 6);
        assertEquals(6, roll.twos());
    }

    @Test
    public void threes() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 4, 5, 6);
        assertEquals(0, roll.threes());

        roll = new YahtzeeRoll(3, 3, 3, 3, 4);
        assertEquals(12, roll.threes());
    }

    @Test
    public void fours() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 5, 6);
        assertEquals(0, roll.fours());

        roll = new YahtzeeRoll(4, 4, 5, 5, 5);
        assertEquals(8, roll.fours());
    }

    @Test
    public void fives() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 6);
        assertEquals(0, roll.fives());

        roll = new YahtzeeRoll(1, 1, 2, 2, 5);
        assertEquals(5, roll.fives());
    }

    @Test
    public void sixes() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 5);
        assertEquals(0, roll.sixes());

        roll = new YahtzeeRoll(3, 3, 6, 6, 6);
        assertEquals(18, roll.sixes());
    }

    @Test
    public void threeOfAKind() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 5);
        assertEquals(0, roll.threeOfAKind());

        roll = new YahtzeeRoll(1, 2, 3, 2, 1);
        assertEquals(0, roll.threeOfAKind());

        roll = new YahtzeeRoll(2, 4, 2, 4, 2);
        assertEquals(14, roll.threeOfAKind());

        roll = new YahtzeeRoll(3, 3, 5, 5, 3);
        assertEquals(19, roll.threeOfAKind());

        roll = new YahtzeeRoll(4, 4, 6, 4, 4);
        assertEquals(22, roll.threeOfAKind());
    }

    @Test
    public void fourOfAKind() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 5);
        assertEquals(0, roll.fourOfAKind());

        roll = new YahtzeeRoll(2, 4, 2, 4, 2);
        assertEquals(0, roll.fourOfAKind());

        roll = new YahtzeeRoll(4, 4, 6, 4, 4);
        assertEquals(22, roll.fourOfAKind());

        roll = new YahtzeeRoll(4, 4, 4, 4, 4);
        assertEquals(20, roll.fourOfAKind());
    }

    @Test
    public void fullHouse() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 1, 2, 3, 2);
        assertEquals(0, roll.fullHouse());

        roll = new YahtzeeRoll(1, 1, 2, 2, 2);
        assertEquals(25, roll.fullHouse());

        roll = new YahtzeeRoll(5, 5, 5, 6, 6);
        assertEquals(25, roll.fullHouse());

        roll = new YahtzeeRoll(3, 4, 3, 4, 3);
        assertEquals(25, roll.fullHouse());

        // According to the official rules, five of the same number does not count as a
        // full house
        roll = new YahtzeeRoll(5, 5, 5, 5, 5);
        assertEquals(0, roll.fullHouse());
    }

    @Test
    public void smallStraight() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 5, 6);
        assertEquals(0, roll.largeStraight());

        roll = new YahtzeeRoll(1, 3, 4, 5, 6);
        assertEquals(30, roll.smallStraight(), "Test 3 4 5 6");

        roll = new YahtzeeRoll(1, 4, 3, 2, 6);
        assertEquals(30, roll.smallStraight(), "Test 1 2 3 4");

        roll = new YahtzeeRoll(5, 4, 3, 2, 2);
        assertEquals(30, roll.smallStraight(), "Test 2 3 4 5");
    }

    @Test
    public void largeStraight() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 6);
        assertEquals(0, roll.largeStraight());

        roll = new YahtzeeRoll(1, 2, 3, 4, 5);
        assertEquals(40, roll.largeStraight(), "Test 1 2 3 4 5");

        roll = new YahtzeeRoll(2, 3, 4, 5, 6);
        assertEquals(40, roll.largeStraight(), "Test 2 3 4 5 6");

        roll = new YahtzeeRoll(5, 4, 3, 2, 1);
        assertEquals(40, roll.largeStraight(), "Test 1 2 3 4 5");

        roll = new YahtzeeRoll(2, 6, 3, 5, 4);
        assertEquals(40, roll.largeStraight(), "Test 2 3 4 5 6");
    }

    @Test
    public void yahtzee() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 6);
        assertEquals(0, roll.yahtzee());

        roll = new YahtzeeRoll(2, 2, 4, 2, 2);
        assertEquals(0, roll.yahtzee());

        roll = new YahtzeeRoll(4, 4, 4, 4, 4);
        assertEquals(50, roll.yahtzee());

        roll = new YahtzeeRoll(6, 6, 6, 6, 6);
        assertEquals(50, roll.yahtzee());
    }

    @Test
    public void chance() {
        YahtzeeRoll roll;
        roll = new YahtzeeRoll(1, 2, 3, 4, 5);
        assertEquals(15, roll.chance());

        roll = new YahtzeeRoll(2, 4, 6, 4, 2);
        assertEquals(18, roll.chance());
    }
}
