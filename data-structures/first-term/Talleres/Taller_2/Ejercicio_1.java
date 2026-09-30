import java.util.HashMap;
import java.util.Map; 

public class Ejercicio_1 {
    public static void main(String[] args) {
        
        //Crear un mapa para almacenar estudiantes.
        Map<String, String> estudiantes = new HashMap<>();

        //Registrar al menos 5 estudiantes.
        estudiantes.put("202412128", "Kevin Morales");
        estudiantes.put("202412129", "Maria Perez");
        estudiantes.put("202412130", "Juan Gomez");
        estudiantes.put("202412131", "Ana Rodriguez");
        estudiantes.put("202412132", "Luis Fernandez");

        //Buscar un estudiante mediante su matrícula.
        String matriculaBuscar = "202412128";
        if (estudiantes.containsKey(matriculaBuscar)) {
            System.out.println("El estudiante con matrícula " + matriculaBuscar + " es: " + estudiantes.get(matriculaBuscar));
        } else {
            System.out.println("La matrícula " + matriculaBuscar + " no existe");
        }

        //Actualizar el nombre de un estudiante existente.
        String matriculaActualizar = "202412128";
        if (estudiantes.containsKey(matriculaActualizar)) {
            estudiantes.put(matriculaActualizar, "Javier Morales");
            System.out.println("Matrícula " + matriculaActualizar + " actualizada a Javier Morales.");
        }

        //Eliminar un estudiante del mapa.
        String matriculaEliminar = "202412132";
        if (estudiantes.containsKey(matriculaEliminar)) {
            estudiantes.remove(matriculaEliminar);
            System.out.println("Estudiante con matrícula " + matriculaEliminar + " borrado");
        } else {
            System.out.println("No se pudo eliminar porque la matrícula " + matriculaEliminar + " no existe.");
        }

        //Mostrar todos los estudiantes registrados.
        System.out.println("\nEstudiantes registrados:");
        for (Map.Entry<String, String> es : estudiantes.entrySet()) {
            System.out.println("Matrícula: " + es.getKey() + ", Nombre: " + es.getValue());
        }

        //Mostrar la cantidad total de estudiantes.
        System.out.println("Cantidad total de estudiantes: " + estudiantes.size()); 
    }
}