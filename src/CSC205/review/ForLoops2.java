package review;

public class ForLoops2 {
    public static void main(String[] args) {
        int count;


        // 1 2 3 4 5 6 7 8 9 10
        for (int x = 1; x <= 10; x++) {
            System.out.println(x);
        }

        // 5 10 15 20 25 30
        for (count = 5; count <= 30; count = count + 5) {
            System.out.println(count);
        }

        // 10 9 8 7 6 5 4 3 2 1 0
        for (int z = 10; z >= 0; z--) {
            System.out.println(z);
        }

        // **********
        printAsterisks();

        // 1) **********
        // 2) **********
        // 3) **********
        for (count = 1; count <= 3; count++) {
            System.out.print(count + ") ");
            printAsterisks();
        }

        int rand0To99;

        for (count = 1; count <= 5; count++) {
            rand0To99 = makeRandomInteger(0, 99);
            System.out.println(rand0To99);
        }

        for (count = 1; count <= 5; count++) {
            int rand6To12 = makeRandomInteger(6, 12);
            System.out.println(rand6To12);
        }

        // 1 2 3 4 6 7 8 9 10
        for (int h = 1; h <= 10; h++) {
            if (h == 5) {
                continue;
            }
            System.out.print(h + " ");
        }
        System.out.println();

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && i % 7 == 0) {
                break;
            }
            System.out.println(i);
        }
    }

    private static void printAsterisks() {
        for (int count = 1; count <= 10; count++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    private static int makeRandomInteger(int smallest, int largest) {
        int randNumber = smallest + (int) (Math.random() * (largest - smallest + 1));
        return randNumber;
    }
}
