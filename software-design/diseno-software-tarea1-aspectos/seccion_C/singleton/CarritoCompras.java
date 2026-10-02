package singleton;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private List<String> productos;

    // Constructor 100% público. Cualquier pantalla creerá que puede crear uno nuevo.
    public CarritoCompras() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(String producto) {
        this.productos.add(producto);
    }

    public void mostrarProductos() {
        System.out.println("Productos en el carrito actual: " + productos);
    }
}
