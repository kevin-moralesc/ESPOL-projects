import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class JuezNatacion {
    private String nombre;
    private List<PruebaNatacion> pruebasAsignadas;
    private String transporteAsignado;

    // Constructor
    public JuezNatacion(String nombre) {
        this.nombre = nombre;
        this.pruebasAsignadas = new ArrayList<>(); // Inicializamos la lista vacía
        this.transporteAsignado = "Ninguno";
    }

    public void asignarPruebas(PriorityQueue<PruebaNatacion> colaPruebas) {
        //  Validamos que exista al menos tres pruebas pendientes
        if (colaPruebas == null || colaPruebas.size() < 3) {
            int faltantes = 3 - (colaPruebas == null ? 0 : colaPruebas.size());
            System.out.println("No se puede realizar la asignación. Faltan " + faltantes + " pruebas para completar la jornada de " + this.nombre + ".");
            return;
        }

        // Aseguramos que la lista no esté nula
        if (this.pruebasAsignadas == null) {
            this.pruebasAsignadas = new ArrayList<>();
        }

        double sumaDistancias = 0.0;

        // Extraer las tres pruebas con mayor prioridad de la cola
        for (int i = 0; i < 3; i++) {
            // poll() extrae y elimina el elemento con mayor prioridad de la cola
            PruebaNatacion prueba = colaPruebas.poll();
            
            // Agregar a la lista del juez
            this.pruebasAsignadas.add(prueba);
            
            // Acumular la distancia para el promedio
            sumaDistancias += prueba.getDistanciaPiscinaKm();
        }

        //distancia promedio
        double distanciaPromedio = sumaDistancias / 3.0;

        // Asignar el transporte según las reglas del negocio
        if (distanciaPromedio < 5.0) {
            this.transporteAsignado = "Bicicleta";
        } else if (distanciaPromedio >= 5.0 && distanciaPromedio <= 10.0) {
            this.transporteAsignado = "Motocicleta";
        } else {
            this.transporteAsignado = "Auto";
        }

        System.out.println("Asignación exitosa para " + this.nombre + ".");
        System.out.println("Distancia promedio calculada: " + String.format("%.2f", distanciaPromedio) + " km.");
        System.out.println("Vehículo asignado: " + this.transporteAsignado);
    }

    // Getters para verificar los resultados
    public String getNombre() { return nombre; }
    public List<PruebaNatacion> getPruebasAsignadas() { return pruebasAsignadas; }
    public String getTransporteAsignado() { return transporteAsignado; }
}