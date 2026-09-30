import java.util.*;

// Clase principal que administra eventos
public class EventScheduler {

    // Cola de prioridad para ordenar eventos
    private PriorityQueue<Event> queue;

    // Mapa para acceder rápidamente a eventos por su ID
    private Map<Integer, Event> eventMap;

    // Constructor
    public EventScheduler(OrderCriteria criteria) {
        // Inicializamos el mapa
        eventMap = new HashMap<>();

        // Inicializamos la cola de prioridad con el comparador adecuado
        if (criteria == OrderCriteria.BY_ID) {
            queue = new PriorityQueue<>(); // Usará compareTo() natural de Event (por ID)
        } else {
            // Comparador personalizado: primero por importancia descendente, luego por fecha ascendente
            queue = new PriorityQueue<>(
                Comparator.comparingInt(Event::getImportancia).reversed()
                          .thenComparing(Event::getFecha)
            );
        }
    }

    // Agrega un nuevo evento a ambas estructuras
    public void scheduleEvent(Event event) {
        if (event == null) return;

        // Restricción: No se deben duplicar eventos con el mismo ID
        if (eventMap.containsKey(event.getId())) {
            System.out.println("Error: Ya existe un evento con el ID " + event.getId());
            return;
        }

        queue.add(event);             // Agrega a la cola de prioridad en O(log n)
        eventMap.put(event.getId(), event); // Registra en el mapa por ID en O(1)
    }

    // Obtiene y marca como IN_PROGRESS el siguiente evento
    public Event getNextEvent() {
        Event next = queue.poll();  // Obtiene y remueve el evento más prioritario en O(log n)

        if (next != null) {
            next.setEstado(EventState.IN_PROGRESS);  // Marca como en progreso
        }

        return next;
    }

    // Marca un evento como COMPLETED usando el ID
    public void markAsCompleted(int eventId) {
        Event event = eventMap.get(eventId); // Acceso en O(1) gracias al mapa

        if (event != null) {
            event.setEstado(EventState.COMPLETED);  // Cambia el estado a COMPLETED
        } else {
            System.out.println("Error: No se encontró el evento con ID " + eventId);
        }
    }
}