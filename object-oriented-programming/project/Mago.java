import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mago extends Personaje {

    public Mago(String n, int v, int a, int d, Equipo equipo) {
        super(n, v, a, d, equipo);
    }

    // Estrategia del Mago:
    // Cura a un aliado vivo aleatorio con el 25% de la vida actual del Mago,
    // sin pasarse de la vida máxima del aliado.
    @Override
    public void usarEstrategia(java.util.Scanner sc) { 
        List<Personaje> objetivosVivos = new ArrayList<Personaje>();
        
        // aliados vivos de miEquipo
        Personaje[] aliados = this.miEquipo.getPersonajes();
        for (int i = 0; i < aliados.length; i++) {
            if (aliados[i].getVida() > 0) {
                objetivosVivos.add(aliados[i]);
            }
        }

        if (objetivosVivos.isEmpty()) {
            System.out.println(this.getNombre() + " (Mago) no encuentra aliados vivos para curar.");
            return;
        }

        Random rand = new Random();
        int indiceAleatorio = rand.nextInt(objetivosVivos.size());
        Personaje objetivoCuracion = objetivosVivos.get(indiceAleatorio);
        
        int curacion = (int) (this.vida * 0.25); 
        int vidaAntes = objetivoCuracion.getVida();
        int nuevaVida = vidaAntes + curacion;

        objetivoCuracion.setVida(nuevaVida); 
        
        System.out.println(this.getNombre() + " (Mago) activa: CURACION");
        System.out.println("Cura a " + objetivoCuracion.getNombre() + " por " + curacion + " PV.");
        System.out.println("Vida de " + objetivoCuracion.getNombre() + ": " 
                           + vidaAntes + " -> " + objetivoCuracion.getVida() 
                           + " / " + objetivoCuracion.getVidaMax());
    }
}
