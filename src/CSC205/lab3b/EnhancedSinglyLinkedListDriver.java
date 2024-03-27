package lab3b;

public class EnhancedSinglyLinkedListDriver {
    public static void main(String[] args) {
        EnhancedSinglyLinkedList<Character> list = new EnhancedSinglyLinkedList<>();

        show(list);
        list.addLast('A');
        show(list);
        list.addLast('B');
        show(list);
        list.addLast('C');
        show(list);
        list.addLast('D');
        show(list);
        list.addLast('E');
        show(list);
    }

    public static void show(EnhancedSinglyLinkedList<Character> list) {
        System.out.println("list: " + list);
        System.out.println("first: " + list.first());
        System.out.println("second: " + list.second());
        System.out.println("middle: " + list.middle());
        System.out.println("penultimate: " + list.penultimate());
        System.out.println("last: " + list.last());
        System.out.println();
    }
}
