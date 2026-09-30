public class Vehiculo {
    public double calcularConsumo(double km, double litros) {
        return km / litros;
    }

    public double calcularConsumo(double km) {
        return km / 10; // consumo estimado
    }
}
