/**
 * Educational implementation of a circular singly linked list.
 *
 * Main idea:
 * - Each node points to the next node.
 * - The last node does not point to null.
 * - The last node points back to head.
 *
 * Shape:
 * head -> [10] -> [20] -> [30]
 *          ^               |
 *          |_______________|
 *
 * Important warning:
 * - In a circular list, traversals cannot use "while (current != null)".
 * - There is no null at the end.
 */
public class MyCircularLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Complexity: O(1)
         * Why?
         * - We create one node and initialize two fields.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Creates an empty circular singly linked list.
     *
     * Complexity: O(1)
     * Why?
     * - Only references and size are initialized.
     */
    public MyCircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element at the beginning.
     *
     * Complexity: O(1)
     * Why?
     * - We only update a few references.
     * - tail.next must always point to head.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        size++;
    }

    /**
     * Adds an element at the end.
     *
     * Complexity: O(1)
     * Why?
     * - We keep a tail reference.
     * - We attach the new node after tail and then make it point to head.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        size++;
    }

    /**
     * Adds an element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - To insert in the middle, we must reach the node before index.
     */
    public void add(int index, T element) {
        checkIndexForAdd(index);

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size) {
            addLast(element);
            return;
        }

        Node<T> previous = getNode(index - 1);
        Node<T> newNode = new Node<>(element);

        newNode.next = previous.next;
        previous.next = newNode;

        size++;
    }

    /**
     * Returns the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - There is no direct access by index.
     * - We must move from head node by node.
     */
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    /**
     * Removes the first element.
     *
     * Complexity: O(1)
     * Why?
     * - We update head.
     * - We also update tail.next so the circular connection remains valid.
     */
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("The list is empty.");
        }

        T removed = head.data;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }

        size--;
        return removed;
    }

    /**
     * Removes the last element.
     *
     * Complexity: O(n)
     * Why?
     * - This is a singly linked list.
     * - We need to find the node before tail, starting from head.
     */
    public T removeLast() {
        if (head == null) {
            throw new IllegalStateException("The list is empty.");
        }

        if (size == 1) {
            return removeFirst();
        }

        Node<T> previous = getNode(size - 2);
        T removed = tail.data;

        tail = previous;
        tail.next = head;

        size--;
        return removed;
    }

    /**
     * Removes the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We must reach the node before the node to remove.
     */
    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<T> previous = getNode(index - 1);
        Node<T> removedNode = previous.next;

        previous.next = removedNode.next;

        size--;
        return removedNode.data;
    }

    /**
     * Searches for an element.
     *
     * Complexity: O(n)
     * Why?
     * - We may need to visit all nodes once.
     * - We stop after size steps to avoid an infinite loop.
     */
    public int indexOf(T element) {
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (current.data == null) {
                    return i;
                }
            } else if (element.equals(current.data)) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    /**
     * Prints the circular list.
     *
     * Complexity: O(n)
     * Why?
     * - We visit each node once.
     * - We use a for loop with size to avoid infinite traversal.
     */
    public void print() {
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("(back to head)");
    }

    /**
     * Returns the number of stored elements.
     *
     * Complexity: O(1)
     * Why?
     * - The value is stored in the size variable.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list is empty.
     *
     * Complexity: O(1)
     * Why?
     * - We only check size.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Finds the node at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We move from head to the desired position.
     */
    private Node<T> getNode(int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index for add: " + index);
        }
    }
}
