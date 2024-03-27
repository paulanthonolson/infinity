package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    private static final int TEST_QTY = 10;
    private StackInterface<Integer> stack;

    // To test a different StackInterface implementation, change the value
    // assigned in setup.
    @BeforeEach
    public void setup() {
        stack = new ArrayStack<>();
    }

    @Test
    public void givenStack_whenPushElements_thenPopElementsAreReversed() {
        for (int i = 1; i <= TEST_QTY; i++) {
            stack.push(i);
        }
        for (int i = TEST_QTY; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }
    }

    @Test
    public void givenStack_whenNothing_thenPopThrowException() {
        Assertions.assertThrows(EmptyCollectionException.class, () -> stack.pop());
    }

    @Test
    public void top_empty() {
        Assertions.assertThrows(EmptyCollectionException.class, () -> {
            stack.top();
        });
    }

    @Test
    public void givenStack_thenPushAndPopElements_thenTopMatchesLastPushedElement() {
        for (int i = 0; i < TEST_QTY; i++) {
            stack.push(i);
            assertEquals(i, (int) stack.top());
        }

        for (int i = TEST_QTY - 1; i > 0; i--) {
            assertEquals(i, (int) stack.top());
            stack.pop();
        }

    }

    @Test
    public void givenStack_whenNothing_thenTopThrowException() {
        Assertions.assertThrows(EmptyCollectionException.class, () -> stack.top());
    }

    @Test
    public void givenStack_whenPushandPopElements_thenSizeMatchesNumberOfElementsOnStack() {
        assertEquals(0, stack.size());

        for (int i = 1; i <= TEST_QTY; i++) {
            stack.push(i);
            assertEquals(i, stack.size());
        }

        for (int i = TEST_QTY; i >= 1; i--) {
            stack.pop();
            assertEquals(i - 1, stack.size());
        }

        assertEquals(0, stack.size());
    }

    @Test
    public void givenStack_whenPushAndPopElements_thenIsEmptyTrueWhenStackEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(0);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void givenStack_whenPushElements_thenToStringMatchesReversedValues() {
        assertEquals("top [ ]", "" + stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("top [ 3, 2, 1 ]", "" + stack);
    }
}
