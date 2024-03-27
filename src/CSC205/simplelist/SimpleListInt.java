package simplelist;

public class SimpleListInt {
	private final int MAX_ELEMENTS = 100;
	private int[] elements;
	private int next;

	public SimpleListInt() {
		elements = new int[MAX_ELEMENTS];
		next = 0;
	}

	public int get(int index) {
		if (index < 0 || index >= next) {
			throw new IndexOutOfBoundsException();
		}
		return elements[index];
	}

	public void append(int element) {
		elements[next++] = element;
	}

	public void set(int index, int element) {
		if (index < 0 || index >= next) {
			throw new IndexOutOfBoundsException();
		}
		elements[index] = element;
	}

	public int size() {
		return next;
	}

	public String toString() {
		String result = "[";
		for (int index = 0; index < next; index++) {
			if (index > 0) {
				result += ",";
			}
			result += " " + elements[index];
		}
		result += " ]";
		return result;
	}
}
