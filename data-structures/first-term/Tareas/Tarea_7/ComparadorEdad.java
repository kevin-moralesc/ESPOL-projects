
import java.util.Comparator;

public class ComparadorEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Si la persona de la lista tiene menos de 18, nos sirve
        if (p1.getEdad() < 18) {
            return 0; // Regresa 0 para decir "esta cumple el filtro"
        }
        return -1;
    }
}