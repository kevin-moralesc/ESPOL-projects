    import java.util.*;

    public class AnalisisJuegos {

        public static List<String> obtenerJuegosMasRentables(
                Map<String, Integer> mapaVentas,
                Map<String, Double> mapaPrecios,
                int n) {

            // Validaciones de entrada
            if (mapaVentas == null || mapaPrecios == null || n <= 0) {
                return Collections.emptyList();
            }

            // Lista temporal para guardar (codigo, ingresos)
            class JuegoIngreso {
                String codigo;
                double ingresos;

                JuegoIngreso(String codigo, double ingresos) {
                    this.codigo = codigo;
                    this.ingresos = ingresos;
                }
            }

            List<JuegoIngreso> lista = new ArrayList<>();

            /*
            * Recorremos las claves de uno de los mapas (por ejemplo, mapaVentas)
            * y solo consideramos los códigos que existen en ambos mapas.
            */
            for (String codigo : mapaVentas.keySet()) {
                Integer ventas = mapaVentas.get(codigo);
                Double precio = mapaPrecios.get(codigo);

                if (ventas != null && precio != null) {
                    double ingresos = ventas * precio;
                    lista.add(new JuegoIngreso(codigo, ingresos));
                }
            }

            // Ordenar por ingresos (descendente) y, en caso de empate,
            // por código (ascendente, determinista).
            lista.sort(
                    Comparator
                            .comparingDouble((JuegoIngreso ji) -> ji.ingresos)
                            .reversed()
                            .thenCom    import java.util.*;

    public class AnalisisJuegos {

        public static List<String> obtenerJuegosMasRentables(
                Map<String, Integer> mapaVentas,
                Map<String, Double> mapaPrecios,
                int n) {

            // Validaciones de entrada
            if (mapaVentas == null || mapaPrecios == null || n <= 0) {
                return Collections.emptyList();
            }

            // Lista temporal para guardar (codigo, ingresos)
            class JuegoIngreso {
                String codigo;
                double ingresos;

                JuegoIngreso(String codigo, double ingresos) {
                    this.codigo = codigo;
                    this.ingresos = ingresos;
                }
            }

            List<JuegoIngreso> lista = new ArrayList<>();

            /*
            * Recorremos las claves de uno de los mapas (por ejemplo, mapaVentas)
            * y solo consideramos los códigos que existen en ambos mapas.
            */
            for (String codigo : mapaVentas.keySet()) {
                Integer ventas = mapaVentas.get(codigo);
                Double precio = mapaPrecios.get(codigo);

                if (ventas != null && precio != null) {
                    double ingresos = ventas * precio;
                    lista.add(new JuegoIngreso(codigo, ingresos));
                }
            }

            // Ordenar por ingresos (descendente) y, en caso de empate,
            // por código (ascendente, determinista).
            lista.sort(
                    Comparator
                            .comparingDouble((JuegoIngreso ji) -> ji.ingresos)
                            .reversed()
                            .thenComparing(ji -> ji.codigo)
            );

            // Construir la lista de resultado con los códigos de los top n
            List<String> resultado = new ArrayList<>();
            int limite = Math.min(n, lista.size());

            for (int i = 0; i < limite; i++) {
                resultado.add(lista.get(i).codigo);
            }

            return resultado;
        }

        // (Opcional) método main para pruebas rápidas
        public static void main(String[] args) {
            Map<String, Integer> ventas = new HashMap<>();
            ventas.put("G001", 300);
            ventas.put("G002", 150);
            ventas.put("G003", 500);
            ventas.put("G004", 200);
            ventas.put("G005", 350);

            Map<String, Double> precios = new HashMap<>();
            precios.put("G001", 15.0);
            precios.put("G002", 25.0);
            precios.put("G003", 10.0);
            precios.put("G004", 20.0);
            precios.put("G005", 12.0);

            List<String> top3 = obtenerJuegosMasRentables(ventas, precios, 3);
            System.out.println("Top 3 juegos más rentables: " + top3);
        }
    }
paring(ji -> ji.codigo)
            );

            // Construir la lista de resultado con los códigos de los top n
            List<String> resultado = new ArrayList<>();
            int limite = Math.min(n, lista.size());

            for (int i = 0; i < limite; i++) {
                resultado.add(lista.get(i).codigo);
            }

            return resultado;
        }

        // (Opcional) método main para pruebas rápidas
        public static void main(String[] args) {
            Map<String, Integer> ventas = new HashMap<>();
            ventas.put("G001", 300);
            ventas.put("G002", 150);
            ventas.put("G003", 500);
            ventas.put("G004", 200);
            ventas.put("G005", 350);

            Map<String, Double> precios = new HashMap<>();
            precios.put("G001", 15.0);
            precios.put("G002", 25.0);
            precios.put("G003", 10.0);
            precios.put("G004", 20.0);
            precios.put("G005", 12.0);

            List<String> top3 = obtenerJuegosMasRentables(ventas, precios, 3);
            System.out.println("Top 3 juegos más rentables: " + top3);
        }
    }
