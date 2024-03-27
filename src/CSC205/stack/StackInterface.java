package stack;

public interface StackInterface<E> {
    /**
     * Return the number of elements on the stack.
     *
     * @return The number of elements on the stack.
     */
    public int size();

    /**
     * Return true if the stack is empty, false if it has any elements.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Place the provided element on the top of the stack.
     *
     * @param e Element to push on to the stack.
     */
    public void push(E e);

    /**
     * Return a copy of the top element from the stack without removing it.
     *
     * @return The top element from the stack without removing it.
     * @throws EmptyCollectionException if stack is empty.
     */
    public E top() throws EmptyCollectionException;

    /**
     * Remove the top element from the stack and return it.
     *
     * @return The top element from the stack.
     * @throws EmptyCollectionException if stack is empty.
     */
    public E pop() throws EmptyCollectionException;

    /**
     * Return a printable representation of the elements on the stack.
     * toString is not a Stack-specific operation. It is included here
     * as a reminder that it is a best practice to provide toString for
     * any class.
     *
     * @return Printable representation of the stack.
     */
    public String toString();
}
