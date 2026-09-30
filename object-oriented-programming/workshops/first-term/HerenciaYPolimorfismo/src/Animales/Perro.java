package Animales;

public class Perro extends Animal {
    private String Raza;

    public Perro(String nombre, String Raza){
        super(nombre);
        this.Raza = Raza;
    }

    // Sobreescritura de método heredado
    @Override
    public void hacerSonido(){
        System.out.println("Sonido de Perro: Guau!");
    }

    public void mostrarInfo(){
        System.out.println("El nombre es: " + nombre);
        System.out.println("La raza es: " + Raza);

    }
    public void cazar(){
        System.out.println("Perro Cazador");
    }
}
