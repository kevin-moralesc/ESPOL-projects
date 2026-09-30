
// Clase Moto que hereda de Vehiculo
public class Moto<T> extends Vehiculo<Moto> {
    // Constructor de la clase Moto
    public Moto(String marca, String placa, String color) {
        super(marca, placa, color);
    }
    // Método para encender la moto
    @Override
    public void encender() {
        System.out.println("La moto está encendida.");
    }
    
}
