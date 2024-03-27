package stack;

public class ArrayStack<E> implements StackInterface<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return t + 1;
    }

    public boolean isEmpty() {
        return t == -1;
    }

    public void push(E e) {
        // If the array is full, we have to expand it to avoid getting an
        // IndexOutOfBoundsException.
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        /*
         * Alternatively we could make the array bigger
         * if (size() == data.length) {
         * data = Arrays.copyOf(data, data.length * 2);
         * }
         */

        data[++t] = e;
    }

    public E top() {
        if (isEmpty()) {
            throw new EmptyCollectionException("ArrayStack");
        }
        return data[t];
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyCollectionException("ArrayStack");
        }
        E answer = data[t];
        // Setting this value to null helps avoid a memory leak
        data[t] = null;
        t--;
        return answer;
    }

    public String toString() {
        String result = "top [";
        boolean first = true;

        for (int idx = t; idx >= 0; idx--) {
            if (first) {
                first = false;
            } else {
                result += ",";
            }
            result += " " + data[idx];
        }

        result += " ]";
        return result;
    }
}
