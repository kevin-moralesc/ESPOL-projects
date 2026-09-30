package POO.Tarea.Seccion4;
import java.util.Objects;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto)) return false;
        Producto p = (Producto) obj;
        return codigo.equals(p.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
