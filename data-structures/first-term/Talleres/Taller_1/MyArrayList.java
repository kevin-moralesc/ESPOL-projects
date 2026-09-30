public class MyArrayList<E> {
    // Arreglo interno y cantidad de elementos válidos
    private E[] data;
    private int size;

    // Capacidad inicial por defecto
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        // Creamos un arreglo de Object y casteamos a E[]
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {  
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, E value) {
        checkIndex(index);
        data[index] = value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index=" + index);
    }

    // Asegura capacidad: si está lleno, crece en 50% (capNueva = capVieja + capVieja/2)
    @SuppressWarnings("unchecked")
    private void ensureCapacityForAdd() {
    int capacidad = data.length;    
    int capNueva = capacidad + (capacidad / 2); // Crece un 50%
    
    // Creamos el nuevo arreglo más grande
    E[] newData = (E[]) new Object[capNueva];
    for (int i = 0; i < size; i++) {
        newData[i] = data[i];
    }
    // Reemplazamos el arreglo viejo por el nuevo
    data = newData;
    }

    /**
     * TODO (Ejercicio 1):
     * Implementa el método add(E elemento):
     *  - Verificar si hay capacidad; si no, llamar a ensureCapacityForAdd()
     *  - Insertar el elemento al final
     *  - Incrementar size
     */
    public void add(E elemento) {
        if (size == data.length) { // Si el arreglo está lleno, necesitamos crecerlo
            ensureCapacityForAdd(); // llamos a ensureCapacityForAdd()
        }
            data[size] = elemento; // Insertamos el elemento al final
            size++; // Incrementamos el tamaño
 }
}


