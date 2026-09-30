import java.util.Comparator;
import java.util.Iterator;

public class Listaimplemente<T> implements Iterable<T> {
    
    private Nodo<T> cabeza = null;

    // Nodo simple
    private static class Nodo<T> {
        T datos;
        Nodo<T> siguiente;
        Nodo(T datos) { this.datos = datos; }
    }

    // Método para agregar elementos
    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    // Método find usando un Comparator e Iterador
    public T find(Comparator<T> comparador, T objetivo) {
        Iterator<T> it = this.iterator(); // Creamos el iterador
        
        while (it.hasNext()) {
            T elementoActual = it.next();
            // Si el comparador devuelve 0, encontramos coincidencia
            if (comparador.compare(elementoActual, objetivo) == 0) {
                return elementoActual; 
            }
        }
        return null; // Si no lo encuentra
    }

    // Método findAll usando un Comparator e Iterador
    public Listaimplemente<T> findAll(Comparator<T> comparador, T objetivo) {
        Listaimplemente<T> resultado = new Listaimplemente<>();
        Iterator<T> it = this.iterator();
        
        while (it.hasNext()) {
            T elementoActual = it.next();
            if (comparador.compare(elementoActual, objetivo) == 0) {
                resultado.agregar(elementoActual);
            }
        }
        return resultado;
    }

    // Método iterator()
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T datos = actual.datos;
                actual = actual.siguiente;
                return datos;
            }
        };
    }
}