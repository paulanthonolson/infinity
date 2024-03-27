package queue;

public interface CircularQueueInterface<E> extends QueueInterface<E> {
    /**
     * Rotates the front element of the queue to the back of the queue.
     * This does nothing if the queue is empty.
     */
    void rotate();
}
