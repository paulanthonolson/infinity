package linkedlist;

/**
 * This class implements a doubly linked list.
 * It is expanded from the sample code in section 3.8
 * to include JavaDoc comments and a toString method.
 */

public class DoublyLinkedList<E> {
    /**
     * head node of the list (or null if empty)
     */
    private Node<E> header = null;
    /**
     * last node of the list (or null if empty)
     */
    private Node<E> trailer = null;
    /**
     * number of nodes in the list
     */
    private int size = 0;

    /**
     * constructs an initial empty list
     */
    public DoublyLinkedList() {
        // create header
        header = new Node<>(null, null, null);
        // trailer is preceded by header
        trailer = new Node<>(null, header, null);
        // header is followed by trailer
        header.setNext(trailer);
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
        return header.getNext().getElement();
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
        return trailer.getPrev().getElement();
    }

    /**
     * add element to the front of the list
     *
     * @param e element to add to the list
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * add element to the end of the list
     *
     * @param e element to add to the list
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
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
        return remove(header.getNext());
    }

    /**
     * removes and returns the last element
     *
     * @return last element or null if list is empty
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * build a string representation of the elements in the list
     *
     * @return return the string representation of the list
     */
    public String toString() {
        String result = "[";
        int count = 0;

        for (Node<E> walk = header.getNext(); walk != trailer; walk = walk.getNext()) {
            if (count++ > 0) {
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
         * reference to the previous node in the list
         */
        private Node<E> prev;
        /**
         * reference to the next node in the list
         */
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
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
         * returns the reference to the previous node
         */
        public Node<E> getPrev() {
            return prev;
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
         * sets the prev reference to the previous node
         *
         * @param n node to reference
         */
        public void setPrev(Node<E> n) {
            prev = n;
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
