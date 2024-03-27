package linkedlist;

/**
 * Compare this with lab3a ArrayShifts version 3
 */

public class LinkedListShifts {
    public static void main(String[] args) {
        char[] letters = { 'O', 'G', 'N', 'I', 'B' };

        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        // CircularlyLinkedList<Character> list = new CircularlyLinkedList<>();
        // DoublyLinkedList<Character> list = new DoublyLinkedList<>();

        for (char letter : letters) {
            list.addFirst(letter);
            System.out.println(list);
        }

        while (!list.isEmpty()) {
            char letter = list.removeFirst();
            System.out.println("Removed: " + letter + "  List: " + list);
        }
    }
}
