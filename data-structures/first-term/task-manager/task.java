import java.time.LocalDate;

// Enum para representar el estado de una tarea
enum Estado {
    PENDIENTE,
    EN_PROGRESO,
    COMPLETADA
}

// Clase que representa una tarea
public class Task implements Comparable<Task> {

    private int id;                   // Identificador único
    private String descripcion;       // Descripción textual de la tarea
    private Estado estado;            // Estado actual (PENDIENTE, EN_PROGRESO, COMPLETADA)
    private int prioridad;            // Prioridad (mayor valor = más urgente)
    private LocalDate deadline;       // Fecha límite de entrega

    // Constructor
    public Task(int id, String descripcion, Estado estado, int prioridad, LocalDate deadline) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.deadline = deadline;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // Implementación del orden natural (por ID ascendente, como ejemplo base)
    @Override
    public int compareTo(Task otra) {
        return Integer.compare(this.id, otra.id);
    }

    // toString para facilitar impresión en consola
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", prioridad=" + prioridad +
                ", deadline=" + deadline +
                '}';
    }
}
