package positionallist;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Serializable {
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    private int changes = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid p");
        }
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("p is no longer in the list");
        }
        return node;
    }

    private Position<E> position(Node<E> node) {
        // Do not expose the sentinels
        if (node == header || node == trailer) {
            return null;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        changes++;
        // Don't need to use return position(newest) since we know newest cannot be the
        // header or trailer
        return newest;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        changes++;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }

    public Position<E> addOrdered(E e) throws IllegalArgumentException {
        // addOrdered is only possible if the element to insert implements
        // the Comparable interface.
        if (!(e instanceof Comparable)) {
            throw new IllegalArgumentException("e is not Comparable");
        }
        @SuppressWarnings("unchecked")
        Comparable<E> c = (Comparable<E>) e;
        // We walk through the list until we hit one of two possibilities:
        // 1. We hit the trailer sentinel, meaning there is no other element
        // greater than this one in the list, making insertion before
        // the sentinel correct (even in an empty list).
        // 2. We hit an element whose value is "greater than" this one,
        // making insertion before that element correct.
        Node<E> walk = header.getNext();
        while (walk != trailer && c.compareTo(walk.getElement()) > 0) {
            walk = walk.getNext();
        }
        return addBetween(e, walk.getPrev(), walk);
    }

    public String toString() {
        // In previous examples, result has been a String. When building a string
        // out of various parts, it is more efficient to use a StringBuilder.
        StringBuilder result = new StringBuilder("[");
        boolean first = true;

        // since LinkedPositionalList implements Iterable, we can use a for-each
        // loop against the current object (this) to walk through all of the elements
        for (E e : this) {
            if (first) {
                first = false;
            } else {
                result.append(",");
            }
            result.append(" ").append(e);
        }
        result.append(" ]");
        return result.toString();
    }

    /**
     * Returns an iterator over the elements stored in the list.
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Returns an iterable that provides an iterator of the positions of elements in
     * the list.
     */
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    // ---------------- nested Node class ----------------
    // This class is marked as Serializable as the linked list is composed of nodes
    // that need to be stored.
    private static class Node<E> implements Position<E>, Serializable {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position is no longer valid");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // ---------------- inner PositionIterator class ----------------
    // This class is not marked Serializable as it is only used for transient data.
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); // position of the next element to report
        private Position<E> recent = null; // position of last reported element
        private int startingChanges = changes; // note how many changes have happened to the list at this point

        private void throwIfListChanged() {
            // If the number of changes in the list has changed since iterator was created,
            // fast fail
            if (startingChanges != changes) {
                throw new ConcurrentModificationException("fast fail due to list change");
            }
        }

        /**
         * Tests whether the iterator has a next object.
         */
        public boolean hasNext() {
            throwIfListChanged();
            return (cursor != null);
        }

        /**
         * Returns the next position in the iterator.
         */
        public Position<E> next() throws NoSuchElementException {
            // Checking for list changes is handled by hasNext
            if (!hasNext()) {
                throw new NoSuchElementException("nothing left");
            }
            recent = cursor; // remember this element in case we are asked to remove it
            cursor = after(cursor);
            return recent;
        }

        /**
         * Removes the element returned by most recent call to next.
         */
        public void remove() throws IllegalStateException {
            throwIfListChanged();
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            // We need our parent class to remove this object, but this inner class
            // also has a method named remove. Since the method names match, we have
            // to qualify that remove call using this strange construction.
            LinkedPositionalList.this.remove(recent);
            // We just changed the list intentionally. Update startingChanges
            // to match or we will end up fast failing for our own change.
            startingChanges = changes;
            recent = null; // do not allow remove again until next is called
        }
    }

    // ---------------- inner PositionIterable class ----------------
    // This class is not marked Serializable as it is only used for transient data.
    private class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    // ---------------- inner ElementIterator class ----------------
    // This class adapts the iteration produced by positions() to return elements.
    // This class is not marked Serializable as it is only used for transient data.
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> psnItr = new PositionIterator();

        public boolean hasNext() {
            return psnItr.hasNext();
        }

        public E next() throws NoSuchElementException {
            return psnItr.next().getElement();
        }

        public void remove() throws IllegalStateException {
            psnItr.remove();
        }
    }
}
