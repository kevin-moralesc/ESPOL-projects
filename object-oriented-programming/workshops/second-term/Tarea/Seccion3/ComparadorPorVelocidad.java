package POO.Tarea.Seccion3;
import java.util.Comparator;

public class ComparadorPorVelocidad implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        return Integer.compare(
            v2.getVelocidadMaxima(),
            v1.getVelocidadMaxima()
        );
    }
}
