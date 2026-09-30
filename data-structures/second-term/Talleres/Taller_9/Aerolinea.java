import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Aerolinea {

    // Clase auxiliar para manejar la información de cada ruta y poder ordenarla
    static class Ruta implements Comparable<Ruta> {
        String codigo;
        double ingresos;

        public Ruta(String codigo, double ingresos) {
            this.codigo = codigo;
            this.ingresos = ingresos;
        }

        @Override
        public int compareTo(Ruta otra) {
            // Ingresos en orden descendente (mayor a menor)
            int comparacionIngresos = Double.compare(otra.ingresos, this.ingresos);
            if (comparacionIngresos != 0) {
                return comparacionIngresos;
            }
            // En caso de empate, código ascendente (orden lexicográfico)
            return this.codigo.compareTo(otra.codigo);
        }
    }

    // Método principal que pide la tarea
    public static List<String> obtenerRutasMasRentables(
            Map<String, Integer> boletosVendidos, 
            Map<String, Double> tarifas, 
            int n) {

        // Manejo de casos borde requeridos en la rúbrica (n <= 0 o mapas vacíos)
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        boolean boletosVacios = (boletosVendidos == null || boletosVendidos.isEmpty());
        boolean tarifasVacias = (tarifas == null || tarifas.isEmpty());
        
        if (boletosVacios && tarifasVacias) {
            return new ArrayList<>();
        }

        // Obtener todos los códigos únicos de ambos mapas
        Set<String> codigosUnicos = new HashSet<>();
        if (!boletosVacios) {
            codigosUnicos.addAll(boletosVendidos.keySet());
        }
        if (!tarifasVacias) {
            codigosUnicos.addAll(tarifas.keySet());
        }

        List<Ruta> listaRutas = new ArrayList<>();

        // Calcular ingresos para cada código único
        for (String codigo : codigosUnicos) {
            // Si falta el dato en algún mapa, se asume como 0
            int boletos = (!boletosVacios && boletosVendidos.containsKey(codigo)) ? boletosVendidos.get(codigo) : 0;
            double tarifa = (!tarifasVacias && tarifas.containsKey(codigo)) ? tarifas.get(codigo) : 0.0;

            // Fórmula de ingresos: tarifa * boletosVendidos
            double ingresos = tarifa * boletos;
            listaRutas.add(new Ruta(codigo, ingresos));
        }

        // Ordenar según los criterios definidos
        Collections.sort(listaRutas);

        // Extraer solo los códigos de las n rutas más rentables
        List<String> topRutas = new ArrayList<>();
        int limite = Math.min(n, listaRutas.size()); // Previene errores si piden un 'n' mayor al total de rutas
        for (int i = 0; i < limite; i++) {
            topRutas.add(listaRutas.get(i).codigo);
        }

        return topRutas;
    }

    public static void main(String[] args) {
        // Datos de ejemplo (puedes reutilizar los del enunciado HTML)
        Map<String, Integer> boletosVendidos = new HashMap<>();
        boletosVendidos.put("R-QUI-GYE", 180);
        boletosVendidos.put("R-GYE-MEC", 120);
        boletosVendidos.put("R-UIO-BOG", 220);
        boletosVendidos.put("R-GYE-LIM", 90);
        boletosVendidos.put("R-UIO-MAD", 70);

        Map<String, Double> tarifas = new HashMap<>();
        tarifas.put("R-QUI-GYE", 95.00);
        tarifas.put("R-GYE-MEC", 120.00);
        tarifas.put("R-UIO-BOG", 80.00);
        tarifas.put("R-GYE-LIM", 180.00);
        tarifas.put("R-UIO-MAD", 750.00);

        // Queremos el top 3
        int n = 3;

        // Invocación del método
        List<String> top3 = obtenerRutasMasRentables(boletosVendidos, tarifas, n);

        // Impresión de ejemplo (solo para verificar)
        System.out.println("Top " + n + " rutas más rentables: " + top3);
    }
}