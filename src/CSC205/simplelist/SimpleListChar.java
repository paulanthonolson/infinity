package simplelist;

public class SimpleListChar {
    private final int MAX_ELEMENTS = 100;
    private char[] elements;
    private int next;

    public SimpleListChar() {
        elements = new char[MAX_ELEMENTS];
        next = 0;
    }

    public char get(int index) {
        if (index < 0 || index >= next) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void append(char element) {
        elements[next++] = element;
    }

    public void set(int index, char element) {
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
