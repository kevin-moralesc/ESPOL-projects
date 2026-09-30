// Clase que representa un evento
public class Event implements Comparable<Event> {

    private int id;                   // Identificador
    private String title;             
    private EventState estado;        // Estado actual (PENDING, IN_PROGRESS, COMPLETED)
    private int importancia;          // Importancia (mayor valor = más prioritario)
    private String fecha;          // Fecha del evento

    // Constructor
    public Event(int id, String title,EventState estado, int importancia, String fecha) {
        this.id = id;
        this.title = title;
        this.estado = EventState.PENDING; // Estado inicial por defecto
        this.importancia = importancia;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EventState getEstado() {
        return estado;
    }

    public void setEstado(EventState estado) {
        this.estado = estado;
    }

    public int getImportancia() {
        return importancia;
    }

    public String getFecha() {
        return fecha;
    }

    // Comparador(por ID ascendente)
    @Override
    public int compareTo(Event otro) {
        return Integer.compare(this.id, otro.id);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", estado=" + estado +
                ", importancia=" + importancia +
                ", fecha=" + fecha +
                '}';
    }
}