
public class Persona {
    //Atributos
    private String nombre;
    private int edad;
    private String ciudad;

    // Constructor
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters necesarios para que los comparadores puedan revisar los datos
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }

    // para poder imprimir el objeto de forma bonita en la consola
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + ", ciudad='" + ciudad + "'}";
    }
}