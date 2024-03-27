package review;

// There is a bug in this program. Can you find and fix it?

public class ArrayMultiDimensional {
    private static int sum = 0;

    public static void main(String[] args) {
        int[][] scores = new int[3][5];

        scores[0][0] = 100;
        scores[0][1] = 90;
        scores[0][2] = 85;
        scores[0][3] = 95;
        scores[0][4] = 98;

        scores[1][0] = 85;
        scores[1][1] = 90;
        scores[1][2] = 91;
        scores[1][3] = 94;
        scores[1][4] = 97;

        scores[2][0] = 70;
        scores[2][1] = 72;
        scores[2][2] = 80;
        scores[2][3] = 100;
        scores[2][4] = 100;

        // In this for loop, scores.length is the length of the first dimension
        // which will be the 3 from the new int[3][5].
        for (int student = 0; student < scores.length; student++) {
            int avg = average(scores[student]);
            System.out.println("Student " + student + " average " + avg);
        }
    }

    private static int average(int[] x) {
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum / x.length;
    }
}
