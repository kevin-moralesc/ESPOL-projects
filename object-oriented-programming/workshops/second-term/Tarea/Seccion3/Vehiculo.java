package POO.Tarea.Seccion3;
import java.util.Objects;

public abstract class Vehiculo {

    protected String marca;
    protected int velocidadMaxima;

    public Vehiculo(String marca, int velocidadMaxima) {
        this.marca = marca;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getMarca() {
        return marca;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehiculo)) return false;
        Vehiculo v = (Vehiculo) obj;
        return marca.equals(v.marca) &&
               velocidadMaxima == v.velocidadMaxima;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, velocidadMaxima);
    }
}
