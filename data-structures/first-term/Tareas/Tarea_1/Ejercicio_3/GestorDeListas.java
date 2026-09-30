import java.util.List;
import java.util.ArrayList;

// Definición de la clase GestorDeListas (Funciona como una caja de herramientas)
public class GestorDeListas<T> {

// Método genérico y estático para agregar un elemento a una lista
public static <T> void agregarElementoALista(List<T> lista, T elemento) {
    lista.add(elemento);
}

// Método genérico y estático para remover un elemento de una lista 
public static <T> void removerElementoDeLista(List<T> lista, T elemento) {
    lista.remove(elemento);
}

// Método genérico y estático para recorrer e imprimir TODOS los elementos de la lista
public static <T> void imprimirLista(List<T> lista){
    for (T elemento : lista) {
        System.out.println(elemento);
    }
}


public static void main (String[]args){
// Creamos una lista de Strings (nombres)
List <String> listaNombres= new ArrayList<>();

// Agregamos elementos a la lista usando los métodos estáticos de GestorDeListas
GestorDeListas.agregarElementoALista(listaNombres, "Juan");
GestorDeListas.agregarElementoALista(listaNombres, "Ana");
// Imprimimos la lista (Debe mostrar: Juan, Ana)
GestorDeListas.imprimirLista(listaNombres); 
//BORRAMOS el nomnre "Ana" de la lista
GestorDeListas.removerElementoDeLista(listaNombres, "Ana");
System.out.println("-------");
// Imprimimos nuevamente para comprobar que "Ana" fue removida (Debe mostrar: Juan)
GestorDeListas.imprimirLista(listaNombres); 

}
    
}
