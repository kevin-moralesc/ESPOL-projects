package POO.Tarea.Seccion1;
import java.util.HashSet;

public class TestLibro {
    public static void main(String[] args) {

        Libro l1 = new Libro("Java Básico", "Kevin Morales", "123");
        Libro l2 = new Libro("Java Avanzado", "Fiore Morales", "123");
        Libro l3 = new Libro("Python", "Piero Castro", "456");

        HashSet<Libro> libros = new HashSet<>();
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);

        System.out.println("Cantidad de libros en el HashSet: " + libros.size());
    }
}
