import java.util.*;

public class GrafoBaseComentado {

    
    private final Map<String, Map<String, Integer>> ady = new LinkedHashMap<>();
    private final Map<String, Map<String, Object>> atributosVertice = new LinkedHashMap<>();
    private final Map<String, Map<String, String>> etiquetaArista = new LinkedHashMap<>();

    // Operaciones Principales
    public void agregarVertice(String id) {
        ady.putIfAbsent(id, new LinkedHashMap<>());
    }

    public boolean existeVertice(String id) {
        return ady.containsKey(id);
    }

    public void setAtributosVertice(String id, Map<String, Object> attrs) {
        agregarVertice(id);
        atributosVertice.put(id, new LinkedHashMap<>(attrs));
    }

    public Map<String, Object> getAtributosVertice(String id) {
        return new LinkedHashMap<>(atributosVertice.getOrDefault(id, Collections.emptyMap()));
    }

    //  Agrega arista dirigida con peso (NO negativo)
    public void agregarArista(String origen, String destino, int peso) {
        if (peso < 0) throw new IllegalArgumentException("El peso debe ser NO negativo.");
        agregarVertice(origen);
        agregarVertice(destino);
        ady.get(origen).put(destino, peso);
    }
    // Variante con etiqueta (p.ej. protocolo). La etiqueta es opcional y didáctica.
    public void agregarArista(String origen, String destino, int peso, String etiqueta) {
        agregarArista(origen, destino, peso);
        etiquetaArista.putIfAbsent(origen, new LinkedHashMap<>());
        etiquetaArista.get(origen).put(destino, etiqueta);
    }

    public boolean existeArista(String origen, String destino) {
        return ady.containsKey(origen) && ady.get(origen).containsKey(destino);
    }

    public int peso(String origen, String destino) {
        if (!existeArista(origen, destino))
            throw new NoSuchElementException("No existe arista " + origen + " -> " + destino);
        return ady.get(origen).get(destino);
    }

    public String etiqueta(String origen, String destino) {
        Map<String, String> m = etiquetaArista.get(origen);
        return (m == null) ? null : m.get(destino);
    }

    public Map<String, Integer> vecinos(String id) {
        return Collections.unmodifiableMap(ady.getOrDefault(id, Collections.emptyMap()));
    }

    public Set<String> vertices() {
        return Collections.unmodifiableSet(ady.keySet());
    }

    public void mostrarConexiones() {
        for (var entry : ady.entrySet()) {
            String origen = entry.getKey();
            for (var ar : entry.getValue().entrySet()) {
                String destino = ar.getKey();
                int peso = ar.getValue();
                String tag = etiqueta(origen, destino);
                if (tag != null) {
                    System.out.printf("%s --(peso=%d, etiqueta=%s)--> %s%n", origen, peso, tag, destino);
                } else {
                    System.out.printf("%s --(peso=%d)--> %s%n", origen, peso, destino);
                }
            }
        }
    }
    // Utilidades didacticas
    
    public int contarVertices() {
        return ady.size();
    }

    public int contarAristas() {
        int total = 0;
        for (var m : ady.values()) total += m.size();
        return total;
    }

    public void limpiar() {
        ady.clear();
        atributosVertice.clear();
        etiquetaArista.clear();
    }


   public void cargarDesdeListas(List<String> ids, List<String[]> aristas) {
        for (String id : ids) agregarVertice(id);
        for (String[] a : aristas) {
            if (a.length == 3) {
                agregarArista(a[0], a[1], Integer.parseInt(a[2]));
            } else if (a.length >= 4) {
                agregarArista(a[0], a[1], Integer.parseInt(a[2]), a[3]);
            }
        }
    }

    // Lista todas las aristas cuya etiqueta coincida con la buscada
    public void listarRelacionesPorEtiqueta(String etiquetaBuscada) {
        for (String origen : vertices()) {
            for (var ent : vecinos(origen).entrySet()) {
                String destino = ent.getKey();
                int peso = ent.getValue();
                String etiqueta = etiqueta(origen, destino);
                if (etiquetaBuscada.equalsIgnoreCase(etiqueta)) {
                    System.out.printf("%s --(%s, %d años)--> %s%n",
                            origen, etiqueta, peso, destino);
                }
            }
        }
    }

    public void listarEntrantesHacia(String destinoObjetivo, Set<String> etiquetas) {
        for (String origen : vertices()) {
            for (var ent : vecinos(origen).entrySet()) {
                String destino = ent.getKey();
                int peso = ent.getValue();
                String etiqueta = etiqueta(origen, destino);
                if (destinoObjetivo.equals(destino) && etiquetas.contains(etiqueta)) {
                    System.out.printf("%s --(%s, %d años)--> %s%n", origen, etiqueta, peso, destino);
                }
            }
        }
    } 

    // MÉTODO DIJKSTRA
        public String dijkstra(String source, String target) {
        final int INF = Integer.MAX_VALUE;
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for (String v : vertices()) {
            dist.put(v, INF);
            prev.put(v, null);
        }

        if (!existeVertice(source)) agregarVertice(source);
        dist.put(source, 0);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(source);

        while (!pq.isEmpty()) {
            String u = pq.poll();
            if (u.equals(target)) break;

            for (var ent : vecinos(u).entrySet()) {
                String v = ent.getKey();
                int w = ent.getValue();

                if (dist.get(u) == INF) continue;
                int alt = dist.get(u) + w;

                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.add(v);
                }
            }
        }

        if (!dist.containsKey(target) || dist.get(target) == INF)
            return "Costo: INF (no hay ruta)\nRuta: (vacío)";

        LinkedList<String> path = new LinkedList<>();
        for (String cur = target; cur != null; cur = prev.get(cur)) {
            path.addFirst(cur);
        }

        return "Costo: " + dist.get(target) + "\nRuta: " + String.join(" -> ", path);
    }


    // ==========================================
    // FLOYD-WARSHALL
    // ==========================================
    public Map<String, Map<String, Integer>> floydWarshall() {
        final int INF = Integer.MAX_VALUE / 2;
        List<String> vertices = new ArrayList<>(this.vertices());
        Map<String, Map<String, Integer>> dist = new HashMap<>();
        
        for (String u : vertices) {
            dist.put(u, new HashMap<>());
            for (String v : vertices) {
                if (u.equals(v)) {
                    dist.get(u).put(v, 0);
                } else if (this.existeArista(u, v)) {
                    dist.get(u).put(v, this.peso(u, v)); 
                } else {
                    dist.get(u).put(v, INF);
                }
            }
        }
        
        for (String k : vertices) {
            for (String i : vertices) {
                for (String j : vertices) {
                    if (dist.get(i).get(k) + dist.get(k).get(j) < dist.get(i).get(j)) {
                        dist.get(i).put(j, dist.get(i).get(k) + dist.get(k).get(j));
                    }
                }
            }
        }
        
        return dist;
    }
}