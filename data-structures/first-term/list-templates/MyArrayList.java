/**
 * Educational implementation of an ArrayList-like structure.
 *
 * Main idea:
 * - Data is stored in a regular array.
 * - The array has a fixed capacity.
 * - When the array becomes full, we create a bigger array and copy the old elements.
 *
 * Important terms:
 * - size: number of real elements stored.
 * - capacity: length of the internal array.
 *
 * This class is intentionally simple for teaching purposes.
 */
public class MyArrayList<T> {

    private T[] data;
    private int size;

    /**
     * Creates an ArrayList with an initial capacity of 10.
     *
     * Complexity: O(1)
     * Why?
     * - We only create an array of fixed initial size.
     * - The work does not depend on the number of stored elements.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }

    /**
     * Adds an element at the end of the list.
     *
     * Complexity: O(1) amortized
     * Why?
     * - Usually, inserting at the end only writes in data[size].
     * - That operation is O(1).
     * - Sometimes the array is full and we must resize it.
     * - Resizing requires copying all elements, which is O(n).
     * - However, because resizing does not happen every time, the average cost
     *   over many insertions is considered O(1) amortized.
     */
    public void add(T element) {
        if (size == data.length) {
            resize();
        }

        data[size] = element;
        size++;
    }

    /**
     * Inserts an element at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - We may need to move many elements one position to the right.
     * - In the worst case, inserting at index 0 moves all existing elements.
     */
    public void add(int index, T element) {
        checkIndexForAdd(index);

        if (size == data.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    /**
     * Returns the element stored at a specific index.
     *
     * Complexity: O(1)
     * Why?
     * - Arrays allow direct access by index.
     * - The program can jump directly to data[index].
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * Replaces the element stored at a specific index.
     *
     * Complexity: O(1)
     * Why?
     * - Arrays allow direct access by index.
     * - We directly write into data[index].
     */
    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    /**
     * Removes the element stored at a specific index.
     *
     * Complexity: O(n)
     * Why?
     * - After removing an element, all elements to the right must move one
     *   position to the left.
     * - In the worst case, removing index 0 moves almost all elements.
     */
    public T remove(int index) {
        checkIndex(index);

        T removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    /**
     * Searches for an element and returns its index.
     *
     * Complexity: O(n)
     * Why?
     * - We may need to compare the searched element with every stored element.
     */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (data[i] == null) {
                    return i;
                }
            } else if (element.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the number of stored elements.
     *
     * Complexity: O(1)
     * Why?
     * - The size is stored in a variable.
     * - We do not need to count elements one by one.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list has no elements.
     *
     * Complexity: O(1)
     * Why?
     * - We only compare size with 0.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the list contents.
     *
     * Complexity: O(n)
     * Why?
     * - We visit each stored element once.
     */
    public void print() {
        System.out.print("[ ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("]");
    }

    /**
     * Doubles the internal array capacity.
     *
     * Complexity: O(n)
     * Why?
     * - We must copy all existing elements into the new array.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    /**
     * Validates an index used for get, set, or remove.
     *
     * Valid indexes are from 0 to size - 1.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    /**
     * Validates an index used for insertion.
     *
     * Valid indexes are from 0 to size.
     * Inserting at index == size means inserting at the end.
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index for add: " + index);
        }
    }
}
