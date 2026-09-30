public class MyLinkedList<T> {

    private static class Node<T> {
        T data;         // contenido del nodo
        Node<T> next;   

        // Contructor
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Atributos de la lista enlazada
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor de la lista
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Retorna el contenido (.data) del nodo en esa posición.
    public T get(int index) {
        if (index < 0 || index >= size || head == null) {
            return null;
        }

        Node<T> current = head;
        
        // Bucle para avanzar posición por posición
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Retorna el contenido (.data)
        return current.data;
    }

   
    //Retorna el contenido del último nodo de la lista. 
    public T getLast() {
        if (head == null) {
            return null;
        }

        // Retorna el contenido del último nodo 
        return tail.data;
    }

    public void addLast(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLast'");
    }

    public void print() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }
}