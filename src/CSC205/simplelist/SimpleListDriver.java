package simplelist;

public class SimpleListDriver {
	public static void main(String[] args) {

		System.out.println("int test");
		// SimpleListInt primes = new SimpleListInt();
		SimpleList<Integer> primes = new SimpleList<Integer>();
		System.out.println(primes);
		primes.append(1);
		primes.append(3);
		primes.append(5);
		primes.append(7);
		System.out.println(primes.size());
		System.out.println(primes);
		primes.set(0, primes.get(0) + 1);
		primes.append(11);
		System.out.println(primes);

		// System.out.println("char test");
		// // SimpleListChar letters = new SimpleListChar();
		// SimpleList<Character> letters = new SimpleList<Character>(); // using
		// reference type for generic
		// letters.append('h');
		// letters.append('e');
		// letters.append('l');
		// letters.append('l');
		// letters.append('o');
		// System.out.println(letters.size());
		// System.out.println(letters);
		// letters.set(0, 'j');
		// System.out.println(letters);

		// System.out.println("double test");
		// SimpleListDouble constants = new SimpleListDouble();
		// constants.append(Math.E);
		// constants.append(Math.PI);
		// constants.append(299792.458); // speed of light in km/s
		// constants.append(6.02214076E23); // Avogadro constant
		// System.out.println(constants.size());
		// System.out.println(constants);
		// constants.set(1, Math.sqrt(2));
		// System.out.println(constants);

		// System.out.println("String test");
		// SimpleListString words = new SimpleListString();
		// words.append("Your");
		// words.append("Success");
		// words.append("Is");
		// words.append("Our");
		// System.out.println(words.size());
		// System.out.println(words);
		// words.append(words.get(1));
		// System.out.println(words);
	}
}
