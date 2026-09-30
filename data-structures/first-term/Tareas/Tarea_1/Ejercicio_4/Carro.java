// Clase Carro que hereda de Vehiculo
public class Carro<T> extends Vehiculo<Carro> {
    // Constructor de la clase Carro
    public Carro(String marca, String placa, String color) {
        super(marca, placa, color);
    }

    // Método encender() para Carro
    @Override
    public void encender() {
        System.out.println("El carro está encendido.");
    }
}
