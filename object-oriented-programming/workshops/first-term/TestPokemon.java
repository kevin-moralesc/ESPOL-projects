public class TestPokemon {
    public static void main(String[] args) {
        Pokemon pk1 = new Pokemon();
        pk1.setNivel(5);
        pk1.setPuntosCombate(2000);
        pk1.setPuntosSalud(3500);
        System.out.println(" ");
        pk1.mostrarInformacion();

        Pokemon pk2 = new Pokemon();
         
        pk2.mostrarInformacion();
        boolean esquiva = pk2.esquivar();
        System.out.println("Prueba de Esquivar:");
        System.out.println("¿Esquiva el ataque? " + esquiva);

        if (esquiva) {
            System.out.println(pk2.getNivel() + " ha esquivado el ataque.");
        } else {
            System.out.println(pk1.getPuntosSalud() + " no ha podido esquivar el ataque.");

        }

        System.out.println(" ");

        pk1.atacar(pk2);
        int f = 2;

        System.out.println("\n" + (double) f);

    }
}
