import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Grafo {
    
    private final Map<String, List<String>> adyacencia;

    public Grafo() {
        adyacencia = new HashMap<>();
    }

    // Agregar vértices
    public void agregarVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    // Agregar aristas (Grafo NO dirigido)
    public void agregarArista(String origen, String destino) {
        // Asegura que los vértices existan antes de conectarlos
        agregarVertice(origen);
        agregarVertice(destino);
        
        // Agrega la conexión en ambos sentidos
        adyacencia.get(origen).add(destino);
        adyacencia.get(destino).add(origen);
    }

    //Mostrar el grafo 
    public void mostrarGrafo() {
        for (Map.Entry<String, List<String>> entrada : adyacencia.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }

    // Grado de un vértice
    public int obtenerGrado(String vertice) {
        if (adyacencia.containsKey(vertice)) {
            return adyacencia.get(vertice).size();
        }
        return 0;
    }

    //bfs por nivel (anchura)


    public void bfs(String inicio) {
        
        Set<String> visitados =  new HashSet<>();
        Queue<String> cola = new ArrayDeque<>();
        
        visitados.add(inicio);
        cola.add(inicio);
    
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");
    
            for (String vecino : adyacencia.getOrDefault(actual, new ArrayList<>())) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }

        }}










    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar los seis vértices (Edificios)
        grafo.agregarVertice("Biblioteca");
        grafo.agregarVertice("Laboratorios");
        grafo.agregarVertice("Aulas");
        grafo.agregarVertice("Cafeteria");
        grafo.agregarVertice("Rectorado");
        grafo.agregarVertice("Auditorio");

        // Agregar todas las aristas requeridas
        grafo.agregarArista("Biblioteca", "Aulas");
        grafo.agregarArista("Biblioteca", "Laboratorios");
        grafo.agregarArista("Aulas", "Cafeteria");
        grafo.agregarArista("Aulas", "Auditorio");
        grafo.agregarArista("Laboratorios", "Rectorado");
        grafo.agregarArista("Cafeteria", "Auditorio");
        grafo.agregarArista("Rectorado", "Auditorio");

        // Mostrar la lista de adyacencia
        System.out.println("--- Lista de Adyacencia ---");
        grafo.mostrarGrafo();

        // Mostrar el grado de al menos tres vértices
        System.out.println("\n--- Grado de Vértices ---");
        System.out.println("Grado de Biblioteca: " + grafo.obtenerGrado("Biblioteca"));
        System.out.println("Grado de Aulas: " + grafo.obtenerGrado("Aulas"));
        System.out.println("Grado de Auditorio: " + grafo.obtenerGrado("Auditorio"));
 
        // bfs
        System.out.println("\n--- Recorrido BFS desde Biblioteca ---");
        grafo.bfs("Biblioteca");
        
 
    }
}
/*
--------------------------------------------------------------------------
                       PREGUNTAS DE COMPROBACIÓN
--------------------------------------------------------------------------
 1. ¿Qué representa un vértice en el problema?
    Un vértice representa un edificio físico del campus universitario 
    (por ejemplo: Biblioteca, Aulas, Rectorado, etc.).

 2. ¿Qué representa una arista?
    Una arista representa una conexión directa o camino existente entre dos 
    edificios del campus.

 3. ¿Por qué una conexión debe agregarse en ambos sentidos?
    Porque se trata de un grafo no dirigido. Esto implica que los caminos 
    son bidireccionales: si se puede ir de la Biblioteca a Aulas, también se 
    puede transitar de Aulas a la Biblioteca usando el mismo camino.

 4. ¿Cuál es la diferencia entre: Biblioteca -> Aulas y  Biblioteca <-> Aulas?
    - "Biblioteca -> Aulas": Representa una relación dirigida (unidireccional), 
      donde solo se permite el tránsito en el sentido de Biblioteca hacia Aulas.
    - "Biblioteca <-> Aulas": Representa una relación no dirigida (bidireccional), 
      donde el tránsito es posible en ambos sentidos.

 5. ¿Cuál es el grado del vértice Aulas?
    El grado del vértice Aulas es 3, ya que posee 3 conexiones directas 
    (Biblioteca, Cafetería y Auditorio).

 6. ¿Existe un camino entre Biblioteca y Rectorado? Indique un posible camino.
    Sí existe. Un camino posible es:
    Biblioteca -> Laboratorios -> Rectorado 
    (o bien: Biblioteca -> Aulas -> Auditorio -> Rectorado).

*/