public class ListaCircularDoblementeEnlazada<T> {

    // Clase interna que define el comportamiento de cada Nodo
    private static class Nodo<T> {
        T dato;
        Nodo<T> anterior;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    // Constructor de la lista
    public ListaCircularDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    // Insertar al inicio manteniendo la circularidad doble
    public void insertarInicio(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cola;
            cabeza.anterior = nuevoNodo;
            cola.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamano++;
    }

    //Insertar al final manteniendo la circularidad doble
    public void insertarFinal(T elemento) {
        if (estaVacia()) {
            insertarInicio(elemento);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(elemento);
            nuevoNodo.anterior = cola;
            nuevoNodo.siguiente = cabeza;
            cola.siguiente = nuevoNodo;
            cabeza.anterior = nuevoNodo;
            cola = nuevoNodo;
            tamano++;
        }
    }

    // Insertar en una posición intermedia mediante un índice
    public void insertarEn(int indice, T elemento) {
        // Control de índice manual sin excepciones
        if (indice < 0 || indice > tamano) {
            System.out.println("Índice de inserción inválido.");
            return;
        }

        if (indice == 0) {
            insertarInicio(elemento);
            return;
        }
        if (indice == tamano) {
            insertarFinal(elemento);
            return;
        }

        Nodo<T> actual = obtenerNodo(indice);
        Nodo<T> previo = actual.anterior;
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        previo.siguiente = nuevoNodo;
        nuevoNodo.anterior = previo;
        nuevoNodo.siguiente = actual;
        actual.anterior = nuevoNodo;

        tamano++;
    }

    // Eliminar el primer nodo de la lista circular
    public T eliminarInicio() {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return null;
        }

        T valorEliminado = cabeza.dato;

        if (tamano == 1) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = cola;
            cola.siguiente = cabeza;
        }

        tamano--;
        return valorEliminado;
    }

    // Eliminar el último nodo de la lista circular
    public T eliminarFinal() {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return null;
        }

        T valorEliminado = cola.dato;

        if (tamano == 1) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.anterior; 
            cola.siguiente = cabeza;
            cabeza.anterior = cola;
        }

        tamano--;
        return valorEliminado;
    }

    // Obtener el dato de una posición específica
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            System.out.println("Índice fuera de rango.");
            return null;
        }
        return obtenerNodo(indice).dato;
    }

    // Modificar el dato de una posición específica
    public void modificar(int indice, T nuevoElemento) {
        if (indice < 0 || indice >= tamano) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        obtenerNodo(indice).dato = nuevoElemento;
    }

    // Método eficiente para buscar nodos sin lanzar excepciones
    private Nodo<T> obtenerNodo(int indice) {
        if (indice < tamano / 2) {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < indice; i++) {
                actual = actual.siguiente;
            }
            return actual;
        } else {
            Nodo<T> actual = cola;
            for (int i = tamano - 1; i > indice; i--) {
                actual = actual.anterior;
            }
            return actual;
        }
    }

    // Devuelve el tamaño actual
    public int getTamano() {
        return this.tamano;
    }

    // Verifica si esta vacia
    public boolean estaVacia() {
        return this.tamano == 0;
    }

    // Imprime la lista desde el inicio al fin mostrando la circularidad
    public void mostrarHaciaAdelante() {
        if (estaVacia()) {
            System.out.println("La lista se encuentra vacía.");
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < tamano; i++) {
            System.out.print("[" + actual.dato + "] <-> ");
            actual = actual.siguiente;
        }
        System.out.println("(Retorna a la cabeza: [" + cabeza.dato + "])");
    }
}