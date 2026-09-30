public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public Nodo rotarDerecha(Nodo nodo) {
        // Guardar el hijo izquierdo del nodo
        Nodo nuevaRaiz = nodo.izquierdo;
        // Guardar temporalmente el hijo derecho de ese hijo
        Nodo temp = nuevaRaiz.derecho;
        // Realizar los cambios de referencias    
        nuevaRaiz.derecho = nodo;
        nodo.izquierdo = temp;
        // Retornar la nueva raíz del subárbol
        return nuevaRaiz;
    }

    public Nodo rotarIzquierda(Nodo nodo) {

        /*
         * 1. Guarde el hijo derecho del nodo.
         * 2. Guarde temporalmente el hijo izquierdo de ese hijo.
         * 3. Realice los cambios de referencias.
         * 4. Retorne la nueva raíz del subárbol.
         */
         // Guardar el hijo derecho del nodo
        Nodo nuevaRaiz = nodo.derecho;
        // Guardar temporalmente el hijo izquierdo de ese hijo
        Nodo temp = nuevaRaiz.izquierdo;
        // Realizar los cambios de referencias    
        nuevaRaiz.izquierdo = nodo;
        nodo.derecho = temp;
        // Retornar la nueva raíz del subárbol
        return nuevaRaiz;

        
    }

    public Nodo rotarIzquierdaDerecha(Nodo nodo) {

        // Caso LR:
        // ROtacion Izquierda sobre el hijo izquierdo
        nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
        // Rotacion Derecha sobre el nodo original
        return rotarDerecha(nodo);
    }

    public Nodo rotarDerechaIzquierda(Nodo nodo) {

        
        // Caso RL:
        // ROtacion Derecha sobre el hijo derecho
        nodo.derecho = rotarDerecha(nodo.derecho);
        // Rotacion Izquierda sobre el nodo original
        return rotarIzquierda(nodo);
    }

    public static void mostrarArbol(Nodo nodo) {

        if (nodo == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.out.println("Raíz: " + nodo.valor);

        System.out.println(
            "Hijo izquierdo: "
            + (nodo.izquierdo != null ? nodo.izquierdo.valor : "null")
        );

        System.out.println(
            "Hijo derecho: "
            + (nodo.derecho != null ? nodo.derecho.valor : "null")
        );

        System.out.println();
    }

    public static void main(String[] args) {

        Arbol arbol = new Arbol();
    
        System.out.println("--- EJERCICIO 1: Rotación LL ---");

        arbol.raiz = new Nodo(30);
        arbol.raiz.izquierdo = new Nodo(20);
        arbol.raiz.izquierdo.izquierdo = new Nodo(10);

        System.out.println("Árbol inicial:");
        mostrarArbol(arbol.raiz);

        // Rotación LL
        arbol.raiz = arbol.rotarDerecha(arbol.raiz);

        System.out.println("Árbol después de rotar a la derecha:");
        mostrarArbol(arbol.raiz);

        System.out.println("-----------------------------------------");

        System.out.println("--- EJERCICIO 2: Rotación RR ---");

        arbol.raiz = new Nodo(10);
        arbol.raiz.derecho = new Nodo(20);
        arbol.raiz.derecho.derecho = new Nodo(30);

        System.out.println("Árbol inicial:");
        mostrarArbol(arbol.raiz);

        // Rotación RR
        arbol.raiz = arbol.rotarIzquierda(arbol.raiz);

        System.out.println("Árbol después de rotar a la izquierda:");
        mostrarArbol(arbol.raiz);
   
        System.out.println("-----------------------------------------");

        System.out.println("--- EJERCICIO 3: Rotación LR ---");
        arbol.raiz = new Nodo(30);
        arbol.raiz.izquierdo = new Nodo(10);
        arbol.raiz.izquierdo.derecho = new Nodo(20);

        System.out.println("Árbol inicial:");
        mostrarArbol(arbol.raiz);

        // Rotación LR
        arbol.raiz = arbol.rotarIzquierdaDerecha(arbol.raiz);

        System.out.println("Árbol después de la rotación doble LR:");
        mostrarArbol(arbol.raiz);

        System.out.println("-----------------------------------------");
        System.out.println("--- EJERCICIO 4: Rotación RL ---");
        arbol.raiz = new Nodo(10);
        arbol.raiz.derecho = new Nodo(30);
        arbol.raiz.derecho.izquierdo = new Nodo(20);

        System.out.println("Árbol inicial:");
        mostrarArbol(arbol.raiz);

        // Rotación RL
        arbol.raiz = arbol.rotarDerechaIzquierda(arbol.raiz);

        System.out.println("Árbol después de la rotación doble RL:");
        mostrarArbol(arbol.raiz);

    }

}