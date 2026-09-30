/**
 * Educational implementation of a singly linked list.
 *
 * Main idea:
 * - A linked list is made of nodes.
 * - Each node stores a value and a reference to the next node.
 *
 * Shape:
 * head -> [data | next] -> [data | next] -> null
 */
public class MyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Complexity: O(1)
         * Why?
         * - Creating one node takes constant time.
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
     * Creates an empty linked list.
     *
     * Complexity: O(1)
     * Why?
     * - We only initialize references and size.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element at the beginning.
     *
     * Complexity: O(1)
     * Why?
     * - We do not traverse the list.
     * - We only update a few references.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
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
     * - Because of tail, we do not need to traverse the list to find the last node.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * Adds an element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - To insert in the middle, we must walk from head to the node before index.
     * - In the worst case, index is near the end.
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
     * - Unlike arrays, linked lists do not allow direct access by index.
     * - We must start at head and move node by node.
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
     * - First we must reach the node at the given index.
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
     * - We only move head to head.next.
     */
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("The list is empty.");
        }

        T removed = head.data;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return removed;
    }

    /**
     * Removes the last element.
     *
     * Complexity: O(n)
     * Why?
     * - Even though we have tail, this is a singly linked list.
     * - To remove the last node, we need to find the node before tail.
     * - That requires walking from head.
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

        previous.next = null;
        tail = previous;
        size--;

        return removed;
    }

    /**
     * Removes the element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We must reach the node before the one we want to remove.
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
     * - We may need to visit all nodes.
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
     * - We only check if size is 0.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the list from head to tail.
     *
     * Complexity: O(n)
     * Why?
     * - We visit each node once.
     */
    public void print() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    /**
     * Returns the node at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We start at head and advance one node at a time.
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
