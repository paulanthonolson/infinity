package queue;

import linkedlist.*;

public class LinkedCircularQueue<E> implements CircularQueueInterface<E> {
    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E first() {
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedQueue");
        }
        return list.first();
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedQueue");
        }
        return list.removeFirst();
    }

    public void rotate() {
        list.rotate();
    }

    public String toString() {
        String result = "front " + list + " rear";
        return result;
    }

}
