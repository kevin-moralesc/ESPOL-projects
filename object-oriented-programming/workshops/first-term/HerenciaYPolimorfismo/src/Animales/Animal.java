package Animales;

public class Animal {
    protected String nombre;

    public Animal(String nombre){
        this.nombre = nombre;
    }

    public void mostrarInfo(){
        System.out.println("El nombre es:" + nombre);
    }

    public void hacerSonido(){
        System.out.println("Sonido de Animal");
    }
}
