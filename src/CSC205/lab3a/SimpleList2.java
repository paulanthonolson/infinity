package lab3a;

public class SimpleList2<T> {
    private final int MAX_ELEMENTS = 100;
    private T[] elements;
    private int next;

    @SuppressWarnings("unchecked")
    public SimpleList2() {
        elements = (T[]) new Object[MAX_ELEMENTS];
        next = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= next) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void append(T element) {
        elements[next++] = element;
    }

    public void set(int index, T element) {
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

    /**
     * Add the provided element to the beginning of the list.
     */
    public void addFirst(T element) {
        for (int i = next; i > 0; i--) {
            elements[i] = elements[i - 1];
        }

        elements[0] = element;
        next++;
    }

    /**
     * Remove and return the first element of the list.
     */
    public T removeFirst() {
        for (int i = 0; i < next - 1; i++) {
            elements[i] = elements[i + 1];

        }

        elements[next - 1] = null;
        // End: shift code
        next--;
        // You will remove this return null; statement during development.
        return null;
    }
}
