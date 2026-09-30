// Nodo.java
// Nodo para lista doblemente enlazada----
public class Nodo<E> {
    E data;           // dato almacenado
    Nodo<E> next;     // referencia al siguiente
    Nodo<E> previous; // referencia al anterior (opcional para lista doblemente enlazada)
    public Nodo(E data) {   // constructor con dato
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Nodo(E data, Nodo<E> next) {  // constructor con dato y siguiente
        this.data = data;
        this.next = next;
        this.previous = null;
    }
    public Nodo(E data, Nodo<E> next, Nodo<E> previous) {  // constructor con dato, siguiente y anterior para tener doble enlazado
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    // Getters/Setters simples para data y next y previous
    public E getData() { return data; }
    public void setData(E data) { this.data = data; }
    public Nodo<E> getNext() { return next; }
    public void setNext(Nodo<E> next) { this.next = next; }
    public Nodo<E> getPrevious() { return previous; }   //  getter para previous
    public void setPrevious(Nodo<E> previous) { this.previous = previous; } // setter para previous

}
