TaskManager manager = new TaskManager(OrderCriteria.PRIORITY_DEADLINE);
manager.addTask(new Task(1, "Tarea 1", Estado.PENDIENTE, 3, LocalDate.of(2025, 6, 30)));
manager.addTask(new Task(2, "Tarea 2", Estado.PENDIENTE, 5, LocalDate.of(2025, 6, 25)));

Task siguiente = manager.getNextTask();  // Obtiene la de prioridad 5
manager.completeTask(siguiente.getId());
