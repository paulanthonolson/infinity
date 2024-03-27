package queue;

public class ArrayQueue<E> implements QueueInterface<E> {
    private final static int CAPACITY = 1000;
    /**
     * data holds the values stored in the queue
     */
    private E[] data;
    /**
     * index of the front element
     */
    private int f;
    /**
     * current number of elements
     */
    private int sz = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public void enqueue(E e) {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    public E first() {
        if (isEmpty()) {
            throw new EmptyCollectionException("ArrayQueue");
        }
        return data[f];
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyCollectionException("ArrayQueue");
        }
        E answer = data[f];
        // Setting this value to null helps avoid a memory leak
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

    @Override
    public String toString() {
        String result = "front [";
        boolean first = true;
        int idx = f;

        for (int remain = sz; remain > 0; idx = (idx + 1) % data.length, remain--) {
            if (first) {
                first = false;
            } else {
                result += ",";
            }
            result += " " + data[idx];
        }

        result += " ] rear";
        return result;
    }
}
