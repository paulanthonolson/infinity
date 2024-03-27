package review;

import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        Random randGen = new Random();
        int rand0To9;
        int rand1To10;
        int rand6To12;

        // Calling nextInt gives you a random number
        // from 0 up to but not including the specified integer
        rand0To9 = randGen.nextInt(10);
        System.out.println("Random 0 to 9: " + rand0To9);

        // To find a number between a lower and upper bound,
        // use the formula smallest + randGen.nextInt(largest - smallest + 1)
        rand1To10 = 1 + randGen.nextInt(10 - 1 + 1);
        System.out.println("Random 1 to 10: " + rand1To10);

        rand6To12 = 6 + randGen.nextInt(12 - 6 + 1);
        System.out.println("Random 6 to 12: " + rand6To12);

        // We can create our own getRandomInt method to replace the above
        // with a simpler and much less prone method call.
        rand0To9 = makeRandomInt(0, 9);
        System.out.println("Random 0 to 9: " + rand0To9);

        rand1To10 = makeRandomInt(1, 10);
        System.out.println("Random 1 to 10: " + rand1To10);

        rand6To12 = makeRandomInt(6, 12);
        System.out.println("Random 6 to 12: " + rand6To12);

        // This demonstrates picking random letters from a String.
        // dnaBases.length() will return the length of the string (4 in this case)
        // which is the appropriate value to use with nextInt as we want
        // a value back between 0 and 3
        for (int i = 1; i <= 16; i++) {
            String dnaBases = "TGAC";
            int randDnaIndex = randGen.nextInt(dnaBases.length());
            char randDnaBase = dnaBases.charAt(randDnaIndex);
            System.out.print(randDnaBase);
        }

        System.out.println("");

        // This demonstrates how a char value can be used as an int. This will pick 10
        // random letters by calling the getRandomInt method.
        // Notice how the return type of randGen.nextInt has to be cast back to a
        // char by putting (char) before that method call.
        for (int i = 1; i <= 10; i++) {
            char randChar = (char) makeRandomInt('a', 'z');
            System.out.print(randChar);
        }
    }

    /**
     * This routine returns a random number between smallest and largest
     * including those values. For example, getRandomInt(1, 10) can return
     * any number from 1 to 10.
     *
     * @param smallest The smallest number that can be returned.
     * @param largest  The largest number that can be returned.
     */
    static int makeRandomInt(int smallest, int largest) {
        Random randGen = new Random();
        int randNumber = smallest + randGen.nextInt(largest - smallest + 1);
        return randNumber;
    }
}
