/**
 * Educational implementation of a doubly linked list.
 *
 * Main idea:
 * - Each node has three parts:
 *   previous reference, data, and next reference.
 *
 * Shape:
 * null <- [prev | data | next] <-> [prev | data | next] -> null
 *
 * Advantage over a singly linked list:
 * - We can move forward and backward.
 * - Removing the last element can be O(1) because tail has a previous reference.
 */
public class MyDoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        /**
         * Complexity: O(1)
         * Why?
         * - We create one node and initialize three fields.
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
     * Creates an empty doubly linked list.
     *
     * Complexity: O(1)
     * Why?
     * - Only references and size are initialized.
     */
    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element at the beginning.
     *
     * Complexity: O(1)
     * Why?
     * - We only update head and a few references.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    /**
     * Adds an element at the end.
     *
     * Complexity: O(1)
     * Why?
     * - We keep a tail reference.
     * - We update tail.next, newNode.previous, and tail.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    /**
     * Adds an element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We need to reach the node currently at that index.
     * - We optimize by starting from head or tail depending on the index.
     * - Even with that optimization, the worst case is still O(n).
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
     * - There is no direct index access.
     * - We must traverse nodes.
     * - Starting from head or tail may reduce steps, but worst case remains O(n).
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
     * - We only update head and possibly tail.
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
            head.previous = null;
        }

        size--;
        return removed;
    }

    /**
     * Removes the last element.
     *
     * Complexity: O(1)
     * Why?
     * - In a doubly linked list, tail.previous gives direct access to the node before tail.
     * - We do not need to traverse from head.
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
            tail.next = null;
        }

        size--;
        return removed;
    }

    /**
     * Removes the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We must find the node at that index.
     * - Once the node is found, unlinking it is O(1).
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
     * - We may need to visit every node.
     */
    public int indexOf(T element) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (element == null) {
                if (current.data == null) {
                    return index;
                }
            } else if (element.equals(current.data)) {
                return index;
            }

            current = current.next;
            index++;
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

        System.out.print("null <- ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    /**
     * Prints the list from tail to head.
     *
     * Complexity: O(n)
     * Why?
     * - We visit each node once, but using previous references.
     */
    public void printBackward() {
        Node<T> current = tail;

        System.out.print("null <- ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.previous;
        }

        System.out.println("null");
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
     * - This reduces the average number of steps, but worst case remains linear.
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
