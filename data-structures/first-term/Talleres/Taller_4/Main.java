public class Main {
    public static void main(String[] args) {
        // Creamos el scheduler
        EventScheduler scheduler = new EventScheduler(OrderCriteria.BY_IMPORTANCE_DATE);

        scheduler.scheduleEvent(new Event(1, "Examen final", 5, , "2026-06-20"));
        scheduler.scheduleEvent(new Event(2, "Entrega Taller", 3,, "2026-06-21"));
        scheduler.scheduleEvent(new Event(3, "Proyecto Critico", 5, ,"2026-06-19")); 

        // Intentar agregar un ID duplicado
        scheduler.scheduleEvent(new Event(1, "Duplicado", 1, "2026-06-30"));

        System.out.println("\n--- Procesando Eventos ---");
        
        // Saldrá primero el Proyecto Crítico (Importancia 5, fecha más cercana: 19)
        Event e1 = scheduler.getNextEvent();
        System.out.println("Siguiente: " + e1);

        // Saldrá el Examen Final (Importancia 5, fecha: 20)
        Event e2 = scheduler.getNextEvent();
        System.out.println("Siguiente: " + e2);

        // Completamos el evento restante por ID (pasamos el id directamente)
        scheduler.markAsCompleted(2);
        
        // Al pedir el siguiente, saldrá el evento 2 pero ya verás que su estado cambió a COMPLETED en el mapa
        System.out.println("Siguiente evento extraído: " + scheduler.getNextEvent());
    }
}