package positionallist;

public interface PositionalList<E> extends Iterable<E> {
    public int size();

    public boolean isEmpty();

    public Position<E> first();

    public Position<E> last();

    public Position<E> before(Position<E> p) throws IllegalArgumentException;

    public Position<E> after(Position<E> p) throws IllegalArgumentException;

    public Position<E> addFirst(E e);

    public Position<E> addLast(E e);

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    public E set(Position<E> p, E e) throws IllegalArgumentException;

    public E remove(Position<E> p) throws IllegalArgumentException;

    // Java 8 changed the rules to allow an interface to provide a default body.
    // Here, we make positions and addOrdered optional operations. If they are not
    // overridden by the class that implements this interface, this default body
    // will throw an UnsupportedOperationException.

    public default Position<E> addOrdered(E e) {
        throw new UnsupportedOperationException("addOrdered not implemented");
    }

    public default Iterable<Position<E>> positions() {
        throw new UnsupportedOperationException("positions not implemented");
    }
}
