package POO.Tarea.Seccion4;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class TestProducto {

    public static void main(String[] args) {

        HashSet<Producto> productos = new HashSet<>();

        productos.add(new Producto("P01", "Laptop", 1200));
        productos.add(new Producto("P02", "Mouse", 20));
        productos.add(new Producto("P03", "Teclado", 35));
        productos.add(new Producto("P01", "Laptop Gamer", 1500)); // duplicado
        productos.add(new Producto("P04", "Monitor", 300));

        System.out.println("Cantidad de productos únicos: " + productos.size());

        List<Producto> lista = new ArrayList<>(productos);
        lista.sort(new ComparadorPorPrecio());

        System.out.println("\nProductos ordenados por precio:");
        for (Producto p : lista) {
            System.out.println(
                p.getCodigo() + " - " + p.getNombre() + " - $" + p.getPrecio()
            );
        }
    }
}
