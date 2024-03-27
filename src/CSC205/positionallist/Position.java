package positionallist;

public interface Position<E> {
    public E getElement() throws IllegalStateException;
}
