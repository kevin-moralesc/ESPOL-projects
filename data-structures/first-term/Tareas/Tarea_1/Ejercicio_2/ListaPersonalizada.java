import java.util.ArrayList;
import java.util.List;

// Creamos la clase genérica para nuestra Lista Personalizada que acepta cualquier tipo <T>
public class ListaPersonalizada<T> {
private List <T> lista;     // Usamos la abstracción ocultando la lista interna para que no sea accesible desde fuera

// Constructor de listaPersonalizada usando un ArrayList
public ListaPersonalizada() {
    lista = new ArrayList<>();
}

// Método agregar que mete un nuevo elemento al final de nuestra lista
public void agregar (T elemento){
    lista.add(elemento);
}

// Método eliminar que quita un elemento específico y avisa con un booleano si lo logró
public boolean eliminar(T elemento) {
    return lista.remove(elemento);
}

// Método buscar que revisa si el elemento existe dentro de la lista (devuelve true o false)
public boolean buscar(T elemento) {
    return lista.contains(elemento);
}
// Método tamanio que cuenta y devuelve la cantidad total de elementos guardados
public int tamanio() {
    return lista.size();
}


public static void main(String[] args) {
    // Creamos una instancia de la lista para manejar cadenas de texto (String)
    ListaPersonalizada<String> listaCadenas = new ListaPersonalizada<>();
    listaCadenas.agregar("Hola");
    listaCadenas.agregar("Mundo");
    // Probamos si la búsqueda funciona (debería imprimir true)
    System.out.println(listaCadenas.buscar("Mundo"));
    // Probamos  si se elimina Hola
    listaCadenas.eliminar("Hola");
    // Verificamos el tamaño final de la lista (debería imprimir 1)
    System.out.println(listaCadenas.tamanio());
    }
}
    


    


