package simplelist;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleListTest {

    private SimpleList<Integer> testList;

    @BeforeEach
    public void init() {
        testList = new SimpleList<Integer>();
    }

    // assertEquals that the 0 is the expected value of testList.size().
    // For this test, a good name might be
    // givenTestList_whenNothingChanged_thenListSize0.

    @Test
    public void givenTestList_whenNothingChanged_thenListSize0() {
        assertEquals(0, testList.size(), "Expected size is 0.");
    }

    // Append any number to testList and then
    // assertEquals that 1 is the expected size of the list.

    @Test
    public void givenTestList_whenNumberAppended_thenListSize1() {
        testList.append(13);
        assertEquals(1, testList.size(), "Expected size is 1.");
    }

    // Append the number 42 to testList and
    // assertEquals that 42 is it the expected value of testList.get(0).

    @Test
    public void givenTestList_when42Appended_thenListValue42() {
        testList.append(42);
        assertEquals(42, testList.get(0), "Expected value is 42.");

    }

    // Append the numbers 4, 8, 14, and 16 to testList, use the set method to change
    // the value
    // at position 2 to 15, and then assertEquals 15 is the expected value at
    // testList.get(2).

    @Test
    public void givenTestList_whenIndexAppended_thenTestListValue15() {
        testList.append(4);
        testList.append(8);
        testList.append(14);
        testList.append(16);
        testList.set(2, 15);
        assertEquals(15, testList.get(2), "Expected value at index 2 is 15.");
    }

    // Try to set the value at position 0 to 10. This will throw an
    // IndexOutOfBoundsException.
    // Use assertThrows around this logic so the test passes.

    @Test
    public void givenTestList_whenOutOfBounds_thenThrowException() {

        assertThrows(IndexOutOfBoundsException.class, () -> {
            testList.set(0, 10);
        });
    }

    // Write a for loop that counts from 0 to 49 and appends those values.
    // assertEquals that 50 is the expected size of the list and that 25 is
    // the expected value of the item at position 25.

    @Test
    public void givenTestList_whenLoopRuns_thenValue25Index25() {

        for (int i = 0; i <= 49; i++) {
            testList.append(i + 1);

        }

        assertEquals(50, testList.size(), "Expected size is 50.");
        assertEquals(25, testList.get(24), "Expected value is 25 at position 25.");

    }

    // Create a test method and as the first line in the method add:
    // SimpleList<Double> doubleList = new SimpleList<Double>();

    @Test
    public void givenNothing_whenDoubleAppended_thenValue2point5AtIndex0() {

        SimpleList<Double> doubleList = new SimpleList<Double>();

        doubleList.append(2.5);

        assertEquals(2.5, doubleList.get(0), "Expected value at index 0 is 2.5.");
    }
}
