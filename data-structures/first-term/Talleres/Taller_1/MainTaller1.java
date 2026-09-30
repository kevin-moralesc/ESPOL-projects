
public class MainTaller1 {
    public static void main(String[] args) {
        // Creamos una lista enlazada vacía
        MyLinkedList<Integer> lista = new MyLinkedList<>();
        
        // Agregamos algunos elementos usando for
        for (int i = 1; i <= 21; i++) {
            lista.addLast(i);
        }
        
        // Mostramos el contenido usando tu método print de MyLinkedList.java
        lista.print();
    }
}