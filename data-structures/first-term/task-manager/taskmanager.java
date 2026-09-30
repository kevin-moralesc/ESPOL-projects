import java.util.*;

// Clase principal que administra tareas
public class TaskManager {

    // Cola de prioridad para ordenar tareas
    private PriorityQueue<Task> queue;

    // Mapa para acceder rápidamente a tareas por su ID
    private Map<Integer, Task> taskMap;

    // Constructor
    public TaskManager(OrderCriteria criteria) {
        // Inicializamos el mapa
        taskMap = new HashMap<>();

        // Inicializamos la cola de prioridad con el comparador adecuado
        if (criteria == OrderCriteria.NATURAL) {
            queue = new PriorityQueue<>(); // Usará compareTo() de Task
        } else {
            // Comparador personalizado: primero por prioridad descendente, luego por deadline ascendente
            queue = new PriorityQueue<>(
                Comparator.comparingInt(Task::getPrioridad).reversed()
                          .thenComparing(Task::getDeadline)
            );
        }
    }

    // Agrega una nueva tarea a ambas estructuras
    public void addTask(Task task) {
        queue.add(task);             // Agrega a la cola de prioridad
        taskMap.put(task.getId(), task); // Registra en el mapa por ID
    }

    // Obtiene y marca como EN_PROGRESO la siguiente tarea
    public Task getNextTask() {
        Task next = queue.poll();  // Obtiene y remueve la tarea más prioritaria

        if (next != null) {
            next.setEstado(Estado.EN_PROGRESO);  // Marca como en progreso
        }

        return next;
    }

    // Marca una tarea como COMPLETADA usando el ID
    public void completeTask(int taskId) {
        Task task = taskMap.get(taskId); // Acceso en O(1) gracias al mapa

        if (task != null) {
            task.setEstado(Estado.COMPLETADA);  // Cambia el estado
        }
    }
}
