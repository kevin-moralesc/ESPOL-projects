import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Creamos la cola de prioridad
        PriorityQueue<PruebaNatacion> centroCoordinacion = new PriorityQueue<>();

        // Agregamos pruebas con diferentes tiempos de espera y distancias
        centroCoordinacion.add(new PruebaNatacion("P01", "Libre", 100, 10, 3.0));  // Espera corta
        centroCoordinacion.add(new PruebaNatacion("P02", "Espalda", 200, 45, 12.0)); // ¡Mucha espera! -> Debería salir de primero
        centroCoordinacion.add(new PruebaNatacion("P03", "Mariposa", 50, 30, 6.5)); // Espera media -> Debería salir de tercero
        centroCoordinacion.add(new PruebaNatacion("P04", "Pecho", 150, 40, 8.0));   // Espera alta -> Debería salir de segundo

        // Creamos un juez
        JuezNatacion juez = new JuezNatacion("Kevin Morales");

        // Intentamos asignar pruebas al juez
        System.out.println("--- Iniciando proceso de asignación ---");
        juez.asignarPruebas(centroCoordinacion);

        System.out.println("\n--- Resumen del Juez ---");
        System.out.println("Pruebas asignadas en su jornada:");
        for (PruebaNatacion p : juez.getPruebasAsignadas()) {
            System.out.println("- " + p);
        }
        
        System.out.println("\nPruebas sobrantes en el centro de coordinación (debió quedar la de menor espera):");
        while(!centroCoordinacion.isEmpty()) {
            System.out.println("- " + centroCoordinacion.poll());
        }
    }
}