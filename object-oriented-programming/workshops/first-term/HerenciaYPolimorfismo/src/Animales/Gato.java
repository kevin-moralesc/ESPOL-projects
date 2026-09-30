package Animales;

public class Gato extends Animal {
    private String ColorPelaje;

    public Gato(String nombre, String ColorPelaje) {
        super(nombre);
        this.ColorPelaje = ColorPelaje;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Sonido de Gato: Miau!");
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("El colorPelajes es: " + ColorPelaje);
    }

    public void trepar() {
        System.out.println("Gato trepador");
    }
}
