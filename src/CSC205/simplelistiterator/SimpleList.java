package simplelistiterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E> implements Iterable<E> {
    private static final int MAX_ELEMENTS = 100;
    private E[] elements;
    private int next;
    private int changes = 0;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        elements = (E[]) new Object[MAX_ELEMENTS];
        next = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= next) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void append(E element) {
        elements[next++] = element;
        changes++;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= next) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    public void delete(int index) {
        if (index < 0 || index >= next) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < next - 1; i++) {
            elements[i] = elements[i + 1];
        }
        next--;
        changes++;
    }

    public int size() {
        return next;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int index = 0; index < next; index++) {
            if (index > 0) {
                result.append(",");
            }
            result.append(" ").append(elements[index]);
        }
        result.append(" ]");
        return result.toString();
    }

    public Iterator<E> iterator() {
        return new SimpleListIterator();
    }

    // Inner class (not declared static)
    private class SimpleListIterator implements Iterator<E> {
        private int itrNext = 0;
        private int itrLast = -1;
        private int itrChanges = changes;

        private void throwIfLastChanged() {
            // Implement fast-fail by watching if the list changes variable has changed
            // value since the iterator was created; if so, throw
            // ConcurrentModificationException
            if (changes != itrChanges) {
                throw new ConcurrentModificationException("list changed during iteration");
            }
        }

        public boolean hasNext() {
            throwIfLastChanged();
            return itrNext < next;
        }

        public E next() {
            // No need to call throwIfLastChanged() here since hasNext is going to do that.
            if (!hasNext()) {
                throw new NoSuchElementException("nothing left");
            }
            itrLast = itrNext;
            return elements[itrNext++];
        }

        public void remove() {
            throwIfLastChanged();
            if (itrLast == -1) {
                throw new IllegalStateException("nothing to remove");
            }
            delete(itrLast);
            // The delete updated the list changes variable. Note the new value so we don't
            // throw a ConcurrentModificationException for our own change.
            itrChanges = changes;
            // The next element just shifted, so we need to back up itrNext to match.
            itrNext--;
            // Note that the element was removed; remove can't be called again until next
            // called again.
            itrLast = -1;
        }
    }
}
