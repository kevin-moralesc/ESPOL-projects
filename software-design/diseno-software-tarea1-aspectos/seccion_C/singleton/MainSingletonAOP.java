package singleton;

public class MainSingletonAOP {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Simulación de Compra con AOP ===");

        // 1. Pantalla "Hamburguesas"
        CarritoCompras carritoPantalla1 = new CarritoCompras();
        carritoPantalla1.agregarProducto("Hamburguesa");

        // 2. Pantalla "Bebidas" (El desarrollador usa 'new' ingenuamente)
        CarritoCompras carritoPantalla2 = new CarritoCompras();
        carritoPantalla2.agregarProducto("Gaseosa");

        // 3. Pantalla "Postres"
        CarritoCompras carritoPantalla3 = new CarritoCompras();
        carritoPantalla3.agregarProducto("Helado");

        // Verificamos qué se guardó en el último carrito obtenido
        carritoPantalla3.mostrarProductos();

        // Comprobación de identidad de los objetos
        boolean sonElMismo = (carritoPantalla1 == carritoPantalla2 && carritoPantalla2 == carritoPantalla3);
        System.out.println("\n¿Es exactamente la misma instancia en memoria?: " + sonElMismo);
    }
}
