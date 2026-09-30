package POO.Tarea.Seccion2;
public class Estudiante {
    private String nombre;
    private double notaFinal;
    private int edad;

    public Estudiante(String nombre, double notaFinal, int edad) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public int getEdad() {
        return edad;
    }
}
