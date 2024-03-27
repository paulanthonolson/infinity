package CSC205.yahtzee;

import java.util.Arrays;

public class YahtzeeRoll {
    private String forUseByToStringOnlyDoNotUseInYourMethods;
    private int[] diceRoll;

    public YahtzeeRoll(int d0, int d1, int d2, int d3, int d4) {
        forUseByToStringOnlyDoNotUseInYourMethods = d0 + " " + d1 + " " + d2 + " " + d3 + " " + d4;

        diceRoll = new int[5];

        int[] diceRollResult = { d0, d1, d2, d3, d4 };

        for (int i = 0; i < diceRoll.length; i++) {
            diceRoll[i] = diceRollResult[i];
        }

    }

    private int calculateSum(int value) {
        int sum = 0;
        for (int i = 0; i < diceRoll.length; i++) {
            if (diceRoll[i] == value) {
                sum += value;
            }
        }
        return sum;
    }

    public int aces() {
        return calculateSum(1);
    }

    public int twos() {
        return calculateSum(2);
    }

    public int threes() {
        return calculateSum(3);
    }

    public int fours() {
        return calculateSum(4);
    }

    public int fives() {
        return calculateSum(5);
    }

    public int sixes() {
        return calculateSum(6);
    }

    public int chance() {
        int sum = 0;
        for (int i = 0; i < diceRoll.length; i++) {
            sum += diceRoll[i];
        }
        return sum;
    }

    public int threeOfAKind() {
        int[] diceArray = new int[7];
        Arrays.sort(diceArray);

        for (int i = 0; i < diceRoll.length; i++) {
            diceArray[diceRoll[i]]++;
        }
        for (int evaluate = 1; evaluate <= 6; evaluate++) {
            if (diceArray[evaluate] >= 3) {
                int sum = 0;
                for (int i = 0; i < diceRoll.length; i++) {
                    sum += diceRoll[i];
                }
                return sum;
            }

        }
        return 0;
    }

    public int fourOfAKind() {
        int[] diceArray = new int[7];
        Arrays.sort(diceArray);

        for (int i = 0; i < diceRoll.length; i++) {
            diceArray[diceRoll[i]]++;
        }
        for (int evaluate = 1; evaluate <= 6; evaluate++) {
            if (diceArray[evaluate] >= 4) {
                int sum = 0;
                for (int i = 0; i < diceRoll.length; i++) {
                    sum += diceRoll[i];
                }
                return sum;
            }

        }
        return 0;
    }

    public int fullHouse() {
        int[] diceArray = new int[7];
        Arrays.sort(diceArray);

        for (int i = 0; i < diceRoll.length; i++) {
            diceArray[diceRoll[i]]++;
        }

        int threeOfAKind = 0;
        int twoOfAKind = 0;

        for (int i = 1; i <= 6; i++) {
            if (diceArray[i] == 3) {
                threeOfAKind = i;
            } else if (diceArray[i] == 2) {
                twoOfAKind = i;
            }
        }

        if (threeOfAKind != 0 && twoOfAKind != 0) {
            return 25;
        } else {
            return 0;
        }

    }

    public int smallStraight() {
        int[] diceArray = new int[7];
        Arrays.sort(diceArray);

        for (int i = 0; i < diceRoll.length; i++) {
            diceArray[diceRoll[i]]++;
        }

        if (diceArray[1] >= 1 && diceArray[2] >= 1 && diceArray[3] >= 1 && diceArray[4] >= 1) {
            return 30;
        } else if (diceArray[2] >= 1 && diceArray[3] >= 1 && diceArray[4] >= 1 && diceArray[5] >= 1) {
            return 30;
        } else if (diceArray[3] >= 1 && diceArray[4] >= 1 && diceArray[5] >= 1 && diceArray[6] >= 1) {
            return 30;
        } else {
            return 0;
        }

    }

    public int largeStraight() {
        int[] diceArray = new int[7];
        Arrays.sort(diceArray);

        for (int i = 0; i < diceRoll.length; i++) {
            diceArray[diceRoll[i]]++;
        }

        if (diceArray[1] >= 1 && diceArray[2] >= 1 && diceArray[3] >= 1 && diceArray[4] >= 1 && diceArray[5] >= 1) {
            return 40;
        } else if (diceArray[2] >= 1 && diceArray[3] >= 1 && diceArray[4] >= 1 && diceArray[5] >= 1
                && diceArray[6] >= 1) {
            return 40;
        } else {
            return 0;
        }

    }

    public int yahtzee() {
        int[] diceArray = new int[7];
        Arrays.sort(diceArray);

        for (int i = 0; i < diceRoll.length; i++) {
            diceArray[diceRoll[i]]++;
        }

        for (int i = 1; i <= 6; i++) {
            if (diceArray[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    public String toString() {
        String result;
        result = "Roll: " + forUseByToStringOnlyDoNotUseInYourMethods + "\n" +
                "Upper Section\n" +
                "Aces: " + aces() + "\n" +
                "Twos: " + twos() + "\n" +
                "Threes: " + threes() + "\n" +
                "Fours: " + fours() + "\n" +
                "Fives: " + fives() + "\n" +
                "Sixes: " + sixes() + "\n" +
                "Lower section\n" +
                "Three of a Kind: " + threeOfAKind() + "\n" +
                "Four of a Kind: " + fourOfAKind() + "\n" +
                "Full House: " + fullHouse() + "\n" +
                "Small Straight: " + smallStraight() + "\n" +
                "Large Straight: " + largeStraight() + "\n" +
                "Yahtzee: " + yahtzee() + "\n" +
                "Chance: " + chance();
        return result;
    }

}
