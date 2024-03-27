package CSC240.Code.Module4;

import java.util.Scanner;

public class Fibonacci {
	static long[] f = new long[100];
	static long count = 0;

	static {
		System.out.println("Initializing the static array");
		for (int i = 0; i < f.length; i++)
			f[i] = -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a small integer: ");
		while (in.hasNextInt()) {
			int x = in.nextInt();

			count = 0;
			long result = fib(x);

			System.out.printf("fibonacci(%d) = %d (count = %d)\n", x, result, count);
			System.out.print("\nEnter a small integer: ");
		}

		in.close();
	}

	// static {
	// System.out.println("Hello World from static code!");
	// }

	private static long fib(int x) {
		count++;

		return x <= 1 ? x : fib(x - 2) + fib(x - 1);
	}

	private static long s_fib(int x) {
		count++;

		if (f[x] >= 0)
			return f[x];

		f[x] = (x <= 1 ? x : s_fib(x - 2) + s_fib(x - 1));

		return f[x];
	}
}
