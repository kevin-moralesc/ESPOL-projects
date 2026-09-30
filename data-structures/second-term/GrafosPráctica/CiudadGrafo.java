import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque; 

public class CiudadGrafo {

    // Clase Arista 
    static class Arista {
        String destino;
        int peso; 

        public Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    private Map<String, List<Arista>> adyacencia; 

    public CiudadGrafo() {
        adyacencia = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        adyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarLado(String origen, String destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso)); 
    }

    //RECORRIDO BFS 
    public void recorridoBFS(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new ArrayDeque<>(); 

        visitados.add(inicio);
        cola.offer(inicio); 

        System.out.print("Recorrido en Anchura (BFS): ");
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");

            for (Arista arista : adyacencia.get(actual)) {
                
                if (visitados.add(arista.destino)) { 
                    cola.offer(arista.destino);
                }
            }
        }
        System.out.println();
    }

    // RECORRIDO DFS RECURSIVO
    public void recorridoDFS(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.print("Recorrido en Profundidad (DFS): ");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(String actual, Set<String> visitados) {
        visitados.add(actual);
        System.out.print(actual + " ");

        for (Arista arista : adyacencia.get(actual)) {
            if (!visitados.contains(arista.destino)) {
                dfsRecursivo(arista.destino, visitados);
            }
        }
    }

    // MÉTODO PARA CONTAR KILÓMETROS
    public int contarKilometrosTotales(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new ArrayDeque<>();
        Set<String> callesContadas = new HashSet<>(); 
        int totalKilometros = 0;

        visitados.add(inicio);
        cola.offer(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();

            for (Arista arista : adyacencia.get(actual)) {
                String calle1 = actual + "-" + arista.destino;
                String calle2 = arista.destino + "-" + actual;

                if (!callesContadas.contains(calle1) && !callesContadas.contains(calle2)) {
                    totalKilometros += arista.peso;
                    callesContadas.add(calle1); 
                }

                if (visitados.add(arista.destino)) {
                    cola.offer(arista.destino);
                }
            }
        }
        return totalKilometros;
    }

    public static void main(String[] args) {
        CiudadGrafo grafo = new CiudadGrafo();

        String[] nodos = {"Casa", "A", "B", "C", "D", "E", "F", "Universidad"};
        for (String nodo : nodos) {
            grafo.agregarVertice(nodo);
        }

        grafo.agregarLado("Casa", "A", 3);
        grafo.agregarLado("Casa", "B", 2);
        grafo.agregarLado("Casa", "C", 5);
        grafo.agregarLado("A", "D", 3);
        grafo.agregarLado("B", "D", 1);
        grafo.agregarLado("B", "E", 6);
        grafo.agregarLado("C", "E", 2);
        grafo.agregarLado("D", "F", 4);
        grafo.agregarLado("E", "F", 1);
        grafo.agregarLado("E", "Universidad", 4);
        grafo.agregarLado("F", "Universidad", 2);

        System.out.println("--- RESULTADOS DE LA TAREA ---");
        grafo.recorridoBFS("Casa");
        grafo.recorridoDFS("Casa");
        System.out.println("------------------------------");
        int totalKm = grafo.contarKilometrosTotales("Casa");
        System.out.println("Total de kilómetros de calles en la ciudad: " + totalKm + " km.");
    }
}