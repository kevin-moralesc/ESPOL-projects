import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;
public class Ejercicio_4 {


public static void main(String[]args){
// Cree un programa que almacene estudiantes en un TreeMap.
// La clave será la matrícula y el valor será el nombre del estudiante.

// Requerimientos
// Registrar al menos 5 estudiantes.
TreeMap<String, String> estudiantes = new TreeMap<>();
estudiantes.put("202412128", "Kevin Morales");
estudiantes.put("202412129", "María García");
estudiantes.put("202412130", "Carlos López");
estudiantes.put("202412131", "Ana Martínez");
estudiantes.put("202412132", "Luis Rodríguez");

// Mostrar los estudiantes ordenados de forma ascendente por matrícula.
System.out.println("Estudiantes ordenados por matrícula (ascendente):");
for (Map.Entry<String, String> es : estudiantes.entrySet()) {
    System.out.println("Matrícula: " + es.getKey() + ", Nombre: " + es.getValue());
}

Comparator<String> comparadorDescendente = new Comparator<String>() {
    @Override
    public int compare(String matricula1, String matricula2) {
        // El comparador compara las matrículas en orden descendente.
        // Si matricula1 es mayor que matricula2, devuelve un valor negativo para invertir el orden.
        return matricula2.compareTo(matricula1);
    }
};

TreeMap<String, String> estudiantesDescendente = new TreeMap<>(comparadorDescendente);
for (Map.Entry<String, String> es : estudiantes.entrySet()) {
    estudiantesDescendente.put(es.getKey(), es.getValue());
}

System.out.println("\nEstudiantes ordenados por matrícula (descendente):");
for (Map.Entry<String, String> es : estudiantesDescendente.entrySet()) {
    System.out.println("Matrícula: " + es.getKey() + ", Nombre: " + es.getValue());


}

    
}}