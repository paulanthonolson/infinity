package simplelist;

public class SimpleList<T> {
    private final int MAX_ELEMENTS = 100;
    private T[] elements;
    private int next;

    public SimpleList() {
        elements = (T[]) new Object[MAX_ELEMENTS]; // special syntax to make an array with T
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

}
