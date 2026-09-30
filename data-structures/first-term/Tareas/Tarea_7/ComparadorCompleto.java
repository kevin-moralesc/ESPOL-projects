
import java.util.Comparator;

public class ComparadorCompleto implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Compara campo por campo
        if (p1.getNombre().equalsIgnoreCase(p2.getNombre()) && 
            p1.getEdad() == p2.getEdad() && 
            p1.getCiudad().equalsIgnoreCase(p2.getCiudad())) {
            return 0; //  si sale 0 son iguales
        }
        return -1; // No son iguales
    }
}