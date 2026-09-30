package Aplicacion;
import Animales.Animal;
import Animales.Gato;
import Animales.Perro;  



public class Registro {
    public static void main(String[] args) {
       Animal [] reg = new Animal [3];
       reg[0] = new Animal ("Generico");
       reg[1] = new Perro ("tobi", "doberman" );
    reg[2] = new Gato ("manchas", "cafe");
    for(Animal iterador: reg){
        iterador.hacerSonido();
        if (iterador instanceof Perro){
            ((Perro)iterador).cazar();}
            else if (iterador instanceof Gato){
                ((Gato)iterador).trepar();
            }
    }

}
}
