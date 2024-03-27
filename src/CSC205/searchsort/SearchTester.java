package searchsort;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTester {

	public static void main(String[] args) {
		long startTime;
		long endTime;
		double duration1, duration2, duration3; // Duration in milliseconds
		final double NANO_TO_MS = 1.0 / 1_000_000.0;
		final int MAX = 10000;
		int failures;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("How many values? ");
		int numCount = keyboard.nextInt();
		Integer[] data = new Integer[numCount];
		keyboard.close();

		for (int i = 0; i < numCount; i++) {
			data[i] = (int) (Math.random() * MAX);
		}

		Integer[] sortedData = Arrays.copyOf(data, data.length);
		Arrays.sort(sortedData);

		if (numCount <= 100) {
			System.out.print("Unsorted Data\n   ");
			for (int i = 0; i < numCount; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();

			System.out.print("\nSorted Data\n   ");
			for (int i = 0; i < numCount; i++) {
				System.out.print(sortedData[i] + " ");
			}
			System.out.println("\n");
		}

		// Prime cache to minimize caching effect by forcing linear scan of all values
		Searching.<Integer>linearSearch(data, 0, data.length - 1, -1);

		// Access each element in the unsorted array, using linear search
		failures = 0;
		startTime = System.nanoTime();
		for (int i = 0; i < numCount; i++) {
			if (!Searching.<Integer>linearSearch(data, 0, data.length - 1, data[i])) {
				failures++;
			}
		}
		endTime = System.nanoTime();
		duration1 = (endTime - startTime) * NANO_TO_MS;
		if (failures > 0) {
			System.out.println("linearSearch on unsorted data failed " + failures + " times");
		}

		// Prime cache to minimize caching effect by forcing linear scan of all values
		Searching.<Integer>linearSearch(sortedData, 0, sortedData.length - 1, -1);

		// Access each element in the sorted array, using binary search
		failures = 0;
		startTime = System.nanoTime();
		for (int i = 0; i < numCount; i++) {
			if (!Searching.<Integer>binarySearch(sortedData, 0, sortedData.length - 1, sortedData[i])) {
				failures++;
			}
		}
		endTime = System.nanoTime();
		duration2 = (endTime - startTime) * NANO_TO_MS; // Duration in milliseconds
		if (failures > 0) {
			System.out.println("binarySearch on sorted data failed " + failures + " times");
		}

		// Prime cache to minimize caching effect by forcing linear scan of all values
		Searching.<Integer>linearSearch(sortedData, 0, sortedData.length - 1, -1);

		// Access each element in the sorted array, using linear search
		failures = 0;
		startTime = System.nanoTime();
		for (int i = 0; i < numCount; i++) {
			if (!Searching.<Integer>linearSearch(data, 0, data.length - 1, data[i])) {
				failures++;
			}
		}
		endTime = System.nanoTime();
		duration3 = (endTime - startTime) * NANO_TO_MS;
		if (failures > 0) {
			System.out.println("linearSearch on sorted data failed " + failures + " times");
		}

		// Print results
		System.out.printf("Linear Search:               %11.4fms\n", duration1);
		System.out.printf("Binary Search:               %11.4fms\n", duration2);
		System.out.printf("Linear Search (sorted data): %11.4fms\n", duration3);
		System.out.printf("Binary / Linear: %.2f%%", duration2 / duration1 * 100.0);
	}
}
