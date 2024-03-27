package simplelistiterator;

import java.util.Iterator;

public class SimpleListDriver {
	public static void main(String[] args) {
		SimpleList<Integer> primes = new SimpleList<>();
		primes.append(2);
		primes.append(3);
		primes.append(5);
		primes.append(7);
		primes.append(9);
		primes.append(11);

		System.out.println("Print primes using explicit iterator");
		System.out.println("When we find 9, tell iterator to remove it");
		Iterator<Integer> itr = primes.iterator();
		while (itr.hasNext()) {
			int i = itr.next();
			System.out.println(i);
			if (i == 9) {
				itr.remove();
			}
		}

		System.out.println("Print primes with for-each, 9 should be gone");
		System.out.println("With for-each, there is no way to remove");
		for (int i : primes) {
			System.out.println(i);
		}

		System.out.println("Print primes using for-each, try to append 13 in loop, trigger fast-fail");
		for (int i : primes) {
			System.out.println(i);
			primes.append(13);
		}
	}
}
