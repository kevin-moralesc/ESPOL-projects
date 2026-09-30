import java.util.Random;

public class Mistico extends Personaje {
    
    private final int ataqueBase;

    public Mistico(String n, int v, int a, int d, Equipo equipo) {
        super(n, v, a, d, equipo);
        this.ataqueBase = a;
    }

    // Místico:
    // Tira un dado (1-6) y el usuario intenta adivinarlo.
    // Si acierta, el ataque = ataqueBase + suma de ataques de aliados vivos.
    // Si falla, ataca con ataqueBase.
    @Override
    public void usarEstrategia(java.util.Scanner sc) {
        this.setAtaque(this.ataqueBase); 
        Random rand = new Random();
        int dado = rand.nextInt(6) + 1;
        int prediccion = 0; 

        System.out.println("\n" + this.getNombre() + " (Místico) activa: HECHIZO DE AZAR");

        while (prediccion < 1 || prediccion > 6) {
            System.out.println("Adivina el número del dado (1-6) para obtener el poder de tu equipo.");
            System.out.print("Introduce tu predicción (1-6): ");
            
            if (sc.hasNextInt()) {
                prediccion = sc.nextInt(); 
                sc.nextLine();
            } else {
                sc.next();
                sc.nextLine();
                prediccion = 0;
            }
            
            if (prediccion < 1 || prediccion > 6) {
                System.out.println("[ERROR] El número debe estar entre 1 y 6. Inténtalo de nuevo.");
            }
        } 
                
        if (prediccion == dado) {
            int dañoAcumulado = 0;
            Personaje[] aliados = this.miEquipo.getPersonajes();
            for (int i = 0; i < aliados.length; i++) {
                 if (aliados[i].getVida() > 0) {
                      dañoAcumulado = dañoAcumulado + aliados[i].getAtaque();
                 }
            }

            int nuevoAtaque = this.ataqueBase + dañoAcumulado;
            this.setAtaque(nuevoAtaque);
            
            System.out.println("*** ¡ÉXITO! El dado fue " + dado + ". ***");
            System.out.println("Ataque del Místico aumenta a: " + this.getAtaque());
        } else {
            System.out.println("*** FALLO. El dado fue " + dado + ". ***");
            System.out.println("El Místico atacará con su ataque base: " + this.ataqueBase);
            this.setAtaque(this.ataqueBase);
        }
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }
}

