public class MyLinkedList<T> {

    // Estructura interna del Nodo
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Atributos de la lista
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor de la lista
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    //Agrega un nuevo elemento al final de la lista.
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        // Si la lista está vacía, el nuevo nodo es tanto el inicio como el fin
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // El nodo que antes era el último ahora apunta al nuevo nodo
            tail.next = newNode;
            // Actualizamos la cola para que sea el nuevo nodo
            tail = newNode;
        }
        size++;
    }

   
    // metodo que sirve para ayudarnos con invertir la lista
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    
    //Retorna la cantidad de elementos guardados.
    public int length() {
        return size;
    }

    
    // Recorrer la lista para imprimirla
    public void printList() {
        Node<T> current = head;
        // Recorremos la lista hasta que el nodo actual sea null
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next; // Avanzamos al siguiente nodo
        }
        System.out.println("null");
    }

    // Agrega todos los elementos de 'otherList' al final de la lista actual.
    public void join(MyLinkedList<T> otherList) {
        // Validamos que la otra lista no sea nula o esté vacía
        if (otherList == null || otherList.head == null) {
            return;
        }

        Node<T> current = otherList.head;
        // Recorremos la otra lista y vamos insertando sus datos al final de la nuestra
        while (current != null) {
            this.addLast(current.data);
            current = current.next;
        }
    }

    
    //Crea y retorna una NUEVA lista con el orden invertido sin modificar la original.
    public MyLinkedList<T> reverse() {
        MyLinkedList<T> reversedList = new MyLinkedList<>();
        
        Node<T> current = this.head;
        // Al ir insertando al inicio (addFirst) de la nueva lista, el orden se invierte solo
        while (current != null) {
            reversedList.addFirst(current.data);
            current = current.next;
        }
        
        return reversedList;
    }


    // PRUEBAS  Y EJEMPLOS DE USO
    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE LA TAREA 05 ---");

        // Crear Lista A
        MyLinkedList<Integer> listaA = new MyLinkedList<>();
        listaA.addLast(10);
        listaA.addLast(20);
        listaA.addLast(30);

        System.out.print("Lista A original: ");
        listaA.printList();
        System.out.println("Longitud de Lista A: " + listaA.length());

        System.out.println("--------------------------------");

        // Probar Invertir Lista A
        MyLinkedList<Integer> listaInvertida = listaA.reverse();
        System.out.print("Nueva Lista Invertida: ");
        listaInvertida.printList();
        System.out.print("Verificación de que Lista A NO cambió: ");
        listaA.printList();

        System.out.println("--------------------------------");

        // Crear Lista B para unir
        MyLinkedList<Integer> listaB = new MyLinkedList<>();
        listaB.addLast(40);
        listaB.addLast(50);
        System.out.print("Lista B: ");
        listaB.printList();

        // Probar Unir dos listas (Unir B en A)
        listaA.join(listaB);
        System.out.print("Lista A después de unirle la Lista B: ");
        listaA.printList();
        System.out.println("Nueva longitud de Lista A: " + listaA.length());
    }
}