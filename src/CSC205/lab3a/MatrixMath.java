package lab3a;

public class MatrixMath {
    public static void main(String[] args) {
        final double[][] testMatrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        final double[][] testMatrix2 = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };

        final double[][] testMatrix3 = {
                { 1, 0, 1 },
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 1, 2 }
        };

        final double[][] testMatrix4 = {
                { 1, 2, 1 },
                { 2, 3, 1 },
                { 4, 2, 2 }
        };

        double[][] scalarMultiplyTest = multiply(3, testMatrix1);
        printMatrix("scalarMultiplyTest", scalarMultiplyTest);

        double[][] addTest = add(testMatrix1, testMatrix2);
        printMatrix("addTest", addTest);

        double[][] subtractTest = subtract(testMatrix1, testMatrix2);
        printMatrix("subtractTest", subtractTest);

        double[][] transposeTest = transpose(testMatrix1);
        printMatrix("transposeTest", transposeTest);

        double[][] matrixMultiplyTest = multiply(testMatrix3, testMatrix4);
        printMatrix("matrixMultiplyTest", matrixMultiplyTest);

        double[][] identityTest = identity(3);
        printMatrix("identityTest", identityTest);

        double[][] multiplyIdentityTest = multiply(testMatrix3, identityTest);
        printMatrix("multiplyIdentityTest", multiplyIdentityTest);

        if (multiplyIdentityTest != null && equals(testMatrix3, multiplyIdentityTest)) {
            System.out.println("multiplyIdentityTest passed");
        } else {
            System.out.println("multiplyIdentityTest failed");
        }
    }

    public static double[][] multiply(double scalar, double[][] matrix1) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        double[][] result = new double[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                result[i][j] = scalar * matrix1[i][j];
            }
        }
        return result;
    }

    // If matrix1 and matrix2 do not have the same dimensions, throw an illegal
    // argument exception.
    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        return null;
    }

    // You could duplicate the logic of add, but for more of a challenge, can you
    // think of a way to do this by just calling the other methods above?
    public static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        return null;
    }

    public static double[][] transpose(double[][] matrix1) {
        return null;
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        return null;
    }

    public static double[][] identity(int size) {
        return null;
    }

    public static boolean equals(double[][] matrix1, double[][] matrix2) {
        if (matrix1 == null) {
            // If matrix1 is null, they are equal if matrix2 is also null.
            return matrix2 == null;
        }

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        // Different dimensions, not equal
        if (rows1 != rows2 || cols1 != cols2) {
            return false;
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                // Different value in a cell, not equal
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printMatrix(String name, double[][] matrix1) {
        System.out.println(name);
        if (matrix1 == null) {
            System.out.println("Matrix is null");
        } else {
            for (double[] row : matrix1) {
                for (double cell : row) {
                    System.out.printf(" %5.0f", cell);
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
