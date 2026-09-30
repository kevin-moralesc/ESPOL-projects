import java.util.*;

public class CloudGraphDemo {

    // Tipos de relación o acciones entre los recursos.
    enum CloudAction {
        BALANCEA_TRAFICO("balancea tráfico"),
        REENVIA_API("reenvía API"),
        CONSULTA_SQL("consulta SQL"),
        DEVUELVE_RESULTADOS("devuelve resultados"),
        REPORTA_HEALTH_CHECK("reporta health-check"),
        LEE_CONFIG("lee config");

        private final String label;
        CloudAction(String label) { this.label = label; }
        @Override public String toString() { return label; }
    }

    
    // Vértice del grafo: Un recurso de la nube (Tabla de atributos DataFrame).

    static class CloudResource {
        final String nombre;
        final String tipo;
        final String region;
        final String plataforma;
        final int costoMensualUSD;

        CloudResource(String nombre, String tipo, String region, String plataforma, int costoMensualUSD) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.region = region;
            this.plataforma = plataforma;
            this.costoMensualUSD = costoMensualUSD;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CloudResource)) return false;
            CloudResource other = (CloudResource) o;
            return Objects.equals(this.nombre, other.nombre);
        }

        @Override public int hashCode() {
            return Objects.hash(nombre);
        }

        @Override public String toString() {
            return nombre + " (" + tipo + ", " + region + ", " + plataforma + ", $" + costoMensualUSD + ")";
        }
    }


     // Arista dirigida del grafo: from -> to con acción y tiempo en meses.
     
    static class ResourceEdge {
        final CloudResource from;
        final CloudResource to;
        final CloudAction action;
        final int meses;

        ResourceEdge(CloudResource from, CloudResource to, CloudAction action, int meses) {
            this.from = from;
            this.to = to;
            this.action = action;
            this.meses = meses;
        }

        @Override public String toString() {
            return from.nombre + " -> " + to.nombre + " : " + action + " (" + meses + " meses)";
        }
    }

    
    // IMPLEMENTACIÓN DEL GRAFO
      

    static class CloudGraph {
        private final Map<CloudResource, List<ResourceEdge>> adj = new HashMap<>();

        // ---------- Vértices ---------- 

        public void addResource(CloudResource r) {
            adj.putIfAbsent(r, new ArrayList<>());
        }

        public boolean contains(CloudResource r) {
            return adj.containsKey(r);
        }

        public Set<CloudResource> resources() {
            return new HashSet<>(adj.keySet());
        }

        public int resourceCount() {
            return adj.size();
        }

        public void removeResource(CloudResource r) {
            if (!adj.containsKey(r)) return;
            for (CloudResource u : adj.keySet()) {
                adj.get(u).removeIf(edge -> edge.to.equals(r));
            }
            adj.remove(r);
        }

        // ---------- Aristas ---------- 

        public void addRelation(CloudResource from, CloudResource to, CloudAction action, int meses) {
            addResource(from);
            addResource(to);
            adj.get(from).add(new ResourceEdge(from, to, action, meses));
        }

        public void removeRelation(CloudResource from, CloudResource to, CloudAction action) {
            if (!adj.containsKey(from)) return;
            adj.get(from).removeIf(e -> e.to.equals(to) && e.action == action);
        }

        public List<ResourceEdge> outgoing(CloudResource r) {
            if (!adj.containsKey(r)) return Collections.emptyList();
            return new ArrayList<>(adj.get(r));
        }

        public List<ResourceEdge> incoming(CloudResource target) {
            List<ResourceEdge> res = new ArrayList<>();
            for (CloudResource u : adj.keySet()) {
                for (ResourceEdge e : adj.get(u)) {
                    if (e.to.equals(target)) res.add(e);
                }
            }
            return res;
        }

        public int relationCount() {
            int total = 0;
            for (CloudResource u : adj.keySet()) total += adj.get(u).size();
            return total;
        }

        // ---------- Consultas por atributos ---------- 

        public List<CloudResource> resourcesInRegion(String region) {
            List<CloudResource> res = new ArrayList<>();
            for (CloudResource r : adj.keySet()) {
                if (r.region.equalsIgnoreCase(region)) res.add(r);
            }
            return res;
        }

        // ---------- Recorridos BFS/DFS ---------

        public List<CloudResource> bfs(CloudResource start) {
            if (!adj.containsKey(start)) return Collections.emptyList();
            List<CloudResource> order = new ArrayList<>();
            Set<CloudResource> visited = new HashSet<>();
            Queue<CloudResource> q = new ArrayDeque<>();

            visited.add(start);
            q.add(start);

            while (!q.isEmpty()) {
                CloudResource u = q.poll();
                order.add(u);
                for (ResourceEdge e : adj.get(u)) {
                    CloudResource v = e.to;
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.add(v);
                    }
                }
            }
            return order;
        }

        public List<CloudResource> dfs(CloudResource start) {
            if (!adj.containsKey(start)) return Collections.emptyList();
            List<CloudResource> order = new ArrayList<>();
            Set<CloudResource> visited = new HashSet<>();
            Deque<CloudResource> stack = new ArrayDeque<>();

            stack.push(start);

            while (!stack.isEmpty()) {
                CloudResource u = stack.pop();
                if (visited.contains(u)) continue;

                visited.add(u);
                order.add(u);

                for (ResourceEdge e : adj.get(u)) {
                    CloudResource v = e.to;
                    if (!visited.contains(v)) stack.push(v);
                }
            }
            return order;
        }

        // ---------- Camino más corto (Dijkstra) por meses ----------

        public List<ResourceEdge> shortestPathByMonths(CloudResource start, CloudResource goal) {
            if (!adj.containsKey(start) || !adj.containsKey(goal)) return Collections.emptyList();

            Map<CloudResource, Integer> dist = new HashMap<>();
            for (CloudResource r : adj.keySet()) dist.put(r, Integer.MAX_VALUE);
            dist.put(start, 0);

            Map<CloudResource, ResourceEdge> parentEdge = new HashMap<>();
            parentEdge.put(start, null);

            PriorityQueue<NodeDist> pq = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.dist));
            pq.add(new NodeDist(start, 0));

            while (!pq.isEmpty()) {
                NodeDist cur = pq.poll();
                CloudResource u = cur.node;

                if (cur.dist != dist.get(u)) continue;
                if (u.equals(goal)) break;

                for (ResourceEdge e : adj.get(u)) {
                    if (e.meses < 0) throw new IllegalStateException("Pesos negativos no soportados.");
                    CloudResource v = e.to;
                    if (dist.get(u) == Integer.MAX_VALUE) continue;

                    int newDist = dist.get(u) + e.meses;
                    if (newDist < dist.get(v)) {
                        dist.put(v, newDist);
                        parentEdge.put(v, e);
                        pq.add(new NodeDist(v, newDist));
                    }
                }
            }

            if (dist.get(goal) == Integer.MAX_VALUE) return Collections.emptyList();

            LinkedList<ResourceEdge> path = new LinkedList<>();
            CloudResource cur = goal;

            while (!cur.equals(start)) {
                ResourceEdge e = parentEdge.get(cur);
                if (e == null) break; 
                path.addFirst(e);
                cur = e.from; 
            }
            return path;
        }

        private static class NodeDist {
            final CloudResource node;
            final int dist;
            NodeDist(CloudResource node, int dist) { this.node = node; this.dist = dist; }
        }

        // ---------- Impresión del grafo ----------

        public void printGraph() {
            for (CloudResource u : adj.keySet()) {
                System.out.println(u.nombre + " -> ");
                for (ResourceEdge e : adj.get(u)) {
                    System.out.println("   " + e.action + " a " + e.to.nombre + " (" + e.meses + " meses)");
                }
            }
        }
    }

    
    public static void main(String[] args) {

        // Nodos y DataFrame
        CloudResource lb = new CloudResource("LB", "Servicio", "us-east-1", "ELB", 22);
        CloudResource web = new CloudResource("WEB", "Servidor", "us-east-1", "EC2 Ubuntu", 45);
        CloudResource app = new CloudResource("APP", "Servidor", "us-east-1", "EC2 Amazon Linux", 58);
        CloudResource db = new CloudResource("DB", "Servicio", "us-east-2", "RDS PostgreSQL", 120);

        // Grafo dirigido
        CloudGraph g = new CloudGraph();

        // Aristas dirigidas (relación + tiempo)
        g.addRelation(lb, web, CloudAction.BALANCEA_TRAFICO, 18);
        g.addRelation(web, app, CloudAction.REENVIA_API, 14);
        g.addRelation(app, db, CloudAction.CONSULTA_SQL, 24);
        g.addRelation(db, app, CloudAction.DEVUELVE_RESULTADOS, 24);
        g.addRelation(app, lb, CloudAction.REPORTA_HEALTH_CHECK, 18);
        g.addRelation(web, db, CloudAction.LEE_CONFIG, 10);

        // Actividades Resueltas
        System.out.println("--- GRAFO DE INFRAESTRUCTURA CLOUD ---");
        g.printGraph();
        System.out.println("Nodos totales: " + g.resourceCount());
        System.out.println("Aristas totales:  " + g.relationCount());

        System.out.println("\n---CONSULTAS EXTRAS (Similares al ejemplo) ---");
        System.out.println("Recursos en us-east-1: " + g.resourcesInRegion("us-east-1"));
        System.out.println("Conexiones salientes de WEB: " + g.outgoing(web));
        System.out.println("BFS desde LB (Flujo de arquitectura): " + g.bfs(lb));
    }
}