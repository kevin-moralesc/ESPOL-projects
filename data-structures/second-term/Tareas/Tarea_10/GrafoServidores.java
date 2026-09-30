import java.util.*;

public class GrafoServidores {

    
    // Vértice del grafo: Un Servidor.
     
    static class Servidor {
        final String id;
        final String nombre;
        final String ubicacion;
        final int capacidadTB;
        final String servicio;

        Servidor(String id, String nombre, String ubicacion, int capacidadTB, String servicio) {
            this.id = id;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
            this.capacidadTB = capacidadTB;
            this.servicio = servicio;
        }

        // Usamos el ID para verificar si dos servidores son el mismo
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Servidor)) return false;
            Servidor servidor = (Servidor) o;
            return Objects.equals(this.id, servidor.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    
    // Arista dirigida: Conexión entre servidores.
    static class Conexion {
        final Servidor origen;
        final Servidor destino;
        final String protocolo;
        final int latenciaMs;

        Conexion(Servidor origen, Servidor destino, String protocolo, int latenciaMs) {
            this.origen = origen;
            this.destino = destino;
            this.protocolo = protocolo;
            this.latenciaMs = latenciaMs;
        }
    }

   
    //Implementación del Grafo Dirigido
    static class Grafo {
        // Lista de adyacencia
        private final Map<Servidor, List<Conexion>> adyacencias = new LinkedHashMap<>();
        
        // Mapas auxiliares para validar unicidad de ID y Nombre
        private final Set<String> idsRegistrados = new HashSet<>();
        private final Set<String> nombresRegistrados = new HashSet<>();

        
        // Agrega un vértice (Servidor) validando que no se repitan IDs o nombres.
  
        public void agregarServidor(Servidor s) {
            if (idsRegistrados.contains(s.id)) {
                System.out.println("Error: El ID '" + s.id + "' ya existe.");
                return;
            }
            if (nombresRegistrados.contains(s.nombre)) {
                System.out.println("Error: El nombre '" + s.nombre + "' ya existe.");
                return;
            }

            adyacencias.putIfAbsent(s, new ArrayList<>());
            idsRegistrados.add(s.id);
            nombresRegistrados.add(s.nombre);
        }

        
        //Agrega una relación (Arista dirigida) entre dos servidores
        public void agregarConexion(Servidor origen, Servidor destino, String protocolo, int latenciaMs) {
            if (adyacencias.containsKey(origen) && adyacencias.containsKey(destino)) {
                adyacencias.get(origen).add(new Conexion(origen, destino, protocolo, latenciaMs));
            } else {
                System.out.println("Error: Ambos servidores deben existir en el grafo antes de conectarlos.");
            }
        }

        
        //Muestra las conexiones con el formato exacto requerido por la tarea.
        public void mostrarConexiones() {
            for (Servidor origen : adyacencias.keySet()) {
                for (Conexion c : adyacencias.get(origen)) {
                    // Formato: [ORIGEN] --(protocolo=..., latenciaMs=...)--> [DESTINO]
                    System.out.println(c.origen.nombre + " --(protocolo=" + c.protocolo + ", latenciaMs=" + c.latenciaMs + ")--> " + c.destino.nombre);
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo red = new Grafo();

        // Crear los vértices (Servidores)
        Servidor s1 = new Servidor("S1", "API-GATEWAY", "Quito", 2, "Enrutamiento API");
        Servidor s2 = new Servidor("S2", "WEB-FRONTEND", "Guayaquil", 1, "Sitio web");
        Servidor s3 = new Servidor("S3", "AUTH-SERVICE", "Cuenca", 1, "Autenticación");
        Servidor s4 = new Servidor("S4", "PAYMENTS", "Manta", 4, "Pasarela de pagos");
        Servidor s5 = new Servidor("S5", "DATA-WAREHOUSE", "Quito", 12, "Analítica/ETL");
        Servidor s6 = new Servidor("S6", "BACKUP-NODE", "Cuenca", 20, "Respaldo/archivado");

        // Agregar los vértices al grafo
        red.agregarServidor(s1);
        red.agregarServidor(s2);
        red.agregarServidor(s3);
        red.agregarServidor(s4);
        red.agregarServidor(s5);
        red.agregarServidor(s6);
        
        // (Prueba de validación: Descomenta la línea de abajo para ver que no deja agregar un ID repetido)
        // red.agregarServidor(new Servidor("S1", "OTRO-NOMBRE", "Quito", 1, "Test"));

        // Agregar las relaciones dirigidas con protocolo y latencia
        red.agregarConexion(s1, s2, "HTTPS", 40);
        red.agregarConexion(s1, s3, "HTTPS", 55);
        red.agregarConexion(s2, s3, "HTTP", 35);
        red.agregarConexion(s2, s5, "gRPC", 80);
        red.agregarConexion(s3, s4, "HTTPS", 60);
        red.agregarConexion(s4, s5, "AMQP", 90);
        red.agregarConexion(s5, s6, "SFTP", 150);
        red.agregarConexion(s6, s5, "SFTP", 160);
        red.agregarConexion(s4, s1, "HTTPS", 85);

        // Mostrar las conexiones (Salida requerida)
        System.out.println("--- Conexiones del Grafo de Servidores ---");
        red.mostrarConexiones();
    }
}