import java.util.ArrayList;

public class Array_Ejercicio2 {
    public static void main(String[] args) {
        String registro = "15.8-18.9;16.6-19.2;15.5-21.2;14.8-20.1;16.2-18.9;15.4-19.5";
        ArrayList<Double> difTemperatura = new ArrayList<>();

        String[] equipos = registro.split(";");

        for (String equipo : equipos) {
            String[] temps = equipo.split("-");
            double tempInicial = Double.parseDouble(temps[0]);
            double tempFinal = Double.parseDouble(temps[1]);

            double diferencia = tempFinal - tempInicial;
            difTemperatura.add(diferencia);
        }

        System.out.println(difTemperatura);
        System.out.println("Diferencias de temperatura:");

        for (double dif : difTemperatura) {
            System.out.println(dif);
        }
        // Métodos para convertir de String a Double:

        // 1.
        // double num1 = Double.parseDouble("18.2");
        // 2.
        // Double num2 = Double.valueOf("13.32");
    }
}
