package Tarea_4_ArrayList;

public class MyArrayList<T> {

    private T[] data;
    private int size;


    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }

    //add(E e)  añade el elemento e al final de la lista
    public void add(T e) {
        if (size == data.length) {
            resize(); // Aumenta la capacidad si data esta llena
        }
        data[size] = e;
        size++;
    }

    //add(int indice, E e)  añade el elemento en la posición indicada por el indice
    public void add(int index, T e) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        if (size == data.length) {
            resize();  // si data esta llena, aumenta la capacidad
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    //remove(int indice) remueve el elemento que se encuentra en la posición indicada por el indice
    public T remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        T removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    // resize (aumenta capacidad)
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}
