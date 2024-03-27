package stack;

import linkedlist.*;

public class LinkedStack<E> implements StackInterface<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.addFirst(element);
    }

    public E top() {
        if (list.isEmpty()) {
            throw new EmptyCollectionException("LinkedStack");
        }
        return list.first();
    }

    public E pop() {
        if (list.isEmpty()) {
            throw new EmptyCollectionException("LinkedStack");
        }
        return list.removeFirst();
    }

    public String toString() {
        String result = "top " + list;
        return result;
    }
}
