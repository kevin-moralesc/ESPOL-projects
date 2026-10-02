import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private static CarritoCompras carritoUnico;
    
    private List<String> productos;

    private CarritoCompras() {  
        productos = new ArrayList<>();
    }
    public static CarritoCompras getInstancia() { // Método para obtener la instancia única del carrito
        if (carritoUnico == null) {  //si no existe el carrito, lo creamos
            System.out.println("[Singleton]: No existe carrito activo. Creando el carrito por primera vez.");
            carritoUnico = new CarritoCompras();
        } else {    //Si ya existe , no se crea uno nuevo, se reutiliza el mismo
            System.out.println("[Singleton]: El carrito ya existe en memoria. Reutilizando la instancia existente.");
        }
        return carritoUnico; // Devolvemos el carrito único
    }

    public void agregarProducto(String producto) {
        productos.add(producto);
        System.out.println("--> Producto añadido con éxito: " + producto);
    }

    public void mostrarProductos() {
        System.out.println("Contenido actual del carrito: " + productos);
    }
}