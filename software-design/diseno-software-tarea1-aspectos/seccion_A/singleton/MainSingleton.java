public class MainSingleton {
    public static void main(String[] args) {
        System.out.println("--- Uso de Patrón de Diseño Singleton ---");
        // Simulación: El usuario entra a la pestaña "Hamburguesas"
        System.out.println("\n--- [Pantalla 1: Hamburguesas] ---");
        CarritoCompras carritoHamburguesas = CarritoCompras.getInstancia();
        carritoHamburguesas.agregarProducto("Hamburguesa con Queso");

        // Simulación: El usuario cambia a la pestaña "Bebidas"
        System.out.println("\n--- [Pantalla 2: Bebidas] ---");
        // Volvemos a pedir la instancia. No se crea una nueva, se usa la anterior.
        CarritoCompras carritoBebidas = CarritoCompras.getInstancia();
        carritoBebidas.agregarProducto("Coca-cola");

        // Simulación: El usuario cambia a la pestaña "Postres"
        System.out.println("\n--- [Pantalla 3: Postres] ---");
        CarritoCompras carritoPostres = CarritoCompras.getInstancia();
        carritoPostres.agregarProducto("Helado de chocolate");

        // Verificación: Mostramos el total de la cena usando la última referencia obtenida
        System.out.println("\n--- [Resumen Final de productos a comprar del Usuario] ---");
        carritoPostres.mostrarProductos();
    }
}