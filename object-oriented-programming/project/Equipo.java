import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Equipo {
    
    private String nombre;
    List<Personaje> personajes; 

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.personajes = new ArrayList<Personaje>();
    }

    public void agregarPersonaje(Personaje p) {
        this.personajes.add(p);
    }

    public Personaje[] getPersonajes() {
        return personajes.toArray(new Personaje[0]); 
    }
    
    // En cada ronda se enfrentan personajes vivos en orden:
    // vivoA[0] vs vivoB[0], vivoA[1] vs vivoB[1], ...
    
    public void atacarOtroEquipo(Equipo otroEquipo, Scanner sc) { 
        // 1) Listas de personajes vivos de ambos equipos
        List<Personaje> vivosAtacante = new ArrayList<Personaje>();
        List<Personaje> vivosDefensor = new ArrayList<Personaje>();

        for (int i = 0; i < this.personajes.size(); i++) {
            Personaje p = this.personajes.get(i);
            if (p.getVida() > 0) {
                vivosAtacante.add(p);
            }
        }

        for (int i = 0; i < otroEquipo.personajes.size(); i++) {
            Personaje p = otroEquipo.personajes.get(i);
            if (p.getVida() > 0) {
                vivosDefensor.add(p);
            }
        }

        if (vivosAtacante.isEmpty()) {
            System.out.println("[" + this.nombre + "] no tiene personajes vivos para atacar.");
            return;
        }

        if (vivosDefensor.isEmpty()) {
            System.out.println("[" + otroEquipo.nombre + "] ya está completamente derrotado.");
            return;
        }

        // número de enfrentamientos
        int limiteAtaque = vivosAtacante.size();
        if (vivosDefensor.size() < limiteAtaque) {
            limiteAtaque = vivosDefensor.size();
        }

        System.out.println("\n>>> Ataca el equipo [" + this.nombre + "]");

        for (int i = 0; i < limiteAtaque; i++) {
            Personaje atacante = vivosAtacante.get(i);
            Personaje defensor = vivosDefensor.get(i);

            System.out.println("\n[ENFRENTAMIENTO " + (i + 1) + "]");
            System.out.println("[" + this.nombre + "] " + atacante.getNombre() + 
                               " VS [" + otroEquipo.nombre + "] " + defensor.getNombre());

            // Activar estrategia y atacar
            atacante.realizarAtaque(defensor, sc);

            // Restaurar ataques si es Guerrero o Místico
            if (atacante instanceof Guerrero) {
                Guerrero g = (Guerrero) atacante;
                atacante.setAtaque(g.getAtaqueBase());
            } else if (atacante instanceof Mistico) {
                Mistico m = (Mistico) atacante;
                atacante.setAtaque(m.getAtaqueBase());
            }

            if (defensor.getVida() <= 0) {
                System.out.println(">> " + defensor.getNombre() + " ha sido DERROTADO.");
            }
        }
    }
    
    //Método que verifica si el equipo ha sido derrotado.
    public boolean estaDerrotado() {
        for (int i = 0; i < this.personajes.size(); i++) {
            Personaje p = this.personajes.get(i);
            if (p.getVida() > 0) {
                return false; 
            }
        }
        return true; 
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaTotalRestante() {
        int vidaTotal = 0;
        for (int i = 0; i < this.personajes.size(); i++) {
            vidaTotal = vidaTotal + this.personajes.get(i).getVida();
        }
        return vidaTotal;
    }
}
