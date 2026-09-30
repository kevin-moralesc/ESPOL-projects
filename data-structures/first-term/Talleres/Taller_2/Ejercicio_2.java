import java.util.HashMap;
import java.util.Map;
public class Ejercicio_2 {

public static void main(String[]args){
    
// Cree un programa que permita manejar el inventario de una tienda usando un Map<String, Integer>.
Map<String, Integer> inventario = new HashMap<>();
// La clave será el nombre del producto y el valor será la cantidad disponible.
// Requerimientos
// Registrar al menos 5 productos con su stock inicial.
inventario.put("Manzanas", 50);
inventario.put("Naranjas", 30);
inventario.put("Melon", 20);
inventario.put("Uvas", 15);
inventario.put("Sandías", 5);

// Aumentar el stock de un producto.
if (inventario.containsKey("Manzanas")) {
            inventario.put("Manzanas", inventario.get("Manzanas") + 20);
        }

// Disminuir el stock cuando se realice una venta.
if (inventario.containsKey("Naranjas")) {
    int nuevoStock = inventario.get("Naranjas") - 5;
    inventario.put("Naranjas", nuevoStock);
            
// Si llega a 0, se elimina
if (nuevoStock == 0) {
    inventario.remove("Naranjas");
}
        }
// Validar que no se pueda vender más de lo disponible.
String productoVenta = "Melon";
int cantidad = 25   ;
        
if (inventario.containsKey(productoVenta)) {
    int stockActual = inventario.get(productoVenta);
    if (stockActual >= cantidad) {
        int nuevoStock = stockActual - cantidad;
        inventario.put(productoVenta, nuevoStock);
                
        //Si llega a 0, se elimina 
        if (nuevoStock == 0) {
            inventario.remove(productoVenta);
            }
        } else {
                System.out.println("No se puede vender " + cantidad + " " + productoVenta + ". Stock insuficiente (Disponible: " + stockActual + ").");
            }
        }
//Mostrar los productos con stock menor a 10.
System.out.println("--- Productos con stock menor a 10 ---");
for (Map.Entry<String, Integer> inv : inventario.entrySet()) {
    if (inv.getValue() < 10) {
        System.out.println(inv.getKey() + ": " + inv.getValue());
    }
}   


// Mostrar el inventario final.
System.out.println("Inventario final:");
for (Map.Entry<String, Integer> inv : inventario.entrySet()) {
    System.out.println(inv.getKey() + ": " + inv.getValue());
}
}}