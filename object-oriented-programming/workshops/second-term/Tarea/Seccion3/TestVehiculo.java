package POO.Tarea.Seccion3;
import java.util.ArrayList;
import java.util.List;

public class TestVehiculo {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Auto("Toyota", 180));
        vehiculos.add(new Moto("Yamaha", 220));
        vehiculos.add(new Auto("Chevrolet", 200));
        vehiculos.add(new Moto("Honda", 210));

        vehiculos.sort(new ComparadorPorVelocidad());
        for (Vehiculo v : vehiculos) {
            System.out.println(
                v.getMarca() + " - Velocidad: " + v.getVelocidadMaxima()
            );
        }
    }
}

