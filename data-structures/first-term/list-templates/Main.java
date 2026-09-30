/**
 * Small test file for the educational list templates.
 *
 * Compile:
 * javac *.java
 *
 * Run:
 * java Main
 */
public class Main {

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testDoublyLinkedList();
        testCircularLinkedList();
        testCircularDoublyLinkedList();
    }

    private static void testArrayList() {
        System.out.println("=== MyArrayList ===");

        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 15);

        list.print();

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Removed: " + list.remove(1));

        list.print();
        System.out.println();
    }

    private static void testLinkedList() {
        System.out.println("=== MyLinkedList ===");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.add(2, 15);

        list.print();

        System.out.println("Element at index 3: " + list.get(3));
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());

        list.print();
        System.out.println();
    }

    private static void testDoublyLinkedList() {
        System.out.println("=== MyDoublyLinkedList ===");

        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.add(2, 15);

        list.printForward();
        list.printBackward();

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());

        list.printForward();
        System.out.println();
    }

    private static void testCircularLinkedList() {
        System.out.println("=== MyCircularLinkedList ===");

        MyCircularLinkedList<Integer> list = new MyCircularLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.add(2, 15);

        list.print();

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());

        list.print();
        System.out.println();
    }

    private static void testCircularDoublyLinkedList() {
        System.out.println("=== MyCircularDoublyLinkedList ===");

        MyCircularDoublyLinkedList<Integer> list = new MyCircularDoublyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.add(2, 15);

        list.printForward();
        list.printBackward();

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());

        list.printForward();
        list.printBackward();
        System.out.println();
    }
}
