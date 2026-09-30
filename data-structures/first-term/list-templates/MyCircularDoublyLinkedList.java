/**
 * Educational implementation of a circular doubly linked list.
 *
 * Main idea:
 * - Each node has previous and next references.
 * - The last node points forward to head.
 * - The head points backward to tail.
 *
 * Shape:
 *        ______________________
 *       |                      |
 *       v                      |
 * [10] <-> [20] <-> [30]
 *  |                      ^
 *  |______________________|
 *
 * This structure allows circular traversal in both directions.
 */
public class MyCircularDoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        /**
         * Complexity: O(1)
         * Why?
         * - We create one node and initialize its fields.
         */
        Node(T data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Creates an empty circular doubly linked list.
     *
     * Complexity: O(1)
     * Why?
     * - Only references and size are initialized.
     */
    public MyCircularDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element at the beginning.
     *
     * Complexity: O(1)
     * Why?
     * - We update only a constant number of references.
     * - The circular links are maintained between head and tail.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;

            head.next = head;
            head.previous = head;
        } else {
            newNode.next = head;
            newNode.previous = tail;

            head.previous = newNode;
            tail.next = newNode;

            head = newNode;
        }

        size++;
    }

    /**
     * Adds an element at the end.
     *
     * Complexity: O(1)
     * Why?
     * - We have direct access to tail.
     * - We update only a constant number of references.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;

            head.next = head;
            head.previous = head;
        } else {
            newNode.previous = tail;
            newNode.next = head;

            tail.next = newNode;
            head.previous = newNode;

            tail = newNode;
        }

        size++;
    }

    /**
     * Adds an element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We must find the node currently at the target index.
     * - Starting from head or tail can reduce steps, but worst case is still O(n).
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

        Node<T> current = getNode(index);
        Node<T> previousNode = current.previous;
        Node<T> newNode = new Node<>(element);

        previousNode.next = newNode;
        newNode.previous = previousNode;

        newNode.next = current;
        current.previous = newNode;

        size++;
    }

    /**
     * Returns the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - There is no direct access by index.
     * - We must traverse through nodes.
     */
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    /**
     * Replaces the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We must first find the node at that index.
     */
    public void set(int index, T element) {
        checkIndex(index);
        getNode(index).data = element;
    }

    /**
     * Removes the first element.
     *
     * Complexity: O(1)
     * Why?
     * - We update a constant number of references.
     * - tail.next must point to the new head.
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
            head.previous = tail;
            tail.next = head;
        }

        size--;
        return removed;
    }

    /**
     * Removes the last element.
     *
     * Complexity: O(1)
     * Why?
     * - tail.previous gives direct access to the node before tail.
     * - No traversal is needed.
     */
    public T removeLast() {
        if (tail == null) {
            throw new IllegalStateException("The list is empty.");
        }

        T removed = tail.data;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
        }

        size--;
        return removed;
    }

    /**
     * Removes the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We first need to find the node.
     * - Once found, removing it is O(1) because it has previous and next references.
     */
    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<T> current = getNode(index);

        current.previous.next = current.next;
        current.next.previous = current.previous;

        size--;
        return current.data;
    }

    /**
     * Searches for an element.
     *
     * Complexity: O(n)
     * Why?
     * - We may need to visit all nodes.
     * - We stop after size steps to avoid infinite traversal.
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
     * Prints the list from head to tail.
     *
     * Complexity: O(n)
     * Why?
     * - We visit each node once.
     */
    public void printForward() {
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("(back to head)");
    }

    /**
     * Prints the list from tail to head.
     *
     * Complexity: O(n)
     * Why?
     * - We visit each node once using previous references.
     */
    public void printBackward() {
        Node<T> current = tail;

        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " <-> ");
            current = current.previous;
        }

        System.out.println("(back to tail)");
    }

    /**
     * Returns the number of stored elements.
     *
     * Complexity: O(1)
     * Why?
     * - The value is stored in a variable.
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
     * Finds a node by index.
     *
     * Complexity: O(n)
     * Why?
     * - We traverse from head or tail depending on the index.
     * - Worst case is still linear.
     */
    private Node<T> getNode(int index) {
        if (index < size / 2) {
            Node<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        } else {
            Node<T> current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }

            return current;
        }
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
