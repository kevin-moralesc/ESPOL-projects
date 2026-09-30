package Aplicacion;
import Animales.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Animal a1 = new Animal("mascota");
        Animal p1 = new Perro("Max", "Rottweiller");
        Animal g1 = new Gato("Katty Perry", "Blanco");

        //Invocar metodo
        a1.hacerSonido();
        p1.hacerSonido();
        g1.hacerSonido();

        //Invocar metodo especifico
        //p1.cazar(); no se puede invocar ningun metodo especifico con variable 
        //g1.trepar(); no se puede invocar ningun metodo especifico con variable 

        //Downcasting - ir de la calse padre a la clase hija usando cast explicito
        Perro pe1 = (Perro)p1; //Cast explicito 
        Gato ga1 = (Gato)g1; //Cast explicito 
        pe1.cazar();
        ga1.trepar();

        //((Perro)p1).cazar();  Downcasting
        //((Gato)g1).trepar(); 

        //Upcasting - es ir de una variable de referencia clase hija de forma implicita
        //Animal an1 = pe1;
        //Animal an2 = ga1;
        //an1.cazar();
        //an2.trepar();
        
        ArrayList<Animal> inventario = new ArrayList<>();
        inventario.add(new Animal("mascota"));
        inventario.add(new Perro("Max", "Rottweiller"));
        inventario.add(new Gato("Katty Perry", "Blanco"));
        
        inventario.get(0).hacerSonido();
        inventario.get(1).hacerSonido(); //Se aplica polimorfismo, en tiempo de ejecucicon se determina el metodo a ejecutar
        //inventario.get(1).mostrarInfo(); //Se aplica polimorfismo
        inventario.get(2).hacerSonido(); //Se aplica polimorfismo, en tiempo de ejecucicon se determina el metodo a ejecutar
        //inventario.get(2).mostrarInfo(); //Se aplica polimorfismo.

        //System.out.println();
        ((Perro)(inventario.get(1))).cazar(); //Enlace Dinamico, Cast Explicito Perro
        ((Gato)(inventario.get(2))).trepar(); //Enlace Dinamico, Cast Explicito Gato


    }
   

    

}
