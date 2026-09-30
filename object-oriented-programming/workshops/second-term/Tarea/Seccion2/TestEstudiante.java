package POO.Tarea.Seccion2;
import java.util.*;

public class TestEstudiante {
    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Jeremy", 9.5, 20));
        estudiantes.add(new Estudiante("Kevin", 8.0, 22));
        estudiantes.add(new Estudiante("Carlos", 7.8, 19));
        estudiantes.add(new Estudiante("Piero", 9.0, 21));
        estudiantes.add(new Estudiante("Pedro", 6.5, 23));

        estudiantes.sort((e1, e2) -> 
            Double.compare(e2.getNotaFinal(), e1.getNotaFinal())
        );

        System.out.println("Ordenados por nota:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - " + e.getNotaFinal());
        }
        estudiantes.sort((e1, e2) -> 
            Integer.compare(e1.getEdad(), e2.getEdad())
        );

        System.out.println("\nOrdenados por edad:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - " + e.getEdad());
        }
    }
}

