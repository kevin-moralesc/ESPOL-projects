import java.util.*;

public class MainTarea9 {
    public static void main(String[] args) {
        
        // TAREA 1: CONSTRUIR LA MATRIZ 

        System.out.println("--- TAREA 1: Matriz de adyacencia ---");
        GrafoBaseComentado g = new GrafoBaseComentado();
        
        // Agregar las ciudades
        String[] ciudades = {"P", "Q", "R", "S", "T"};
        for(String c : ciudades) {
            g.agregarVertice(c);
        }
        // Agregar los atributos (Tabla)
        g.setAtributosVertice("P", Map.of("Region", "Costa", "Aeropuerto", true));
        g.setAtributosVertice("Q", Map.of("Region", "Costa", "Aeropuerto", true));
        g.setAtributosVertice("R", Map.of("Region", "Sierra", "Aeropuerto", false));
        g.setAtributosVertice("S", Map.of("Region", "Sierra", "Aeropuerto", true));
        g.setAtributosVertice("T", Map.of("Region", "Amazonia", "Aeropuerto", false));

        // Agregar los caminos y distancias 
        g.agregarArista("P", "Q", 6);
        g.agregarArista("P", "R", 3);
        g.agregarArista("Q", "R", 2);
        g.agregarArista("Q", "S", 5);
        g.agregarArista("R", "S", 3);
        g.agregarArista("S", "T", 4);
        g.agregarArista("T", "Q", 7);

        // Imprimir la Matriz de Adyacencia en formato tabla
        System.out.print("\tP\tQ\tR\tS\tT\n");
        for (String i : ciudades) {
            System.out.print(i + "\t");
            for (String j : ciudades) {
                if (i.equals(j)) {
                    System.out.print("0\t");
                } else if (g.existeArista(i, j)) {
                    System.out.print(g.peso(i, j) + "\t");
                } else {
                    System.out.print("∞\t"); // Usamos infinito si no hay conexión directa
                }
            }
            System.out.println();
        }

        // TAREA 2: FLOYD-WARSHALL
        System.out.println("\n--- TAREA 2 (Floyd-Warshall) ---");
        Map<String, Map<String, Integer>> distancias = g.floydWarshall();
        
        // Imprimir la matriz resultante de forma sencilla
        for (String origen : g.vertices()) {
            for (String destino : g.vertices()) {
                int dist = distancias.get(origen).get(destino);
                String valor = (dist > 99999) ? "INF" : String.valueOf(dist);
                System.out.print(valor + "\t");
            }
            System.out.println();
        }


        // TAREA 3: DIJKSTRA 
        System.out.println("\n--- TAREA 3 (Dijkstra) ---");
        System.out.println("Ruta P -> T:");
        System.out.println(g.dijkstra("P", "T"));
        
        System.out.println("\nRuta T -> R:");
        System.out.println(g.dijkstra("T", "R"));


        // TAREA 4: RESTRICCIONES 
     
        System.out.println("\n--- TAREA 4 (Restricciones) ---");
        
        // Restricción por aeropuerto (P -> T)
        // Como R no tiene aeropuerto, armamos un grafo temporal idéntico, pero SIN R.
        GrafoBaseComentado grafoAero = new GrafoBaseComentado();
        grafoAero.agregarArista("P", "Q", 6);
        grafoAero.agregarArista("Q", "S", 5);
        grafoAero.agregarArista("S", "T", 4);
        // Omitimos intencionalmente todas las rutas que toquen "R"
        System.out.println("Ruta alternativa evitando la ciudad R (sin aeropuerto):");
        System.out.println(grafoAero.dijkstra("P", "T"));
        
        System.out.println("EXPLICACIÓN: Es IMPOSIBLE cumplir la regla de forma estricta. " 
            + "La ciudad destino 'T' no tiene aeropuerto. Si consideramos la restricción solo para nodos intermedios, "
            + "la ruta P -> Q -> S -> T sí es válida porque P, Q y S tienen aeropuerto (Costo 15). "
            + "La ruta directa Dijkstra P -> R -> S -> T pasa por R, que NO tiene aeropuerto, así que queda descartada.");

        // Restricción misma región (Q -> R)
        System.out.println("\nRestricción por misma región (Q -> R):");
        System.out.println("Es IMPOSIBLE. El origen Q pertenece a la Costa. La única otra ciudad de la Costa es P.");
        System.out.println("Al observar el grafo dirigido, el nodo P tiene un grado de entrada de 0 desde Q, " +
                           "lo que significa que ninguna flecha permite viajar hacia P estando en Q o sus sucesores.");
    }
}