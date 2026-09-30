import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlataformaCursos {

    public static List<String> obtenerCursosMasRentables(
            Map<String, Integer> mapaInscripciones, 
            Map<String, Double> mapaPrecios, 
            int n) {
        
        if (mapaInscripciones == null || mapaPrecios == null || n <= 0) {
            return new ArrayList<String>();
        }

        //  HashMap normal para calcular y guardar temporalmente los ingresos de cada curso
        HashMap<String, Double> mapaIngresos = new HashMap<String, Double>();

        for (String codigo : mapaInscripciones.keySet()) {
            if (mapaPrecios.containsKey(codigo)) {
                int inscripciones = mapaInscripciones.get(codigo);
                double precio = mapaPrecios.get(codigo);
                
                double ingresos = inscripciones * precio;
                mapaIngresos.put(codigo, ingresos);
            }
        }

        //  comparador para ordenar por ingresos 
        Comparator<String> comparadorRentabilidad = new Comparator<String>() {
            @Override
            public int compare(String curso1, String curso2) {
                double ingresos1 = mapaIngresos.get(curso1);
                double ingresos2 = mapaIngresos.get(curso2);

                // CMayor a menor ingresos (Descendente)
                if (ingresos1 > ingresos2) {
                    return -1; // curso1 va primero por tener más ingresos
                } else if (ingresos1 < ingresos2) {
                    return 1;  // curso2 va primero por tener más ingresos
                } else {
                    // Si hay empate, orden alfabético ascendente del código
                    return curso1.compareTo(curso2);
                }
            }
        };

        // Pasamos los datos a un TreeMap que se ordena solo gracias al comparador
        TreeMap<String, Double> cursosOrdenados = new TreeMap<String, Double>(comparadorRentabilidad);
        
        // Al hacer el put, el TreeMap ejecuta tu comparador automáticamente
        for (Map.Entry<String, Double> es : mapaIngresos.entrySet()) {
            cursosOrdenados.put(es.getKey(), es.getValue());
        }

        //  Extraer los primeros 'n' elementos usando un bucle tradicional
        List<String> resultadoFinal = new ArrayList<String>();
        
        int contador = 0;
        for (Map.Entry<String, Double> es : cursosOrdenados.entrySet()) {
            if (contador < n) {
                resultadoFinal.add(es.getKey());
                contador++;
            } else {
                break; // Ya completamos los 'n' elementos, salimos del ciclo
            }
        }

        return resultadoFinal;

    }
public static void main(String[] args) {

Map<String, Integer> inscripciones = new HashMap<>();
    inscripciones.put("C001", 50);
    inscripciones.put("C002", 30);
    inscripciones.put("C003", 80);
    inscripciones.put("C004", 40);
    inscripciones.put("C005", 60);

Map<String, Double> precios = new HashMap<>();
    precios.put("C001", 40.0);
    precios.put("C002", 55.0);
    precios.put("C003", 30.0);
    precios.put("C004", 35.0);
    precios.put("C005", 25.0);
    int n = 4;
    List<String> top = obtenerCursosMasRentables(inscripciones, precios, n);
System.out.println("Los "+n+ " cursos más rentables: " + top);


}


}