public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public static void main(String[] args) {

        Arbol arbol = new Arbol();

        //      10
        //    /    \
        //   5      15
        //  / \    /  \
        // 3   7  12   20
        
        // Los tres niveles son:

        // Nivel 0: 10
        // Nivel 1: 5 y 15
        // Nivel 2: 3, 7, 12 y 20

        // Crear la raíz
        arbol.raiz = new Nodo(10);

        // Agregar los nodos del nivel 1
        arbol.raiz.izquierdo = new Nodo(5);
        arbol.raiz.derecho = new Nodo(15);


        // Agregar los nodos del nivel 2
        arbol.raiz.izquierdo.izquierdo = new Nodo(3);
        arbol.raiz.izquierdo.derecho = new Nodo(7);
        arbol.raiz.derecho.izquierdo = new Nodo(12);
        arbol.raiz.derecho.derecho = new Nodo(20);

        System.out.println("Árbol creado correctamente.");
    }
}