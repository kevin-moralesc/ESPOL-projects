// Clase que implementa un MaxHeap (el mayor valor está en la raíz)
public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }


    public boolean isEmpty() {
        return this.size == 0;
    }


    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap lleno");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] > heap[parent(current)]) {
            System.out.println("  -> Intercambio (MaxHeap): subiendo el " + heap[current] + " (reemplaza al " + heap[parent(current)] + ")");            
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap vacío");

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getMax() {
        if (size == 0) throw new IllegalStateException("Heap vacío");
        return heap[0];
    }

    public void printHeap() {
        System.out.print("Heap actual: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
