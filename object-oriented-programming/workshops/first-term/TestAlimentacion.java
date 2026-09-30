public class TestAlimentacion {
    // Integrantes:
    // -Kevin Morales
    // -Alvarez Jorge
    // -Luis Santamaría
    public static void main(String[] args) {
        Alimento baya = new Alimento("Baya", 5);
        Alimento pina = new Alimento("Piña");

        Pokemon pokemon1 = new Pokemon("Amarillo", "Pikachu", 20, 100, 50);
        System.out.println("-------------------------" + "\n" + "Información inicial del" + "\n" + "Pokémon:" + "\n");
        pokemon1.mostrarInformacion();
        baya.mostrarAlimento();
        System.out.println("");
        pokemon1.comer(baya);
        pokemon1.mostrarInformacion();
        pina.mostrarAlimento();
        System.out.println(" ");
        pokemon1.comer(pina);
        System.out.println("-------------------------");
        System.out.println("Información final del" + "\n" + "Pokémon:" + "\n");
        pokemon1.mostrarInformacion();

    }
}
