public class Guerrero extends Personaje {
    private final int ataqueBase;

    public Guerrero(String n, int v, int a, int d, Equipo equipo) {
        super(n, v, a, d, equipo);
        this.ataqueBase = a; 
    }
    
    @Override
    public void usarEstrategia(java.util.Scanner sc) {
        int ataqueDuplicado = this.ataqueBase * 2;
        this.setAtaque(ataqueDuplicado);
        
        System.out.println(this.getNombre() + " activa: furia");
        System.out.println("Ataque temporal duplicado: " + this.getAtaque());
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }
}
