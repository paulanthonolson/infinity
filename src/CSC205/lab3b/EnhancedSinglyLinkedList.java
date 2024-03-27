package lab3b;

// This is an enhanced version of SinglyLinkedList that incorporates three new methods: second, middle, and penultimate

public class EnhancedSinglyLinkedList<E> {
    /**
     * head node of the list (or null if empty)
     */
    private Node<E> head = null;
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
    public EnhancedSinglyLinkedList() {
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
        return head.getElement();
    }

    public E second() {
        if (size < 2) {
            return null;
        }
        return head.getNext().getElement();
    }

    public E middle() {
        Node<E> walk;

        if (isEmpty()) {
            return null;
        }

        walk = head;

        for (int i = 0; i < (size - 1) / 2; i++) {
            walk = walk.getNext();
        }

        return walk.getElement();
    }

    public E penultimate() {
        Node<E> walk;

        if (size < 2) {
            return null;
        }

        walk = head;
        // walk != null;
        for (int i = 0; i < size - 2; i++) {
            walk = walk.getNext();
        }
        return walk.getElement();
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

    /**
     * add element to the front of the list
     *
     * @param e element to add to the list
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    /**
     * add element to the end of the list
     *
     * @param e element to add to the list
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
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
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    /**
     * build a string representation of the elements in the list
     *
     * @return return the string representation of the list
     */
    public String toString() {
        String result = "[";
        boolean first = true;

        for (Node<E> walk = head; walk != null; walk = walk.getNext()) {
            if (first) {
                first = false;
            } else {
                result += ",";
            }
            result += " " + walk.getElement();
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
         * reference to the subsequent node in the list
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
