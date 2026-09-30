public abstract class Personaje {
    // Atributos
    private String nombre;
    protected int vida;
    protected int vidaMax;    
    protected int ataque;
    protected int defensa;
    protected Equipo miEquipo;
    
    // Constructor
    public Personaje(String n, int v, int a, int d, Equipo equipo) {
        this.nombre = n;
        this.vida = v;
        this.vidaMax = v;   // al inicio ----> vida máxima = vida inicial
        this.ataque = a;
        this.defensa = d;
        this.miEquipo = equipo;
    }
    
    // método recibir Ataque 
    public void recibirAtaque(int dano) {
        // daño real = daño - defensa (no negativo)
        int danoReal = dano - this.defensa;
        if (danoReal < 0) {
            danoReal = 0;
        }

        int vidaAntes = this.vida;
        this.vida = this.vida - danoReal;

        if (this.vida < 0) {
            this.vida = 0;
        }

        System.out.println(this.nombre + " recibe " + danoReal + " de daño.");
        System.out.println("Vida de " + this.nombre + ": " + vidaAntes + " -> " + this.vida);
    }
    //NUEVO METODO
    public boolean esquivar(){
        double probabilidad= Math.random();
        if (probabilidad <= 0.5) {
            return true;
        } else {    
            return false;
        }
    }
    
    // Método realizar Ataque y aca se incluye el esquivar
    public void realizarAtaque(Personaje contrario, java.util.Scanner sc) { 
        
        System.out.println("\n--- Turno de ataque de " + this.nombre + " ---");

        // Verificar si el contrario logra esquivar
        if (contrario.esquivar()) {
            // Si esquiva no hay daño y no se activa la estrategia.
            System.out.println("*******" + contrario.getNombre() + " (" + contrario.miEquipo.getNombre() + ") ha ESQUIVADO el ataque!");
            
        } else {
            //Si no lo esquiva entonces se activa la habilidad y se realiza el ataque
            // Activar la estrategia (Furia, Curación, Hechizo de Azar)
            usarEstrategia(sc); 
            //  Enviar el ataque al contrario
            System.out.println(this.nombre + " ataca con " + this.ataque + " ptos de ataque.");
            contrario.recibirAtaque(this.ataque); 
        }
    }



    // método abstracto usarEstrategia() (Acepta Scanner)
    public abstract void usarEstrategia(java.util.Scanner sc); 
    
    // GETTERS y SETTERS
    public String getNombre() {
        return nombre;
    }
    
   
    public int getVida() {
        return vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public Equipo getMiEquipo() {
        return miEquipo;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else if (vida > this.vidaMax) {
            this.vida = this.vidaMax;
        } else {
            this.vida = vida; 
        }
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}
