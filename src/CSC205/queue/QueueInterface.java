package queue;

public interface QueueInterface<E> {
    /**
     * Place the provided element at the rear of the queue.
     *
     * @param e Element to insert into the queue.
     */
    public void enqueue(E e);

    /**
     * Remove the front element from the queue and return it.
     *
     * @return The front element from the queue.
     * @throws EmptyCollectionException if queue is empty.
     */
    public E dequeue() throws EmptyCollectionException;

    /**
     * Return a copy of the first element from the queue without removing it.
     *
     * @return The front element from the queue.
     * @throws EmptyCollectionException if queue is empty.
     */
    public E first() throws EmptyCollectionException;

    /**
     * Return true if the queue is empty, false if it has any elements.
     *
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Return the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size();

    /**
     * Return a printable representation of the elements in the queue.
     * toString is not a Queue-specific operation. It is included here
     * as a reminder that it is a best practice to provide toString for
     * any class.
     *
     * @return Printable representation of the queue.
     */
    public String toString();
}
