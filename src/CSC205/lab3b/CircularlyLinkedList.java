package lab3b;

/**
 * This class implements a circularly linked list.
 * It is expanded from the sample code in section 3.7
 * to include JavaDoc comments and a toString method.
 */

public class CircularlyLinkedList<E> {
    /**
     * last node of the list (or null if empty)
     */
    private Node<E> tail = null;
    /**
     * number of nodes in the list
     */
    private int size = 0;

    /**
     * constructs an initial empty list
     */
    public CircularlyLinkedList() {
    }

    /**
     * returns the number of nodes in the list
     *
     * @return number of nodes
     */
    public int size() {
        return size;
    }

    /**
     * returns true if the list is empty, false otherwise
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns (but does not remove) the first element
     *
     * @return first element or null if the list is empty
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        // The head is next after the tail
        return tail.getNext().getElement();
    }

    /**
     * returns (but does not remove) the last element
     *
     * @return last element or null if the list is empty
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    /**
     * add element to the front of the list
     *
     * @param e element to add to the list
     */
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * add element to the end of the list
     *
     * @param e element to add to the list
     */
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    /**
     * removes and returns the first element
     *
     * @return first element or null if list is empty
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }

    /**
     * build a string representation of the elements in the list
     *
     * @return return the string representation of the list
     */
    public String toString() {
        String result = "[";
        int count = 0;
        int remain = size;

        if (remain > 0) {
            for (Node<E> walk = tail.getNext(); remain > 0; walk = walk.getNext(), remain--) {
                if (count++ > 0) {
                    result += ",";
                }
                result += " " + walk.getElement();
            }
        }
        result += " ]";
        return result;
    }

    /**
     * Nested class for building Nodes to use for internal links.
     */
    private static class Node<E> {
        /**
         * reference to the element stored at this node
         */
        private E element;
        /**
         * reference to the next node in the list
         */
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        /**
         * returns the element
         *
         * @return
         */
        public E getElement() {
            return element;
        }

        /**
         * returns the reference to the next node
         *
         * @return
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * sets the next reference to the specified node
         *
         * @param n node to reference
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }
}
