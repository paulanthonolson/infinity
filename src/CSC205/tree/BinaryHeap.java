// An implementation of a binary heap using computed child links

package tree;

import java.util.Scanner;

public class BinaryHeap {
    private static int size = 0;
    private static int maxSize = 100;
    private static int[] heap = new int[2 * maxSize];

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int n;

        do {
            System.out.print("Next number? (0 to delete min, -1 to quit) ");
            n = scnr.nextInt();
            if (n > 0) {
                add(n);
            } else if (n == 0) {
                remove();
            }
            printHeap();
        } while (n >= 0);

        scnr.close();
    }

    private static void add(int n) {
        int p = size++;
        heap[p] = n;
        while (p > 0) {
            if (heap[parent(p)] < heap[p]) {
                break;
            }
            swap(p, parent(p));
            p = parent(p);
        }
    }

    private static int remove() {
        int result = heap[0];
        heap[0] = heap[--size];
        int p = 0;

        while (left(p) < size) {
            int small = left(p);
            if (right(p) < size && heap[right(p)] < heap[small]) {
                small = right(p);
            }
            if (heap[small] > heap[p]) {
                break;
            }
            swap(p, small);
            p = small;
        }
        return result;
    }

    private static int parent(int n) {
        return (n - 1) / 2;
    }

    private static int left(int n) {
        return 2 * n + 1;
    }

    private static int right(int n) {
        return 2 * n + 2;
    }

    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
        System.out.println(getTree());
    }

    private static final double log2 = Math.log(2);

    private static int getHeight(int n) {
        return (int) (Math.log(n) / log2);
    }

    private static String getTree() {
        String result = "";
        int printDepth = getHeight(size);
        int countNodes = 0;
        int previousLevel = -1;

        while (countNodes < size) {
            int current = heap[countNodes++];
            int currentLevel = getHeight(countNodes);
            if (currentLevel > previousLevel) {
                result = result + "\n";
                previousLevel = currentLevel;
                for (int j = 0; j < ((Math.pow(2, (printDepth - currentLevel))) - 1); j++) {
                    result = result + "   ";
                }
            } else {
                for (int i = 0; i < ((Math.pow(2, (printDepth - currentLevel + 1)) - 1)); i++) {
                    result = result + "   ";
                }
            }
            result = result + String.format("%3d", current);
        }
        return result;
    }
}
